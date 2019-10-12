package Action_item;

import Reusable_classes.Abstrat_class;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static Yahoo_Page_Object.Yahoo_Base_Class.RegistrationPage;


public class review_Yahoo extends Abstrat_class {

    Workbook readable = null;
    Sheet readableSheet = null;
    WritableWorkbook writable = null;
    WritableSheet wSheet = null;
    int readableRows = 0;

    @Test
    public void Review_Yahoo_Registration_Page() throws IOException, InterruptedException, BiffException, WriteException {
        readable = Workbook.getWorkbook(new File("src\\main\\resources\\this.xls"));
        readableSheet = readable.getSheet(0);
        writable = Workbook.createWorkbook(new File("src\\main\\resources\\thisResults.xls"),readable);
        readableRows = readableSheet.getRows();
        wSheet = writable.getSheet(0);
        String firstName = null,lastName = null,email = null,password = null,phoneNumber = null;
        String birthMonth = null,birthDay = null,birthyear = null;

        for(int i=1;i < readableRows;i++) {
            firstName = readableSheet.getCell(0,i).getContents();
            lastName = readableSheet.getCell(1,i).getContents();
            email = readableSheet.getCell(2,i).getContents();
            password = readableSheet.getCell(3,i).getContents();
            phoneNumber = readableSheet.getCell(4,i).getContents();
            birthMonth = readableSheet.getCell(5,i).getContents();
            birthDay = readableSheet.getCell(6,i).getContents();
            birthyear = readableSheet.getCell(7,i).getContents();

            logger.log(LogStatus.INFO, "Navigating to Yahoo registration page");
            driver.navigate().to("https://login.yahoo.com/account/create?specId=yidReg");
            RegistrationPage().FirstName(firstName);
            RegistrationPage().LastName(lastName);
            RegistrationPage().Email(email);
            RegistrationPage().Password(password);
            RegistrationPage().PhoneNum(phoneNumber);
            RegistrationPage().BirthMonth(birthMonth);
            RegistrationPage().BirthDay(birthDay);
            RegistrationPage().BirthYear(birthyear);
            RegistrationPage().ContinueButton();
            String Message = RegistrationPage().captchaMessage();

            Label label = new Label(8,i,Message);
            wSheet.addCell(label);
            //delete all cookies
            driver.manage().deleteAllCookies();
        }//end of loop

        writable.write();
        writable.close();
        readable.close();

    }//end of test

}//end of class
