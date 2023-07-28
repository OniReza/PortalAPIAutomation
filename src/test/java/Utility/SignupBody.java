package Utility;

import io.restassured.RestAssured;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.BeforeClass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;




public class SignupBody {


    public static String Portal_Email;
    public static String Portal_FirstName;
    public static String Portal_LastName;
    public static String Portal_Phone;
    public static String Portal_Address;
    public static String Portal_Dob;
    public static String Country_Code;
    public static String Random_city;
    public static String Pass_word;


       public static class PortalSignup {


           public static String Email() {
               String PortalEmail= Random_data.signUpEmail();
               Portal_Email =PortalEmail;
               return Portal_Email;
           }

           public static String Password() {
               String pass= Random_data.pass();
               Pass_word =pass;

               return Pass_word;
           }

           public static String FirstName() {
               String PortalFname= Random_data.firstName();
               Portal_FirstName =PortalFname;
               return Portal_FirstName;
           }

           public static String LastName() {
               String PortalLname= Random_data.lastName();
               Portal_LastName =PortalLname;
               return Portal_LastName;
           }

           public static String PhoneNumber() {
               String PortalPhone= Random_data.phoneNumber();
               Portal_Phone =PortalPhone;
               return Portal_Phone;
           }

           public static String Address() {
               String PortalAddress= Random_data.adddress();
               Portal_Address =PortalAddress;
               return Portal_Address;
           }

           public static String Dob() {
               String PortalDob= Random_data.dob();
               Portal_Dob =PortalDob;
               return Portal_Dob;
           }

    public static String CountryCode() throws Exception {
        String C_Code= Random_data.countrycode();
        Country_Code =C_Code;
        return Country_Code;
    }

    public static String RandomCity() throws Exception {
        String R_City= Random_data.rendomcity();
        Random_city =R_City;
        return Random_city;
    }


        public static String portal_body() throws Exception {
            Email();
            FirstName();
            LastName();
            PhoneNumber();
            Address();
            Dob();
            CountryCode();
            RandomCity();
            Password();


            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            String portalBody = "{\n" +
                    "\t\"email\":\""+Portal_Email+"\",\n" +
                    "    \"password\": \""+Pass_word+"\",\n" +
                    "    \"firstName\": \""+Portal_FirstName+"\",\n" +
                    "    \"lastName\": \""+Portal_LastName+"\",\n" +
                    "    \"latinFirstName\":  \""+Portal_FirstName+"\",\n" +
                    "    \"latinLastName\": \""+Portal_LastName+"\",\n" +
                    "    \"countryCode\": \""+Country_Code+"\",\n" +
                    "    \"dateOfBirth\": \""+Portal_Dob+"\",\n" +
                    "    \"addressLine1\": \""+Portal_Address+"\",\n" +
                    "    \"addressLine2\": \"\",\n" +
                    "    \"city\": \""+Random_city+"\",\n" +
                    "    \"postCode\": \"1516\",\n" +
                    "    \"doNotEmail\": true,\n" +
                    "    \"mobileNumber\": \"+880"+Portal_Phone+"\",\n" +
                    "    \"preferredDisplayLanguage\": \"en\",\n" +
                    "    \"state\": \"Texas\",\n" +
                    "    \"isTermsAgreed\": true\n" +
                    "}";

            System.out.println("Email:  " + Portal_Email + " " + dtf.format(now));
            String Data ="Email : "+ Portal_Email + "  "+dtf.format(now);

            File files = new File("Email/PortalEmail.txt");
            FileWriter fw = new FileWriter(files,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Data);
            bw.newLine();
            bw.close();
            return portalBody;

        }

        public String partner_body() throws Exception {

            Email();
            FirstName();
            LastName();
            PhoneNumber();
            Address();
            Dob();
            CountryCode();
            Password();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();


            String partnerBody = "{\n" +
                    "\t\"email\":\""+Portal_Email+"\",\n" +
                    "    \"password\": \""+Pass_word+"\",\n" +
                    "    \"brand\" : \"AURIX\",\n" +
                    "    \"preferredCardCurrency\": \"USD\",\n" +
                    "    \"title\": \"\",\n" +
                    "    \"firstName\": \""+Portal_FirstName+"\",\n" +
                    "    \"lastName\": \""+Portal_LastName+"\",\n" +
                    "    \"latinFirstName\": \"russel\",\n" +
                    "    \"latinLastName\": \"arnold\",\n" +
                    "    \"dateOfBirth\": \""+Portal_Dob+"\",\n" +
                    "    \"phone\": \"+880"+Portal_Phone+"\",\n" +
                    "    \"province\": \"\",\n" +
                    "    \"postCode\": \"55555\",\n" +
                    "    \"countryCode\": \""+Country_Code+"\",\n" +
                    "    \"city\": \"Dhaka\",\n" +
                    "    \"addressLine1\": \""+Portal_Address+"\",\n" +
                    "    \"state\": \"Texas\",\n" +
                    "    \"ssn\": \"\"\n" +
                    "}";

            System.out.println("Email:  " + Portal_Email + " " + dtf.format(now));
            String Data ="Email : "+ Portal_Email + "  "+dtf.format(now);

            File files = new File("Email/PartnerEmail.txt");
            FileWriter fw = new FileWriter(files,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Data);
            bw.newLine();
            bw.close();


            return partnerBody;


        }



    }
}
