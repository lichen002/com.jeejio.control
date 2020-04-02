import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;


public class base {
    public void refresh(AppiumDriver driver){
        TouchAction touchAction = new TouchAction(driver);
        //2.可以根据当前屏幕的宽度和高度来自定义起始点和终止点的坐标来实现滑动的通用操作
        Dimension dimension = driver.manage().window().getSize();
        int X = dimension.getWidth();
        int Y = dimension.getHeight();
        int startx = X/2;
        int starty = Y/4;
        // startPoint 起始点
//        PointOption startPoint = PointOption.point(startx, starty);
//        int endx = X/2;
//        int endy = Y*3/4;
//        // endPoint 终止点
//        PointOption endPoint = PointOption.point(endx, endy);
//        //把原始的滑动时间转换成duration
//        Duration duration = Duration.ofMillis(5000);
//        //然后再把duration转化成 WaitOptions
//        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
//        //appium将按-等待-移动-释放转换为滑动操作
//        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release();
//        touchAction.perform();
    }
}
