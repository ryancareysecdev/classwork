/*
Project: Group Lab 4
Purpose Details: POSTGET
Course: IST 411
Author: Team 4
Last Date Changed: 6/15/2020
Revision: 3
*/
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 3
 * @author Scott Jr
 */
public class MyHTTPServer {
    
    static Path basePath = Paths.get("").toAbsolutePath();
    private static final Path diaryPath = basePath.resolve("nbproject").resolve("Diary.txt");
    private static List<String> diary;

    public static void main(String[] args) throws Exception {
        diary = Files.readAllLines(diaryPath);
        System.out.println("MyHTTPServer Started");
        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080), 0);
        server.createContext("/", new IndexHandler());
        server.start();
    }
    
    static class IndexHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) 
                throws IOException {
            FileWriter saveIt = new FileWriter(diaryPath.toString());
            System.out.println(exchange.getRemoteAddress());
            String requestMethod = exchange.getRequestMethod();
            String response = getResponse();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream out = exchange.getResponseBody();
            if(requestMethod.equals("GET")){
               out.write(response.toString().getBytes());
            }
            else if(requestMethod.equals("POST")){
                InputStream in = exchange.getRequestBody();
                if (in != null) {
                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(in));) {
                        String inputLine;
                        StringBuilder strResponse = new StringBuilder();
                        strResponse.append("Entry: ");
                        while ((inputLine = br.readLine()) != null) {
                            strResponse.append(inputLine);
                        }
                        diary.add(strResponse.toString());
                        System.out.println(strResponse.toString());
                        saveIt.write(strResponse.toString());
                        br.close();
                        saveIt.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("Request body is empty");
                }
            }
            out.close();
        }
        
        public String getResponse() {
            StringBuilder responseBuffer = new StringBuilder();
            diary.forEach(line -> responseBuffer.append(line).append("\n"));
            return responseBuffer.toString();
        }
    }
}
