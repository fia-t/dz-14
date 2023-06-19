package pageobjects.webtables;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.AbstractPageObject;

public class addEditPage extends AbstractPageObject {
    private final By btnAdd = By.cssSelector("#addNewRecordButton");
    private final By btnEdit = By.cssSelector("#edit-record-1");
    private final By formRegistrationTitle = By.cssSelector("#registration-form-modal");
    private final By firstNameField = By.cssSelector("#firstName");
    private final By lastNameField = By.cssSelector("#lastName");
    private final By emailField = By.cssSelector("#userEmail");
    private final By ageField = By.cssSelector("#age");
    private final By salaryField = By.cssSelector("#salary");
    private final By departmentField = By.cssSelector("#department");
    public final By btnSubmit = By.cssSelector("#submit");
    private final static int timeout = 40;
    public addEditPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/webtables");
    }

    @Step("The user click on button Add and fill form registration and submit")
    public searchPage registerUser(String firstName, String lastName, String email, String age, String salary, String department, String title){
        waitTillAppears(btnAdd,timeout);
        getElement(btnAdd).click();

        String registrationTitleActual = getElement(formRegistrationTitle).getText();
        Assert.assertEquals(registrationTitleActual, title, "The title didn`t show");

        waitTillAppears(firstNameField,timeout);
        getElement(firstNameField).sendKeys(firstName);
        getElement(lastNameField).sendKeys(lastName);
        getElement(emailField).sendKeys(email);
        getElement(ageField).sendKeys(age);
        getElement(salaryField).sendKeys(salary);
        getElement(departmentField).sendKeys(department);
        getElement(btnSubmit).click();

        return new searchPage(driver);
    }
    @Step("The user edit salary, department")
    public searchPage editUsersSalaryDepartment(String salaryNew, String departmentNew, String title){
        waitTillAppears(btnEdit,timeout);
        getElement(btnEdit).click();

        String registrationTitleActual = getElement(formRegistrationTitle).getText();
        Assert.assertEquals(registrationTitleActual, title, "The title didn`t show");

        getElement(salaryField).click();
        getElement(salaryField).clear();
        waitTillAppears(salaryField,timeout);
        getElement(salaryField).sendKeys(salaryNew);

        getElement(departmentField).click();
        getElement(departmentField).clear();
        waitTillAppears(departmentField,timeout);
        getElement(departmentField).sendKeys(departmentNew);
        getElement(btnSubmit).click();

        return new searchPage(driver);
    }
}
