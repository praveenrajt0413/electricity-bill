import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testCalculateBillNegativeUnits() {
        App app = new App();
        assertThrows(IllegalArgumentException.class, () -> app.calculateBill(-10), "Should throw exception for negative units");
    }

    @Test
    public void testCalculateBillZeroUnits() {
        App app = new App();
        double bill = app.calculateBill(0);
        assertEquals(0.0, bill, 0.001, "Bill for 0 units should be 0.0");
    }

    @Test
    public void testCalculateBillFirstTier() {
        App app = new App();
        // 50 units at 1.50 = 75.0
        double bill = app.calculateBill(50);
        assertEquals(75.0, bill, 0.001, "Bill for 50 units should be 75.0");
    }

    @Test
    public void testCalculateBillBoundaryFirstTier() {
        App app = new App();
        // 100 units at 1.50 = 150.0
        double bill = app.calculateBill(100);
        assertEquals(150.0, bill, 0.001, "Bill for 100 units should be 150.0");
    }

    @Test
    public void testCalculateBillSecondTier() {
        App app = new App();
        // 100 * 1.50 + 100 * 2.00 = 150.0 + 200.0 = 350.0
        double bill = app.calculateBill(200);
        assertEquals(350.0, bill, 0.001, "Bill for 200 units should be 350.0");
    }

    @Test
    public void testCalculateBillBoundarySecondTier() {
        App app = new App();
        // 100 * 1.50 + 200 * 2.00 = 150.0 + 400.0 = 550.0
        double bill = app.calculateBill(300);
        assertEquals(550.0, bill, 0.001, "Bill for 300 units should be 550.0");
    }

    @Test
    public void testCalculateBillThirdTier() {
        App app = new App();
        // 100 * 1.50 + 200 * 2.00 + 50 * 3.00 = 150.0 + 400.0 + 150.0 = 700.0
        double bill = app.calculateBill(350);
        assertEquals(700.0, bill, 0.001, "Bill for 350 units should be 700.0");
    }
}
