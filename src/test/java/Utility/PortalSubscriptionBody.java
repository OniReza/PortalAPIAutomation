package Utility;

public class PortalSubscriptionBody {
    public static class PortalSubscription {

        public String portal_sub_body() throws Exception {

            String PortalsubBody = "{\n" +
                    "\t\"planId\":\"b8fe30a0-3dd8-ed11-a7c6-6045bdd0ef47\",\n" +
                    "    \"cardDesign\": \"13100\",\n" +
                    "    \"productRef\": \"AUX_PL1\"\n" +
                    "}";

            return PortalsubBody;
        }
    }
}
