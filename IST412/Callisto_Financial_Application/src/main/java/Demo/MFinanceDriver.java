package Demo;

import Model.Address;
import Model.Customer;
import Model.CustomerInteraction;
import Model.Identifier;
import Model.LoanHistory;
import Model.LoanRequest;
import Util.DoubleUtil;
import Util.RandomGenerator;
import Util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * A class that drives the application by giving the base options when the user
 * chooses how they want to proceed with their experience.
 */
public class MFinanceDriver {

    private Scanner scanner = new Scanner(System.in);
    private RandomGenerator randomGenerator = new RandomGenerator();
    private LoanHistory loanHistory = LoanHistory.getInstance();
    private List<Customer> customers = new ArrayList<>();
    private String subMenuChoice;
    private String userInput;
    private LoanRequest.LoanType loanType;
    private Customer activeCustomer;
    private CustomerInteraction customerInteraction = new CustomerInteraction();
    ;

    Customer customer1 = new Customer(new Identifier(), "Customer", "One", new Address("123 Main St", "Philly", "PA", "12345"), "02-12-1992", "967-623-2347", 700);
    Customer customer2 = new Customer(new Identifier(), "Customer", "Two", new Address("3014 New Town", "Miami", "FL", "67890"), "03-15-1980", "215-871-0957", randomGenerator.generateCredit());
    Customer customer3 = new Customer(new Identifier(), "Customer", "Three", new Address("1 USA Ave", "Boston", "MA", "13579"), "12-20-1997", "147-016-0597", randomGenerator.generateCredit());

    /**
     * Will display a list of options for the employee to interact with customer
     * information.
     */
    public void initializeCustomers() {
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }

    public void displayEmployeeOptions() throws InterruptedException {
        initializeCustomers();

        for (Customer customer : customers) {
            loanHistory.add(new LoanRequest(new Identifier(), customer, LoanRequest.LoanType.PERSONAL, LoanRequest.LoanStatus.ACCEPTED, 5000, 5000));
            loanHistory.add(new LoanRequest(new Identifier(), customer, LoanRequest.LoanType.BUSINESS, LoanRequest.LoanStatus.ACCEPTED, 4000, 4000));
            loanHistory.add(new LoanRequest(new Identifier(), customer, LoanRequest.LoanType.SCHOOL, LoanRequest.LoanStatus.ACCEPTED, 3000, 3000));
        }

        do {
            System.out.println("\n1) View Customer Profile");
            System.out.println("2) View Customer Loan History");
            System.out.println("3) Perform Customer Credit Check");
            System.out.println("4) Open Loan For Customer");
            System.out.println("5) Add New Customer");
            System.out.println("6) Display All Customers");
            System.out.println("7) Exit");
            System.out.print("Choice: ");

            subMenuChoice = scanner.next();

            switch (subMenuChoice) {
                case "1":
                    viewCustomerProfile();
                    break;

                case "2":
                    viewCustomerLoanHistory();
                    break;

                case "3":
                    performCustomerCreditCheck();
                    break;

                case "4":
                    openCustomerLoan();
                    break;

                case "5":
                    createNewCustomer();
                    break;

                case "6":
                    System.out.println("Viewing All Customers\n");
                    customers.forEach((customer) -> {
                        customer.displayCustomer();
                    });
                    break;

                case "7":
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
            }
        } while (!subMenuChoice.equals("7"));

    }

    public void performCustomerCreditCheck() {
        try {
            System.out.print("\nCustomer Credit Check\nCustomer's Full Name: ");

            userInput = scanner.nextLine();
            userInput += scanner.nextLine();
            for (Customer customer : customers) {
                if (userInput.equals(customer.getFullName())) {
                    System.out.println(customer.getFirstName() + " " + customer.getLastName()
                            + "'s Credit Score: " + customer.getCredit());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not perform loan check.");
        }

    }

    public void openCustomerLoan() throws InterruptedException {
        System.out.print("\nOpen New Loan For Customer\nCustomer's Full Name: ");
        userInput = scanner.nextLine();
        userInput += scanner.nextLine();
        try {
            String loanTypeString;
            for (Customer customer : customers) {
                if (userInput.equals(customer.getFullName())) {
                    Customer loanCustomer = customer;
                    do {
                        System.out.print("Enter Loan Type (Options - PERSONAL, SCHOOL, BUSINESS): ");
                        loanTypeString = scanner.next();
                        if (loanTypeString.equalsIgnoreCase("PERSONAL")) {
                            loanType = LoanRequest.LoanType.PERSONAL;
                        } else if (loanTypeString.equalsIgnoreCase("SCHOOL")) {
                            loanType = LoanRequest.LoanType.SCHOOL;
                        } else if (loanTypeString.equalsIgnoreCase("BUSINESS")) {
                            loanType = LoanRequest.LoanType.BUSINESS;
                        }

                    } while (!StringUtil.isNullOrEmpty(loanTypeString));

                    String loanAmountString;

                    try {
                        do {
                            System.out.print("Enter Loan Amount (Ex. 4000): ");
                            loanAmountString = scanner.next();
                            double loanAmount = DoubleUtil.tryParseDouble(loanAmountString);

                            loanHistory.add(customerInteraction.requestLoan(loanCustomer, loanType, loanAmount));
                            System.out.println("\nLoan Application Process Complete");
                        } while (!StringUtil.isNullOrEmpty(loanAmountString));
                    } catch (Exception e) {
                        System.out.println("Could not process customer loan.");
                    }
                }
                break;
            }
        } catch (Exception e) {
            System.out.println("Could not process customer loan.");
        }
    }

    public void createNewCustomer() {
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
            System.out.print("Customer Date of Birth (Ex. 02-21-1990): ");
            String dob = scanner.next();
            System.out.print("Customer Phone Number (Ex. 123-456-7890): ");
            String phoneNumber = scanner.next();
            customers.add(new Customer(new Identifier(), firstName, lastName, new Address(street, city, state, zip), dob, phoneNumber, randomGenerator.generateCredit()));
        } catch (Exception e) {
            System.out.println("Could not add customer to mFinance.");
        }
    }

    public void viewCustomerLoanHistory() {
        do {
            try {
                System.out.print("Customer Loan History\nCustomer's Full Name: ");
                userInput = scanner.nextLine();
                userInput += scanner.nextLine();
                for (Customer customer : customers) {
                    if (userInput.equals(customer.getFullName())) {
                        System.out.println(customer.getFirstName() + " " + customer.getLastName()
                                + "'s Loan History:\n");
                        for (LoanRequest request : loanHistory.searchCustomerLoans(customer)) {
                            if (request.getCustomer().getFullName().equals(userInput)) {
                                System.out.println(request.toString());
                            }
                        }
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Could not retrieve customer loan history.");
            }
        } while (!StringUtil.isNullOrEmpty(userInput));
    }

    public void viewCustomerProfile() {
        System.out.print("Customer Profile\nCustomer's Full Name: ");
        userInput = scanner.nextLine();
        userInput += scanner.nextLine();
        for (Customer customer : customers) {
            if (userInput.equals(customer.getFullName())) {
                System.out.println("\nFinancial Profile for " + customer.getFirstName()
                        + " " + customer.getLastName() + ":\n");
                customer.displayCustomer();
                System.out.println("\n" + customer.getFullName() + " Loan History:");
                for (LoanRequest request : loanHistory.searchCustomerLoans(customer)) {
                    if (request.getCustomer().getFullName().equals(userInput)) {
                        System.out.println(request.toString());
                    }
                }
            }
        }
    }

    /**
     * Will display a list of options for the customer to requests loans and
     * make payments.
     */
    public void displayCustomerOptions() throws InterruptedException {
        initializeCustomers();

        do {
            System.out.println("\n1) Request Loan");
            System.out.println("2) Make a payment");
            System.out.println("3) View My Loan History");
            System.out.println("4) Make Inquiry");
            System.out.println("5) Exit");
            System.out.print("Choice: ");

            subMenuChoice = scanner.next();

            switch (subMenuChoice) {
                case "1":
                    boolean validEntry = false;
                    do {
                        System.out.print("Enter Loan Type (Options - PERSONAL, SCHOOL, BUSINESS): ");
                        String loanTypeString = scanner.next();
                        if (loanTypeString.equalsIgnoreCase("PERSONAL")) {
                            loanType = LoanRequest.LoanType.PERSONAL;
                            validEntry = true;
                        } else if (loanTypeString.equalsIgnoreCase("SCHOOL")) {
                            loanType = LoanRequest.LoanType.SCHOOL;
                            validEntry = true;
                        } else if (loanTypeString.equalsIgnoreCase("BUSINESS")) {
                            loanType = LoanRequest.LoanType.BUSINESS;
                            validEntry = true;
                        } else {
                            System.out.println("Invalid Entry");
                        }
                    } while (validEntry == false);

                    try {
                        System.out.print("Enter Loan Amount (Ex. 4000): ");
                        String loanAmountString = scanner.next();
                        double loanAmount = DoubleUtil.tryParseDouble(loanAmountString);
                        loanHistory.add(customerInteraction.requestLoan(activeCustomer, loanType, loanAmount));
                        System.out.println("Loan Application Process Complete");
                    } catch (Exception e) {
                        System.out.println("Invalid Amount, Returning to Home Base...");
                    }
                    break;

                case "2":
                    if (loanHistory.searchActiveLoans(loanHistory.getAll()).isEmpty()) {
                        System.out.println("You have no active payable loans at this time.");
                    } else {
                        System.out.println("\nMake a Loan Payment\nLoan History");
                        for (LoanRequest request : loanHistory.searchCustomerLoans(activeCustomer)) {
                            if (request.getCustomer().getFullName().equals(activeCustomer.getFullName())) {
                                System.out.println(request.toString());
                            }
                        }
                        System.out.print("Please enter the first three sets of numbers on the loan "
                                + "you wish to make a payment toward: ");
                        String loanChoice = scanner.next();

                        for (LoanRequest loan : loanHistory.getAll()) {
                            if (loan.toString().contains(loanChoice)) {
                                System.out.print("Please enter the amount you want to pay towards your loan: ");
                                String paymentAmount = scanner.next();
                                System.out.println("Processing Loan Payment...");
                                TimeUnit.SECONDS.sleep(3);
                                customerInteraction.makeLoanPayment(loan, paymentAmount);

                            }
                        }
                    }

                    break;

                case "3":
                    if (loanHistory.searchCustomerLoans(customer1).isEmpty()) {
                        System.out.println("No Loan Record Available at this time.");
                    } else {
                        System.out.println(activeCustomer.getFullName() + " Loan History\n");
                        for (LoanRequest request : loanHistory.searchCustomerLoans(activeCustomer)) {
                            if (request.getCustomer().getFullName().equals(activeCustomer.getFullName())) {
                                System.out.println(request.toString());
                            }
                        }
                    }
                    break;

                case "4":
                    customerInteraction.requestCustomerInquiry(activeCustomer);
                    break;

                case "5":
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
            }

        } while (!subMenuChoice.equals("5"));

    }

    public void setActiveCustomer(Customer customer) {
        this.activeCustomer = customer;
    }

    public Customer getActiveCustomer() {
        return activeCustomer;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
