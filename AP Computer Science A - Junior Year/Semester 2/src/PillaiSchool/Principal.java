package PillaiSchool;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by adityapillai on 2/1/17.
 * PillaiSchool.Principal class.
 */
public class Principal extends Person {


    private String[] announcements = {"Make it a great day or not, the choice is yours.", "Welcome to Brentwood High PillaiSchool.PillaiSchool.",
            "Beat Ravenswood.", "Blank Message"};


    Principal(String name, int age, String gender) {
        super(name, age, gender);
    }

    //describes job, saying he/she is a principal
    public String describeJob() {
        return "I work as a PillaiSchool.Principal at Brentwood High School.";
    }

    String makeAnnouncement(){


        //gives random number between 0 and 3.
        int index = (int)(Math.random()*4);

        if (index == 3) {
            //updates timer, then will display it
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
            this.announcements[3] = "It is " + sdf.format(cal.getTime()) + ".";
        }
        //uses that index and returns a String for the announcement.
        return announcements[index];
    }
}
