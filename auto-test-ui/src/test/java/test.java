import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.xml.bind.Element;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class test {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver driver;
        DesiredCapabilities cap;
        cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "127.0.0.1:62001"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "5.1.1");
        cap.setCapability("appPackage", "com.jeejio.controller");
        cap.setCapability("appActivity", "com.jeejio.controller.view.appImpl.SplashActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), cap);

        Thread.sleep(2000);
        //点击跳过
        driver.findElement(By.id("com.jeejio.controller:id/btn_guide_jump")).click();
        Thread.sleep(2000);
        //账号输入框
        WebElement accountInput = driver.findElement(By.id("com.jeejio.controller:id/et_username"));
        accountInput.sendKeys("");
        //密码输入框
        WebElement passwordInput = driver.findElement(By.id("com.jeejio.controller:id/et_password"));
        passwordInput.sendKeys("11323");
        //登陆按钮
        driver.findElement(By.id("com.jeejio.controller:id/btn_login")).click();
        Thread.sleep(2000);
        //String text = driver.findElement(By.id("com.jeejio.controller:id/tv_username_error_info")).getText();
        WebElement element =(WebElement) driver.findElements(By.id("com.jeejio.controller:id/tv_username_error_info")).get(0);
        String text = element.getText();

        System.out.println(text);


    }
}
