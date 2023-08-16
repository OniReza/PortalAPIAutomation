package Utility;

import com.github.javafaker.Faker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Random_data {

    public static String cCode="BD";
    public static String password="Tt123#123#";
    public static Faker faker = new Faker();
    public static String email;

    public static String countrycode(){
         return cCode;
    }

    public static String pass(){
        return password;
    }

    public static String signUpEmail(){

        Portals.dev dev = new Portals.dev();
        Portals.tst tst = new Portals.tst();

        String PortalEmail= tst.wallmoneymembers();

        int start = PortalEmail.indexOf('.');
        int end = PortalEmail.lastIndexOf('.');

        String outStr = PortalEmail.substring(start+1, end);
        System.out.println(outStr);

        if(cCode=="BD")
        {
            email = "NonUs_"+outStr + "_" + firstName().trim().toLowerCase() + "@mailinator.com";
        }
        else
        {
            email = "Us_"+outStr + "_" + firstName().trim().toLowerCase() + "@mailinator.com";
        }
        return email;
    }

    public static String signUpEmailnon_us(){

        Portals.dev dev = new Portals.dev();
        Portals.tst tst = new Portals.tst();

        String PortalEmail=dev.ultimamembers();

        int start = PortalEmail.indexOf('.');
        int end = PortalEmail.lastIndexOf('.');

        String outStr = PortalEmail.substring(start+1, end);
        System.out.println(outStr);

         email = "Non_"+ outStr + "_" + firstName().trim().toLowerCase() + "@mailinator.com";
        return email;

    }

    public static String firstName()  {
        String fName = faker.name().firstName().replaceAll("'", "");
        return fName;
    }


    public static String lastName() {
        String lName = faker.name().lastName().replaceAll("'", "");
        return lName;
    }

    public static String phoneNumber() {
        int code = faker.number().numberBetween(22222222, 99999999);
        String postcode = "15" + code;
        return postcode;
    }

    public static String adddress() {
        String lName = faker.address().streetAddress();
        return lName;
    }

    public static String rendomcity(){
        String cCity = faker.address().city();
        return cCity;
    }

    public static String dob() {

        Random random = new Random();
        int minDay = (int) LocalDate.of(1990, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

        System.out.println(randomBirthDate);

        String birthDay="" + randomBirthDate;

        return birthDay;
    }

}
