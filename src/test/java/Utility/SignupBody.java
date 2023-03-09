package Utility;

public class SignupBody {

    public static class PortalSignup {

        public String portal_body() {

            String portalBody = "{\n" +
                    "    \"email\":\"robert.hodl.tst.41@mailinator.com\",\n" +
                    "    \"password\": \"Tt123#123#\",\n" +
                    "    \"firstName\": \"Alpain\",\n" +
                    "    \"lastName\": \"Rike\",\n" +
                    "    \"latinFirstName\": \"Kanek\",\n" +
                    "    \"latinLastName\": \"Rike\",\n" +
                    "    \"countryCode\": \"GB\",\n" +
                    "    \"dateOfBirth\": \"1990-11-24\",\n" +
                    "    \"addressLine1\": \"someplace\",\n" +
                    "    \"addressLine2\": \"\",\n" +
                    "    \"city\": \"somewhere \",\n" +
                    "    \"postCode\": \"1516\",\n" +
                    "    \"doNotEmail\": true,\n" +
                    "    \"mobileNumber\": \"+4479405025478\",\n" +
                    "    \"preferredDisplayLanguage\": \"en\",\n" +
                    "    \"isTermsAgreed\": true\n" +
                    "}";
            return portalBody;
        }

        public String partner_body() {

            String partnerBody = "{\n" +
                    "\t\"email\": \"malkom.icc.tst.9@sharklasers.com\",\n" +
                    "\t\"password\": \"Tt123#123\",\n" +
                    "    \"brand\" : \"Seacret\",\n" +
                    "    \"preferredCardCurrency\": \"USD\",\n" +
                    "    \"title\": \"\",\n" +
                    "    \"firstName\": \"Malkom\",\n" +
                    "    \"lastName\": \"Marshal\",\n" +
                    "    \"latinFirstName\": \"jems\",\n" +
                    "    \"latinLastName\": \"romi\",\n" +
                    "    \"dateOfBirth\": \"1995-01-01\",\n" +
                    "    \"phone\": \"+8801745254811\",\n" +
                    "    \"province\": \"\",\n" +
                    "    \"postCode\": \"55555\",\n" +
                    "    \"countryCode\": \"US\",\n" +
                    "    \"city\": \"New york\",\n" +
                    "    \"addressLine1\": \"test\",\n" +
                    "    \"state\": \"Texas\",\n" +
                    "    \"ssn\": \"\"\n" +
                    "}";
            return partnerBody;
        }
    }
}
