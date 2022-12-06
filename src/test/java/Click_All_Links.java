import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Click_All_Links {
	
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links is : "+links.size());
		
		for(int i = 0; i < links.size(); i++) {
			WebElement AllLinks = links.get(i);
			System.out.println(AllLinks.getText()+"      "+AllLinks.isDisplayed());
			if(AllLinks.isDisplayed() == true) {
				AllLinks.click();
				System.out.println(driver.getTitle());
				driver.navigate().back();
				Thread.sleep(2000);
				links = driver.findElements(By.tagName("a"));
			}
		}
		
		for(int i = 0; i < links.size(); ++i) {
			System.out.println(links.get(i).getText()+"       "+links.get(i).getAttribute("href"));
		}
		
		driver.quit();
	}

}
