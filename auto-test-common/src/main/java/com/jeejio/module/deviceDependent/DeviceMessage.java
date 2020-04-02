package com.jeejio.module.deviceDependent;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeviceMessage {
    AppiumDriver driver;

    //返回按钮
    public void headReturnButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/ib_left")).click();
    }

    //操作按钮
    public void opernationButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_right")).click();
    }

    //操作/消息编辑按钮
    public void messageEditAccessButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_add_device")).click();
    }

    //操作/消息设置按钮
    public void messageSetingAccessButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_scan")).click();
    }

    //消息编辑界面，取消按钮
    public void messageEditOffButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_left")).click();
    }

    //消息编辑界面，删除按钮
    public void messageEditCancelButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_right")).click();
    }

    //消息编辑界面，全部选中按钮
    public void allSelectButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/cb_check_all")).click();
    }

    //消息编辑界面，单个选中按钮
    public void singleMessagePitchButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/cb_device_message_delete")).click();
    }

    //消息设置界面，返回按钮
    public void messageSetingButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/ib_left")).click();
    }

    //消息设置界面，预警消息进入按钮
    public void warningMessageAccessButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_warning_message_receive_type")).click();
    }

    //消息设置界面，反馈消息进入按钮
    public void feedbackMessageAccessButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_feedback_message_receive_type")).click();
    }

    //消息设置界面，通知消息进入按钮
    public void notificationMessageAccessButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_notification_message_receive_type")).click();
    }

    //消息设置界面，消息免打扰按钮
    public void noDisturbButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/cb_message_no_disturb")).click();
    }

    //消息设置界面，免打扰时段按钮
    public void noDisturbTimeButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_device_message_setting_no_disturb_time")).click();
    }

    //消息设置界面，免打扰时段，取消按钮
    public void noDisturbCancelButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_dialog_choose_time_cancle")).click();
    }

    //消息设置界面，免打扰时段，确定按钮
    public void noDisturbConfirmButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_dialog_choose_time_confirm")).click();
    }

    //消息设置界面，免打扰时段，开启时间选择按钮
    public void startTimeSelectButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/ib_left")).click();
    }

    //消息设置界面，免打扰时段，结束时间选择按钮
    public void endTimeSelectButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/ib_left")).click();
    }

    //消息设置界面，预警消息设置界面，返回按钮
    public void ReturnButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/ib_left")).click();
    }

    //消息设置界面，预警消息设置界面，保存按钮
    public void saveButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_right")).click();
    }

    //消息设置界面，预警消息设置界面，接收方式进入按钮
    public void warningMessageSetingAccessButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_message_receive_type")).click();
    }

    //消息设置界面，预警消息设置界面，消息等级进入按钮
    public void messageLevelAccessButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/tv_message_level")).click();
    }

    //消息设置界面，预警消息设置界面，接收方式，接收并推送
    public void acceptAndPushButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement o = (WebElement)driver.findElementsByClassName("android.widget.RadioButton").get(0);
        o.click();
    }

    //消息设置界面，预警消息设置界面，接收方式，不接收
    public void noAcceptButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement o = (WebElement)driver.findElementsByClassName("android.widget.RadioButton").get(1);
        o.click();
    }

    //消息设置界面，预警消息设置界面，接收方式，接收不推送
    public void acceptNoPushButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement o = (WebElement)driver.findElementsByClassName("android.widget.RadioButton").get(2);
        o.click();

    }

    //消息设置界面，预警消息设置界面，接收方式弹出框，取消按钮
    public void acceptMethodCancelButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/btn_cancel_extend")).click();
    }

    //消息设置界面，预警消息设置界面，消息等级，一般
    public void messageLevelOrdinaryButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement o = (WebElement)driver.findElementsByClassName("android.widget.RadioButton").get(0);
        o.click();
    }

    //消息设置界面，预警消息设置界面，消息等级，重要
    public void messageLevelImportanceButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement o = (WebElement)driver.findElementsByClassName("android.widget.RadioButton").get(1);
        o.click();
    }

    //消息设置界面，预警消息设置界面，消息等级弹出框，取消按钮
    public void messagLevelCancelButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/btn_cancel_extend")).click();
    }
}
