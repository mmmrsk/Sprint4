package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import java.util.concurrent.TimeUnit;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // локатор для вопроса
    private By setQuestionNumber(int questionNumber) {
        return By.xpath(".//div[@class='accordion__item'][" + questionNumber + "]//div[@class='accordion__button']");
    }
    // локатор для текста раскрытого ответа
    private By setAnswerNumber(int questionNumber) {
        return By.xpath(".//div[@class='accordion__item'][" + questionNumber + "]//div[@class='accordion__panel']/p");
    }

    // метод для скролла до вопроса
    public void scrollToQuestion(int questionNumber) {
        WebElement element = driver.findElement(setQuestionNumber(questionNumber));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // метод для клика по вопросу
    public void clickOnQuestion(int questionNumber) {
        driver.findElement(setQuestionNumber(questionNumber)).click();
    }
    // метод для ожидания загрузки текста
    public void waitForLoadDescription (){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    // метод для получения текста ответа
    public String getDescriptionText (int questionNumber){
        return driver.findElement(setAnswerNumber(questionNumber)).getText();
    }

}