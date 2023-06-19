package pageobjects.webtables;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.AbstractPageObject;

public class deletePage extends AbstractPageObject {
    private final By deleteButton = By.cssSelector("#delete-record-4");
    private final static int timeout = 40;

    public deletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Delete added user")
    public searchPage deleteUser(){
        waitTillAppears(deleteButton,timeout);
        getElement(deleteButton).click();
        return new searchPage(driver);
    }


}
