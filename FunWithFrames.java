package week4.day1.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunWithFrames {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File screen1=driver.getScreenshotAs(OutputType.FILE);
		File dest1=new File("./snap/seat.png");
		FileUtils.copyFile(screen1, dest1);
		WebElement frame1=driver.findElement(By.xpath("(//div[@id='wrapframe'])[1]/iframe"));
		driver.switchTo().frame(frame1);
		WebElement click=driver.findElement(By.id("Click"));
		File screen2=click.getScreenshotAs(OutputType.FILE);
		File dest2=new File("./snap/seat.png");
		FileUtils.copyFile(screen2, dest2);
		driver.switchTo().defaultContent();
		List<WebElement> ListofFrame= driver.findElementsByTagName("iframe");
		int size=ListofFrame.size();
		System.out.println("Number Of Frames:"+size);
		
		
	}

}
