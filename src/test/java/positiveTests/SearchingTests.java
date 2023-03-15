package positiveTests;

import org.junit.jupiter.api.Test;
import pages.Home;
import pages.Products;
import utils.UserGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class SearchingTests extends BaseTest {
    Home homePage = new Home();

    @Test
    public void homePageTest() {
        homePage.getHeader().getLogin().should(visible);
        homePage.getHeader().getCatalogButton().should(visible);
        homePage.getHeader().getLogo().should(visible);
        homePage.getSearchLine().should(visible);
        homePage.getCategoriesSection().should(visible);
    }

    @Test
    public void searchLineTest() {
        homePage
                .searchBySearchLine("Холодильник")
                .getComparePricesButton()
                .should(visible);
    }

    @Test
    public void openCatalog() {
        homePage.getHeader().openCatalog();
    }

    @Test
    public void selectProductByCatalogTest(){
        homePage
                .getHeader()
                .openCatalog()
                .choiceCategory("Офіс")
                .openProducts("Ручки подарункові");
    }

    @Test
    public void likeTest() {
        homePage
                .searchBySearchLine("Iphone")
                .openProduct()
                .likeButton()
                .saveLike()
                .getProduct()
                .should(visible);
    }

    @Test
    public void checkboxTest() {
        open("https://hotline.ua/ua/bt/posudomoechnye-mashiny/");
        Products productsPage = new Products();
        productsPage.checkbox("Bosch");
    }

    @Test
    public void registration() {
        homePage
                .getHeader()
                .openLogin()
                .registration()
                .addEmail(UserGenerator.generateEmail())
                .addName(UserGenerator.generateName())
                .addPassword(UserGenerator.generatePassword());
    }
}
