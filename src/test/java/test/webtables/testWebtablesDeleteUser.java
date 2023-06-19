package test.webtables;

import dataproviders.dataForRegistration;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.webtables.addEditPage;
import pageobjects.webtables.deletePage;
import test.BaseTest;

import java.time.Duration;

public class testWebtablesDeleteUser extends BaseTest {
    @Description("The test is positive case for delete user")
    @Test(dataProvider = "dataForRegistration", dataProviderClass = dataForRegistration.class)
    public void deleteUserPositive(String firstName, String lastName, String email, String age, String salary, String department){
        String newUsersEmailActual = new addEditPage(driver)
                .registerUser(firstName, lastName, email, age, salary, department, testWebtablesAddUser.title)
                .searchUser(email)
                .newUsersEmail();
        Assert.assertEquals(newUsersEmailActual, email, "The email didn`t show");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        String deleteUserActual = new deletePage(driver)
                .deleteUser()
                .newUsersEmail();
        Assert.assertEquals(deleteUserActual, " ", "The email is show");
    }

}
