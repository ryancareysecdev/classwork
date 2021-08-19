/* 
Project: Lab 2
Purpose Details: Threading Synchronization
Course: IST 411
Author: Ryan Carey
Date Developed: 5/31/2020
Last Date Changed: 5/31/2020
Revision: 1
*/
public class BankDeadlock {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;
    
    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for(int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while(true) {
                        int toAccount = (int)(bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(toAccount, fromAccount, amount);
                    }
                } catch(InterruptedException ex) {
                    ex.printStackTrace();
                } catch (Exception noFunds) {
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
