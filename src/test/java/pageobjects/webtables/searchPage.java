package pageobjects.webtables;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.AbstractPageObject;

import java.time.Duration;

public class searchPage extends AbstractPageObject {

    private final By searchField = By.cssSelector("#searchBox");
    public final By searchResultEmail = By.cssSelector("div.rt-tr-group:nth-child(1) div div:nth-child(4)");
    private final By searchResultFirstName = By.cssSelector("div.rt-tr-group:nth-child(1) div div:nth-child(1)");
    private final By searchResultLastName = By.cssSelector("div.rt-tr-group:nth-child(1) div div:nth-child(2)");
    private final By searchResultAge = By.cssSelector("div.rt-tr-group:nth-child(1) div div:nth-child(3)");
    private final By searchResultSalary = By.cssSelector("div.rt-tr-group:nth-child(1) div div:nth-child(5)");
    private final By searchResultDepartment = By.cssSelector("div.rt-tr-group:nth-child(1) div div:nth-child(6)");
    private final static int timeout = 40;

    public searchPage(WebDriver driver) {

        super(driver);
    }

    @Step("The user search new User by [{data}]")
    public searchPage searchUser(String data){
        getElement(searchField).sendKeys(data);
        waitTillAppears(searchResultEmail,timeout);
        return new searchPage(driver);
    }
    @Step("Find new User by email")
    public String newUsersEmail(){
        waitTillAppears(searchResultEmail,timeout);
        return getElement(searchResultEmail).getText();
    }
    @Step("Find new User by firstName")
    public String newUsersFirstName(){
        waitTillAppears(searchResultFirstName,timeout);
        return getElement(searchResultFirstName).getText();
    }

    @Step("Find new User by lastName")
    public String newUsersLastName(){
        waitTillAppears(searchResultLastName,timeout);
        return getElement(searchResultLastName).getText();
    }
    @Step("Find new User by Age")
    public String newUsersAge(){
        waitTillAppears(searchResultAge,timeout);
        return getElement(searchResultAge).getText();
    }
    @Step("Find new User by Salary")
    public String newUsersSalary(){
        waitTillAppears(searchResultSalary,timeout);
        return getElement(searchResultSalary).getText();
    }
    @Step("Find new User by Department")
    public String newUsersDepartment(){
        waitTillAppears(searchResultDepartment,timeout);
        return getElement(searchResultDepartment).getText();
    }

}
