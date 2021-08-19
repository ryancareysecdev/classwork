package Util;

import Model.LoanRequest;
import Model.LoanRequest.LoanType;

public class LoanTypeConverter {

    public static LoanType getloanType(String loanTypeString) {
        if (loanTypeString.equalsIgnoreCase("PERSONAL")) {
            return LoanRequest.LoanType.PERSONAL;
        } else if (loanTypeString.equalsIgnoreCase("SCHOOL")) {
            return LoanRequest.LoanType.SCHOOL;
        } else if (loanTypeString.equalsIgnoreCase("BUSINESS")) {
            return LoanRequest.LoanType.BUSINESS;
        }
        System.out.println("Invalid Entry.");
        return null;
    }

}
