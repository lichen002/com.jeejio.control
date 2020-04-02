package com.jeejio.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.jeejio.common.ApiPath;
import com.jeejio.entity.devices.DevicesList;
import com.jeejio.entity.devices.UnbindDevices;
import com.jeejio.entity.loginout.AccountLoginOut;
import com.jeejio.entity.loginout.JudgeUserExist;
import com.jeejio.entity.loginout.RegistAccount;
import com.jeejio.entity.loginout.ResetPassword;
import com.jeejio.http.common.HttpDelegate;
import com.jeejio.module.myCorrelation.LoginElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MethodPublic extends LoginElement implements ApiPath {
    public static AppiumDriver driver;
    public static FileUtils fileUtils;
    public static LoginElement loginElement;

    //初始化打开app方法
    public static DesiredCapabilities configuration(AppiumDriver driver) throws MalformedURLException {
        DesiredCapabilities cap;
        cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "127.0.0.1:62001"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "5.1.1");
        cap.setCapability("appPackage", "com.jeejio.controller");
        cap.setCapability("appActivity", "com.jeejio.controller.view.appImpl.SplashActivity");
        return cap;
    }

    /**
     * 隐式等待
     */
    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    //等待时间为1秒的方法
    public static void sleepOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    }

    //等待时间为2秒的方法
    public static void sleepTwoSecond() throws InterruptedException {
        Thread.sleep(1000);
    }

    //等待时间为3秒的方法
    public static void sleepThreeSecond() throws InterruptedException {
        Thread.sleep(2000);
    }

    //登录方法
    public static void Login(String account, String password, AppiumDriver driver) throws InterruptedException {
        WebElement accountinput = LoginElement.LoginPasswordAccountImputReturn(driver);
        WebElement passwordinput = LoginElement.LoginPasswordPasswordImputReturn(driver);
        accountinput.sendKeys(account);
        passwordinput.sendKeys(password);
        MethodPublic.sleepTwoSecond();
        LoginElement.LoginButton(driver);
    }

    //账号密码登录成功方法
    public static boolean loginSuccessModule() throws InterruptedException, MalformedURLException {
        DesiredCapabilities cap = MethodPublic.configuration(driver);
        driver = new AndroidDriver(new URL(SERVER_PATH), cap);
        LoginElement.GuidePageSkipButton(driver);
        WebElement accountinput = loginElement.LoginPasswordAccountImputReturn(driver);
        WebElement passwordinput = loginElement.LoginPasswordPasswordImputReturn(driver);
        accountinput.sendKeys("15701188230");
        passwordinput.sendKeys("123qweasd");
        MethodPublic.sleepTwoSecond();
        loginElement.LoginButton(driver);
        MethodPublic.sleepTwoSecond();
        boolean isempty = driver.findElements(By.id("com.jeejio.controller:id/ib_account_info")).isEmpty();
        return isempty;
    }

    //账号注销接口方法
    public static void loginOutAccount(String userKey) throws IOException {
        AccountLoginOut accountLoginOut = new AccountLoginOut();
        accountLoginOut.setUserKey(TEST_ACCOUNT);
        String requestJson = JSON.toJSONString(accountLoginOut);
        String resultString = HttpDelegate.post(LOGIN_OUT_SERVICE_PATH, requestJson);
    }

    //获取设备列表方法接口
    public static String getDevicesList(String userId) throws IOException {
        DevicesList devicesList = new DevicesList();
        devicesList.setUserId(userId);
        String requestJson = JSON.toJSONString(devicesList);
        String resultString = HttpDelegate.post(GET_DEVICES_LIST, requestJson);
        return resultString;

    }

    //解绑设备接口
    public static String unBindDevices(String machineCode, String ubindingType, String userId) throws IOException {
        UnbindDevices unbindDevices = new UnbindDevices();
        unbindDevices.setUserId(userId);
        unbindDevices.setMachineCode(machineCode);
        unbindDevices.setUbindingType(ubindingType);
        String requestJson = JSON.toJSONString(unbindDevices);
        String resultString = HttpDelegate.post(UNBIND_DEVICES_RESTORE_NETWORK, requestJson);
        return resultString;

    }

    //设置密码接口
    public static String setPassword(String userKey, String userPassword) throws IOException {
        ResetPassword resetPassword = new ResetPassword();
        resetPassword.setUserKey(userKey);
        resetPassword.setUserPasswd(userPassword);
        String requestJson = JSON.toJSONString(resetPassword);
        String resultString = HttpDelegate.post(RESET_PASSWORD, requestJson);
        return resultString;

    }

    //注册接口
    public static String registAccount(String userPhone) throws IOException {
        RegistAccount registAccount = new RegistAccount();
        registAccount.setUserPhone(userPhone);
        String requestJson = JSON.toJSONString(registAccount);
        String resultString = HttpDelegate.post(REGIST_USER_ACCOUNT, requestJson);
        return resultString;

    }

    //判断用户是否存在接口，获取用户userid
    public static String judgeUserExist(String userPhone, String status) throws IOException {
        JudgeUserExist judgeUserExist = new JudgeUserExist();
        judgeUserExist.setUserPhone(userPhone);
        judgeUserExist.setStatus(status);
        String requestString = JSON.toJSONString(judgeUserExist);
        String resultString = HttpDelegate.post(JUDGE_USER_EXIST, requestString);
        return resultString;

    }

    //账号解绑设备并注销账号方法
    public static void loginOutAndUnBinddevices(String testAccount,String status,String ubindingType) throws IOException {
        String resultUserId = judgeUserExist(testAccount, status);
        System.out.println(resultUserId);
        JSONObject jsonObject = JSON.parseObject(resultUserId);
        if(jsonObject.containsKey("resultValue")){
            JSONObject resultValue = (JSONObject)jsonObject.get("resultValue");
            log.info("resultValue = {}",resultValue);
            Object userId = resultValue.get("id");
            System.out.println("==================="+userId.toString());
            String resultList = getDevicesList(userId.toString());
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
                    String unBindResult = unBindDevices(machineCode, ubindingType, userId.toString());
                }
            }

            loginOutAccount(TEST_ACCOUNT);
        }

    }

    //页面下拉刷新方法
    public static void swipeToDown(AppiumDriver<WebElement> driver,int during, int num) throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        System.out.println(width);
        System.out.println(height);
        for (int i = 0; i < num; i++) {
            driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
            MethodPublic.sleepTwoSecond();
        }
    }

    /**
     * 上滑
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToUp(AppiumDriver<WebElement> driver,int during, int num) throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i < num; i++) {
            driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
            MethodPublic.sleepTwoSecond();
        }
    }


    /**
     * 向左滑动
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToLeft(AppiumDriver<WebElement> driver,int during, int num) throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i < num; i++) {
            driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
           MethodPublic.sleepTwoSecond();
        }
    }

    /**
     * 向右滑动
     *
     * @param driver
     * @param during
     * @param num
     */
    public static void swipeToRight(AppiumDriver<WebElement> driver,int during, int num) throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i < num; i++) {
            driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
            MethodPublic.sleepTwoSecond();
        }
    }




}