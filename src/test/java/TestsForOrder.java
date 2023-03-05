
import PageObjects.OrderPage;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TestsForOrder {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String metroStation;
    private final String comment;
    private final String date;
    private final int rentalPeriod;
    private final String colorOption;
    public TestsForOrder(String firstName, String lastName, String address, String phone, String metroStation, String date, int rentalPeriod, String colorOption, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
        this.metroStation = metroStation;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.colorOption = colorOption;
    }
    @Parameterized.Parameters
    public static Object[][] dataForForm() {
        return new Object[][]{
                {"Мария", "Иванова", "ул пушкина дом колотушкина 25", "89052212323", "Спортивная", "01.03.2023", 1, "black", "Привезите поскорее"},
                {"Кострома", "Иванова", "ул Ленина 34", "89056662323", "Сокольники", "10.03.2023", 2, "grey", "код на двери 666"},
        };
    }
    private WebDriver driver;
    @Before
    public void setUp() {
        // драйвер для браузера Chrome
        // System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
    }
    @Test
    public void testForUpButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderPage objOrder = new OrderPage(driver);

        objOrder.clickOnCreateOrderUpButton();
        objOrder.fillForm(firstName, lastName, address, phone);
        objOrder.fillMetroStation(metroStation);
        objOrder.clickOnNextButton();
        objOrder.fillForm2(date,comment);
        objOrder.chooseRentalPeriod(rentalPeriod);
        objOrder.chooseColor(colorOption);
        objOrder.createOrder();
        objOrder.clickOnYesButton();
        boolean actual = objOrder.checkSuccessfulMessage();
            Assert.assertTrue("Номер заказа не найден:", actual);
        }
    public void testForDownButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderPage objOrder = new OrderPage(driver);

        objOrder.clickOnCreateOrderDownButton();
        objOrder.fillForm(firstName, lastName, address, phone);
        objOrder.fillMetroStation(metroStation);
        objOrder.clickOnNextButton();
        objOrder.fillForm2(date,comment);
        objOrder.chooseRentalPeriod(rentalPeriod);
        objOrder.chooseColor(colorOption);
        objOrder.createOrder();
        objOrder.clickOnYesButton();
        boolean actual = objOrder.checkSuccessfulMessage();
        Assert.assertTrue("Номер заказа не найден:", actual);
    }
        @After
        public void tearDown() throws Exception {
            driver.quit();
        }
    }

