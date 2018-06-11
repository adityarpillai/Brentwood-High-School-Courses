package Pet;

import java.util.ArrayList;

/**
 * Created by adityapillai on 4/17/17.
 */
public class Kennel {
    private ArrayList<Pet> petList;

    public void allSpeak() {
        for (Pet p :
                petList) {
            System.out.println(p.getName() + " " + p.speak());
        }
    }

    public Kennel() {
        petList = new ArrayList<Pet>();
    }

    public void addPet(Pet pet) {
        petList.add(pet);
    }
}
