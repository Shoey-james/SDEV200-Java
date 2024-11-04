// James Shoemaker
// 9/30/24
// DinnerParty2.java p 338


public class DinnerParty2 extends Party {
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