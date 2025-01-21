package tests.homeWork;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
//Только после open() ещё стоит вставить код удаления баннеров
//executeJavaScript("$('#fixedban').remove()");
//executeJavaScript("$('footer').remove()");
//Загрузку можно сделать проще - $("#uploadPicture").uploadFromClasspath("sample-pic.jpg");

public class HW_PracticeForm {

    @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void positiveFillForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("some@email.com");
        $("#gender-radio-1").setValue("Male").click();
        $("#userNumber").setValue("7915564712");
        $("").setValue("");

    }
}
