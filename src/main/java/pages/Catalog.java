package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class Catalog {
    private final SelenideElement catalog = $(byXpath("//nav[@class='menu-main active']"));

    public Catalog choiceCategory(String category) {
        actions().moveToElement(catalog.find(byText(category))).perform();
        return this;
    }

    public void openProducts(String product) {
        $(byText(product)).click();
    }
}
