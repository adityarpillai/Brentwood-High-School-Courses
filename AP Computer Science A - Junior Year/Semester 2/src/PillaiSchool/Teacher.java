package PillaiSchool;

/**
 * Created by adityapillai on 2/1/17.
 * Teacher for PillaiSchool
 */
public class Teacher extends Person {

    private String subject;

    Teacher(String name, int age, String gender, int subjectInt) {
        super(name, age, gender);
        String[] subjects = {
                "Math", "Language Arts", "Science", "History"
        };
        this.subject = subjects[subjectInt];
    }

    public String describeJob() {
        return "I teach " + subject + " at Brentwood High School.";
    }

    String teachLesson() {
        switch (subject) {
            case "Math":
                return "2 + 2 = 4, obviously.";

            case "Language Arts":
                return "The Great Gatsby is Great.";

            case "Science":
                return "Oxygen has an electron configuration of [He]2s2 2p4.";

            case "History":
                return "MURICA!";
        }
        return "I don't know what I teach.";
    }

}
