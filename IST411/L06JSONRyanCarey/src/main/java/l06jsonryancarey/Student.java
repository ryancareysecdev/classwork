/* 
Project: Lab 6Carey 
Purpose Details: Working with JSON
Course: IST 411
Author: Ryan Carey
Date Developed: 7/4/2020
Last Date Changed: 7/4/2020
Revision: 1
*/
package l06jsonryancarey;
/**
 *
 * @author godli
 */
public class Student {
    private String fName;
    private String lName;
    private double GPA;
    private int currentCredits;
    private int totalCredits;
    
    public Student(String first, String last, double gpa, int currentCredits, int totalCredits) {
        this.fName = first;
        this.lName = last;
        this.GPA = gpa;
        this.currentCredits = currentCredits;
        this.totalCredits = totalCredits;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getCurrentCredits() {
        return currentCredits;
    }

    public void setCurrentCredits(int currentCredits) {
        this.currentCredits = currentCredits;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

}
