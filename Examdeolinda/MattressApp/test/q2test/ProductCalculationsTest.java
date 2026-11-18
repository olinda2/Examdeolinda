package q2test;

import org.junit.jupiter.api.Test;
import q2.ProductCalculations;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductCalculationsTest {
    @Test
    void GetVat_WithValidData_ReturnsCorrectValue() {
        assertEquals(525.0, new ProductCalculations(3500).GetVat(), 0.001);
    }

    @Test
    void GetTotal_WithValidData_ReturnsCorrectValue() {
        assertEquals(4200.0, new ProductCalculations(3500).GetTotal(), 0.001);
    }
}
