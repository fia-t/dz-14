package test.webtables;

import dataproviders.dataForRegistration;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.webtables.addEditPage;
import pageobjects.webtables.searchPage;
import test.BaseTest;

import java.time.Duration;

public class testWebtablesSearchUser extends BaseTest {
    @Description("The test is positive case for Add user to table and search by firstName")
    @Test(dataProvider = "dataForRegistration", dataProviderClass = dataForRegistration.class)
    public void searchByFirstNamePositive(String firstName, String lastName, String email, String age, String salary, String department){
        String newUsersFirstNameActual = new addEditPage(driver)
                .registerUser(firstName, lastName, email, age, salary, department, testWebtablesAddUser.title)
                .searchUser(firstName)
                .newUsersFirstName();
        Assert.assertEquals(newUsersFirstNameActual, firstName, "The first name didn`t show");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String newUsersEmailActual = new searchPage(driver)
                .newUsersEmail();
        Assert.assertEquals(newUsersEmailActual, email, "The email didn`t show");
    }

    @Description("The test is positive case for Add user to table and search by lastName")
    @Test(dataProvider = "dataForRegistration", dataProviderClass = dataForRegistration.class)
    public void searchByLastNamePositive(String firstName, String lastName, String email, String age, String salary, String department){
        String newUsersLastNameActual = new addEditPage(driver)
                .registerUser(firstName, lastName, email, age, salary, department, testWebtablesAddUser.title)
                .searchUser(lastName)
                .newUsersLastName();
        Assert.assertEquals(newUsersLastNameActual, lastName, "The last name didn`t show");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String newUsersEmailActual = new searchPage(driver)
                .newUsersEmail();
        Assert.assertEquals(newUsersEmailActual, email, "The email didn`t show");
    }

    @Description("The test is positive case for Add user to table and search by age")
    @Test(dataProvider = "dataForRegistration", dataProviderClass = dataForRegistration.class)
    public void searchByAgePositive(String firstName, String lastName, String email, String age, String salary, String department){
        String newUsersAgeActual = new addEditPage(driver)
                .registerUser(firstName, lastName, email, age, salary, department, testWebtablesAddUser.title)
                .searchUser(age)
                .newUsersAge();
        Assert.assertEquals(newUsersAgeActual, age, "The age didn`t show");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String newUsersEmailActual = new searchPage(driver)
                .newUsersEmail();
        Assert.assertEquals(newUsersEmailActual, email, "The email didn`t show");
    }
    @Description("The test is positive case for Add user to table and search by Salary")
    @Test(dataProvider = "dataForRegistration", dataProviderClass = dataForRegistration.class)
    public void searchBySalaryPositive(String firstName, String lastName, String email, String age, String salary, String department){
        String newUsersSalaryActual = new addEditPage(driver)
                .registerUser(firstName, lastName, email, age, salary, department, testWebtablesAddUser.title)
                .searchUser(salary)
                .newUsersSalary();
        Assert.assertEquals(newUsersSalaryActual, salary, "The salary didn`t show");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String newUsersEmailActual = new searchPage(driver)
                .newUsersEmail();
        Assert.assertEquals(newUsersEmailActual, email, "The email didn`t show");
    }
    @Description("The test is positive case for Add user to table and search by Salary")
    @Test(dataProvider = "dataForRegistration", dataProviderClass = dataForRegistration.class)
    public void searchByDepartmentPositive(String firstName, String lastName, String email, String age, String salary, String department){
        String newUsersDepartmentActual = new addEditPage(driver)
                .registerUser(firstName, lastName, email, age, salary, department, testWebtablesAddUser.title)
                .searchUser(department)
                .newUsersDepartment();
        Assert.assertEquals(newUsersDepartmentActual, department, "The department didn`t show");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String newUsersEmailActual = new searchPage(driver)
                .newUsersEmail();
        Assert.assertEquals(newUsersEmailActual, email, "The email didn`t show");
    }
}
