package PillaiSchool;

/**
 * Created by adityapillai on 2/1/17.
 * PillaiSchool.Person Class
 */
abstract public class Person {

    private String name;
    private int age;

    //true is male, false is female
    private String gender;


    //true is male, false is female
    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getGender() {
        return gender;
    }

    abstract public String describeJob();

}
