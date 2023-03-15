package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class Products {
    private final SelenideElement productCart = $(byXpath("//div[@class='list-item list-item--row']"));
    private final SelenideElement comparePricesButton = $(byXpath("//a[@class='btn btn--orange']"));

    public SelenideElement getComparePricesButton() {
        return comparePricesButton;
    }

    public SelenideElement getProductCart() {
        return productCart;
    }

    public Product openProduct() {
        comparePricesButton.click();
        return new Product();
    }

    public Products checkbox(String checkboxName) {
        actions().scrollToElement($(byText(checkboxName))).click().perform();
        return this;
    }

}
