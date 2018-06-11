import java.util.ArrayList;

/**
 * Created by Aditya Pillai on 10/24/16.
 * Completed on 24 10 2016
 */
@SuppressWarnings({"unused", "WeakerAccess", "SpellCheckingInspection"})
public class PillaiHotel {

    private PillaiReservation[] rooms;
    @SuppressWarnings("SpellCheckingInspection")
    private ArrayList<String> waitlist;

    public PillaiHotel(int hotelSize) {
        rooms = new PillaiReservation[hotelSize];
        waitlist = new ArrayList<>();
    }


    public PillaiHotel(PillaiReservation[] rooms, ArrayList<String> waitlist) {
        this.rooms = rooms;
        this.waitlist = waitlist;
    }

    public PillaiReservation requestRoom(String guestName) {
        //cycles through rooms
        for (int i = 0; i < rooms.length; i++) {
            //if room is empty (null), goes through assignment
            if (rooms[i] == null) {
                //assigns room in hotel array to the specific Reservation
                rooms[i] = new PillaiReservation(guestName, i);
                //returns the room that is assigned, which is a reservation
                return rooms[i];
            }
        }
        //if no rooms are empty (cycles through for loop)
        //adds name to waitlist
        waitlist.add(guestName);
        //returns null
        return null;

    }


    public PillaiReservation cancelAndReassign(PillaiReservation res) {
        int roomNumber = res.getRoomNumber();
        //resets room number of res to null, indicating empty
        rooms[roomNumber] = null;
        if (!waitlist.isEmpty()) { //if waitlist is not empty (is filled), takes index 0
            rooms[roomNumber] = new PillaiReservation(waitlist.get(0), roomNumber);
            waitlist.remove(0);
            //assigns index 0 of hotel array to room that was emptied
            //returns that room number that was just assigned (Reservation object)
            return rooms[roomNumber];
        }
        //otherwise, if waitlist is empty, returns null, indicating none on the wait list
        return null;
    }

    public boolean hasGuest(PillaiReservation res) {
        for (PillaiReservation room : rooms) {
            //if room is filled, goes through assignment
            if (room != null) {
                if (room.getGuestName().equals(res.getGuestName()) && (room.getRoomNumber() == res.getRoomNumber())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int findGuestRoomNumber(String guestName) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null) {
                if (rooms[i].getGuestName().equals(guestName)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String getGuestName(int roomNumber) {
        if (rooms[roomNumber] == null) {
            return null;
        }
        return rooms[roomNumber].getGuestName();
    }

    public ArrayList<String> getWaitlist() {
        return waitlist;
    }

    public PillaiReservation[] getRooms() {
        return rooms;
    }

    public int getSize() {
        return rooms.length;
    }

}
