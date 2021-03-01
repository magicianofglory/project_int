import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebscrappingOflinks {
	
		//Creating web driver object
		WebDriver driver=new ChromeDriver();  
		
		//Creating collection object for  list 
		List<WebElement> allLinks;  
		
		//Creating key,value pair for HapMap
		static HashMap<String,String>alllinkMap= new HashMap<>();
		
		//Creating the WebElement object
		static WebElement link;
		
	public void launching()
	{	
		//Setting the property for wedriver
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe"); //Can put your location of chromdriver
		
		//Taking input from user
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
		System.out.print("Please enter the Url starting with the https: ");
		String a= sc.next();
		
		//Launching  website 
		driver.get(a);
		
		//Maximize the browser
		driver.manage().window().maximize();
	}
	
	public void GetLinks()
	 {
		 //Get list of web-elements with tagName  - a
		 allLinks = driver.findElements(By.tagName("a"));
		 
		 //Travel through the list and printing its text along with link address
		for(WebElement link:allLinks)
		 {
		 System.out.println(link.getText() + " - " + link.getAttribute("href"));
		 String LT=link.getText();
		 String LA=link.getAttribute("href");
		 alllinkMap.put(LT, LA);
		 }
	}
	
	 public void ClosingDriver()
	 {
		 //To close the browser 
		 driver.close();
	}
	 
	public static void main(String[] args) throws IOException 
	{
			WebscrappingOflinks obj=new WebscrappingOflinks(); //Creating the class object
			obj.launching(); 								   //Calling the function to open the browser and enter url
			obj.GetLinks();									   //Calling the function to get all links inside the url
			 for(Map.Entry<String,String> eachMapItem : alllinkMap.entrySet())
				{
					System.out.println(eachMapItem.getKey()+" ---- " +eachMapItem.getValue());
				}
			 		ExcelFunctions ef=new ExcelFunctions();		//Creating the object for class
			 		ef.SaveDataToExcel(alllinkMap);
			 		obj.ClosingDriver();

	}
		
	}


		
