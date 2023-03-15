package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Registration {
    private final SelenideElement emailInput = $(byXpath("//input[@class='field m_b-sm']"));
    private final SelenideElement nameInput = $(byXpath("//input[@name='name']"));
    private final SelenideElement passwordInput = $(byXpath("//input[@name='password']"));

    public Registration addEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public Registration addName(String name) {
        nameInput.setValue(name);
        return this;
    }

    public Registration addPassword(String surname) {
        passwordInput.setValue(surname);
        return this;
    }

}
