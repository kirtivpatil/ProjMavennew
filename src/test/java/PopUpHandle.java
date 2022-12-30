import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopUpHandle extends BaseTest{

    @Test
public void popupTest() throws InterruptedException {

    driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
    driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
    boolean chk=(driver.findElement(By.id("android:id/checkbox")).isSelected());
    System.out.println(chk);
    Thread.sleep(2000);
    if(!chk) {
        driver.findElement(By.id("android:id/checkbox")).click();
    }
    else{
        System.out.println("already checked");
    }

    driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
    String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");
    driver.findElement(By.id("android:id/edit")).sendKeys("KirtiP");
    driver.findElement(By.id("android:id/button1")).click();
}


}
