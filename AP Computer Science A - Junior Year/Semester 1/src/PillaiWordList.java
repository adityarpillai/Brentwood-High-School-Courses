import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Aditya Pillai on 11/1/16.
 * APCS 2004 FRQ Question 1
 */
@SuppressWarnings({"SpellCheckingInspection", "unused"})
public class PillaiWordList {


    private ArrayList<String> myList; // contains Strings made up of letters

    // postcondition: returns the number of words in this WordList that

    // are exactly len letters long

    public PillaiWordList() {
        myList = new ArrayList<>();
    }

    // postcondition: all words that are exactly len letters long

    // have been removed from this WordList, with the

    // order of the remaining words unchanged

    public int numWordsOfLength(int len) {
        int count = 0;
        for (String word : myList) {
            if (word.length() == len) {
                count++;
            }
        }
        return count;
    }

    // ... constructor and other methods not shown

    public void removeWordsOfLength(int len) {
        ArrayList<String> tempList = myList.stream().filter(word -> word.length() != len).collect(Collectors.toCollection(ArrayList::new));
        myList.clear();
        myList = tempList;
    }


}

