package Yahoo_Page_Object;

import Reusable_classes.Abstrat_class;
import Reusable_classes.Reusable_Library_logger_POM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Yahoo_Registragion_Page<label> extends Abstrat_class {

        ExtentTest logger;

        public Yahoo_Registragion_Page(WebDriver driver)  {
            super();
            PageFactory.initElements(driver, this);
            this.logger = super.logger;
        }

        @FindBy(xpath = "//*[@name='firstName']")
        public static WebElement firstName;

        @FindBy (xpath = "//*[contains(@name,'lastName')]")
        public static WebElement lastName;

        @FindBy (xpath = "//*[@name='yid']")
        public static WebElement emailAddress;

        @FindBy (xpath = "//*[@placeholder='Password']")
        public static WebElement Password;

        @FindBy(xpath = "//*[@id='usernamereg-phone']")
        public static WebElement phoneNumber;

        @FindBy(xpath = "//*[@name='mm']")
        public static WebElement birthMonth;

        @FindBy (xpath = "//*[@placeholder='Day']")
        public static WebElement birthDay;

        @FindBy (xpath = "//*[contains(@id,'year')]")
        public static WebElement birthYear;

        @FindBy (xpath = "//*[@type='submit']")
        public static WebElement Continue;

        public static WebElement verificationMessage;


        public Yahoo_Registragion_Page verifyTitle (){
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(driver.getTitle(), "Yahoo");
            softAssert.assertAll();
            return new Yahoo_Registragion_Page(driver);
        }

        public Yahoo_Registragion_Page inputfirstName () throws IOException, InterruptedException {
            String firstname = readableSheet.getCell(0, 1).getContents();
            userInput(driver, firstName,0,firstname,logger,"First name");
            return new Yahoo_Registragion_Page(driver);
        }

        public Yahoo_Registragion_Page inputlastName () throws IOException, InterruptedException {
            String lastname = readableSheet.getCell(1,1).getContents();
            userInput(driver, lastName, 0, lastname, logger,"Last Name");
            return new Yahoo_Registragion_Page(driver);
        }

        public Yahoo_Registragion_Page inputemailAddress () throws IOException, InterruptedException {
            String emailaddress = readableSheet.getCell(2,1).getContents();
            userInput(driver, emailAddress, 0, emailaddress, logger, "Email Address");
            return new Yahoo_Registragion_Page(driver);
        }
        public Yahoo_Registragion_Page inputPassword () throws IOException, InterruptedException {
            String password = readableSheet.getCell(3,1).getContents();
            userInput(driver, Password, 0, password, logger, "Password");
            return new Yahoo_Registragion_Page(driver);
        }

        public Yahoo_Registragion_Page inputphoneNumber () throws IOException, InterruptedException {
            String phonenumber = readableSheet.getCell(4,1).getContents();
            userInput(driver, phoneNumber, 0, phonenumber, logger, "Phone Number");
            return new Yahoo_Registragion_Page(driver);
        }

        public Yahoo_Registragion_Page inputbirthMonth () throws IOException, InterruptedException {
            String Birthmonth = readableSheet.getCell(5,1).getContents();
            Reusable_Library_logger_POM.dropDownByText(driver,birthMonth, Birthmonth,0, logger, "Birth Month");
            return new Yahoo_Registragion_Page(driver);
        }

        public Yahoo_Registragion_Page inputbirthDay () throws IOException, InterruptedException {
            String birthday = readableSheet.getCell(6,1).getContents();
            userInput(driver, birthDay, 0, birthday, logger, "Birth Day");
            return new Yahoo_Registragion_Page(driver);
        }

        public Yahoo_Registragion_Page inputbirthYear () throws IOException, InterruptedException {
            String birthyear = readableSheet.getCell(7,1).getContents();
            userInput(driver, birthYear, 0, birthyear, logger, "Birth Year");
            return new Yahoo_Registragion_Page(driver);
        }

        public void pressButton () throws IOException,InterruptedException{
            click(driver,Continue,0,logger,"Continue Button");
        }

        public Yahoo_Registragion_Page inputverificationMessage () throws IOException, InterruptedException {
            String verificationmessage = readableSheet.getCell(8,1).getContents();
            userInput(driver, verificationMessage, 0, verificationmessage, logger, "Verification Message");
            return new Yahoo_Registragion_Page(driver);
        }





    }

