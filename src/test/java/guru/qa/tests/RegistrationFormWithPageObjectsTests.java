package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjectsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

       new RegistrationPage().setFirstName("Yana");
       new RegistrationPage().setLastName("Veryutina");

        $("#userEmail").setValue("test@test.com");
        $("[for=gender-radio-2]").click();

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();


        $("#subjectsInput").setValue("Maths").pressEnter();
        $("[for=hobbies-checkbox-3]").click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/123456.png"));

        $("#currentAddress").setValue("Something");

        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).scrollTo().click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Yana Veryutina"), text("test@test.com"));
        new RegistrationPage().checkForm("Student Name", "Yana Veryutina");
        new RegistrationPage().checkForm("Student Email", "test@test.com");
        new RegistrationPage().checkForm("Gender", "Female");

    }

}
