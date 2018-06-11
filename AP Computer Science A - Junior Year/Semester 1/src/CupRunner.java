public class CupRunner {

    public static void main(String[] args) {
        Cup red = new Cup();
        System.out.println(red.getMaterial() + ", " + red.getColor() + ", " + red.isEmpty());
        red.setMaterial("Plastic");
        red.setColor("Red");
        red.setEmpty(false);
        System.out.println(red.getMaterial() + ", " + red.getColor() + ", " + red.isEmpty());

        Cup green = new Cup("Steel", "Green", true);
        System.out.println(green.getMaterial() + ", " + green.getColor() + ", " + green.isEmpty());

    }//end of main method

}//end of CupRunner class
