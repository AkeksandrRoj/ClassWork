package tests.homeWork;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//Загрузку можно сделать проще - $("#uploadPicture").uploadFromClasspath("sample-pic.jpg");

public class HW_PracticeForm {

    @BeforeAll
   public static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
       // Configuration.holdBrowserOpen = true;
    }

    @Test
    public void positiveFillForm() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('#footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("petr@email.gov");
//             GENDER
//        $("gender-radio-1").click();        // wrong
//        $("#gender-radio-2").parent().click();      //good
        $("#genterWrapper").$(byText("Male")).click();      // BEST
//        $("[for=gender-radio-2]").click();    //good
        $("#userNumber").setValue("77961459595");

//        DATE IF BIRTH
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOptionByValue("1976");
       // $(".react-datepicker__year-select").selectOption("1976");
        $(".react-datepicker__day--010").click();

//        SUBJECTS
        $("#subjectsInput").setValue("English").pressEnter();
//        HUBBIES
//        $("#hobbies-checkbox-1").parent().click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
//         LOAD PICTURE
        $("#uploadPicture").uploadFromClasspath("img/some.png");
//      $("#uploadPicture").uploadFile(new File("src/test/resources/img/some.png"));

        $("#currentAddress").setValue("Something address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alexander"), text("Petrov"), text("petr@email.gov"));
    }
}













