/* 9/2/24 
 * James Shoemaker
 * BookstoreCredit pg 112
*/

import java.util.Scanner;
public class BookstoreCredit {
    public static void main(String[] args) {
        String name;
        double gpa;
        final double credit = 10;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = sc.next();
        System.out.println("Enter GPA: ");
        gpa = sc.nextDouble();
        computeDiscount(name, gpa, credit);
    }

    private static void computeDiscount(String name, double gpa, double credits) {

        double total_credits = gpa * credits;
        System.out.println(name+ ", your GPA is "+gpa+", so your credit is $"+total_credits+".");
    }
}