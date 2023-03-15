package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import widgets.Header;

public class Home {
    private final Header header = new Header();

    private final SelenideElement searchLine = $(byXpath("//input"));
    private final SelenideElement categoriesSection = $(byXpath("//div[@class='categories-section__inner']"));

    public SelenideElement getSearchLine() {
        return searchLine;
    }

    public SelenideElement getCategoriesSection() {
        return categoriesSection;
    }

    public Header getHeader() {
        return header;
    }

    public Products searchBySearchLine(String product) {
        searchLine.setValue(product).pressEnter();
        return new Products();
    }
}
