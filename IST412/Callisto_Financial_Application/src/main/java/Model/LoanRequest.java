package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A class for creating a loan request.
 */
public class LoanRequest {

    private Identifier id;
    private LocalDateTime dateTimeCreated;
    private LoanType loanType;
    private LoanStatus loanStatus;
    private double loanAmount;
    private double remainingAmount;
    private Customer customer;

    /**
     * Types of available loans.
     */
    public enum LoanType {

        PERSONAL,
        SCHOOL,
        BUSINESS

    }

    /**
     * Types of loan statuses.
     */
    public enum LoanStatus {

        PENDING,
        ACCEPTED,
        DENIED

    }

    /**
     * A constructor for creating a loan request.
     *
     * @param id Unique ID for the loan.
     * @param customer Customer requesting a loan.
     * @param loanType Type of requested loan.
     * @param loanStatus Status of requested loan.
     * @param loanAmount Amount of being requested for the loan.
     * @param remainingAmount Amount remaining on the loan.
     */
    public LoanRequest(Identifier id, Customer customer, LoanType loanType, LoanStatus loanStatus, double loanAmount, double remainingAmount) {
        this.id = new Identifier();
        this.dateTimeCreated = LocalDateTime.now();
        this.loanType = loanType;
        this.loanStatus = loanStatus;
        this.loanAmount = loanAmount;
        this.customer = customer;
        this.remainingAmount = remainingAmount;
    }

    /**
     * Returns a loan's ID.
     *
     * @return An ID to be associated with the loan.
     */
    public Identifier getId() {
        return id;
    }

    /**
     * Returns a loan's type.
     *
     * @return A type of loan.
     */
    public LoanType getLoanType() {
        return loanType;
    }

    /**
     * Returns a loan's status.
     *
     * @return A status of a loan.
     */
    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    /**
     * Sets a loan's ID.
     *
     * @param id Sets the loan's unique ID.
     */
    public void setId(Identifier id) {
        this.id = id;
    }

    /**
     * Sets a loan's request date.
     *
     * @param dateTimeCreated Sets the loans creation date.
     */
    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    /**
     * Returns a loan's request date.
     *
     * @return A LocalDateTime for the loan request date.
     */
    public LocalDateTime getDateTimeCreated() {
        return this.dateTimeCreated;
    }

    /**
     * Returns a loan's amount.
     *
     * @return A string for the loan amount.
     */
    public double getAmount() {
        return loanAmount;
    }
    
    public double getRemainingAmount() {
        return remainingAmount;
    }

    /**
     * Sets a loan's amount.
     *
     * @param loanAmount Sets the loan amount.
     */
    public void setAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    
    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Returns a string representing an organized loan request.
     *
     * @return String with loan information.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateTimeCreatedFormatted = this.dateTimeCreated.format(formatter);

        return String.format(
                "Loan ID: %s| Loan Date: %s| Loan Type: %s| Loan Status: %s| Loan Amount: $%s| Current Amount Owed: $%s",
                this.id,
                dateTimeCreatedFormatted,
                this.loanType,
                this.loanStatus,
                this.loanAmount,
                this.remainingAmount
        );
    }
}
