package Util;

import java.text.SimpleDateFormat;

public class DateFormatter {

    private static SimpleDateFormat dobFormatter = new SimpleDateFormat("MM-dd-yyyy");

    public static String getFormattedDOB(String dobString) {
        try {
            String formattedDOB = dobFormatter.parse(dobString).toString();
            return formattedDOB;
        } catch (Exception e) {
            System.out.println("Invalid Entry, Please Enetr a Valid DOB");
            return null;
        }
    }

}
