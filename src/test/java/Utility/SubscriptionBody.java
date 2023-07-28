package Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class SubscriptionBody {
    public static class Subscription {

        public String sub_body() throws Exception {

            String subBody = "{\n" +
                    "\t\"planId\":\"b8fe30a0-3dd8-ed11-a7c6-6045bdd0ef47\",\n" +
                    "    \"cardDesign\": \"13100\",\n" +
                    "    \"productRef\": \"AUX_PL1\"\n" +
                    "}";

            return subBody;
        }
    }

}
