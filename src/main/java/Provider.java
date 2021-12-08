import org.testng.annotations.DataProvider;

import java.text.ParseException;



public class Provider {

    @DataProvider(name = "create")
    public static Object[][] createData() throws ParseException {
        return new Object[][] {
                new Object[] {new TestObject()},
                new Object[] {new TestObject()},
                new Object[] {new TestObject()},
                new Object[] {new TestObject()},
                new Object[] {new TestObject()}
        };
    }


}
