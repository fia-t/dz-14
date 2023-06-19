package test.elements;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.elements.buttonsPage;
import pageobjects.elements.elementsPage;
import test.BaseTest;

public class testElements extends BaseTest {
    private final static String message = "You have done a dynamic click";
    @Test
    @Description("The test is positive case for Click on element Buttons")
    public void clickOnButtonsElementPositive(){

        String messageActual = new elementsPage(driver)
                .clickOnElementButton()
                .clickOnButtonClickMe();

        new buttonsPage(driver).clickOnButtonClickMe();
        Assert.assertEquals(messageActual, message, "The message after click on button 'Click Me' is wrong");
        System.out.println(messageActual);

    }

}