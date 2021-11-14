package guru.qa.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @Test
    void fillPracticeFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Yana");
        $("#lastName").setValue("Veryutina");
        $("#userEmail").setValue("test@test.com");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("1234567890");
        //$("#dateOfBirthInput").click();
        //Перед вводом даты нужно очистить поле
        $("#dateOfBirthInput").setValue("06 Jan 1997");
        //$("#subjectsContainer").click();
        $("#subjectsContainer").setValue("Automation");
        $("[for=hobbies-checkbox-3]").click();
      //  $("#uploadPicture").uploadFromClasspath("123456.png");
        $("#currentAddress").setValue("Something");


        $("#currentAddress").setValue("Something");

        $("#submit").scrollTo().click();

    }
}
