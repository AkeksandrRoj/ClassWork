package tests;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpathExample() {
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid= email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");
        $x("//*[@data-testid= 'email']").setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email"
        $("[id= email]").setValue("1");
        $(by("id", "email")).setValue("1");
        $(byId("email")).setValue("1");
        $("#name").setValue("2");
        $x("//*[@id= 'email']").setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email"
        $("[name= email]").setValue("1");
        $(by("name", "email")).setValue("1");
        $(byName("email")).setValue("1");
        $x("//*[name= 'email']").setValue("1");

        // <input type="email" class="inputtext login_form_input_box"
        $("[class=inputtext] [class=login_form_input_box]").setValue("1");
        $(by("class", "inputtext")).setValue("1");
        $(".inputtext.login_form_input_box").setValue("1");
        $x("//*[@class='inputtext']").setValue("1");

        // <div class="inputText">
        //      <input type="email" class="login_form_input_box">
        // </div>
        $(".inputText .login_form_input_box").setValue("1");
        $("inputText").$("login_form_input_box").setValue("1");
        $("div.inputText").$("input.login_form_input_box").setValue("1");

        // <div>Hello, qa.guru!</div>
        $(byText("Hello, qa.guru!"));
        $(withText(", qa.guru!"));
        $x("//*[text()='\"Hello, qa.guru!']");
        $x("//*[contains(text(),'Hello, qa.guru!')]");

    }
}
