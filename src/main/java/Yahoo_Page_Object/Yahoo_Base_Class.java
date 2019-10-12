package Yahoo_Page_Object;

import Reusable_classes.Abstrat_class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Base_Class extends Abstrat_class {

    public Yahoo_Base_Class(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    //// Object for yahoo home page
    public static Yahoo_Homepage yahoo_homepage() {
        Yahoo_Homepage yahoo_homepage = new Yahoo_Homepage(driver);
        return yahoo_homepage;
    }

    //// Object for yahoo home page
    public static Yahoo_SearchResultPage yahoo_searchResultPage() {
        Yahoo_SearchResultPage yahoo_searchResultPage = new Yahoo_SearchResultPage(driver);
        return yahoo_searchResultPage;
    }

    ////Object for registration page
    public static Yahoo_Registragion_Page registrationpage() {
        Yahoo_Registragion_Page registrationpage = new Yahoo_Registragion_Page(driver);
        return registrationpage;
    }

    ////Object for registration page
    public static Review_Yahoo_Registration_Page RegistrationPage() {
        Review_Yahoo_Registration_Page RegistrationPage = new Review_Yahoo_Registration_Page(driver);
        return RegistrationPage;
    }


}


