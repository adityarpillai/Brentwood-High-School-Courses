import javax.swing.*;

public class PillaiInputLab1 {
    public static void main(String[] args) {
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        String studentNumber = JOptionPane.showInputDialog("Enter your Student ID:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age:"));
        double GPA = Double.parseDouble(JOptionPane.showInputDialog("Enter your GPA:"));
        int grade = Integer.parseInt(JOptionPane.showInputDialog("Enter your grade: "));
        String favoriteSport = JOptionPane.showInputDialog("What is your favorite sport?");
        int numberPets = Integer.parseInt(JOptionPane.showInputDialog("How many pets do you have?"));
        String thisSummer = JOptionPane.showInputDialog("What did you do this summer?");

        JOptionPane.showMessageDialog(null, "Student Name: " + lastName + ", " + firstName
                + "\nStudent Number: " + studentNumber + "\nAge: " + age +
                "\nGrade: " + grade + String.format("\nGPA: %.2f", GPA) + "\nFavorite Sport: " +
                favoriteSport + "\nNumber of Pets: " + numberPets + "\nThis summer you: " + thisSummer);

    }
}
