package guru.qa.tests;


import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        //$("practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("[id=firstName]").setValue("Yana");
        $("#lastName").setValue("Veryutina");
        $("#userEmail").setValue("test@test.com");
        $("[for=gender-radio-2]").click();
        //$("#genterWrapper").$(byText("Male")).click(); сработал первый вариант
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        //Перед вводом даты нужно очистить поле?
        //$("#dateOfBirthInput").setValue("06 Jan 1997");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day react-datepicker__day--006").click();

        //$("#subjectsContainer").click();
        $("#subjectsContainer").setValue("Automation");
        $("[for=hobbies-checkbox-3]").click();
      //  $("#uploadPicture").uploadFromClasspath("123456.png");
        $("#currentAddress").setValue("Something");


        $("#currentAddress").setValue("Something");

        $("#submit").scrollTo().click();

    }
}
