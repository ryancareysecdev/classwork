/* 
Project: Lab 2
Purpose Details: Threading Synchronization
Course: IST 411
Author: Ryan Carey
Date Developed: 5/31/2020
Last Date Changed: 5/31/2020
Revision: 1
*/
import java.util.Arrays;
import java.util.concurrent.locks.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bank {
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();
    private Condition sufficientFunds = bankLock.newCondition();
    
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }
    
    public void transfer(int from, int to, double amount) throws InterruptedException, Exception {
        bankLock.lock();
        try {
            if (accounts[from] < amount) {
                //edited this line for the new exception
                sufficientFunds.await();
                //throw new Exception();
            }          
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f", getTotalBalance());
            sufficientFunds.signal();
        }
        finally {
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
