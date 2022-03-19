package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	
	public static WebDriver driver;
	XSSFWorkbook wbook;// creating object of workbook
	XSSFSheet sheet;//creating object for Excel sheet
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeTest
	public void DataSetup() throws IOException {
		FileInputStream file=new FileInputStream("TestData.xlsx");
		wbook= new XSSFWorkbook(file);
		sheet= wbook.getSheet("Sheet1");
		
		report=new ExtentReports("ExtentReport.html");
	}
	
	@AfterTest
	public void DataTearDown() throws IOException {
		
		wbook.close();
		report.flush();
		report.close();	
	}
	
	@BeforeMethod
	public void Setup(Method method) {
		
		test = report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.simplilearn.com");
		driver.manage().window().maximize();//To maximize the window size
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
	}

	@AfterMethod
	public void TearDown() {
		
		report.endTest(test);
		driver.quit();	
	}
}
