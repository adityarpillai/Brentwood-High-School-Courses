package FamilyTree;

import java.util.ArrayList;

/**
 * Created by adityapillai on 2/8/17.
 * Family Member
 */
public class PillaiFamilyMember {

    private String firstName;
    private String lastName;

    private int birthday;

    private PillaiFamilyMember spouse;
    private ArrayList<PillaiFamilyMember> children = new ArrayList<>();

    PillaiFamilyMember(String firstName, String lastName, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = year;
    }


    void setSpouse(PillaiFamilyMember spouse) {
        this.spouse = spouse;
    }

    void addChild(PillaiFamilyMember child) {
        this.children.add(child);
    }

    String getLastName() {
        return lastName;
    }

    int getBirthdayYear() {
        return birthday;
    }

    ArrayList<PillaiFamilyMember> getChildren() {
        return children;
    }

    String getFirstName() {
        return firstName;
    }

    public String toString() {
        return(firstName + " " + lastName);
    }

    PillaiFamilyMember getSpouse() {
        return spouse;
    }

}
