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
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class CalcImp extends UnicastRemoteObject implements Calc{
  public CalcImp() throws RemoteException{
  }
   public double add(double operand1,double operand2) throws RemoteException{
     return operand1 + operand2;  //Addition implementation
   }
    public double subtract(double operand1,double operand2) throws RemoteException{
     return operand1 - operand2;
    }
    public double multiply(double operand1,double operand2) throws RemoteException{
     return operand1 * operand2;
    }
    public double divide(double operand1,double operand2) throws RemoteException{
     return operand1 / operand2;//add the other operations for the subtract, multiply, and divide
    }
}