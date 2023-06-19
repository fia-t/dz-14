package dataproviders;
import org.testng.annotations.DataProvider;

public class dataForRegistration {

    private final static String firstName = "Jon";
    private final static String lastName = "Doe";
    private final static String email = "jondoe@example.com";
    private final static String age = "40";
    public final static String salary = "50000";
    public final static String department = "audit";
    private final static String salaryNew = "70000";
    private final static String departmentNew = "QA";
    @DataProvider(name = "dataForRegistration")
    public static Object[][] dataForRegistration() {
        return new Object[][] {
                {firstName, lastName, email, age, salary, department}
        };
    }

    @DataProvider(name = "dataForEdit")
    public static Object[][] dataForEdit() {
        return new Object[][] {
                {firstName, lastName, email, age, salaryNew, departmentNew}
        };
    }

}
