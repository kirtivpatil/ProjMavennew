import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ScrollTest extends BaseTest {

    @Test
    public void scrollTest() throws InterruptedException {
        System.out.println("child scroll");
        /*Thread.sleep(2000);
        driver.findElements(By.id("android:id/text1")).get(1).click();
        Thread.sleep(2000);*/

        List<WebElement> elements = driver.findElements(By.id("android:id/text1"));

        for (WebElement element : elements) {
            if (element.getText().equals("Views")) {
                element.click();
            }

        }

        scrollAction(driver);
        boolean p=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Secure View\"]")).isDisplayed();
        System.out.println(p);
        Assert.assertTrue(p,"value is present");
    }
}
