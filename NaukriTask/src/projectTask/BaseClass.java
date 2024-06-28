package projectTask;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	protected static ArrayList<String> list=new ArrayList<String>();

	protected static WebDriver driver=null;
	
	//How to launch browser
	public static void browserSetup(String browserName)
	{
		if(browserName.equalsIgnoreCase(Constants.chromeBrowser))
		{
			driver=new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase(Constants.edgeBrowser))
		{
			driver=new EdgeDriver();
		}

		else if(browserName.equalsIgnoreCase(Constants.firefoxBrowser))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new IllegalArgumentException(Constants.warningMessage);
		}
	}

	//How to maximize the window
	public static void maximize()
	{
		driver.manage().window().maximize();
	}

	//How to minimize the window
	public static void minimize()
	{
		driver.manage().window().minimize();
	}

	//Implicit wait
	public static void implictWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.longWait));
	}

	//Implicit wait with parameter
	public static void implictWait(int wait)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
	}

	//How to launch the URL
	public static void passURL(String url)
	{
		driver.get(url);
	}

	//How to read the Title
	public static String printTitle()
	{
		return driver.getTitle();
	}

	//How to read the URL
	public static String printCurrentURL()
	{
		return driver.getCurrentUrl();
	}

	//How to pass input to field
	public static void sendKeys(By locator,String value)
	{
		WebElement element = driver.findElement(locator);
		element.sendKeys(value);
	}

	//How to click the element
	public static void click(By locator)
	{
		WebElement element = driver.findElement(locator);
		element.click();
	}

	//How to find multiple webelements
	public static List<WebElement> findElements(By locator)
	{
		return driver.findElements(locator);
	}

	//How to perform scroll
	public static void scrollingDown(int xaxis,int yaxis)
	{
		JavascriptExecutor script=(JavascriptExecutor)driver;
		script.executeScript("window.scrollBy("+xaxis+","+yaxis+")");
	}

	//How to close the entire window
	public static void quit()
	{
		driver.quit();
	}
}
