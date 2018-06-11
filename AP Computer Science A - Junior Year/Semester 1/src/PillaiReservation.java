/**
 * Created by Aditya Pillai on 10/24/16.
 * https://classroom.google.com/u/1/c/MTYwMzc1NzYxM1pa
 */
@SuppressWarnings("WeakerAccess")
public class PillaiReservation {

    private String guestName;
    private int roomNumber;

    public PillaiReservation(String guestName, int roomNumber) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
    }

    @SuppressWarnings("unused")
    public String getGuestName() {
        return guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

}
