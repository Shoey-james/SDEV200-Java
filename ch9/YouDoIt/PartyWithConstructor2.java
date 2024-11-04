// James Shoemaker
// 9/30/24
// PartyWithConstructor2.java p 341

public class DinnerPartyWithConstructor2 extends PartyWithConstructor2 {
    private int dinnerChoice;

    public DinnerPartyWithConstructor2(int numGuests) {
        super(numGuests);
    }

    public void setDinnerChoice(int choice) {
        dinnerChoice = choice;
    }

    public int getDinnerChoice() {
        return dinnerChoice;
    }

    @Override
    public void displayInvitation() {
        System.out.println("Please come to my dinner party!");
    }
}