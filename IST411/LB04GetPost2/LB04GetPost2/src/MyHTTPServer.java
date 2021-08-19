
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Scott Jr
 */
public class MyHTTPServer {

    static String diary = "Diary: ";
    
    public static void main(String[] args) throws Exception {
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
            System.out.println("hereHandle");
            System.out.println(exchange.getRemoteAddress());
            String method = exchange.getRequestMethod();
            String response = getResponse();       
                exchange.sendResponseHeaders(200, response.length());
                OutputStream out = exchange.getResponseBody();
                out.write(response.toString().getBytes());
                out.close();  
            if(method.equals("GET")){
                System.out.println("hereGet");;  
            }
            else if(method.equals("POST")){
                System.out.println("herePost");
                try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                        exchange.getRequestBody()));) {
                    String inputLine;
                    StringBuilder strResponse = new StringBuilder();
                    while ((inputLine = br.readLine()) != null) {
                        strResponse.append(inputLine);
                    }
                    br.close();
                    diary += strResponse.toString();
                } catch (IOException ex) {
                    // Handle exceptions
                }
            }
        }

        public String getResponse() {
        StringBuilder responseBuffer = new StringBuilder();
        responseBuffer
            .append(diary);
        return responseBuffer.toString();
        }
    }
    
    static class DetailHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) 
                throws IOException {
            Headers requestHeaders = exchange.getRequestHeaders();
            Set<String> keySet = requestHeaders.keySet();
            for (String key : keySet) {
                List values = requestHeaders.get(key);
                String header = key + " = " + values.toString() + "\n";
                System.out.print(header);
            }
        }
    }

}
