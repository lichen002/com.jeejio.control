package com.jeejio.control.login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeejio.common.ApiPath;
import com.jeejio.module.myCorrelation.LoginElement;
import com.jeejio.utils.FileUtils;
import com.jeejio.utils.JsonResolve;
import com.jeejio.utils.MethodPublic;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.jeejio.common.ApiPath.TEST_ACCOUNT;
@Slf4j
public class test {

    public static void main(String[] args) throws IOException, InterruptedException {
//        LoginElement loginElement = null;
//        AndroidDriver driver;
//        DesiredCapabilities cap;
//        FileUtils fileUtils;
//        JsonResolve jsonResolve;
////        FileUtils fileUtils = new FileUtils();
////        List<String> strings = fileUtils.readFileByLine("data/login/login_input_json.txt");
////        System.out.println(strings.toString());
//
//        cap = new DesiredCapabilities();
//        cap.setCapability(CapabilityType.BROWSER_NAME, "");
//        cap.setCapability("platformName", "Android"); //指定测试平台
//        cap.setCapability("deviceName", "127.0.0.1:62001"); //指定测试机的ID,通过adb命令`adb devices`获取
//        cap.setCapability("platformVersion", "5.1.1");
//        cap.setCapability("appPackage", "com.jeejio.controller");
//        cap.setCapability("appActivity", "com.jeejio.controller.view.appImpl.SplashActivity");
////        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
////        loginElement.GuidePageSkipButton(driver);
//        String s = MethodPublic.registAccount(ApiPath.TEST_ACCOUNT);
//        System.out.println("==============================="+s);

        String resultUserId = MethodPublic.judgeUserExist("15701188230", "2");
        System.out.println(resultUserId);
        JSONObject jsonObject = JSON.parseObject(resultUserId);
        JSONObject resultValue = (JSONObject)jsonObject.get("resultValue");
        log.info("resultValue = {}",resultValue);
        Object userId = resultValue.get("id");
        System.out.println("==================="+userId.toString());
        String resultList = MethodPublic.getDevicesList(userId.toString());
        log.info("resultList = {}",resultList);
        JSONObject jsonObjectList = JSON.parseObject(resultList);
        JSONObject resultValueList =(JSONObject) jsonObjectList.get("resultValue");
        Integer machineNumber =(Integer) resultValueList.get("machineNumber");
        JSONArray machineInfoList =(JSONArray) resultValueList.get("machineInfoList");
        int devicesNumber = machineNumber.intValue();
        if(devicesNumber>0){
            for(int index=0;index<devicesNumber;index++){
                JSONObject machineInfo = (JSONObject)machineInfoList.get(index);
                String machineCode =(String) machineInfo.get("machineId");
                String unBindResult = MethodPublic.unBindDevices(machineCode, "2", userId.toString());
            }
        }




     //   MethodPublic.loginOutAccount(TEST_ACCOUNT);
    }
}
