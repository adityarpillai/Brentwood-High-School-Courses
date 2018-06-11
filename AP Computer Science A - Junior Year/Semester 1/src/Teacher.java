/**
 * Created by Aditya Pillai on 10/17/16.
 */
@SuppressWarnings("WeakerAccess")
public class Teacher {
    private int experience;
    private String name;

    public Teacher(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String toString() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
}
