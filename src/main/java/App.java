public class App {

    public static void main(String[] args) {
        System.out.println("Electricity Billing System running...");
        try {
            while (true) {
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            System.err.println("Application interrupted.");
        }
    }

    /**
     * Calculates the electricity bill based on the number of units consumed.
     * Tariffs:
     * - First 100 units: $1.50 per unit
     * - Next 200 units (101-300): $2.00 per unit
     * - Above 300 units: $3.00 per unit
     * 
     * @param units the electricity units consumed
     * @return the total bill amount
     * @throws IllegalArgumentException if units are negative
     */
    public double calculateBill(int units) {
        if (units < 0) {
            throw new IllegalArgumentException("Units cannot be negative");
        }
        
        double billAmount = 0.0;
        
        if (units <= 100) {
            billAmount = units * 1.5;
        } else if (units <= 300) {
            billAmount = (100 * 1.5) + ((units - 100) * 2.0);
        } else {
            billAmount = (100 * 1.5) + (200 * 2.0) + ((units - 300) * 3.0);
        }
        
        return billAmount;
    }
}
