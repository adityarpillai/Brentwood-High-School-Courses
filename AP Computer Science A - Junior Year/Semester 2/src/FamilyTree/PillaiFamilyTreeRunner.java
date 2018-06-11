package FamilyTree;

/**
 * Created by adityapillai on 2/8/17.
 * Runner for Family Tree
 */
public class PillaiFamilyTreeRunner {

    public static void main(String[] args) {

        PillaiFamilyMember SpongeBuckSquarePants = new PillaiFamilyMember("SpongeBuck", "SquarePants", 1890);
        PillaiFamilyTree squarePantsFamily = new PillaiFamilyTree();

        //Grandpa SquarePants descends from SpongeBuck
        PillaiFamilyMember GrandpaSquarePants = new PillaiFamilyMember("Grandpa", "SquarePants", 1930);
        SpongeBuckSquarePants.addChild(GrandpaSquarePants);

        //Grandpa SquarePants marries Grandma SquarePants
        PillaiFamilyMember GrandmaSquarePants = new PillaiFamilyMember("Grandma", "SquarePants", 1932);
        GrandpaSquarePants.setSpouse(GrandmaSquarePants);

        //They have 3 children
            //Sherm SquarePants
            PillaiFamilyMember ShermSquarePants = new PillaiFamilyMember("Sherm", "SquarePants", 1951);
            GrandpaSquarePants.addChild(ShermSquarePants);

            //HaroldSquarePants
            PillaiFamilyMember HaroldSquarePants = new PillaiFamilyMember("Harold", "SquarePants", 1983);
            GrandpaSquarePants.addChild(HaroldSquarePants);
            //BlueSquarePants
            PillaiFamilyMember BlueSquarePants = new PillaiFamilyMember("Blue", "SquarePants", 1974);
            GrandpaSquarePants.addChild(BlueSquarePants);

        //Harold SquarePants marries Mrs. SquarePants
        PillaiFamilyMember MrsSquarePants = new PillaiFamilyMember("Mrs.", "SquarePants", 1981);
        HaroldSquarePants.setSpouse(MrsSquarePants);

        //They have SpongeBob SquarePants
        PillaiFamilyMember SpongeBobSquarePants = new PillaiFamilyMember("SpongeBob", "SquarePants", 1999);
        HaroldSquarePants.addChild(SpongeBobSquarePants);

        //Multiple generations down, SpongeBob has SpongeTron as his descendant
        PillaiFamilyMember SpongeTron = new PillaiFamilyMember("SpongeTron", "SquarePants", 22339);
        SpongeBobSquarePants.addChild(SpongeTron);

        //Stanley is the child of Sherm
        PillaiFamilyMember StanleySSquarePants = new PillaiFamilyMember("Stanley S.", "SquarePants", 1982);
        ShermSquarePants.addChild(StanleySSquarePants);

        //Harold is the child of Blue
        PillaiFamilyMember HaroldSquarePants2 = new PillaiFamilyMember("Harold", "SquarePants", 2004);
        BlueSquarePants.addChild(HaroldSquarePants2);

        System.out.println(squarePantsFamily.bornAfter1950(SpongeBuckSquarePants) + " sponges descending from SpongeBuckSquarePants were born after 1950.");
        System.out.println(squarePantsFamily.withName(SpongeBuckSquarePants, "Harold") + " sponges have the name \"Harold\"");

    }

}
