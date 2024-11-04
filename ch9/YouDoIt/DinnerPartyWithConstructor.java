// James Shoemaker
// 9/30/24
// DinnerPartyWithConstructor.java p 341

public class DinnerPartyWithConstructor extends PartyWithConstructor {
    private int dinnerChoice;

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