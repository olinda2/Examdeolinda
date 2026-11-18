package q1test;

import org.junit.jupiter.api.Test;
import q1.Product;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    private final String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    private final int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};

    @Test
    void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, new Product(names, sales).GetTotalProductsSold());
    }

    @Test
    void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(17.0, new Product(names, sales).GetAverageProductSold(), 0.001);
    }
}
