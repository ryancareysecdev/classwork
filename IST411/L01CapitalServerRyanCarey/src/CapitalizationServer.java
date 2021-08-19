/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
Project: Lab 1
Purpose Details: Client-Server capitalization application
Course: IST 411
Author: Scott Crowthers, Ryan Carey
Last Date Changed: 5/24/2020
Revision: 1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CapitalizationServer {
    
    public static void main(String[] args) {
        System.out.println("Capitalization Server");
        
        try(ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Waiting for connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client");
            
            try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(), true)) {
                String inputLine;
                while((inputLine = br.readLine()) != null) {
                    // This line converts any input string to uppercase.
                    inputLine = inputLine.toUpperCase();
                    System.out.println("Server: " + inputLine);
                    out.println(inputLine);
                }
        }
        } catch (IOException ex) {
        }
    }
}

