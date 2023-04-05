package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    // локатор для верхней кнопки "Заказать"
    private By createOrderUpButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // локатор для нижней кнопки "Заказать"
    private By createOrderDownButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    // метод для клика по верхней кнопке "Заказать"
    public void clickOnCreateOrderUpButton () {
        driver.findElement(createOrderUpButton).click();
    }
    // метод для клика по нижней кнопке "Заказать"
    public void clickOnCreateOrderDownButton () {
        driver.findElement(createOrderDownButton).click();
    }

    // Поле "Имя"
    private By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    // Поле "Фамилия"
    private By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле "Адрес"
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле "Станция метро"
    private By metroStationField = By.className("select-search__input");
    // первый элемент списка метро
    private By firstMetroStation = By.xpath(".//li[1]");
    // Поле "Телефон"
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка "Далее"
    private By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");


    // метод для заполнения первой формы
    public void fillForm(String firstName, String lastName, String address, String phone) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(phoneField).sendKeys(phone);
    }
    // метод для ожидания прогрузки страницы
    public void waitForLoadPage () {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    // метод для заполнения поля "Станция метро"
    public void fillMetroStation(String metroStation) {
        driver.findElement(metroStationField).sendKeys(metroStation);
        driver.findElement(firstMetroStation).click();
    }
    // метод для клика по кнопке Далее
    public void clickOnNextButton () {
        driver.findElement(nextButton).click();
    }

    // Локатор для поля "Когда привезти самокат"
    private By whenYouGetScooterField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    // Локатор для поля "Срок аренды"
    private By rentalPeriodField = By.className("Dropdown-placeholder");

    // Локатор для выбора из выпадающего списка
    private By setRentalPeriod(int rentalPeriod) {
        return By.xpath(".//div[@class='Dropdown-option'][" + rentalPeriod + "]");
    }
    // локаторы для выбора цвета самоката
    private By setColor(String colorOption) {
        return By.xpath(".//input[@id='" + colorOption + "']");
    }
    // Поле "Комментарий для курьера"
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // локатор для кнопки "Заказать" на странице "Про Аренду"
    private By createOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // локатор для надписи "Заказ оформлен"
    private By successfullyCreatedOrder = By.xpath(".//div[text()='Заказ оформлен']");

    // Метод вводит дату и комментарий
    public void fillForm2(String date, String comment) {
        driver.findElement(whenYouGetScooterField).sendKeys(date);
        driver.findElement(whenYouGetScooterField).sendKeys(Keys.RETURN);
        driver.findElement(commentField).sendKeys(comment);
    }
        // Метод заполеняет поле "Срок аренды"
        public void chooseRentalPeriod(int rentalPeriod) {
            driver.findElement(rentalPeriodField).click();
            driver.findElement(setRentalPeriod(rentalPeriod)).click();
        }

    // метод для выбора цвета самоката
    public void chooseColor(String colorOption) {
        driver.findElement(setColor(colorOption)).click();
    }
    // метод для клика по кнопке Заказать
    public void createOrder () {
        driver.findElement(createOrderButton).click();
    }

    // локатор для кнопки Да
    private By yesButton = By.xpath(".//button[text()='Да']");
    // метод для клика по кнопке Да
    public void clickOnYesButton () {
        driver.findElement(yesButton).click();
    }
    // метод получения сообщения об успешном заказе
    public boolean checkSuccessfulMessage () {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // ожидание загрузки написи
        return driver.findElement(successfullyCreatedOrder).isDisplayed();
    }
}

