package positiveTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        timeout = 4000;
        browser = "firefox";
        browserSize = "1920x1080";
    }

    @BeforeEach
    public void openUrl() {
        open("https://hotline.ua/");
    }
}
