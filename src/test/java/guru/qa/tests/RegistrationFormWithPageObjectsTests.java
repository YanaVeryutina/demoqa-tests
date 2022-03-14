package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
;

public class RegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Yana",
            lastName = "Veryutina",
            userEmail = "yana@kor.com",
            gender = "Female",
            userNumber = "1234567890",
            birthayDay = "6",
            birhdayMonth = "January",
            birthayYear = "1997",
            subject = "Math",
            hobby = "Music",
    address = "Your address";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail);
        registrationPage.setGenderWrapper(gender)
                .setUserNumber(userNumber)
                .setBirthDate(birthayDay, birhdayMonth, birthayYear)
                .setSubject(subject)
                .setHobbiesWrapper(hobby);
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/123456.png"));

        registrationPage.setCurrentAddress(address);

        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).scrollTo().click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        registrationPage
                .checkForm("Student Name", firstName + " Veryutina")
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", gender);

    }

}
