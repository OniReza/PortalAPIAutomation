package Utility;

import com.github.javafaker.Faker;

public class Random_data {

    public static Faker faker = new Faker();
    public static String email;

    public static String signUpEmail(){

        Portals.dev dev = new Portals.dev();
        Portals.tst tst = new Portals.tst();


        String PortalEmail=tst.clubswan();


        int start = PortalEmail.indexOf('.');
        int end = PortalEmail.lastIndexOf('.');

        String outStr = PortalEmail.substring(start+1, end);
        System.out.println(outStr);

         email = "Us_"+ outStr + "_" + firstName().trim().toLowerCase() + "@mailinator.com";
        return email;

    }

    public static String signUpEmailnon_us() throws Exception  {

        Portals.dev dev = new Portals.dev();
        Portals.tst tst = new Portals.tst();

        String PortalEmail=tst.clubswan();

        int start = PortalEmail.indexOf('.');
        int end = PortalEmail.lastIndexOf('.');

        String outStr = PortalEmail.substring(start+1, end);
        System.out.println(outStr);

         email = "Non_"+ outStr + "_" + firstName().trim().toLowerCase() + "@mailinator.com";
        return email;

    }

    public static String email_log(){

        String emailnon=email;
        return emailnon;

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

    public static String email() {
        String email = firstName().toLowerCase().trim() + "@mailinator.com";
        return email;


    }
//
//    public static String bankAccNum() {
//        int number = faker.number().numberBetween(100000000, 999999999);
//        String accNum = Integer.toString(number);
//        return accNum;
//    }
//
//    public static String sortCode() {
//        int number = faker.number().numberBetween(222222, 999999);
//        String accNum = Integer.toString(number);
//        return accNum;
//    }
//
//    public static String ssnNumber() {
//        int ssnNum = faker.number().numberBetween(555555555, 888888888);
//        String accNum = Integer.toString(ssnNum);
//        return accNum;
//    }
}
