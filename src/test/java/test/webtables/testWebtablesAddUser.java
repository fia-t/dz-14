package test.webtables;

import dataproviders.dataForRegistration;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.webtables.addEditPage;
import test.BaseTest;

public class testWebtablesAddUser extends BaseTest {
    public final static String title = "Registration Form";

    @Description("The test is positive case for Add user to table")
    @Test(dataProvider = "dataForRegistration", dataProviderClass = dataForRegistration.class)
    public void addUserPositive(String firstName, String lastName, String email, String age, String salary, String department){
//        String registrationTitleActual = new addPage(driver).clickOnButtonAdd();
        String newUsersEmailActual = new addEditPage(driver)
                .registerUser(firstName, lastName, email, age, salary, department, title)
                .searchUser(email)
                .newUsersEmail();
        Assert.assertEquals(newUsersEmailActual, email, "The email didn`t show");
    }


}
