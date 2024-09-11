/* James Shoemaker 
 * 8/29/31
 * In the ChiliToGo program, the costs to produce an adult’s meal and a child’s meal are $4.35 and $3.10, respectively.
 * Modify the ChiliToGo program to display the total profit for each type of meal as well as the grand total profit.
*/
import java.util.Scanner;
public class ChiliToGoProfit
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
        double totACost;
        double totCCost;
        double aProfit;
        double cProfit;
        double totProfit;
        double aCost = 4.35;
        double cCost = 3.10;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the number of adult meals: ");
        adult = input.nextInt();

        System.out.print("Please enter the number of children's meals: ");
        child = input.nextInt();
        totACost = adult * aCost;
        totCCost = child * cCost;
        totAdult = adult * aMeal;
        totChild = child * cMeal;
        aProfit = totAdult - totACost;
        cProfit = totChild - totCCost;
        totAll = totAdult + totChild;
        totProfit = aProfit + cProfit;


        System.out.printf("Total money collected for the adult meals is  $%.2f\n", aProfit,
            " and the total money collected for the children's meals is $%.2f\n", cProfit 
            + " The grand total of all meals is $%.2f\n", totProfit);

        input.close();
    }
}
