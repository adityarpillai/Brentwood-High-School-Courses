import javax.swing.*;

/**
 * Created by Aditya Pillai on 10/25/16.
 * Runner for Hotel and Reservation classes.
 */
@SuppressWarnings("SpellCheckingInspection")
public class PillaiHotelRunner {

    public static void main(String[] args) {

        String[] options = {"Exit", "Cancel and Reassign Reservation", "New Reservation", "Find Guest Name", "View Waitlist"};
        int repeat = 0;
        int number = 0;
        String errorMessage = "";
        do {
            try {
                number = Integer.parseInt(JOptionPane.showInputDialog(null, errorMessage + "Enter the number of rooms in the hotel"));
                errorMessage = "";
            } catch (NumberFormatException e) {
                errorMessage = "Not a number. Retrying. \n";
            }
        } while (!errorMessage.isEmpty());


        PillaiHotel localHotel = new PillaiHotel(number);
        //noinspection Duplicates
        while (repeat == 0) {
            int choice = JOptionPane.showOptionDialog(null, "Choose option:", "PillaiHotel", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 1:
                    runCancelAndReassign(localHotel);
                    break;
                case 2:
                    runNewReservation(localHotel);
                    break;
                case 3:
                    runFindGuest(localHotel);
                    break;
                case 4:
                    runViewWaitList(localHotel);
                    break;
                case 0:
                    repeat = 1;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error in input, retrying.");
                    break;
            }
        }
    }

    private static void runViewWaitList(PillaiHotel localHotel) {
        JOptionPane.showMessageDialog(null, "The following guests are on the waitlist:" + "\n" +
                localHotel.getWaitlist());
    }

    private static void runFindGuest(PillaiHotel localHotel) {
        int roomNumber = getRoomNumberR("Find Guest", localHotel);
        JOptionPane.showMessageDialog(null, "The Guest at Room Number " + roomNumber + " is " + localHotel.getGuestName(roomNumber));
    }

    private static void runNewReservation(PillaiHotel localHotel) {
        String gName = JOptionPane.showInputDialog(null, "Enter the name of the guest:", "New Reservation", JOptionPane.QUESTION_MESSAGE);
        PillaiReservation temp = localHotel.requestRoom(gName);
        if (temp != null) {
            JOptionPane.showMessageDialog(null, "Guest " + gName + " has been assigned to Room Number " + temp.getRoomNumber());
        } else {
            JOptionPane.showMessageDialog(null, "Guest " + gName + " has been put on the waitlist.");
        }
    }

    private static void runCancelAndReassign(PillaiHotel localHotel) {
        String gName = JOptionPane.showInputDialog(null, "Enter the name of the guest:", "Cancel and Reassign Room", JOptionPane.QUESTION_MESSAGE);
        int roomNumber = getRoomNumberR("Cancel and Reassign", localHotel);
        PillaiReservation tempReservation = new PillaiReservation(gName, roomNumber); //creates temp reservation
        if (localHotel.hasGuest(tempReservation)) { //if reservation to cancel exists, will do following
            PillaiReservation tempGet = localHotel.cancelAndReassign(tempReservation); //will get the new reservation through hotel class

            if (tempGet != null) { //if null is not returned from cancel and reassign (aka: guest has been assigned)
                JOptionPane.showMessageDialog(null, "Guest " + localHotel.getGuestName(tempGet.getRoomNumber()) +
                        " has been assigned to Room Number " + tempGet.getRoomNumber());
            } else {  //otherwise, it will say there is no one on the waitlist.
                JOptionPane.showMessageDialog(null, "Guest " + gName + " has been removed. No one is waiting on the waitlist.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Guest with specified information does not exist in the system.");
        }

    }

    private static int getRoomNumberR(String title, PillaiHotel locHotel) {
        String errorMessage = "";
        do {
            // Show input dialog with current error message, if any
            String stringInput = JOptionPane.showInputDialog(null, errorMessage + "Enter the room number of the guest:",
                    title, JOptionPane.QUESTION_MESSAGE);
            try {
                int roomNumber = Integer.parseInt(stringInput);
                if (roomNumber < 0 || roomNumber > locHotel.getSize()) {
                    errorMessage = "The room number is invalid. \n";
                } else {
                    //noinspection UnusedAssignment
                    errorMessage = "";
                    return roomNumber;
                }

            } catch (NumberFormatException e) {
                // The typed text was not an integer
                errorMessage = "Text entered was not an input. \n";
            }
        } while (!errorMessage.isEmpty()); //error message is happening
        return -1;
    }

}
