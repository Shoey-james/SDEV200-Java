// James Shoemaker
// 9/30/24
// PartyWithConstructor.java p 341

public class PartyWithConstructor {
    private int guests;

    public PartyWithConstructor() {
        System.out.println("Creating a Party");
    }

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