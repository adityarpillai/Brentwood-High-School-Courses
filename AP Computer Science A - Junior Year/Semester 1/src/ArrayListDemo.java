import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aditya Pillai on 10/24/16.
 * 10/24/2016 AP CS Notes
 */
public class ArrayListDemo {
    //ArrayList is a reference variable that makes using arrays easy
    //the indexes work exactly the same
    public static void main(String[] args) {
        //Initialize an array list; Integer, Double
        ArrayList<String> words = new ArrayList<>();

        //learn how to add items to the end of a list
        words.add("BHS");
        words.add("Bruins");
        words.add("Gold");
        System.out.println(words);

        //add items to a specific location, add(index, element)
        words.add(2, "Blue");
        System.out.println(words);

        //allows to set an element at given index to a new value
        words.set(0, "BMS");
        words.set(1, "Vikings");
        words.set(2, "Green");
        System.out.println(words);

        //size() gives the length of the list
        System.out.println(words.size());

        //remove(index) removes the item at the given index
        words.remove(0);
        words.remove(1);
        System.out.println(words);

        //clear() removes everything from the list
        words.clear();
        System.out.println(words);

        //collections require an import java.util.Collections
        //Collections.sort(listname);
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(55);
        nums.add(44);
        nums.add(77);
        nums.add(11);
        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);

        //Collections.binarySearch(nums, value); returns - if not in list, return index if in list
        System.out.println(Collections.binarySearch(nums, 11));
        System.out.println(Collections.binarySearch(nums, 99));

        //Collections.rotate(nums, value); if value is positive rotate to right, neg to left
        nums.add(99);
        Collections.rotate(nums, 2);
        System.out.println(nums);
        Collections.rotate(nums, -1);
        System.out.println(nums);

        //Collections.reverse(nums); reverses nums
        System.out.println(nums);

        //Collections.fill(nums, value); replaces all of nums with value
        Collections.fill(nums, 22);
        System.out.println(nums);

        System.out.println(nums.contains(22));
        System.out.println(nums.indexOf(22));
        System.out.println(nums.lastIndexOf(22));
    }


}
