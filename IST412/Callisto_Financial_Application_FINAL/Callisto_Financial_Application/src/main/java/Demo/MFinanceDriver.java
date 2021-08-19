package Demo;

import Model.Address;
import Model.Customer;
import Model.CustomerInteraction;
import Model.EmployeeInteraction;
import Model.Identifier;
import Model.LoanHistory;
import Model.LoanRequest;
import Util.DoubleUtil;
import Util.RandomGenerator;
import Util.StringUtil;
import View.LogInSelectionUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MFinanceDriver {

    private static final MFinanceDriver INSTANCE = new MFinanceDriver();
    private Scanner scanner = new Scanner(System.in);
    private RandomGenerator randomGenerator = new RandomGenerator();
    private LoanHistory loanHistory = LoanHistory.getInstance();
    private List<Customer> customers = new ArrayList<>();
    private String subMenuChoice;
    private String userInput;
    private LoanRequest.LoanType loanType;
    private String loanTypeString;
    String loanAmountString;
    private Customer activeCustomer;
    private CustomerInteraction customerInteraction = new CustomerInteraction();
    private EmployeeInteraction employeeInteraction = new EmployeeInteraction();
    private LogInSelectionUI mainMenu = new LogInSelectionUI();

    Customer customer1 = new Customer(new Identifier(), "Customer", "One", new Address("123 Main St", "Philly", "PA", "12345"), Util.DateFormatter.getFormattedDOB("02-12-1992"), "967-623-2347", 700);
    Customer customer2 = new Customer(new Identifier(), "Customer", "Two", new Address("3014 New Town", "Miami", "FL", "67890"), Util.DateFormatter.getFormattedDOB("03-15-1980"), "215-871-0957", randomGenerator.generateCredit());
    Customer customer3 = new Customer(new Identifier(), "Customer", "Three", new Address("1 USA Ave", "Boston", "MA", "13579"), Util.DateFormatter.getFormattedDOB("12-20-1997"), "147-016-0597", randomGenerator.generateCredit());

    public static MFinanceDriver getInstance() {
        return INSTANCE;
    }
    
    public void initializeCustomers() {
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }

    public void displayEmployeeOptions() throws InterruptedException, IOException {
        initializeCustomers();

        for (Customer customer : customers) {
            loanHistory.add(new LoanRequest(new Identifier(), customer, LoanRequest.LoanType.PERSONAL, LoanRequest.LoanStatus.ACCEPTED, 5000, 5000));
            loanHistory.add(new LoanRequest(new Identifier(), customer, LoanRequest.LoanType.BUSINESS, LoanRequest.LoanStatus.ACCEPTED, 4000, 4000));
            loanHistory.add(new LoanRequest(new Identifier(), customer, LoanRequest.LoanType.SCHOOL, LoanRequest.LoanStatus.ACCEPTED, 3000, 3000));
        }

        do {
            employeeInteraction.displayEmployeeOptions();
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
                    for (int i = 0; i <50; i++) {
                        System.out.println();
                    }
                    mainMenu.show();
                    break;
                case "8":
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
                    employeeInteraction.performCustomerCreditCheck(customer);
                    return;
                }
            }
            System.out.println("Customer Does Not Exist.");
        } catch (Exception e) {
            System.out.println("Could not perform loan check.");
        }
    }

    public void openCustomerLoan() throws InterruptedException {
        System.out.print("\nOpen New Loan For Customer\nCustomer's Full Name: ");
        userInput = scanner.nextLine();
        userInput += scanner.nextLine();
        try {
            for (Customer customer : customers) {
                if (userInput.equals(customer.getFullName())) {
                    Customer loanCustomer = customer;
                    do {
                        System.out.print("Enter Loan Type (Options - PERSONAL, SCHOOL, BUSINESS): ");
                        loanTypeString = scanner.next();
                        loanType = Util.LoanTypeConverter.getloanType(loanTypeString);
                    } while (loanType == null);
                    do {
                        try {
                            System.out.print("Enter Loan Amount (Ex. 4000): ");
                            loanAmountString = scanner.next();
                            double loanAmount = DoubleUtil.tryParseDouble(loanAmountString);
                            loanHistory.add(employeeInteraction.openCustomerLoan(loanCustomer, loanType, loanAmount));
                            System.out.println("\nLoan Application Process Complete");
                        } catch (Exception e) {
                            System.out.println("Invalid Loan Amount Entry.");
                            loanAmountString = null;
                        }
                    } while (StringUtil.isNullOrEmpty(loanAmountString)
                            || StringUtil.isNullOrWhitespace(loanAmountString));
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not process customer loan.");
        }
        System.out.println("Customer does Not Exist.");
    }

    public void createNewCustomer() {
        Customer newCustomer;
        do {
            newCustomer = employeeInteraction.createNewCustomer();
            customers.add(newCustomer);
        } while (newCustomer == null);
    }

    public void viewCustomerLoanHistory() {
        //do {
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
                    return;
                }
            }
            System.out.println("Customer Does Not Exist.");
        } catch (Exception e) {
            System.out.println("Could not retrieve customer loan history OR Customer does not exist.");
        }
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
                System.out.println(customer.getFullName() + " Loan History:");
                for (LoanRequest request : loanHistory.searchCustomerLoans(customer)) {
                    if (request.getCustomer().getFullName().equals(userInput)) {
                        System.out.println(request.toString());
                    }
                }
                return;
            }
        }
        System.out.println("Customer Does Not Exist.");
    }

    /**
     * Will display a list of options for the customer to requests loans and
     * make payments.
     */
    public void displayCustomerOptions() throws InterruptedException, IOException {
        initializeCustomers();

        do {
            customerInteraction.displayCustomerOptions();
            subMenuChoice = scanner.next();

            switch (subMenuChoice) {
                case "1":
                    String loanTypeString;
                    do {
                        System.out.print("Enter Loan Type (Options - PERSONAL, SCHOOL, BUSINESS): ");
                        loanTypeString = scanner.next();
                        loanType = Util.LoanTypeConverter.getloanType(loanTypeString);
                    } while (loanType == null);
                    
                    do {
                        try {
                            System.out.print("Enter Loan Amount (Ex. 4000): ");
                            loanAmountString = scanner.next();
                            double loanAmount = DoubleUtil.tryParseDouble(loanAmountString);
                            loanHistory.add(customerInteraction.requestLoan(activeCustomer, loanType, loanAmount));
                            System.out.println("Loan Application Process Complete");
                        } catch (Exception e) {
                            System.out.println("Invalid Amount.");
                            loanAmountString = null;
                        }
                    } while (StringUtil.isNullOrEmpty(loanAmountString)
                            || StringUtil.isNullOrWhitespace(loanAmountString));
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
                    if (loanHistory.searchCustomerLoans(activeCustomer).isEmpty()) {
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
                    for (int i = 0; i <50; i++) {
                        System.out.println();
                    }
                    mainMenu.show();
                    break;
                case "6":
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