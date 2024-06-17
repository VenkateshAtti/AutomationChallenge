package CDW.Challenge;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Frames {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://play1.automationcamp.ir/frames.html");

		driver.switchTo().frame("frame1");
		WebElement ele1 = driver.findElement(By.id("click_me_1"));
		ele1.click();
		String str1 = ele1.getText();
		Assert.assertEquals(str1, "Clicked");

		driver.switchTo().frame("frame2");
		WebElement ele2 = driver.findElement(By.id("click_me_2"));
		ele2.click();
		String str2 = ele2.getText();
		Assert.assertEquals(str2, "Clicked");
		driver.switchTo().parentFrame();

		driver.switchTo().frame("frame3");
		driver.switchTo().frame("frame4");
		WebElement ele3 = driver.findElement(By.id("click_me_4"));
		ele3.click();
		String str3 = ele3.getText();
		Assert.assertEquals(str3, "Clicked");
	}

}
