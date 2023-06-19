package pageobjects.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.AbstractPageObject;

public class buttonsPage extends AbstractPageObject {
    private final By btnClickMe = By.cssSelector("div.col-md-6 div.mt-4:last-child button");
    private final By messageClickMe = By.cssSelector("#dynamicClickMessage");
    public buttonsPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/buttons");
    }

    @Step("The user wait and click on button Click Me")
    public String clickOnButtonClickMe(){
        waitTillAppears(btnClickMe);
        getElement(btnClickMe).click();

        return getElement(messageClickMe).getText();
    }

}
