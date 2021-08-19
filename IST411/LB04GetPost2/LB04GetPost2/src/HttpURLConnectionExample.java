
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Scott Jr
 */
public class HttpURLConnectionExample {

    public static void main(String[] args) throws Exception {
        HttpURLConnectionExample http = 
            new HttpURLConnectionExample();
        http.sendGet();
        http.sendPost();
        http.sendGet();
    }
    
    private void sendGet() throws Exception {
        String request = "http://127.0.0.1:8080";
        URL url = new URL(request);
        HttpURLConnection connection = 
            (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", 
            "Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        if (responseCode == 200) {
            String response = getResponse(connection);
            System.out.println("response: " + 
                response.toString());
        } else {
            System.out.println("Bad Response Code: " + 
                responseCode);
        }
    }
    
    private void sendPost() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int responseCode;
        URL url = new URL("http://127.0.0.1:8080");
        System.out.println("Type diary entry: ");
        String input = scanner.nextLine();
        
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("User-Agent", "nbClient");
        conn.setDoOutput(true);
        OutputStream toPost = conn.getOutputStream();
        PrintWriter out = new PrintWriter(toPost, true);
        out.println(input);
        System.out.println("hereResponse");
        responseCode = conn.getResponseCode();
        System.out.println("hereResponseAfter");
        if (responseCode == 200) {
            System.out.println("hereIf");
            String response = getResponse(conn);
            System.out.println("response: " + 
                response.toString());
            System.out.println("hereEndIf");
        } else {
            System.out.println("Bad Response Code: " + 
                responseCode);
        }
    }
    
    private String getResponse(HttpURLConnection connection) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                    connection.getInputStream()));) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            return response.toString();
        } catch (IOException ex) {
            // Handle exceptions
        }
        return "";
    }

}
