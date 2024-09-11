/* The Huntington Boys and Girls Club is conducting a fundraiser by selling chili dinners to go. 
* The price is $7 for an adult’s meal and $4 for a child’s meal. Write a program that accepts the number of each type of meal ordered,
* and display the total money collected for adults’ meals, children’s meals, and all meals. Save the program as ChiliToGo.java. 
* James Shoemaker 8/28/24 */

import java.util.Scanner;
public class ChiliToGo
{
    public static void main(String[] args) 
    {
        int adult;
        int child;
        double aMeal = 7.00;
        double cMeal = 4.00;
        double totAdult;
        double totChild;
        double totAll;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the number of adult meals: ");
        adult = input.nextInt();

        System.out.print("Please enter the number of children's meals: ");
        child = input.nextInt();

        totAdult = adult * aMeal;
        totChild = child * cMeal;
        totAll = totAdult + totChild;

        System.out.println("Total money collected for the adult meals is  $" + totAdult +
            " and the total money collected for the children's meals is $" + totChild + " The grand total of all meals is $" +totAll);

        input.close();
    }
}

