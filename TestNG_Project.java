package com.tesng.org;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestNG_Project {
	
	public static WebDriver driver;

	@Test(priority = -8)
	public static void browserlaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Arul\\eclipse-workspace\\Selenium_Project\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}
	
	@Test(priority = -7)
	public static void searchtshirt() throws InterruptedException, AWTException {

		WebElement tshirts = driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,2500)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-2500)");
		Thread.sleep(3000);
		Actions ac = new Actions(driver);
		ac.moveToElement(tshirts).perform();
		tshirts.click();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);

		WebElement tees = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[2]"));
		ac.moveToElement(tees).perform();
		ac.contextClick().perform();
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@Test(priority = -6)
	public static void colorchange() throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> win = new ArrayList<>(windowHandles);
		String title = driver.switchTo().window(win.get(0)).getTitle();
		System.out.println(title);

		String title1 = driver.switchTo().window(win.get(1)).getTitle();
		System.out.println(title1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@title='Blue']")).click();
		Thread.sleep(3000);
		String title3 = driver.switchTo().window(win.get(0)).getTitle();
		System.out.println(title3);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
	}
	
	@Test(priority = -5)
	public static void compare() throws InterruptedException {
		WebElement instock = driver.findElement(By.xpath("//span[@class='available-now']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(instock).perform();
		WebElement addtocompare = driver.findElement(By.xpath("//div[@class='compare']"));
		ac.moveToElement(addtocompare).perform();
		Thread.sleep(2000);
		addtocompare.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(3000);

		WebElement women = driver.findElement(By.xpath("(//a[@title='Women'])[1]"));
		ac.moveToElement(women).perform();
		Thread.sleep(2000);
		WebElement blouses = driver.findElement(By.xpath("//a[@title='Blouses']"));
		ac.moveToElement(blouses);
		blouses.click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,800)");
	}
	
	@Test(priority = -4)
	public static void compareto() throws InterruptedException, IOException {
		WebElement stock = driver.findElement(By.xpath("//span[@class='availability']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(stock).perform();
		Thread.sleep(2000);
		WebElement addtocompare1 = driver.findElement(By.xpath("//div[@class='compare']"));
		ac.moveToElement(addtocompare1).perform();
		addtocompare1.click();

		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = -3)
	public static void addtocart() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		driver.findElement(By.xpath("(//a[@title='Add to cart'])[2]")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = -2)
	public static void checkout() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = -1)
	public static void login() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("arulford7@gmail.com	");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Arul@1425");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='SubmitLogin']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
	}
	
	@Test(priority = 0)
	public static void postcheckout() throws InterruptedException {
		WebElement cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(cart).perform();
		WebElement cart1 = driver.findElement(By.xpath("//a[@title='Check out']"));
		ac.moveToElement(cart1).perform();
		cart1.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]")).click();
	}
	
	@Test(priority = 1)	
	public static void address() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//button[@name='processAddress']")).click();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public static void Checkbox() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
	}
	
	@Test(priority = 3)	
	public static void payment() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//a[@title='Pay by check.']")).click();
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		js.executeScript("window.scrollBy(0,400)");
	}
	
	@Test(priority = 4)
	public static void orderplaced() throws IOException {
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
	}
	
	@Test(priority = 5)
	public static void orders() throws InterruptedException, IOException {
		WebElement account = driver.findElement(By.xpath("//a[@class='account']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(account).perform();
		account.click();
		Thread.sleep(2000);
		WebElement orders = driver.findElement(By.xpath("//i[@class='icon-list-ol']"));
		Thread.sleep(2000);
		ac.moveToElement(orders).perform();
		orders.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(2000);
		driver.navigate().back();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
	}
	
	@Test(priority = 6)
	public static void wishlist() throws InterruptedException, IOException {
		Thread.sleep(2000);
		WebElement wishlist = driver.findElement(By.xpath("//i[@class='icon-heart']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(wishlist).perform();
		Thread.sleep(2000);
		wishlist.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(2000);
		driver.navigate().back();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
	}
	
	@Test(priority = 7)
	public static void creditslips() throws InterruptedException, IOException {
		Thread.sleep(2000);
		WebElement creditslip = driver.findElement(By.xpath("//i[@class='icon-ban-circle']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(creditslip).perform();
		Thread.sleep(2000);
		creditslip.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(2000);
		driver.navigate().back();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
	}
	
	@Test(priority = 8)
	public static void addresses() throws InterruptedException, IOException {
		Thread.sleep(2000);
		WebElement address = driver.findElement(By.xpath("//i[@class='icon-building']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(address).perform();
		Thread.sleep(2000);
		address.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(2000);
		driver.navigate().back();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
	}
	
	@Test(priority = 9)
	public static void personalinfo() throws InterruptedException, IOException {
		Thread.sleep(2000);
		WebElement perinfo = driver.findElement(By.xpath("//i[@class='icon-user']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(perinfo).perform();
		Thread.sleep(2000);
		perinfo.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(2000);
		driver.navigate().back();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
	}
	
	@Test(priority = 10)
	public static void logout() throws InterruptedException, IOException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
		driver.findElement(By.xpath("//a[@class='logout']")).click();
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
