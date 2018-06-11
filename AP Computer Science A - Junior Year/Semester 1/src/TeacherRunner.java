/**
 * Created by Aditya Pillai on 10/17/16.
 * hi
 */
public class TeacherRunner {
    public static void main(String[] args) {
        Teacher teach1 = new Teacher("Teacher1", 7);
        Teacher teach2 = new Teacher("Teacher2", 7);

        if (teach1.getExperience() > teach2.getExperience()) {
            System.out.println(teach1.toString() + " has more experience.");
        } else if (teach2.getExperience() > teach1.getExperience()) {
            System.out.println(teach2.toString() + " has more experience.");
        } else {
            System.out.println(teach1.toString() + " and " + teach2.toString() + " have the same experience.");
        }
    }
}
