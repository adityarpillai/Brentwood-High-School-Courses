@SuppressWarnings("SpellCheckingInspection")
public class PillaiOutputLab1 {

    public static void main(String[] args) {
        //lab 1
        String letterA = "AAAAAAAAAAAAAAAAAAAAAAAAA";
        String symbolPlus = "+++++++++++++++++++++++++";

        System.out.println("Aditya Pillai \t 08/15/2016");
        //extra spacing
        System.out.println("\n");
        for (int repeat = 0; repeat < 3; repeat++) {
            System.out.println(symbolPlus + "\n" + symbolPlus + "\n" + symbolPlus);
            System.out.println(letterA + "\n" + letterA);
        }
        System.out.println(symbolPlus + "\n" + symbolPlus + "\n" + symbolPlus);

        //extra spacing
        System.out.println("\n");

        //lab 2
        String plusSpace = "+++                   +++";
        String plusCompSci = "+++     CompSci       +++";
        System.out.println(letterA);
        System.out.println(symbolPlus);
        for (int repeat = 0; repeat < 4; repeat++) {
            System.out.println(plusSpace);
        }
        System.out.println(plusCompSci);
        for (int repeat = 0; repeat < 4; repeat++) {
            System.out.println(plusSpace);
        }
        System.out.println(letterA);
        System.out.println(symbolPlus);

        //extra spacing
        System.out.println("\n");

        //lab 3
        System.out.print("`;-.          ___,\n"
                + "  `.`\\_...._/`.-\"`" + "\n"
                + "    \\        /      ," + "\n"
                + "    /()   () \\    .' `-._" + "\n"
                + "   |)  .    ()\\  /   _.'" + "\n"
                + "   \\  -'-     ,; '. <" + "\n"
                + "    ;.__     ,;|   > \\" + "\n"
                + "   / ,    / ,  |.-'.-'" + "\n"
                + "  (_/    (_/ ,;|.<`" + "\n"
                + "    \\    ,     ;-`" + "\n"
                + "     >   \\    /" + "\n"
                + "    (_,-'`> .'" + "\n"
                + "         (_,'");

    }

}
