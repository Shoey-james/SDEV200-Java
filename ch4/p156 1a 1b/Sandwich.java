/* 9/2/24
 * James Shoemaker
 * p156 ex 1a 1b Sandwich and TestSandwich
 */
public class Sandwich {
    private String mainIngredient, breadType;
    private double price;

    public String getMainIngredient() 
    {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) 
    {
        this.mainIngredient = mainIngredient;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) 
    {
        this.breadType = breadType;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }
}