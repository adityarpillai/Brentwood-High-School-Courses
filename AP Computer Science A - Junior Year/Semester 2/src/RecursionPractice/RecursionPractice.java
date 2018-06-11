package RecursionPractice;

/**
 * Created by adityapillai on 2/6/17.
 * APCS RecursionPractice Practice
 */
@SuppressWarnings("unused")
public class RecursionPractice {


    private int add(int x) {
        //exit
        if (x == 0) {
            return 0;
        }

        //recursive
        return x + add(x - 1);
    }

}
