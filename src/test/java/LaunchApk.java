import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class LaunchApk {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities;
        WebDriver driver;

        //      AppiumDriver driver;
        // AndroidDriver driver;


        capabilities = new DesiredCapabilities(); // Defining and setting desired capabilities
        capabilities.setCapability("deviceName", "Pixel 4 XL API 33");
        capabilities.setCapability("uuid", "emulator-5554");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("noReset",true);
        //capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
       // capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        //capabilities.setCapability("app","/Users/e25104/Desktop/Appium_Projects/appium_batch_01/apk/APIDemos.apk");
        capabilities.setCapability("app","/Users/Vinod.Patil/Desktop/Appium/apkfiles/APIDemos.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability("AUTO_ACCEPT_ALERT", "true");
        capabilities.setCapability(AndroidMobileCapabilityType.ACCEPT_INSECURE_CERTS, true);


        capabilities.setCapability("autoAcceptAlerts", "true");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver= new AndroidDriver(url,capabilities); // android Driver assign
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.switchTo().alert().accept();
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
      //  capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
     //   capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");









    }
}
