package Script;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Childwindow1 {

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		WebElement best = driver.findElement(By.xpath("//a[.='Best Sellers']"));
        WebElement prime = driver.findElement(By.xpath("//a[.='Mobiles']"));
        ArrayList<WebElement> ee=new ArrayList<>();
        ee.add(best);
        ee.add(prime);
        Robot rbt=new Robot();
        Actions act=new Actions(driver);
        for(WebElement w:ee) {
        	act.contextClick(w).perform();
        	Thread.sleep(2000);
        	rbt.keyPress(KeyEvent.VK_T);
        	rbt.keyRelease(KeyEvent.VK_T);
        	Thread.sleep(2000);
        }
        String pid = driver.getWindowHandle();
        Set<String> allid = driver.getWindowHandles();
        allid.remove(pid);
        for(String s:allid) {
        	driver.switchTo().window(s);
        	Thread.sleep(2000);
        	driver.close();
        }
        driver.switchTo().window(pid);
        Thread.sleep(2000);
        driver.close();
	}

}
