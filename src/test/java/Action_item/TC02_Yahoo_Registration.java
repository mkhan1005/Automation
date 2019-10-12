package Action_item;

import Reusable_classes.Abstrat_class;
import org.testng.annotations.Test;

import java.io.IOException;

import static Yahoo_Page_Object.Yahoo_Base_Class.registrationpage;

public class TC02_Yahoo_Registration extends Abstrat_class {

    @Test
    public static void Yahoo_Search_Result() throws IOException, InterruptedException {

        driver.navigate().to("https://login.yahoo.com/account/create?specId=yidReg");

        registrationpage().verifyTitle();
        registrationpage().inputfirstName();
        registrationpage().inputlastName();
        registrationpage().inputemailAddress();
        registrationpage().inputPassword();
        registrationpage().inputphoneNumber();
        registrationpage().inputbirthMonth();
        registrationpage().inputbirthDay();
        registrationpage().inputbirthYear();
        registrationpage().pressButton();
        registrationpage().inputverificationMessage();

    }
}
