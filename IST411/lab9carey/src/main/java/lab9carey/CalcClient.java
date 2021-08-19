/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9carey;

import java.rmi.Naming;
import java.rmi.RemoteException;
public class CalcClient {
 public static void main(String[]args) {
  try{
   Calc calc = (Calc)Naming.lookup("rmi://localhost:1999/Calculator");      //Port number = 1999
   System.out.println(calc.add(10,5));    //Add two Numbers RMI call
   System.out.println(calc.subtract(10,5));
   System.out.println(calc.multiply(10,5));
   System.out.println(calc.divide(10,5));
  } catch (RemoteException e){
   System.out.println("Remote exception: " + e.getMessage());
  } catch (Exception e){
  System.out.println("Exception: " + e.getMessage());
 }
 }
}