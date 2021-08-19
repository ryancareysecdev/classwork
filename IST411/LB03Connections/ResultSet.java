/*
Project: Group Lab 3
Purpose Details: NOAA interface application
Course: IST 411
Author: Scott Crowthers, Ryan Carey
Last Date Changed: 6/9/2020
Revision: 2
*/
public class ResultSet {
    int offset;
    int count;
    int limit;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
