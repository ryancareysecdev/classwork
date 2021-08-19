/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9carey;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class CalcServer {
  public static void main(String [] args) throws RemoteException {
  try{
  Registry registry = LocateRegistry.createRegistry(1999); //Port number = 1999
   registry.rebind("Calculator", new CalcImp()); //Start the RMI Service first
   System.out.println("Server is Running");
}catch (Exception e){
   throw new RuntimeException(e);
 }
}
}