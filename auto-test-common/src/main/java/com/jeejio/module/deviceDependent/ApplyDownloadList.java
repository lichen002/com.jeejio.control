package com.jeejio.module.deviceDependent;

import com.jeejio.utils.MethodPublic;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ApplyDownloadList {
    AppiumDriver driver;

    //返回按钮
    public  static WebElement headReturnButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/ib_left")).get(0);
        return element;
    }

    //第一个应用安装按钮
    public static WebElement applyDownloadButton(AppiumDriver driver) throws InterruptedException {
        MethodPublic.sleepOneSecond();
        WebElement element = (WebElement)driver.findElements(By.id("com.jeejio.controller:id/ib_left")).get(0);
        return element;
    }
}
