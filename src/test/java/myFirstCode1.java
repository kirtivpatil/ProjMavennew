import io.appium.java_client.android.AndroidDriver;
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

public class myFirstCode1 {

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
        capabilities.setCapability("deviceName", "Pixel 4 XL API 33");
        capabilities.setCapability("uuid", "emulator-5554");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
        capabilities.setCapability("appPackage", "com.google.android.dialer");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(url, capabilities); // android Driver assign

        Thread.sleep(10000); //10 sec static wait

        driver.findElement(By.id("com.google.android.dialer:id/tab_contacts")).click();

        driver.findElement(By.id("com.google.android.dialer:id/empty_content_view_action")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));

        Thread.sleep(20000);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        List<WebElement> txtbox = driver.findElements(By.className("android.widget.EditText"));
        System.out.println(txtbox.size());
        txtbox.get(0).sendKeys("First_Name1");
        txtbox.get(1).sendKeys("Last_Name");
        txtbox.get(2).sendKeys("QACompany_Name");
        txtbox.get(3).sendKeys("5512638443");
        txtbox.get(4).sendKeys("kp@qa.com");

        driver.findElement(By.id("com.google.android.contacts:id/toolbar_button")).click();

        Thread.sleep(20000);

       List<WebElement> txtbox4 = driver.findElements(By.id("com.google.android.dialer:id/contact_name"));
        System.out.println(txtbox4.size());
        System.out.println(txtbox4.get(0).getText());
        System.out.println(txtbox4.get(1).getText());
        txtbox4.get(1).click();
        Thread.sleep(20000);
        List<WebElement> txtbox1 = driver.findElements(By.className("android.widget.ImageView"));
        System.out.println(txtbox1.size());
        txtbox1.get(1).click();

        Thread.sleep(20000);

        List<WebElement> txtbox2 = driver.findElements(By.className("android.widget.TextView"));
        txtbox2.get(0).click();

        driver.findElement(By.id("android:id/button1")).click();


}


}