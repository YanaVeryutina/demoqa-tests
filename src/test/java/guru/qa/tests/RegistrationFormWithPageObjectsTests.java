package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Yana",
            lastName = "Veryutina",
            userEmail = "yana@kor.com",
            gender = "Female",
            userNumber = "1234567890",
            birthdayDay = "6",
            birthdayMonth = "January",
            birthdayYear = "1997",
            subject = "Math",
            hobby = "Music",
            picture = "src/test/resources/img/123456.png",
            address = "Your address",
            state = "NCR",
            city = "Delhi";

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
                .setBirthDate(birthdayDay, birthdayMonth, birthdayYear)
                .setSubject(subject)
                .setHobbiesWrapper(hobby)
                .setUploadPicture(picture)
                .setCurrentAddress(address)
                .setStateWrapper(state)
                        .setCityWrapper(city)
                .submitForm()
                .checkHeaderOfSubmitForm()
                .checkForm("Student Name", firstName + " " + lastName )
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", gender);

    }

}
