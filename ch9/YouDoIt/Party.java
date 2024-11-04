// James Shoemaker
// 9/30/24
// Party.java p 333

public class Party {
    private int guests;

    public void displayInvitation() {
        System.out.println("Please come to my party!");
    }

    public void setGuests(int numGuests) {
        guests = numGuests;
    }

    public int getGuests() {
        return guests;
    }
}