package com.jeejio.control.login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeejio.common.ApiPath;
import com.jeejio.http.common.HttpDelegate;
import com.jeejio.module.myCorrelation.LoginElement;
import com.jeejio.utils.FileUtils;
import com.jeejio.utils.MethodPublic;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
@Slf4j
public class LoginTest extends LoginElement implements ApiPath {
    AppiumDriver driver;
    FileUtils fileUtils;
    LoginElement loginElement;
    HttpDelegate httpDelegate = new HttpDelegate();

    @BeforeClass
    public static void setUpBeforeClass() throws IOException {
        String resultString = MethodPublic.registAccount(TEST_ACCOUNT);
        log.info("resultString = {}",resultString);
        MethodPublic.setPassword(TEST_ACCOUNT,TEST_PASSWORD);

        log.info("resultString is {}",resultString);

    }


   @Before
    public  void setupEnvironment() throws MalformedURLException, InterruptedException {
       DesiredCapabilities cap = MethodPublic.configuration(driver);
       driver = new AndroidDriver(new URL(SERVER_PATH), cap);
       LoginElement.GuidePageSkipButton(driver);

   }


   //账号密码登录失败用例5条
   @Test
    public void loginFailedTest() throws InterruptedException, IOException {
       List<String> expectjson =fileUtils.readFileByLine("data/login/login_expect_result_json.txt");
       List<String> inputjson = fileUtils.readFileByLine("data/login/login_input_json.txt");

       System.out.println("预期结果list"+expectjson);
       System.out.println("输入信息list"+inputjson);
       WebElement accountinput = loginElement.LoginPasswordAccountImputReturn(driver);
       WebElement passwordinput = loginElement.LoginPasswordPasswordImputReturn(driver);
       for(int index=0;index<inputjson.size();index++){
           JSONObject inputaccount = (JSONObject) JSONObject.parse(inputjson.get(index));
           int addnumber = index;
           addnumber++;
           System.out.println("第"+addnumber+"次输入"+inputaccount.toString());
           String account = inputaccount.getString("account");
           String password = inputaccount.getString("password");
           accountinput.sendKeys(account);
           passwordinput.sendKeys(password);
           loginElement.LoginButton(driver);
           boolean accountempty = loginElement.accountIsEmpty(driver);
           if(!accountempty){
               WebElement accountelement = LoginElement.accountErrorInfo(driver);
               String accounterrorinfo = accountelement.getText();
               Assert.assertEquals(expectjson.get(index),accounterrorinfo);
           }else {
               MethodPublic.sleepTwoSecond();
               WebElement passwordelement = loginElement.passwordErrorInfo(driver);
               Assert.assertEquals(expectjson.get(index),passwordelement.getText());
           }

           accountinput.clear();
           passwordinput.clear();
       }

   }

   //账号密码登录成功
    @Test
    public void loginSuccessTest() throws InterruptedException {
        WebElement accountinput = loginElement.LoginPasswordAccountImputReturn(driver);
        WebElement passwordinput = loginElement.LoginPasswordPasswordImputReturn(driver);
        accountinput.sendKeys(TEST_ACCOUNT);
        passwordinput.sendKeys("123qweasd");
        MethodPublic.sleepTwoSecond();
        loginElement.LoginButton(driver);
        MethodPublic.sleepTwoSecond();
        boolean isempty = driver.findElements(By.id("com.jeejio.controller:id/ib_account_info")).isEmpty();
        Assert.assertFalse(isempty);

    }

    //验证码登录成功
    @Test
    public void CodeLoginSuccessTest() throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        loginElement.codeLoginButton(driver);
        WebElement phoneinput = loginElement.codeLoginPhoneInputReturn(driver);
        WebElement codeinput = loginElement.codeLoginCodeInputReturn(driver);
        phoneinput.sendKeys("15701188230");
        codeinput.sendKeys("888888");
        loginElement.LoginButton(driver);
        MethodPublic.sleepTwoSecond();
        boolean isempty = driver.findElements(By.id("com.jeejio.controller:id/ib_account_info")).isEmpty();
        Assert.assertFalse(isempty);


    }

    //验证码登录失败
    @Test
    public void CodeLoginFailedTest() throws InterruptedException, IOException {
        List<String> expectjson =fileUtils.readFileByLine("data/login/code_login_expect_result_json.txt");
        List<String> inputjson = fileUtils.readFileByLine("data/login/code_login_input_json.txt");
        MethodPublic.sleepTwoSecond();
        loginElement.codeLoginButton(driver);

        System.out.println("预期结果list"+expectjson);
        System.out.println("输入信息list"+inputjson);
        WebElement phoneinput = loginElement.codeLoginPhoneInputReturn(driver);
        WebElement codeinput = loginElement.codeLoginCodeInputReturn(driver);
        for(int index=0;index<inputjson.size();index++){
            JSONObject inputaccount = (JSONObject) JSONObject.parse(inputjson.get(index));
            int addnumber = index;
            addnumber++;
            System.out.println("第"+addnumber+"次输入"+inputaccount.toString());
            String phone = inputaccount.getString("phone");
            String code = inputaccount.getString("code");
            phoneinput.sendKeys(phone);
            MethodPublic.sleepTwoSecond();
            codeinput.sendKeys(code);
            loginElement.LoginButton(driver);
            boolean accountempty = loginElement.phoneIsEmpty(driver);
            if(!accountempty){
                WebElement accountelement = LoginElement.codeLoginPhoneErrorInfo(driver);
                String accounterrorinfo = accountelement.getText();
                Assert.assertEquals(expectjson.get(index),accounterrorinfo);
            }else {
                MethodPublic.sleepTwoSecond();
                WebElement passwordelement = loginElement.codeLoginCodeErrorInfo(driver);
                Assert.assertEquals(expectjson.get(index),passwordelement.getText());
            }

            phoneinput.clear();
            codeinput.clear();
        }



    }

    @AfterClass
    public static void recover() throws IOException {
            String resultUserId = MethodPublic.judgeUserExist(TEST_ACCOUNT, "2");
            JSONObject jsonObject = JSON.parseObject(resultUserId);
            JSONObject resultValue = (JSONObject)jsonObject.get("resultValue");
            Object userId = resultValue.get("id");
            String resultList = MethodPublic.getDevicesList(userId.toString());
            log.info("resultList = {}",resultList);
            JSONObject jsonObjectList = JSON.parseObject(resultList);
            JSONObject resultValueList =(JSONObject) jsonObjectList.get("resultValue");
            Integer machineNumber =(Integer) resultValueList.get("machineNumber");
            JSONArray machineInfoList =(JSONArray) resultValueList.get("machineInfoList");
            int devicesNumber = machineNumber.intValue();
            if(devicesNumber>0){
                for(int index=0;index<devicesNumber;index++){
                    JSONObject machineInfo = (JSONObject)machineInfoList.get(index);
                    String machineCode =(String) machineInfo.get("machineId");
                    String unBindResult = MethodPublic.unBindDevices(machineCode, "2", userId.toString());
                }
            }




        MethodPublic.loginOutAccount(TEST_ACCOUNT);
    }


}
