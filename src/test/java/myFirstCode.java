import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class myFirstCode {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        /***
         * Declaring DesiredCapabilities and Webdriver
         *
         *
         */
        DesiredCapabilities capabilities;
        WebDriver driver;

//        AppiumDriver driver;
//        AndroidDriver driver


        capabilities = new DesiredCapabilities(); // Defining and setting desired capabilities
        capabilities.setCapability("deviceName", "Pixel 5 API 33");
        capabilities.setCapability("uuid", "emulator-5554");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
        capabilities.setCapability("appPackage", "com.google.android.dialer");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(url, capabilities); // android Driver assign

        Thread.sleep(10000); //10 sec static wait
    }
}