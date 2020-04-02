package com.jeejio.module.deviceDependent;

import com.jeejio.utils.MethodPublic;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeviceInfo {
    AppiumDriver driver;
    //返回按钮
    public static WebElement headReturnButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/iv_left")).get(0);
        return element;
    }

    //三个点按钮
    public static WebElement headMoreButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/iv_title_right")).get(0);
        return element;
    }

    //日志按钮
    public static WebElement logButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/tv_device_log")).get(0);
        return element;
    }

    //消息按钮
    public static WebElement messageButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/tv_device_message_text")).get(0);
        return element;
    }

    //未运行列表更多按钮
    public static WebElement notRunMoreButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/tv_not_running_app_more")).get(0);
        return element;
    }

    //运行列表更多按钮
    public static WebElement runMoreButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/tv_running_app_more")).get(0);
        return element;
    }

    //应用按钮
    public static WebElement applyDownloadButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/btn_app_download")).get(0);
        return element;
    }

    //资源按钮
    public static WebElement resourceButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/btn_resource_download")).get(0);
        return element;
    }

    //设备按钮
    public static WebElement equipmentButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/btn_device_setting")).get(0);
        return element;
    }




}
