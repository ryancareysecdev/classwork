/* 
Project: Lab 6Carey 
Purpose Details: Working with JSON
Course: IST 411
Author: Ryan Cary
Date Developed: 7/4/2020
Last Date Changed: 7/4/2020
Revision: 1
*/
package l06jsonryancarey;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.json.*;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

/**
 *
 * @author godli
 */
public class l06JSONRyanCarey {
    ArrayList<Student> students = new ArrayList();
    static Path basePath = Paths.get("").toAbsolutePath();
    private static final Path filePath = basePath.resolve("src").resolve("main").resolve("Students.json");
    JsonReader jsonReader;
    JsonParser parser;
    JsonWriter saveIt;
    FileReader configReader;
    
    public static void main(String[] args) {
        l06JSONRyanCarey testRun = new l06JSONRyanCarey();
        try {
            testRun.objToJSON();
            testRun.displayJSON();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void objToJSON()throws Exception {
        saveIt = Json.createWriter(new FileWriter(filePath.toString()));
        Student joey = new Student("Joe", "Sanchez", 3.1, 12, 30);
        Student zoe = new Student("Zoe", "Smith", 2.1, 8, 12);
        Student bill = new Student("William", "Jones", 3.5, 22, 54);
        students.add(joey);
        students.add(zoe);
        students.add(bill);
        JsonArrayBuilder studentArrayBuilder = Json.createArrayBuilder();
        students.forEach(stud -> {
            studentArrayBuilder.add(Json.createObjectBuilder().add("First Name", stud.getfName()).add("Last Name", stud.getlName()).add("GPA", stud.getGPA()).add("Current Credits", stud.getCurrentCredits()).add("Total Credits", stud.getTotalCredits()));
        });
        JsonArray studentArray = studentArrayBuilder.build();
        saveIt.writeArray(studentArray);
        saveIt.close();
    }
    
    public void displayJSON() throws Exception {
        configReader = new FileReader(filePath.toString());
        parser = Json.createParser(configReader);
        while (parser.hasNext()) {
            Event event = parser.next(); 
            if (event.equals(JsonParser.Event.START_OBJECT)) { 
                System.out.println("Student record found.");
            } else if (event.equals(JsonParser.Event.KEY_NAME)) { 
                String keyName = parser.getString(); 
                switch (keyName) { 
                  case "First Name": 
                  parser.next(); 
                  System.out.println("First Name: " + parser.getString()); 
                  break; 
                  case "Last Name": 
                  parser.next(); 
                  System.out.println("Last Name: " + parser.getString());
                  break; 
                  case "GPA": 
                  parser.next(); 
                  System.out.println("GPA: " + parser.getString()); 
                  break; 
                  case "Current Credits": 
                  parser.next(); 
                  System.out.println("Current Credits: " + parser.getInt()); 
                  break; 
                  case "Total Credits": 
                  parser.next(); 
                  System.out.println("Total Credits: " + parser.getInt()); 
                  break; 
                  default:
                  parser.next();
                  break;
                } 
              } else if (event.equals(JsonParser.Event.END_OBJECT)) {
                System.out.println("End of student record.\n");
              } else if (event.equals(JsonParser.Event.END_ARRAY)) {
                System.out.println("End of records reached.\n");
              }
        }
    }
}
