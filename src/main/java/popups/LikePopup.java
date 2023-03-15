package popups;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LikePopup {
    private final SelenideElement saveButton = $(byXpath("//button[@class='footer__btn btn btn--graphite']"));
    private final SelenideElement closeButton = $(byXpath("//div[@class='modal__close-icon btn-close']"));

    public SelenideElement getProduct() {
        return product;
    }

    private final SelenideElement product = $(byXpath("//div[@class='product flex-column middle-xs']"));

    public LikePopup saveLike() {
        saveButton.click();
        return this;
    }

    public void closeLikePopup() {
        closeButton.click();
    }
}
