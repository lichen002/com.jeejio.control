package com.jeejio.control.login;

import com.alibaba.fastjson.JSONObject;
import com.jeejio.common.ApiPath;
import com.jeejio.http.common.HttpDelegate;
import com.jeejio.module.myCorrelation.LoginElement;
import com.jeejio.module.myCorrelation.SigninElement;
import com.jeejio.utils.FileUtils;
import com.jeejio.utils.MethodPublic;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SignInTest  extends SigninElement implements ApiPath {
    AppiumDriver driver;
    FileUtils fileUtils;
    LoginElement loginElement;
    HttpDelegate httpDelegate = new HttpDelegate();

    @Before
    public  void setupEnvironment() throws IOException, InterruptedException {
        DesiredCapabilities cap = MethodPublic.configuration(driver);
        driver = new AndroidDriver(new URL(SERVER_PATH), cap);
        LoginElement.GuidePageSkipButton(driver);
        MethodPublic.loginOutAndUnBinddevices(TEST_ACCOUNT,"2","2");
        loginElement.newUserLoginButton(driver);

    }

    //手机号注册成功
    @Test
    public void phoneSignIn() throws IOException, InterruptedException {
        WebElement accountReturn = SigninElement.signinAccountInputReturn(driver);
        accountReturn.sendKeys(TEST_ACCOUNT);
        WebElement imageCodeReturn = SigninElement.signinImageCodeInputReturn(driver);
        imageCodeReturn.sendKeys(IMAGE_SUPER_CODE);
        SigninElement.signinNowSigninButton(driver);
        WebElement phoneCodeReturn = SigninElement.signinPhoneCodeImputReturn(driver);
        phoneCodeReturn.sendKeys(PHONE_SUPER_CODE);
        SigninElement.signinNextStepButton(driver);
        MethodPublic.sleepTwoSecond();
        MethodPublic.sleepTwoSecond();
        MethodPublic.sleepTwoSecond();
        boolean signinSuccessElement = SigninElement.getSigninSuccessElement(driver);
        Assert.assertTrue(signinSuccessElement);

    }

    @Test
    //邮箱注册成功
    public void emailSignIn() throws InterruptedException {
        SigninElement.switcherEmailButton(driver);
        WebElement accountReturn = SigninElement.signinEmailInputReturn(driver);
        accountReturn.sendKeys(TEST_EMAIL_ACCOUNT);
        WebElement imageCodeReturn = SigninElement.signinImageCodeInputReturn(driver);
        imageCodeReturn.sendKeys(IMAGE_SUPER_CODE);
        SigninElement.signinNowSigninButton(driver);
        WebElement phoneCodeReturn = SigninElement.signinPhoneCodeImputReturn(driver);
        phoneCodeReturn.sendKeys(PHONE_SUPER_CODE);
        SigninElement.signinNextStepButton(driver);
        boolean signinSuccessElement = SigninElement.getSigninSuccessElement(driver);
        Assert.assertTrue(signinSuccessElement);

    }

    @Test
    //手机号注册失败
    public void phoneSignInFailed() throws IOException, InterruptedException {
        List<String> expectjson =fileUtils.readFileByLine("data/signin/phone_signin_expect_result.txt");
        List<String> inputjson = fileUtils.readFileByLine("data/signin/phone_signin_input_json.txt");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        System.out.println("预期结果list"+expectjson);
        System.out.println("输入信息list"+inputjson);
        WebElement phoneInput = SigninElement.signinAccountInputReturn(driver);
        WebElement imageCodeInput = SigninElement.signinImageCodeInputReturn(driver);

        for(int index=0;index<inputjson.size();index++){
            JSONObject inputaccount = (JSONObject) JSONObject.parse(inputjson.get(index));
            int addnumber = index;
            addnumber++;
            System.out.println("第"+addnumber+"次输入"+inputaccount.toString());
            String phone = inputaccount.getString("phone");
            String imageCode = inputaccount.getString("imageCode");
            phoneInput.sendKeys(phone);
            imageCodeInput.sendKeys(imageCode);
            SigninElement.signinNextStepButton(driver);
            boolean signinSuccessElement = SigninElement.getSigninSuccessElement(driver);
            Assert.assertFalse(!signinSuccessElement);

            if(!signinSuccessElement){
                List phoneErrorInfo = SigninElement.getPhoneErrorInfoList(driver);
                List imageCodeErrorInfoList = SigninElement.getImageCodeErrorInfoList(driver);
                if(phoneErrorInfo.isEmpty()){
                    WebElement phoneErrorInfo1 = SigninElement.getPhoneErrorInfo(driver);
                    String phoneInputError = phoneErrorInfo1.getText();
                    Assert.assertEquals(expectjson.get(index),phoneInputError);
                }if(imageCodeErrorInfoList.isEmpty()){
                    WebElement imageCodeErrorInfo = SigninElement.getImageCodeErrorInfo(driver);
                    String imageInfo = imageCodeErrorInfo.getText();
                    Assert.assertEquals(expectjson.get(index),imageInfo);
                }

            }

            phoneInput.clear();
            imageCodeInput.clear();
        }

    }
    @Test
    //邮箱注册失败
    public void emailSignInFailed() throws InterruptedException, IOException {
        List<String> expectjson =fileUtils.readFileByLine("data/signin/email_signin_expect_result.txt");
        List<String> inputjson = fileUtils.readFileByLine("data/signin/email_signin_input_json.txt");

        System.out.println("预期结果list"+expectjson);
        System.out.println("输入信息list"+inputjson);
        WebElement phoneInput = SigninElement.signinAccountInputReturn(driver);
        WebElement imageCodeInput = SigninElement.signinImageCodeInputReturn(driver);
        WebElement phoneCodeInput = SigninElement.signinPhoneCodeImputReturn(driver);
        for(int index=0;index<inputjson.size();index++){
            JSONObject inputaccount = (JSONObject) JSONObject.parse(inputjson.get(index));
            int addnumber = index;
            addnumber++;
            System.out.println("第"+addnumber+"次输入"+inputaccount.toString());
            String phone = inputaccount.getString("phone");
            String imageCode = inputaccount.getString("imageCode");
            String phoneCode = inputaccount.getString("phoneCode");
            phoneInput.sendKeys(phone);
            imageCodeInput.sendKeys(imageCode);
            phoneCodeInput.sendKeys(phoneCode);
            SigninElement.signinNextStepButton(driver);
            boolean signinSuccessElement = SigninElement.getSigninSuccessElement(driver);
            Assert.assertFalse(signinSuccessElement);

            if(!signinSuccessElement){
                List phoneErrorInfo = SigninElement.getPhoneErrorInfoList(driver);
                List imageCodeErrorInfoList = SigninElement.getImageCodeErrorInfoList(driver);
                List phoneCodeErrorInfoList = SigninElement.getPhoneCodeErrorInfoList(driver);
                if(phoneErrorInfo.isEmpty()){
                    WebElement phoneErrorInfo1 = SigninElement.getPhoneErrorInfo(driver);
                    String phoneInputError = phoneErrorInfo1.getText();
                    Assert.assertEquals(expectjson.get(index),phoneInputError);
                }if(imageCodeErrorInfoList.isEmpty()){
                    WebElement imageCodeErrorInfo = SigninElement.getImageCodeErrorInfo(driver);
                    String imageInfo = imageCodeErrorInfo.getText();
                    Assert.assertEquals(expectjson.get(index),imageInfo);
                }else {
                    WebElement phoneCodeErrorInfo = SigninElement.getPhoneErrorInfo(driver);
                    String phoneCodeInfo = phoneCodeErrorInfo.getText();
                    Assert.assertEquals(expectjson.get(index),phoneCodeInfo);

                }

            }

            phoneInput.clear();
            imageCodeInput.clear();
        }

    }

    @After
    public  void recover() throws IOException {
        MethodPublic.loginOutAndUnBinddevices(TEST_ACCOUNT,"2","2");
    }

}
