package Model;

import Util.DateFormatter;
import Util.RandomGenerator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class EmployeeInteraction {
    
    private Scanner scanner = new Scanner(System.in);
    private RandomGenerator randomGenerator = new RandomGenerator();
    
    public void displayEmployeeOptions() {
        System.out.println("\n1) View Customer Profile");
        System.out.println("2) View Customer Loan History");
        System.out.println("3) Perform Customer Credit Check");
        System.out.println("4) Open Loan For Customer");
        System.out.println("5) Add New Customer");
        System.out.println("6) Display All Customers");
        System.out.println("7) Return to Main Menu");
        System.out.println("8) Exit");
        System.out.print("Choice: ");
    }
    
    public Customer createNewCustomer() {
        String formattedDOB;
        System.out.print("\nEnter New Customer Into the System\n");
        
        try {
            System.out.print("Open Loan For Customer\n");
            System.out.print("Customer First Name: ");
            String firstName = scanner.next();
            System.out.print("Customer Last Name: ");
            String lastName = scanner.next();
            System.out.print("Customer Street Address (Ex. 123 Main St): ");
            String street = scanner.next();
            street += scanner.next();
            street += scanner.next();
            System.out.print("Customer City: ");
            String city = scanner.next();
            System.out.print("Customer State (Ex. PA): ");
            String state = scanner.next();
            System.out.print("Customer Zip Code: ");
            String zip = scanner.next();
            do {
                System.out.print("Customer Date of Birth (Ex. 02-21-1990): ");
                String dob = scanner.next();
                formattedDOB = Util.DateFormatter.getFormattedDOB(dob);
            } while (formattedDOB == null);
            System.out.print("Customer Phone Number (Ex. 123-456-7890): ");
            String phoneNumber = scanner.next();
            return new Customer(new Identifier(), firstName, lastName, new Address(street, city, state, zip), formattedDOB, phoneNumber, randomGenerator.generateCredit());
        } catch (Exception e) {
            System.out.println("Could not add customer to mFinance.");
        }
        return null;
    }
    
    public LoanRequest openCustomerLoan(Customer customer, LoanRequest.LoanType loanType, double loanAmount) {
        try {
            System.out.println("Processing Loan Request...\n");
            TimeUnit.SECONDS.sleep(3);
            
            if (customer.getCredit() < 600) {
                System.out.println("Credit rating is too low for customer loan at this time.");
                return new LoanRequest(new Identifier(), customer, loanType, LoanRequest.LoanStatus.DENIED, loanAmount, loanAmount);
            } else if (customer.getCredit() >= 600 && customer.getCredit() < 700) {
                System.out.println("Credit score is under review - Loan application is pending - Notification of any changes.");
                return new LoanRequest(new Identifier(), customer, loanType, LoanRequest.LoanStatus.PENDING, loanAmount, loanAmount);
            }
            
            System.out.println("Loan Application Accepted");
            return new LoanRequest(new Identifier(), customer, loanType, LoanRequest.LoanStatus.ACCEPTED, loanAmount, loanAmount);
            
        } catch (Exception e) {
            System.out.println("Could not process loan.");
            return null;
        }
    }
    
    public void performCustomerCreditCheck(Customer customer) {
        String userChoice;
        System.out.println("Perform customer credit check? ('Y' or 'N'): ");
        
        do {
            userChoice = scanner.next();
            try {
                switch (userChoice.toUpperCase()) {
                    case "Y":
                        System.out.println("Customer ID: " + customer.getId());
                        System.out.println("Customer Name: " + customer.getFullName());
                        System.out.println("Credit Score: " + customer.getCredit());
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
