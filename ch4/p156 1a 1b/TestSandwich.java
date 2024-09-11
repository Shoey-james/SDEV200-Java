/* 9/2/24
 * James Shoemaker
 * p156 ex 1a 1b Sandwich and TestSandwich
 */

import java.util.Scanner;

public class TestSandwich {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Sandwich sandwich = new Sandwich();

        System.out.print("Enter your main ingredient >> ");
        sandwich.setMainIngredient(sc.nextLine());

        System.out.print("Enter your bread type >> ");
        sandwich.setBreadType(sc.nextLine());

        System.out.print("Enter price for your sandwich >> ");
        sandwich.setPrice(sc.nextDouble());

        sc.close();

        System.out.println("Main Ingredient: " + sandwich.getMainIngredient());
        System.out.println("Bread Type: " + sandwich.getBreadType());
        System.out.println("Price: " + sandwich.getPrice());
    }
}