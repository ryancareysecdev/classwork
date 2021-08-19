import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
  Name: Ryan Carey
  Project: Lab6JUnit
  Date: 9/26/2019
  Class: IST 261
*/
public class Movie {
    private String title;
    private Date startTime;
    private int runningTime;
    private List<Actor> actors = new ArrayList<>();
    private List<Genre> genres = new ArrayList<>();

    public Movie() {
    }
}
