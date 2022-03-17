package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponents calendarComponents = new CalendarComponents();


    //locators
    SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genderWapper = $("#genterWrapper"),
            subjectsInput = $("#subjectsInput"),
            hobbyWrapper = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            uploadPictureInput = $("#uploadPicture"),
            stateWrapper = $("#stateCity-wrapper"),
            cityWrapper = $("#stateCity-wrapper"),
            headerOfSubmitForm = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");


    //actions

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public void setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
    }

    public RegistrationPage setGenderWrapper(String gender) {
        genderWapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesWrapper(String hobby) {
        hobbyWrapper.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage setUploadPicture(String picture) {
        uploadPictureInput.uploadFile(new File(picture));
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage setStateWrapper(String state) {
        $("#state").scrollTo().click();
        stateWrapper.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCityWrapper(String city) {
        $("#city").click();
        cityWrapper.$(byText(city)).scrollTo().click();
        return this;
    }

    public RegistrationPage submitForm() {
        $("#submit").click();
        return this;
    }

    public RegistrationPage checkHeaderOfSubmitForm() {
        headerOfSubmitForm.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

}

