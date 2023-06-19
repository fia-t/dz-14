package test.webtables;

import dataproviders.dataForRegistration;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.webtables.addEditPage;
import pageobjects.webtables.searchPage;
import test.BaseTest;

import java.time.Duration;

public class testWebtablesEditUser extends BaseTest {
    @Description("The test is positive case for edit users Salary, Department")
    @Test(dataProvider = "dataForEdit", dataProviderClass = dataForRegistration.class)
    public void editUserPositive(String firstName, String lastName, String email, String age, String salaryNew, String departmentNew){
//        String registrationTitleActual = new addPage(driver).clickOnButtonAdd();
        String newUsersEmailActual = new addEditPage(driver)
                .registerUser(firstName, lastName, email, age, dataForRegistration.salary, dataForRegistration.department, testWebtablesAddUser.title)
                .searchUser(email)
                .newUsersEmail();
        Assert.assertEquals(newUsersEmailActual, email, "The email didn`t show");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String salaryNewAfterEditActual = new addEditPage(driver)
                .editUsersSalaryDepartment(salaryNew, departmentNew, testWebtablesAddUser.title)
                .searchUser(email)
                .newUsersSalary();
        Assert.assertEquals(salaryNewAfterEditActual, salaryNew, "The new salary didn`t show");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        String departmentNewAfterEditActual = new searchPage(driver)
                .newUsersDepartment();
        Assert.assertEquals(departmentNewAfterEditActual, departmentNew, "The new department didn`t show");

    }
}
