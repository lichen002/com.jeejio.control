package com.jeejio.control.deviceslist;

import com.jeejio.common.ApiPath;
import com.jeejio.module.myCorrelation.LoginElement;
import com.jeejio.utils.FileUtils;
import com.jeejio.utils.MethodPublic;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DevicesListTest extends LoginElement implements ApiPath {
    AppiumDriver driver;
    FileUtils fileUtils;
    LoginElement loginElement;

    @Before
    public  void setupEnvironment() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = MethodPublic.configuration(driver);
        driver = new AndroidDriver(new URL(SERVER_PATH), cap);
        LoginElement.GuidePageSkipButton(driver);

    }

    //修改设备名称
    @Test
    public void UpdateDevicesName() throws MalformedURLException, InterruptedException {
        boolean keyExist = MethodPublic.loginSuccessModule();

    }
}
