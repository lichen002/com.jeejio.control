package com.jeejio.module.myCorrelation;

import com.jeejio.utils.MethodPublic;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;

public class LoginElement {

    //引导页点击跳过
    public static void GuidePageSkipButton(AppiumDriver driver) throws InterruptedException, MalformedURLException {
        MethodPublic.sleepTwoSecond();
  //      driver.findElement(By.id("com.jeejio.controller:id/btn_guide_jump")).click();
        driver.findElement(By.id("com.jeejio.controller:id/btn_guide_jump")).click();

    }

    //密码登陆账号输入框
    public static void LoginPasswordAccountImput(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/et_username")).click();
    }


    //密码登陆账号输入框,返回输入框属性
    public static WebElement LoginPasswordAccountImputReturn(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        WebElement accountInput = driver.findElement(By.id("com.jeejio.controller:id/et_username"));
        return accountInput;
    }

    //密码登陆，密码输入框
    public static void LoginPasswordPasswordImput(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/et_password")).click();
    }

    //密码登陆，密码输入框，返回属性
    public static WebElement LoginPasswordPasswordImputReturn(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        WebElement passwordInput = driver.findElement(By.id("com.jeejio.controller:id/et_password"));
        return passwordInput;
    }

    //登陆按钮
    public static void LoginButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/btn_login")).click();
    }

    //判断账号输入框报错是否为空
        public static boolean accountIsEmpty(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        boolean empty = driver.findElements(By.id("com.jeejio.controller:id/tv_username_error_info")).isEmpty();
        return empty;
    }
    //获取账号输入框报错信息
    public static WebElement accountErrorInfo(AppiumDriver driver){
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/tv_username_error_info")).get(0);
        return element;
    }


    //获取密码输入框报错信息
    public static WebElement passwordErrorInfo(AppiumDriver driver){
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/tv_password_error_info")).get(0);
        return element;
    }

    //获取登录页面忘记密码按钮
    public static boolean getForgetThePassword(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        boolean empty = driver.findElements(By.id("com.jeejio.controller:id/tv_forget_password")).isEmpty();
        return empty;
    }

    //登录页面验证码登录按钮,点击
    public static void codeLoginButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/tv_username_and_password_login")).click();
    }

    //验证码登录手机号输入框
    public static void codeLoginPhoneInput(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/et_phone_number")).click();
    }

    //验证码登录手机号输入框返回值
    public static WebElement codeLoginPhoneInputReturn(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/et_phone_number")).get(0);
        return element;
    }

    //验证码登录验证码输入框
    public static WebElement codeLoginCodeInputReturn(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/et_check_code")).get(0);
        return element;

    }



    //验证码登录验证码输入框
    public static void codeLoginCodeInput(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/et_check_code")).click();
    }

    //发送验证码按钮
    public static void codeLoginSendCode(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/tv_resend_check_code")).click();
    }

    //新用户注册按钮
    public static void newUserLoginButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/tv_register")).click();
    }

    //验证码登录手机号输入框报错信息
    public static WebElement codeLoginPhoneErrorInfo(AppiumDriver driver){
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/tv_phone_number_error_info")).get(0);
        return element;
    }

    //验证码登录验证码输入框报错信息
    public static WebElement codeLoginCodeErrorInfo(AppiumDriver driver){
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/tv_check_code_error_info")).get(0);
        return element;
    }

    //设备列表返回空白处返回属性值
    public static WebElement devicesListReturn(AppiumDriver driver){
        WebElement element = driver.findElement(By.id("com.jeejio.controller:id/rv_machine_list"));
        return element;

    }

    //判断账号输入框报错是否为空
    public static boolean phoneIsEmpty(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        boolean empty = driver.findElements(By.id("com.jeejio.controller:id/tv_phone_number_error_info")).isEmpty();
        return empty;
    }








}
