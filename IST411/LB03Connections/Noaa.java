/*
Project: Group Lab 3
Purpose Details: NOAA interface application
Course: IST 411
Author: Scott Crowthers, Ryan Carey
Last Date Changed: 6/9/2020
Revision: 2
*/
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Noaa {
    public Noaa() {
        String accessToken = "UhiHVBexKWAnKCdMAYbKqQbvnSTmTtds";
        Gson gson = new Gson();
        String response = "";
        HttpURLConnection connection = null;

        try {
            URL url = new URL("https://www.ncdc.noaa.gov/cdo-web/api/v2/datasets");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("token", accessToken);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            response = br.readLine();
            System.out.println(response + "\n");
        }
        catch(IOException ex) {
            System.out.println(ex);
        }
        finally {
            connection.disconnect();
        }

        NoaaData noaa = gson.fromJson(response, NoaaData.class);
        System.out.println("Result Set");
        System.out.println("----------");
        System.out.printf("Offset %10s\n", noaa.getMetadata().getResultset().getOffset());
        System.out.printf("Count  %10s\n", noaa.getMetadata().getResultset().getCount());
        System.out.printf("Limit  %10s\n", noaa.getMetadata().getResultset().getLimit());

        int size = noaa.getResults().length;
        for(int i = 0; i < size; i++) {
            System.out.println("Result: " + i);
            System.out.println("---------");
            System.out.printf("Uid            %s\n", noaa.getResults()[i].getUid());
            System.out.printf("Min Date       %s\n", noaa.getResults()[i].getMindate());
            System.out.printf("Max Date       %s\n", noaa.getResults()[i].getMaxdate());
            System.out.printf("Name           %s\n", noaa.getResults()[i].getName());
            System.out.printf("Data Coverage  %s\n", noaa.getResults()[i].getDatacoverage());
            System.out.printf("ID             %s\n", noaa.getResults()[i].getId());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Noaa noaa = new Noaa();
    }
}
