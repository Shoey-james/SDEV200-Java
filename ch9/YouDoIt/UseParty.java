// James Shoemaker
// 9/30/24
// UseParty.java p 333

import java.util.Scanner;

public class UseParty {
    public static void main(String[] args) {
        int guests;
        Party aParty = new Party();

        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.print("Enter number of guests for the party >> ");
            guests = keyboard.nextInt();
        }

        aParty.setGuests(guests);

        System.out.println("The party has " + aParty.getGuests() + " guests");

        aParty.displayInvitation();
    }
}