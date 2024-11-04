// James Shoemaker
// 10/7/24
// Fiction.java p 387-b

public class Fiction extends Book {
    public Fiction(String title) {
        super(title);
        setPrice();
    }

    @Override
    public void setPrice() {
        this.price = 24.99;
    }
}