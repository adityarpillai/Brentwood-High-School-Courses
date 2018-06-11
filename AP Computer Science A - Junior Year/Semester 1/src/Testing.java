
/**
 * Created by Aditya Pillai on 10/17/16.
 * Just here to test stuff for labs/problem sets.
 */
public class Testing {

    public static void main(String[] args) {
        HiddenWord puzzle = new HiddenWord("HARPS");
        System.out.println(puzzle.getHint("AAAAA"));
        System.out.println(puzzle.getHint("HELLO"));
        System.out.println(puzzle.getHint("HEART"));
        System.out.println(puzzle.getHint("HARMS"));
        System.out.println(puzzle.getHint("HARPS"));

    }

}
