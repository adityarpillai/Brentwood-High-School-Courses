import java.util.Arrays;

/**
 * Created by adityapillai on 1/11/17.
 * FRQ 2015 #2
 */
public class HiddenWord {

    private String word;

    public HiddenWord(String word) {
        this.word = word;
    }

    public String getHint(String guess) {
        int index = 0;
        String result = "";
        while (index < guess.length()) {
            if (guess.charAt(index) == word.charAt(index)) {
                result += "" + word.charAt(index);
                index++;
            } else {
                char[] charArray = word.toCharArray();
                if (Arrays.binarySearch(charArray, guess.charAt(index)) >= 0) {
                    result += "+";
                    index++;
                } else {
                    result += "*";
                    index++;
                }
            }
        }
        return result;
    }

}
