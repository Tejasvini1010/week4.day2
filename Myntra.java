package Week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement men = driver.findElement(By.xpath("//a[contains(text(),'Men')]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform();

		driver.findElement(By.xpath("//a[contains(text(),'Jackets')]")).click();

		String count = driver.findElement(By.className("title-count")).getText();
		System.out.println(count);

		String countfin = count.replaceAll("[^0-9]", "");
		System.out.println("The total number of jackets: " + countfin);

		int parseInt = Integer.parseInt(countfin);
		System.out.println(parseInt);

		String jacket = driver.findElement(By.className("categories-num")).getText();
		System.out.println(jacket);

		String count1 = jacket.replaceAll("[^0-9]", "");
		System.out.println("The total number of jackets category: " + count1);

		int parseInt1 = Integer.parseInt(count1);

		String rainJacket = driver.findElement(By.xpath("//label[contains(text(),'Rain Jacket')]")).getText();
		System.out.println(rainJacket);

		String count2 = rainJacket.replaceAll("[^0-9]", "");
		System.out.println("The total number of Rain Jackets category: " + count2);

		int parseInt2 = Integer.parseInt(count2);

		int sum = parseInt1 + parseInt2;
		if (parseInt == sum)
			System.out.println("The count matches");
		else
			System.out.println("The count doesn't match");

		driver.findElement(By.className("common-checkboxIndicator")).click();
		driver.findElement(By.className("brand-more")).click();

		driver.findElement(By.xpath("//label[contains(text(),'Duke')]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();

		List<WebElement> brand = driver.findElements(By.xpath("//h3[contains(text(),'Duke')]"));
		List<String> brands = new ArrayList<String>();
		String brand1 = "Duke";
		for (int i = 0; i < brand.size(); i++) {
			String duke = brand.get(i).getText();
			if (duke.equals(brand1)) {
				brands.add(duke);
			}
		}
		WebElement sort1 = driver.findElement(By.className("sort-sortBy"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(sort1).perform();

		WebElement sort = driver.findElementByXPath("//div[@class='horizontal-filters-sortContainer']");
		WebElement better = driver.findElementByXPath("//label[text()='Better Discount']");
		WebElement move = driver.findElementByXPath("//ul[@class='atsa-filters']");
		builder.moveToElement(sort).moveToElement(better).click(better).moveToElement(move).perform();
		String rate = null;
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		rate = price.get(0).getText();
		System.out.println("The price of first displayed item: " + rate);

		driver.findElement(By.xpath("//div[@class='product-productMetaInfo'][1]")).click();
		
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		windowHandlesList.get(1);
		driver.switchTo().window(windowHandlesList.get(1));
		
		//System.out.println(screen);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/firstproduct.png");
		FileUtils.copyFile(source, dst);
		
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-notWishlistedIcon sprites-notWishlisted pdp-flex pdp-center ']")).click();
		driver.quit();
		
	}

}
