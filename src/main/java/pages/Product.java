package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import popups.LikePopup;
import widgets.Header;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class Product {

    Header header = new Header();

    private final SelenideElement likeButton = $(byXpath("//div[@class='bookmark-button flex']"));

    public Header getHeader() {
        return header;
    }

    public LikePopup likeButton() {
    likeButton.click();
    return new LikePopup();
    }

}
