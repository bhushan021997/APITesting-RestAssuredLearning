package ex_25062024;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab285 {

    @DataProvider
    public Object[][] getData() {


        return new Object[][]{
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password123"}
        };
    }


    @Test(dataProvider = "getData")
    public void testAuthToGetToken(String username, String password) {
        System.out.println(username);
        System.out.println(password);

        // Rest Assured Login

        // Rest Given -> when -> then -> 200 Ok or Response


    }
}



