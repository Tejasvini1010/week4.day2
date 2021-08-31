package Week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) {
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
	    System.out.println("The total number of jackets: "+countfin);

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
	    
	  WebElement dukeList = driver.findElement(By.xpath("//h3[contains(text(),'Duke')]"));
	  System.out.println(dukeList);
	    
	    
	    
	   
	    
	    
	    		

	}

}
