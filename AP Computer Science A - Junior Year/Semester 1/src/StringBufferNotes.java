import java.util.Scanner;

public class StringBufferNotes {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Tell me something good...");

        String input = keyboard.nextLine();
        System.out.println(input);

        StringBuffer buff = new StringBuffer(input);
        buff.setLength(4);
        System.out.println(buff);


        buff.setLength(14);
        buff.replace(4, buff.length() - 1, "          ");
        buff.setCharAt(14, 'z');
        System.out.println(buff);

        //convert from a buffer to a string
        input = buff.toString();
        System.out.println(input);


    }//end of main

}//end of class
