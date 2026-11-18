package q1;

public class Product implements IProduct {
    private final String[] names;   // single-dimensional array
    private final int[][] sales;    // two-dimensional array [product][month]

    public Product(String[] names, int[][] sales) {
        this.names = names;
        this.sales = sales;
    }

    private int productTotal(int p) {
        int sum = 0;
        for (int m = 0; m < sales[p].length; m++) sum += sales[p][m];
        return sum;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int p = 0; p < sales.length; p++) total += productTotal(p);
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int count = 0;
        for (int[] row : sales) count += row.length;
        return count == 0 ? 0 : (double) GetTotalProductsSold() / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int best = 0;
        for (int p = 1; p < sales.length; p++) {
            if (productTotal(p) > productTotal(best)) best = p;
        }
        return names[best] + " (" + productTotal(best) + ")";
    }
}
