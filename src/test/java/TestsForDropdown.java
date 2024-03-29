
import PageObjects.MainPage;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestsForDropdown {
    private WebDriver driver;
    private final int questionNumber;
    private final String expectedAnswer;

    public TestsForDropdown(int questionNumber, String expectedAnswer) {
        this.questionNumber = questionNumber;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] questionAnswers() {

        return new Object[][]{
                { 1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { 2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { 3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { 4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                { 5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                { 6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                { 7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                { 8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    @Before
    public void setUp() {
        // драйвер для браузера Chrome
        // System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void testForTextInAnswers() {
            driver.get("https://qa-scooter.praktikum-services.ru/");
            MainPage objMainPage = new MainPage(driver);

            objMainPage.scrollToQuestion(questionNumber);
            objMainPage.clickOnQuestion(questionNumber);
            objMainPage.waitForLoadDescription();
            String actualTextAnswer = objMainPage.getDescriptionText(questionNumber);
            assertEquals("Текст не совпадает", expectedAnswer, actualTextAnswer);

        }
        @After
        public void tearDown() {
            driver.quit();
        }
    }

