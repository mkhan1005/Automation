/*
package testNg_1005;

import Reusable_classes.Abstrat_class;
import Reusable_classes.Reusable_Library_loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static Reusable_classes.Reusable_Library_loggers.clickByIndex;

public class Express_Abstract extends Abstrat_class {
    Workbook readFile = null;
    WritableWorkbook writeFile = null;
    Sheet readSheet = null;
    WritableSheet writeSheet = null;
    int rows = 0;


    @Test
    public void ExpressCheckout() throws InterruptedException, WriteException, IOException, BiffException {
        //access readable excel workbook
        readFile = Workbook.getWorkbook(new File("src\\main\\resources\\express.xls"));
        // create duplicate workbook to input new data
        writeFile = Workbook.createWorkbook(new File("src\\main\\resources\\express_results.xls"), readFile);
        // create writable sheet
        writeSheet = writeFile.getSheet(0);
        // access readable sheet to retrieve data
        readSheet = readFile.getSheet(0);
        rows = readSheet.getRows();
        System.out.println("Number of rows in express sheet is: " + rows);

        // begin iteration
        for (int i = 1; i < 2; i++) {

            // store excel values in string
            String size = readSheet.getCell(0, i).getContents();
            String sizeNum = readSheet.getCell(1, i).getContents();
            String quantity = readSheet.getCell(2, i).getContents();
            String firstName = readSheet.getCell(3, i).getContents();
            String lastName = readSheet.getCell(4, i).getContents();
            String email = readSheet.getCell(5, i).getContents();
            String phoneNum = readSheet.getCell(6, i).getContents();
            String address = readSheet.getCell(7, i).getContents();
            String zipCode = readSheet.getCell(8, i).getContents();
            String city = readSheet.getCell(9, i).getContents();
            String state = readSheet.getCell(10, i).getContents();
            String cardNum = readSheet.getCell(11, i).getContents();


            //1. re-navigate to express
            logger.log(LogStatus.INFO, "Navigating to Express home page on iteration " + i);
            driver.navigate().to("https://express.com");
            //2.verify title
            String expectedTitle = "Men’s and Women’s Clothing";
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Home page title matches. Expected title is: " + expectedTitle + " Actual title is: " + actualTitle);
            } else {
                System.out.println("Home page title does not match. Expected title: " + expectedTitle + " Actual title: " + actualTitle);
            }// end of if else

            //3.hover to womens clothing
            mouseHover(driver, "//*[@href='/womens-clothing']",0, logger, "Women");
            //4.hover to dresses
            mouseHover(driver, "//*[contains(@href,'/womens-clothing/dresses/cat550007')]",0, logger, "Dresses");
            //5.click on jumpsuits & rompers
            click(driver, "//*[contains(text(),'Jumpsuits & Rompers')]",0, logger, "Jumpsuits & Rompers");

            Thread.sleep(1000);

            //6.scroll down 400 pixels
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0,5000)");

            //7. Click on first image //use @src property with contains to match up to fashion keyword
            clickByIndex(driver, "//*[@class='active loaded']", 0, logger, "First Result");

            //8. choose size
            Thread.sleep(3500);
            //Reusable_Library.click(driver, "//button[contains(@value,'"+size+"')]", "Size" );
            try {
                System.out.println("Clicking on Size by Text");
                logger.log(LogStatus.INFO, "Clicking on Size by Text");
                driver.findElement(By.xpath("//*[@value='" + size + "']")).click();
            } catch (Exception e) {
                System.out.println("Clicking on Size by Number");
                logger.log(LogStatus.INFO, "Clicking on Size by Number");
                driver.findElement(By.xpath("//*[@value='" + sizeNum + "']")).click();
            }

            //9. Click Add to Bag
            click(driver, "//button[contains(text(),'Add to Bag')]",0, logger, "Add To Bag");

            //10. Click on Checkout from Popup
            click(driver, "//*[text()='CHECKOUT']", 0,logger, "Checkout");

            //11.Select Quantity from drop down
            dropDownByText(driver, "//*[contains(@id,'quantity')]", quantity, 10, logger, "Quantity");

            //12. Click on Checkout
            click(driver, "//*[text()='Checkout']",0, logger, "Checkout");

            //13. Click on checkout as guest
            click(driver, "//*[contains(text(),'Continue as Guest')]",0, logger, "Continue as Guest");

            //14. Input first name
            userInput(driver, "//*[@name='firstname']", firstName,0, logger, "First Name");

            //15. Input last name
            userInput(driver, "//*[@name='lastname']", lastName,1,logger, "Last Name");

            //16. Input email address
            userInput(driver, "//*[@name='email']", email,2, logger, "Email Address");

            //17. Re-input to confirm email address
            userInput(driver, "//*[@name='confirmEmail']", email,3, logger, "Last Name");

            //18. Input phone number
            userInput(driver, "//*[@name='phone']", phoneNum,4, logger, "Phone Number");

            //19. Click continue
            click(driver, "//*[text()='Continue']",5, logger, "Continue");

            //20. Click on continue again
            click(driver, "//*[text()='Continue']",6, logger, "Continue");

            //21. Input address
            userInput(driver, "//*[contains(@aria-label,'Street Address')]", address,7, logger, "Streetaddress");

            //22. Input postal code
            userInput(driver, "//*[contains(@aria-label,'Postal Code')]", zipCode,8, logger, "Zip Code");

            //23. Input city
            userInput(driver, "//*[contains(@aria-label,'City')]", city,9, logger, "City");

            //24.Choose state
            dropDownByText(driver, "//*[@name='shipping.state']", state,10, logger, "State");

            //25. click on continue
            click(driver, "//*[text()='Continue']",11, logger, "Continue");

            //26. clear and enter card num
            userInput(driver, "//*[contains(@aria-label,'Credit Card Number')]", cardNum,12, logger, "Card Number");

            //27. click on place order\
            click(driver, "//*[contains(text(),'Place Order')]",0, logger, "Place Order");

            //28. Print credit card message error
            String cardErrorMsg = new String();
            try {
                logger.log(LogStatus.INFO, "Verifying Credit Card error message");
                cardErrorMsg = driver.findElement(By.xpath("//div[contains(text(),'valid credit card')]")).getText();
            } catch (Exception e) {
                System.out.println("card error message not avaialable" + e);
            }

            Label label = new Label(12, i, cardErrorMsg);
            writeSheet.addCell(label);

            //29. delete all cookies
            driver.manage().deleteAllCookies();

        } // end of loop
        writeFile.write();
        writeFile.close();
        readFile.close();

    }//end of test

}

*/
