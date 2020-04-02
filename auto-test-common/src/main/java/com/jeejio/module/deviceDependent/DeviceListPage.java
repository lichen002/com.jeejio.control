package com.jeejio.module.deviceDependent;

import com.jeejio.utils.MethodPublic;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
* 设备列表页面
* */
public class DeviceListPage {
    AppiumDriver driver;

    //头像按钮
    public static WebElement headPortraitButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/ib_account_info")).get(0);
        return element;

    }

    //加号按钮
    public static WebElement plusSignButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/ib_add_device")).get(0);
        return element;
    }

    //第一个设备按钮
    public static WebElement firstDeviceButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/iv_machine_img")).get(0);
        return element;
    }

    //第二个设备按钮
    public static WebElement towDevicesButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/iv_machine_img")).get(0);
        return element;
    }

    //判断是否有绑定的设备
    public static boolean ifDeviceListExit(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        boolean empty = driver.findElements(By.id("com.jeejio.controller:id/iv_machine_img")).isEmpty();
        return empty;
    }

}
