/*
Project: Group Lab 3
Purpose Details: NOAA interface application
Course: IST 411
Author: Scott Crowthers, Ryan Carey
Last Date Changed: 6/9/2020
Revision: 2
*/
public class NoaaData {
    MetaData metadata;
    Results[] results;

    public MetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaData metadata) {
        this.metadata = metadata;
    }

    public Results[] getResults() {
        return results;
    }

    public void setResult(Results[] results) {
        this.results = results;
    }
}
