package testng0929;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Extent_Report_Test {
    WebDriver driver = null;
    ExtentReports reports = null;
    ExtentTest logger = null;

    @BeforeSuite
    public void openBrowser() {

    }

    @Test
    public void test() {


    }

    @AfterSuite
    public void closeBrowser() {


    }






















}
