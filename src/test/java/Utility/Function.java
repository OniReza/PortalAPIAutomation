package Utility;

public class Function {

    public static void main(String args[]) {

        String PortalEmail ="tst.gslifestylecard.com";

        int start = PortalEmail.indexOf('.');
        int end = PortalEmail.lastIndexOf('.');

        String outStr = PortalEmail.substring(start+1, end);
        System.out.println(outStr);
    }
}
