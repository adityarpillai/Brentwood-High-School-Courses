package FamilyTree;

/**
 * Created by adityapillai on 2/8/17.
 * Family tree class
 */
class PillaiFamilyTree {

    PillaiFamilyTree() {
    }

    int bornAfter1950(PillaiFamilyMember familyMember) {
        //checks if this individual has any children
        //if doesn't have any children, will return 1 if they were born after 1950, returns 0 if they weren't.
        if (familyMember.getChildren().size() == 0) {
            if (familyMember.getBirthdayYear() > 1950) {
                return 1;
            }
            return 0;
        }

        int result = 0;
        //if this individual is born after 1950, will return 1 + (bornAfter1950) method for each of the children
        if (familyMember.getBirthdayYear() > 1950) {
            result++;
        }

        //if this individual's spouse is not null && born after 1950, will add 1
        if (familyMember.getSpouse() != null && familyMember.getSpouse().getBirthdayYear() > 1950) {
            result++;
        }
        //other wise will return 0 + (bornAfter1950) for each of the children
        for (PillaiFamilyMember child : familyMember.getChildren()) {
            result += bornAfter1950(child);
        }
        return result;

    }

    int withName(PillaiFamilyMember member, String name) {
        //checks if this individual has any children
        //if doesn't have children returns 1 if their name is name, 0 if their name isn't name
        if (member.getChildren().size() == 0) {
            if (member.getFirstName().equals(name)) {
                return 1;
            }
            return 0;
        }

        //else, result = 0. result++ if their name is the same as "name"
        //then result+= withName for each of their children to total.
        int result = 0;
        //if this individual is named name, will add 1 to result
        if (member.getFirstName().equals(name)) {
            result++;
        }

        //if this individual's spouse is not null and is named name, will add 1 to result
        if (member.getSpouse() != null && member.getSpouse().getFirstName().equals(name)) {
            result++;
        }

        //other wise will return 0 + (bornAfter1950) for each of the children
        for (PillaiFamilyMember child : member.getChildren()) {
            result += withName(child, name);
        }
        return result;
    }

}
