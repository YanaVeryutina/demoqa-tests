package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Some Name");
        $("#userEmail").setValue("aaaaa@a.aa");
        $("#currentAddress").setValue("Some address");
        $("#permanentAddress").setValue("Another address");
        $("#submit").scrollTo();
        $("#submit").click();

        $("#submit").click();

        $("#output #name").shouldHave(text("Some Name"));
        $("#output #email").shouldHave(text("aaaaa@a.aa"));
        $("#output").$("#currentAddress").shouldHave(text("Some address"));
        $("#output").$("#permanentAddress").shouldHave(text("Another address"));

        //$("#output").shouldHave(text("Some Name")), (text("aaaaa@a.aa")), (text("Some address")), (text("Another address"));
    }
}
