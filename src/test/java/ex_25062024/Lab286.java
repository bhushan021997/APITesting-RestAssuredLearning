package ex_25062024;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class Lab286 {
    // Randomd User or Password

    public static void main(String[] args) {
        Faker faker=new Faker();
        String username= faker.name().username();
        String password= faker.phoneNumber().phoneNumber();

        System.out.println(username);
        System.out.println(password);
    }


}
