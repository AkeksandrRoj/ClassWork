package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

        @Test
        void fillFormTest() {
            open("/text-box");
            $("#userName").setValue("Alex");
            $("#userEmail").setValue("roj@mail.org");
            $("#currentAddress").setValue("new_address");
            $("#permanentAddress").setValue("old_address");
            $("#submit").click();

            $("#output #name").shouldHave(text("Alex"));
            $("#output #email").shouldHave(text("roj@mail.org"));
            $("#output #currentAddress").shouldHave(text("new_address"));
            $("#output #permanentAddress").shouldHave(text("old_address"));
        }

    }
