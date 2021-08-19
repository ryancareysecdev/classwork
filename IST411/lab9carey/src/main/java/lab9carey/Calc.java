/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9carey;

/**
 *
 * @author godli
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Calc extends Remote{
  double add(double operand1,double operand2) throws RemoteException;  //Addition interface
  double subtract(double operand1, double operand2) throws RemoteException;
  double multiply(double operand1, double operand2) throws RemoteException;
  double divide(double operand1, double operand2) throws RemoteException;
//add the other operations for the subtract, multiply, and divide
}