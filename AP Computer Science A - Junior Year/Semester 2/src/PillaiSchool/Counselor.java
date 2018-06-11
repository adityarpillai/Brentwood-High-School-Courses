package PillaiSchool;

/**
 * Created by adityapillai on 2/1/17.
 * Counselor for School
 */
public class Counselor extends Person {

    private String[] advices = {
            "Don't be pushed by your problems, be led by your dreams.",
            "BElieve in \n YOUrself",
            "Change your thoughts, and change your world.",
            "Allow your passion to become your purpose, and it will one day become your profession."
    };

    Counselor(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String describeJob() {
        return "I am a counselor at Brentwood High School.";
    }

    String getAdvice() {
        int index = (int)(Math.random()*4);
        return advices[index];
    }

}
