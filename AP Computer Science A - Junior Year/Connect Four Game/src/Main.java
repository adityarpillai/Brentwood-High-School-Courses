import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        int choice;
        Object[] menu = {"Play Game", "Exit"};
        do {
            choice = JOptionPane.showOptionDialog(null, "Do you want to play Connect Four?", "Connect Four", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
            if (choice == 0) {
                //noinspection unused
                ConnectFourGUI myGame = new ConnectFourGUI();
            }
        } while (choice == 0);
    }
}
