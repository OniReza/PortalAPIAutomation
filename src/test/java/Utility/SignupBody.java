package Utility;

public class SignupBody {

    public static class PortalSignup {

        public String portal_body() {

            String portalBody = "{\n" +
                    "    \"email\":\"makengy.hodl.tst.41@mailinator.com\",\n" +
                    "    \"password\": \"Tt123#123#\",\n" +
                    "    \"firstName\": \"Makengy\",\n" +
                    "    \"lastName\": \"Watson\",\n" +
                    "    \"latinFirstName\": \"mike\",\n" +
                    "    \"latinLastName\": \"jeckson\",\n" +
                    "    \"countryCode\": \"GB\",\n" +
                    "    \"dateOfBirth\": \"1989-11-24\",\n" +
                    "    \"addressLine1\": \"someplace\",\n" +
                    "    \"addressLine2\": \"\",\n" +
                    "    \"city\": \"somewhere \",\n" +
                    "    \"postCode\": \"1516\",\n" +
                    "    \"doNotEmail\": true,\n" +
                    "    \"mobileNumber\": \"+4479405017402\",\n" +
                    "    \"preferredDisplayLanguage\": \"en\",\n" +
                    "    \"isTermsAgreed\": true\n" +
                    "}";
            return portalBody;
        }

        public String partner_body() {

            String partnerBody = "{\n" +
                    "\t\"email\": \"rulin.icd.tst.9@sharklasers.com\",\n" +
                    "\t\"password\": \"Tt123#123\",\n" +
                    "    \"brand\" : \"Seacret\",\n" +
                    "    \"preferredCardCurrency\": \"USD\",\n" +
                    "    \"title\": \"\",\n" +
                    "    \"firstName\": \"Rulin\",\n" +
                    "    \"lastName\": \"Arnold\",\n" +
                    "    \"latinFirstName\": \"russel\",\n" +
                    "    \"latinLastName\": \"arnold\",\n" +
                    "    \"dateOfBirth\": \"1988-01-01\",\n" +
                    "    \"phone\": \"+8801745254666\",\n" +
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
