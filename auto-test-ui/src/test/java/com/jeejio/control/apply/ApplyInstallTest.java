package com.jeejio.control.apply;

import com.jeejio.common.ApiPath;
import com.jeejio.module.deviceDependent.ApplyDownloadList;
import com.jeejio.module.deviceDependent.DeviceInfo;
import com.jeejio.module.deviceDependent.DeviceListPage;
import com.jeejio.module.myCorrelation.LoginElement;
import com.jeejio.utils.FileUtils;
import com.jeejio.utils.MethodPublic;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplyInstallTest extends LoginElement implements ApiPath {
    AppiumDriver driver;
    FileUtils fileUtils;
    LoginElement loginElement;

    @Before
    public  void setupEnvironment() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = MethodPublic.configuration(driver);
        driver = new AndroidDriver(new URL(SERVER_PATH), cap);
        LoginElement.GuidePageSkipButton(driver);
        MethodPublic.Login(TEST_ACCOUNT,TEST_PASSWORD,driver);
        boolean deviceexit = DeviceListPage.ifDeviceListExit(driver);
        if(deviceexit){
            //执行绑定操作
        }
        //执行下载应用功能


    }

    @Test
    public void applyInstallTest() throws InterruptedException {
        DeviceListPage.firstDeviceButton(driver).click();
        DeviceInfo.applyDownloadButton(driver).click();
        ApplyDownloadList.applyDownloadButton(driver);
        ApplyDownloadList.headReturnButton(driver);
        driver.swipe(367,998,532,1042,900);





    }

}
