// James Shoemaker
// 10/7/24
// CountingDownDemo.java p.494

public class CountingDownDemo {
    public static void main(String[] args) {
        countingDown(10);
        System.out.println("Blastoff!");
    }

    private static void countingDown(int count) {
        if (count > 0) {
            System.out.println(count);
            countingDown(count - 1);
        }
    }
}