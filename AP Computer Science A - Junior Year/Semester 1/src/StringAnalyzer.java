import java.util.ArrayList;

/**
 * Created by Aditya Pillai on 10/28/16.
 */
@SuppressWarnings("unused")
public class StringAnalyzer {

    private ArrayList<String> words;

    public StringAnalyzer() {
        words = new ArrayList<>();
    }

    private boolean hasMoreVowelsThanConsonants(String word) {

        int oCount = 0;
        int eCount = 0;
        String lWord = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char c = lWord.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                eCount++;
            } else {
                oCount++;
            }
        }

        return eCount > oCount;

    }

    private void stringMachine(ArrayList<String> words) {
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (hasMoreVowelsThanConsonants(words.get(i))) {
                index.add(i);
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (Integer anIndex : index) {
            result.add(words.get(anIndex));
        }
        words.clear();
        words = result;

    }

}
