package Pet;

/**
 * Created by adityapillai on 4/17/17.
 */
public class Main {

    public static void main(String[] args) {
        Kennel ken = new Kennel();
        ken.addPet(new Cat("Kaiser"));
        ken.addPet(new LoudDog("Clifford?"));
        ken.addPet(new Dog("brandon's non-existent dog"));
        ken.allSpeak();
    }
}
