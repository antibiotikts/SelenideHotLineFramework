package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class Login {
    private final SelenideElement registerHref = $(byXpath("//a[@href='/register/']"));

    public Registration registration() {
        registerHref.click();
        return new Registration();
    }
}