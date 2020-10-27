package elements;

import net.serenitybdd.screenplay.targets.IFrame;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class InterzoidElements {

    private static final IFrame IFRAME = IFrame.withPath(By.xpath("//iframe"));

    public static final Target ASSERT_HOME = Target.the("Home logo").locatedBy("//*[@id=\"title\"]/img").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target BTN_REGISTER_HOME = Target.the("Button to click register").locatedBy("//*[@id=\"navbarSupport1\"]/div[2]/a[1]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_FIRST_NAME = Target.the("Field for name input").locatedBy("//*[@id=\"first\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_LAST_NAME = Target.the("Last name input field").locatedBy("//*[@id=\"last\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_EMAIL = Target.the("Field for email input").locatedBy("//*[@id=\"email\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_CONFIR_EMAIL = Target.the("Field for confirm email input").locatedBy("//*[@id=\"confirmemail\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_PASSWORD = Target.the("Field for password input").locatedBy("//*[@id=\"password\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_CONFIR_PASSWORD = Target.the("Field for confirm password input").locatedBy("//*[@id=\"confirmpassword\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_TITLE = Target.the("Field for title input").locatedBy("//*[@id=\"title\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_COMPANY = Target.the("Field for campany input").locatedBy("//*[@id=\"company\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_PHONE = Target.the("Field for phone input").locatedBy("//*[@id=\"phone\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_ADDRESS1 = Target.the("Field for address 1 input").locatedBy("///*[@id=\"address1\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_ADDRESS2 = Target.the("Field for address 2 input").locatedBy("//*[@id=\"address2\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_CITY = Target.the("Field for city input").locatedBy("//*[@id=\"city\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_STATE = Target.the("Field for state input").locatedBy("//*[@id=\"state\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_POSTAL = Target.the("Field for postal code input").locatedBy("//*[@id=\"postal\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_COUNTRY = Target.the("Field for country input").locatedBy("//*[@id=\"country\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_REFERRAL = Target.the("Field for referral code input").locatedBy("//*[@id=\"referral\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target INPUT_QUESTION = Target.the("Field for question answer input").locatedBy("//*[@id=\"whereheard\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target CHECKBOX_RECAPTCHA = Target.the("Checkbox for recaptcha").inIFrame(IFRAME).locatedBy("//*[@id=\"recaptcha-anchor\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target CHECKBOX_TERMS = Target.the("Checkbox for terms").locatedBy("//*[@id=\"acceptCheckbox\"]").waitingForNoMoreThan(Duration.ofSeconds(60));
    public static final Target BTN_REGISTER = Target.the("Button to click register").locatedBy("//*[@id=\"sbut\"]").waitingForNoMoreThan(Duration.ofSeconds(60));





}
