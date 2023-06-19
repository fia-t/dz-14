package pageobjects.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.AbstractPageObject;

public class elementsPage extends AbstractPageObject {

    private final By btnButtons = By.cssSelector(".show ul #item-4");

    public elementsPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/elements");
    }

    @Step("The user click on element Buttons")
    public buttonsPage clickOnElementButton(){
        waitTillAppears(btnButtons,20);
        clickOnElementWithJs(btnButtons);
        return new buttonsPage(driver);
    }
}
