package Script;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Child {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://skpatro.github.io/demo/links/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='NewWindow']")).click();
		Thread.sleep(2000);
	  Set<String> a1 = driver.getWindowHandles();//parent+child
		String a2 = driver.getWindowHandle();//parent
		//System.out.println(a1);
		//System.out.println(a2);
		Thread.sleep(2000);
		a1.remove(a2);//removed parent
		System.out.println(a1);
		for(String s:a1) {
			
		driver.switchTo().window(s);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//driver.quit();
	}
	}
}
