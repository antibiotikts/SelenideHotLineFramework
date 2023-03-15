package widgets;

import com.codeborne.selenide.SelenideElement;
import pages.Catalog;
import pages.Likes;
import pages.Login;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Header {

    private final SelenideElement logo = $(byXpath("//div[@class='flex middle-xs logo-container']"));
    private final SelenideElement catalogButton = $(byXpath("//div[@class='header-catalog-button']"));
    private final SelenideElement location = $(byXpath("//div[@class='location flex middle-xs']"));
    private final SelenideElement language = $(byXpath("//div[@class='lang-button flex middle-xs center-xs header__lang-icon']"));
    private final SelenideElement comparison = $(byXpath("//div[@class='button flex-column middle-xs center-xs header__icon']"));
    private final SelenideElement like = $(byXpath("//div[@class='button flex-column middle-xs center-xs header__icon']"));
    private final SelenideElement login = $(byXpath("//div[@class='user-button__image flex middle-xs center-xs']"));

    public SelenideElement getLogo() {
        return logo;
    }

    public SelenideElement getCatalogButton() {
        return catalogButton;
    }

    public SelenideElement getLogin() {
        return login;
    }

    public Catalog openCatalog() {
        catalogButton.click();
        return new Catalog();
    }

    public Likes openLikes() {
        like.click();
        return new Likes();
    }

    public void choiceLocation() {
        location.click();
    }

    public Login openLogin() {
        login.click();
        return new Login();
    }

}


