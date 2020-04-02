package com.jeejio.module.deviceDependent;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class DeviceLogList {
    AppiumDriver driver;


    //返回按钮
    public void headReturnButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/ib_left")).click();
    }
    //编辑按钮
    public void headEditButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_right")).click();
    }

    //编辑界面取消按钮
    public void cancelButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_left")).click();
    }

    //编辑界面删除按钮
    public void deleteButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_right")).click();
    }

    //编辑界面全部选中按钮
    public void allSelectButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/cb_check_all")).click();
    }

    //编辑界面单个选中按钮
    public void oneSelectButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/cb_device_log_item_delete")).click();
    }


}
