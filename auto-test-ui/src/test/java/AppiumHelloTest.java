import com.jeejio.module.myCorrelation.LoginElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class AppiumHelloTest extends LoginElement {

    AndroidDriver driver;
    DesiredCapabilities cap;

    @Before
    public void testLoginInitialize() throws MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "127.0.0.1:62001"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "5.1.1");
        cap.setCapability("appPackage", "com.jeejio.controller");
        cap.setCapability("appActivity", "com.jeejio.controller.view.appImpl.SplashActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }
    @Test
    public void setup() throws Exception {
        Thread.sleep(2000);
        //点击跳过
        driver.findElement(By.id("com.jeejio.controller:id/btn_guide_jump")).click();
        Thread.sleep(2000);
        //账号输入框
        WebElement accountInput = driver.findElement(By.id("com.jeejio.controller:id/et_username"));
        accountInput.sendKeys("15701188230");
        //密码输入框
        WebElement passwordInput = driver.findElement(By.id("com.jeejio.controller:id/et_password"));
        passwordInput.sendKeys("123qweasd");
        //登陆按钮
        driver.findElement(By.id("com.jeejio.controller:id/btn_login")).click();
        Thread.sleep(2000);
        //设备按钮
        driver.findElement(By.id("com.jeejio.controller:id/iv_machine_img")).click();
        Thread.sleep(1000);
        //设备详情页，应用按钮
        driver.findElement(By.id("com.jeejio.controller:id/btn_app_download")).click();
        Thread.sleep(2000);
        //应用列表第一个应用安装按钮
        driver.findElement(By.id("com.jeejio.controller:id/btn_install")).click();
        while (true){
            Thread.sleep(1000);
            //可安装列表返回按钮
            driver.findElement(By.id("com.jeejio.controller:id/ib_left")).click();
            Thread.sleep(5000);
            //设备详情页，应用按钮
            driver.findElement(By.id("com.jeejio.controller:id/btn_app_download")).click();
            Thread.sleep(5000);
            //可安装列表返回按钮
            driver.findElement(By.id("com.jeejio.controller:id/ib_left")).click();
            Thread.sleep(5000);
            //获取未运行列表元素值
            String tagName = driver.findElement(By.id("com.jeejio.controller:id/iv_app_img")).getTagName();
//            log.info("tagName ={}",tagName);
//            driver.
//            com.jeejio.controller:id/tv_password_error_info

            if(tagName.length()!=0) {
                Thread.sleep(2000);
                //点击未运行应用列表第一个应用开启
                driver.findElement(By.id("com.jeejio.controller:id/iv_app_img")).click();
                break;
            }
        }
        Thread.sleep(2000);
        //可安装列表返回按钮
        driver.findElement(By.id("com.jeejio.controller:id/ib_left")).click();
        Thread.sleep(2000);
    }
    @After
    public void LoginQuit() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/iv_left")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/ib_account_info")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/rl_mine_setting")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/btn_logout")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.jeejio.controller:id/btn_positive")).click();

    }
}