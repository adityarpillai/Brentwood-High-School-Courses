package Dogs;

/**
 * Created by adityapillai on 1/31/17.
 * Dog Superclass
 */
public class Dog {

    private String name;
    private int age;
    boolean tail;

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void bark(){
        System.out.println("Woof! I'm a dog.");
    }

}
