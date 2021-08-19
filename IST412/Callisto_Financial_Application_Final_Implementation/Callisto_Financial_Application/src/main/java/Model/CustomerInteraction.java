package Model;

import Model.LoanRequest.LoanType;
import Util.DoubleUtil;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * A class representing a financial profile for a customer.
 */
public class CustomerInteraction {

    Scanner scanner = new Scanner(System.in);

    /**
     * Returns a new loan request for a customer.
     *
     * @param loanType The type of loan requested.
     * @param loanAmount the amount of the loan.
     * @return A LoanRequest for a customer.
     */
    public void displayCustomerOptions() {
        System.out.println("\n1) Request Loan");
        System.out.println("2) Make a payment");
        System.out.println("3) View My Loan History");
        System.out.println("4) Make Inquiry");
        System.out.println("5) Return to Main Menu");
        System.out.println("6) Exit");
        System.out.print("Choice: ");
    }

    public LoanRequest requestLoan(Customer customer, LoanType loanType, double loanAmount) throws InterruptedException {

        try {
            System.out.println("Processing Loan Request...\n");
            TimeUnit.SECONDS.sleep(3);

            if (customer.getCredit() < 600) {
                System.out.println("Credit rating is too low for a loan at this time. "
                        + "Record of loan request will stay on file.");
                return new LoanRequest(new Identifier(), customer, loanType, LoanRequest.LoanStatus.DENIED, loanAmount, loanAmount);
            } else if (customer.getCredit() >= 600 && customer.getCredit() < 700) {
                System.out.println("Credit score is under review and loan application is pending."
                        + "There will be notification of any changes.");
                return new LoanRequest(new Identifier(), customer, loanType, LoanRequest.LoanStatus.PENDING, loanAmount, loanAmount);
            }

            System.out.println("Loan Application Accepted");
            return new LoanRequest(new Identifier(), customer, loanType, LoanRequest.LoanStatus.ACCEPTED, loanAmount, loanAmount);

        } catch (Exception e) {
            System.out.println("Could not process loan.");
            return null;
        }
    }

    public void makeLoanPayment(LoanRequest loanRequest, String amount) {
        
        try {
            double payAmount = DoubleUtil.tryParseDouble(amount);

            if (loanRequest.getRemainingAmount() < payAmount) {
                System.out.println("You do not owe more than $" + loanRequest.getRemainingAmount()
                        + " on this loan.");
            } else {
                loanRequest.setRemainingAmount(loanRequest.getRemainingAmount() - payAmount);
                System.out.println("\nPayment Applied\n");
                System.out.println("Updated Loan Data:\n" + loanRequest.toString());
            }

        } catch (Exception e) {
            System.out.println("Could not process loan payment\nPlease Try Again Later.");
        }
    }

    public void requestCustomerInquiry(Customer customer) {
        String userChoice;
        System.out.println("You are about to make a Credit Inquiry from the Callisto Financial Group.\n"
                + "PLEASE BE ADVISED: This will affect you credit score by an average of 5 points in\n"
                + "the negative. However, it will give you an idea of where you stand with the possibility\n"
                + "of receiving a loan from the Callisto Financial Group.\nDo you wish to proceed? ('Y' or 'N'): ");

        do {
            userChoice = scanner.next();
            try {
                switch (userChoice.toUpperCase()) {
                    case "Y":
                        System.out.println("Customer ID: " + customer.getId());
                        System.out.println("Customer Name: " + customer.getFullName());
                        System.out.println("Credit Score Before Request: " + customer.getCredit());
                        customer.setCredit(customer.getCredit() - 5);
                        System.out.println("Credit Score Now: " + customer.getCredit());
                        return;
                    case "N":
                        return;
                    default:
                        System.out.println("Invalid Input, Please Try Again.\nDo you wish to proceed? ('Y' or 'N'): ");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Could not make inquiry.");
            }
        } while (!userChoice.equals("Y"));
    }
}
