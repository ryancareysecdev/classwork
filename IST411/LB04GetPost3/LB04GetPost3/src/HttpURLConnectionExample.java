/*
Project: Group Lab 4
Purpose Details: POSTGET
Course: IST 411
Author: Team 4
Last Date Changed: 6/15/2020
Revision: 3
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpURLConnectionExample {

    public static void main(String[] args) throws Exception {
        String again = "";
        Scanner scanner = new Scanner(System.in);
        HttpURLConnectionExample http = 
            new HttpURLConnectionExample();
        do {
        http.sendGet();
        http.sendPost();
        http.sendGet();
        System.out.println("Continue? (Y/N)");
        again = scanner.nextLine();
        } while(again.toUpperCase().equals("Y"));
    }
    
    private void sendGet() throws Exception {
        String query =  "http://127.0.0.1:8080";
        URL url = new URL(query);
        HttpURLConnection connection = 
            (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", 
            "Mozilla/5.0");
        System.out.println("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        if (responseCode == 200) {
            String response = getResponse(connection);
            System.out.println("Response: " + 
                response.toString());
        } else {
            System.out.println("Bad Response Code: " + 
                responseCode);
        }
        System.out.println();
    }
    
    private void sendPost() throws Exception {
        int responseCode;
        Scanner scanner = new Scanner(System.in);
        URL url = new URL("http://127.0.0.1:8080");
        System.out.println("POST");
        System.out.println("Type diary entry: ");
        String input = scanner.nextLine();
        
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("User-Agent", "nbClient");
        conn.setDoOutput(true);
        OutputStream toPost = conn.getOutputStream();
        PrintWriter out = new PrintWriter(toPost, true);
        out.println(input);
        responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        if (responseCode == 200) {
            String response = getResponse(conn);
            /*System.out.println("Response: " + 
                response.toString());*/
        } else {
            System.out.println("Bad Response Code: " + 
                responseCode);
        }
        System.out.println();
    }
    
    private String getResponse(HttpURLConnection connection) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                    connection.getInputStream()));) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine).append(System.lineSeparator());
            }
            br.close();
            return response.toString();
        } catch (IOException ex) {
            // Handle exceptions
        }
        return "";
    }

}