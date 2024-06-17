package CDW.Challenge;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class MouseActions {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://play1.automationcamp.ir/mouse_events.html");
		WebElement ele = driver.findElement(By.cssSelector("div#click_area"));
		Actions a = new Actions(driver);
		a.click(ele).perform();

		WebElement cli = driver.findElement(By.cssSelector("span#click_type"));
		String str1 = cli.getText();
		System.out.println(cli.getText());
		
		Assert.assertEquals(str1, "Click");

		a.doubleClick(ele).perform();
		String str2 = cli.getText();
		System.out.println(cli.getText());
		
		Assert.assertEquals(str2, "Double-Click");

		a.contextClick(ele).perform();
		String str3 = cli.getText();
		System.out.println(cli.getText());
		
		Assert.assertEquals(str3, "Right-Click");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		WebElement hov = driver.findElement(By.xpath("//button[text()='Choose Language']"));
		a.moveToElement(hov).perform();

		WebElement E = driver.findElement(By.cssSelector("p#dd_java"));
		String txt = E.getText();
		E.click();
		Assert.assertEquals(txt, "Java");

		WebElement source = driver.findElement(By.id("drag_source"));
		WebElement target = driver.findElement(By.id("drop_target"));
		a.dragAndDrop(source, target).perform();

		String dragmessage = target.getText();
		Assert.assertEquals(dragmessage, "Drop is successful!");
	}

}

