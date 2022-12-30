import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import com.google.common.base.Function;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
public class BaseTest {
    public WebDriver driver;
    @BeforeTest
    public  void BaseT () throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities;


        //      AppiumDriver driver;
        // AndroidDriver driver;


        capabilities = new DesiredCapabilities(); // Defining and setting desired capabilities
        capabilities.setCapability("deviceName", "Pixel 4 XL API 33 2");
        capabilities.setCapability("uuid", "emulator-5554");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("noReset",true);
        //capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
       // capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        //capabilities.setCapability("app","/Users/e25104/Desktop/Appium_Projects/appium_batch_01/apk/APIDemos.apk");
        capabilities.setCapability("app","/Users/Vinod.Patil/Desktop/Appium/apkfiles/ApiDemos-debug.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability("AUTO_ACCEPT_ALERT", "true");
        capabilities.setCapability(AndroidMobileCapabilityType.ACCEPT_INSECURE_CERTS, true);


        capabilities.setCapability("autoAcceptAlerts", "true");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver= new AndroidDriver(url,capabilities); // android Driver assign
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       //driver.switchTo().alert().accept();
       // driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
      //  capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
     //   capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");



    }

    public void swipeAction(WebElement ele, String direction)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),

                "direction", direction,
                "percent", 0.75
        ));


    }

    public void swipe(double startX, double startY, double endX, double endY, double duration) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        // swipeObject.put("touchCount", 1.0);
        swipeObject.put("startX", startX);
        swipeObject.put("startY", startY);
        swipeObject.put("endX", endX);
        swipeObject.put("endY", endY);
        swipeObject.put("duration", duration);
        js.executeScript("mobile: swipe", swipeObject);


    }


    public void scrollAction(WebDriver driver) throws InterruptedException {
                this.driver= driver;
               driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Secure View\"))"));

        Dimension screenSize = driver.manage().window().getSize();
        System.out.println("screenSize.height"+screenSize.height);
    }

    public void longClick(WebElement ele)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "duration",2000
        ));
    }
@AfterClass
public void tearDown()
{
driver.quit();
//service.stop();

}
}
