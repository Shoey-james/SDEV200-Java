// James Shoemaker
// 9/30/24
// UseDinnerParty.java p 333


import java.util.Scanner;

public class UseDinnerParty {
    public static void main(String[] args) {
        int guests, choice;
        Party aParty = new Party();
        DinnerParty aDinnerParty = new DinnerParty();

        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.print("Enter number of guests for the party >> ");
            guests = keyboard.nextInt();

            aParty.setGuests(guests);

            System.out.println("The party has " + aParty.getGuests() + " guests");

            aParty.displayInvitation();

            System.out.print("Enter number of guests for the dinner party >> ");
            guests = keyboard.nextInt();
            aDinnerParty.setGuests(guests);

            System.out.print("Enter the menu option --> 1 for chicken or 2 for beef >> ");
            choice = keyboard.nextInt();
        }
        aDinnerParty.setDinnerChoice(choice);

        System.out.println("The dinner party has " + aDinnerParty.getGuests() + " guests");
        System.out.println("Menu option " + aDinnerParty.getDinnerChoice() + " will be served");

        aDinnerParty.displayInvitation();
    }
}