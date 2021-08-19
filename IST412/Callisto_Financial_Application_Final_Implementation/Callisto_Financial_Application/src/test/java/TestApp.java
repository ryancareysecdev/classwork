/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alban
 */
public class TestApp {
     public static void main(String args[]) {
  
        Model.AddressTest testAddrs = new Model.AddressTest();
//        testAddrs.testGetStreet();
//        testAddrs.testGetCity();
//        testAddrs.testGetState();
//        testAddrs.testGetZip();
        testAddrs.testToString();
        
        Model.CustomerTest testCustomer = new Model.CustomerTest();
        testCustomer.testToString();
        
        Model.EmployeeTest testEmployee = new Model.EmployeeTest();
        testEmployee.testFullName();
        
//        Model.FinancialProfileTest profileTest = new Model.FinancialProfileTest();
//        profileTest.testRequestLoan();
        Model.LoanRequestTest loanReqTest = new Model.LoanRequestTest();
        loanReqTest.testGetAmount();
        
         }
     }