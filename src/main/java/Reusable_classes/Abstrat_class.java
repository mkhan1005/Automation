package Reusable_classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import static Reusable_classes.Reusable_Library_logger_POM.getDateTime;
import static Reusable_classes.Reusable_Library_logger_POM.navigate;

public class Abstrat_class extends Reusable_Library_logger_POM{
    public static WebDriver driver = null;
    public static ExtentReports report = null;
    public static ExtentTest logger = null;
    public static Workbook readableFile;
    public static WritableWorkbook writeableFile;
    public static Sheet readableSheet;
    public static WritableSheet wSheet;
    public static int rows;


    @BeforeSuite()
    public static void openBrowser() throws IOException, BiffException {
        //path to your report
        report = new ExtentReports("src\\main\\java\\Report_Folder\\AutomationReport" + getDateTime() + ".html", true);
        logger = report.startTest("Yahoo Testing");
        readableFile = Workbook.getWorkbook(new File("src\\main\\resources\\YahooRegistration.xls"));
        writeableFile = Workbook.createWorkbook(new File("src\\main\\resources\\YahooRegistrationResults.xls"), readableFile);
        readableSheet = readableFile.getSheet(0);
        wSheet = writeableFile.getSheet(0);
        rows = wSheet.getRows();
    }//end of before suite

    @Parameters("Browser")
    @BeforeMethod
    public static void captureTestName(String Browser,Method methodName) throws IOException {
        if(Browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if(Browser.equalsIgnoreCase("Chrome")) {
            driver = navigate(driver, "https://www.google.com");
        }
        //path t
        //logger below will get the actual name of each of your @Test method(s)
        logger = report.startTest(methodName.getName() + "--" + Browser);
        logger.log(LogStatus.INFO,"Automation Test Scenario Started....");
    }//end of before method

    @AfterMethod
    public static void endTest(){
        report.endTest(logger);
        logger.log(LogStatus.INFO,"Automation Test Scenario ended....");
    }//end of after method


    @AfterSuite
    public void closeBrowser(){
        report.flush();
        report.close();
        //driver.quit();

//        @AfterSuite
//     public void writeablesheet(){


        }


    }//end of after suite









