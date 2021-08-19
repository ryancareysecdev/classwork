package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class for storing loans.
 */
public class LoanHistory {

    private static final LoanHistory INSTANCE = new LoanHistory();
    private List<LoanRequest> history;

    /**
     * Sets the synchronized loan history.
     */
    private LoanHistory() {
        this.history = Collections.synchronizedList(new ArrayList<>());
    }

    /**
     * Returns a loan history instance.
     *
     * @return A single instance of the loan history.
     */
    public static LoanHistory getInstance() {
        return INSTANCE;
    }

    /**
     * Adds a loan request to the loan history.
     */
    public void add(LoanRequest request) {
        this.history.add(request);
    }

    /**
     * Returns a list of loan requests.
     *
     * @return Loan history list.
     */
    public List<LoanRequest> getAll() {
        return this.history;
    }

    /**
     * Clears the history of loans.
     */
    public void clear() {
        this.history.clear();
    }
    
    public List<LoanRequest> searchCustomerLoans(Customer customer) {
    /*
     * Return all transactions with the given transaction type
     */

    List<LoanRequest> found = new ArrayList<>();

    if (customer == null) {
      return found;
    }

    for (LoanRequest request : this.getAll()) {
      if (request.getCustomer().getFullName().equals(customer.getFullName())) {
        found.add(request);
      }
    }

    return found;
  }
    
    public List<LoanRequest> searchActiveLoans(List<LoanRequest> loanRequests) {
    /*
     * Return all transactions with the given transaction type
     */

    List<LoanRequest> found = new ArrayList<>();

    if (loanRequests == null) {
      return found;
    }

    for (LoanRequest request : loanRequests) {
      if (request.getLoanStatus().equals(LoanRequest.LoanStatus.ACCEPTED)) {
        found.add(request);
      }
    }

    return found;
  }
}
