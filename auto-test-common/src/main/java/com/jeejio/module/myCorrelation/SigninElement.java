package com.jeejio.module.myCorrelation;

import com.jeejio.utils.MethodPublic;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SigninElement {

    //注册手机账号输入框
    public static void signinAccountInput(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/et_phone_number")).click();
    }

    //注册手机账号输入框,返回输入框属性
    public static WebElement signinAccountInputReturn(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        WebElement accountInput = driver.findElement(By.id("com.jeejio.controller:id/et_phone_number"));
        return accountInput;
    }

    //注册邮箱账号输入框
    public static void signinEmailInput(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/register_et_email")).click();
    }

    //注册邮箱账号输入框返回属性
    public static WebElement signinEmailInputReturn(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        WebElement emailInput = driver.findElement(By.id("com.jeejio.controller:id/register_et_email"));
        return emailInput;
    }

    //注册图形验证码输入框
    public static void signinImageCodeImput(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/et_picture_check_code")).click();
    }

    //注册图形验证码输入框，返回输入框属性
    public static WebElement signinImageCodeInputReturn(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        WebElement accountInput = driver.findElement(By.id("com.jeejio.controller:id/et_picture_check_code"));
        return accountInput;
    }

    //注册界面立即注册按钮
    public static void signinNowSigninButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/btn_register")).click();
    }

    //用户协议连接
    public static void userProtocolLink(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/tv_info")).click();
    }

    //隐私协议连接
    public static void privacyProtocolLink(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/tv_info")).click();
    }

    //切换邮箱注册按钮
    public static void switcherEmailButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/tv_jump_to_login")).click();
    }

    //验证码切换按钮
    public static void imageCodeSwitcherButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/iv_picture_check_code")).click();
    }

    //注册手机号验证码输入框
    public static void signinPhoneCodeImput(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/et_check_code")).click();
    }

    //注册手机号验证码输入框，返回属性
    public static WebElement signinPhoneCodeImputReturn(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        WebElement accountInput = driver.findElement(By.id("com.jeejio.controller:id/et_check_code"));
        return accountInput;
    }

    //注册下一步按钮
    public static void signinNextStepButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/btn_register")).click();
    }

    //手机号验证码输入界面返回按钮
    public static void phoneCodeReturnButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/ib_left")).click();
    }

    //验证码重新发送按钮
    public static void codeAnewSendButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        driver.findElement(By.id("com.jeejio.controller:id/iv_picture_check_code")).click();
    }

    //注册成功界面元素验证
    public static boolean getSigninSuccessElement(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        boolean exist = driver.findElements(By.id("com.jeejio.controller:id/tv_main_title")).isEmpty();
        return exist;
    }

    //手机号错误提示list
    public static List getPhoneErrorInfoList(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        List phoneInputError = driver.findElements(By.id("com.jeejio.controller:id/tv_phone_number_error_info"));
        return phoneInputError;
    }

    //手机号错误提示
    public static WebElement getPhoneErrorInfo(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        WebElement phoneInputError = driver.findElement(By.id("com.jeejio.controller:id/tv_phone_number_error_info"));
        return phoneInputError;
    }

    //图像验证码错误提示list
    public static List getImageCodeErrorInfoList(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        List imageCodeInputError = driver.findElements(By.id("com.jeejio.controller:id/tv_picture_check_code_error_info"));
        return imageCodeInputError;
    }

    //图像验证码错误提示
    public static WebElement getImageCodeErrorInfo(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepTwoSecond();
        WebElement imageCodeInputError = driver.findElement(By.id("com.jeejio.controller:id/tv_picture_check_code_error_info"));
        return imageCodeInputError;
    }

    //手机号验证码错误提示list
    public static List getPhoneCodeErrorInfoList(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        List phoneCodeInputError = driver.findElements(By.id("com.jeejio.controller:id/tv_check_code_error_info"));
        return phoneCodeInputError;
    }

    //手机号验证码错误提示
    public static WebElement getPhoneCodeErrorInfo(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement phoneCodeInputError = driver.findElement(By.id("com.jeejio.controller:id/tv_check_code_error_info"));
        return phoneCodeInputError;
    }

    //获取邮箱输入框报错信息
    public static WebElement getEmailInputError(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement emailInputError = driver.findElement(By.id("com.jeejio.controller:id/tv_email_error_info"));
        return emailInputError;
    }

    //获取邮箱输入框报错信息list
    public static List getEmailInputErrorList(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        List emailInputError = driver.findElements(By.id("com.jeejio.controller:id/tv_email_error_info"));
        return emailInputError;
    }


}
