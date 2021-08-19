/* 
Project: Group Lab 2
Purpose Details: Deadlock application
Course: IST 411
Author: Scott Crowthers, Ryan Carey
Last Date Changed: 5/31/2020
Revision: 1
*/
import java.util.Arrays;
import java.util.concurrent.locks.*;

public class Bank {
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();
    private Condition sufficientFunds = bankLock.newCondition();
    
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }
    
    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while(accounts[from] < amount) {
                sufficientFunds.await();
            }          
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f", getTotalBalance());
            sufficientFunds.signal();
        } finally {
            bankLock.unlock();
        }
    }
    
    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;         
            for(double a : accounts) {
                sum += a;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }
    
    public int size() {
        return accounts.length;
    }
}
