/*
Project: Group Lab 3
Purpose Details: NOAA interface application
Course: IST 411
Author: Scott Crowthers, Ryan Carey
Last Date Changed: 6/9/2020
Revision: 2
*/
public class Results {
    String uid;
    String mindate;
    String maxdate;
    String name;
    double datacoverage;
    String id;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMindate() {
        return mindate;
    }

    public void setMindate(String mindate) {
        this.mindate = mindate;
    }

    public String getMaxdate() {
        return maxdate;
    }

    public void setMaxdate(String maxdate) {
        this.maxdate = maxdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDatacoverage() {
        return datacoverage;
    }

    public void setDatacoverage(double datacoverage) {
        this.datacoverage = datacoverage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
