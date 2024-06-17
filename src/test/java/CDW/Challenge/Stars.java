package CDW.Challenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;


public class Stars {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.get("https://play1.automationcamp.ir/advanced.html");
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    	
    	String jscode = "return window.getComputedStyle(document.querySelector('label.star-rating'), ':after').getPropertyValue('content')";
		String ratingtext = (String) ((JavascriptExecutor) driver).executeScript(jscode);
		System.out.println(ratingtext);
		String stars = ratingtext.replace("\"", "");
		
		WebElement textBox = driver.findElement(By.xpath("//input[@placeholder='Enter the * Rating of the book. E.g. ****']"));
		textBox.click();
		System.out.println(stars);
		textBox.sendKeys(stars);
		
		driver.findElement(By.xpath("//button[@id='check_rating']")).click();
		
		String actualMsg=driver.findElement(By.xpath("//span[@id='validate_rating']")).getText();
		Assert.assertEquals(actualMsg,"Well done!");
		
      }

}
