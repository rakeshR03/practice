package design_pattern.Behaviour_design_pattern.StrategyPattern;

public class Client {
    public static void main(String[] args) {
        ClearTax clearTax = new ClearTax();
        double tax = clearTax.calculateTax(TaxRegimeFactory.getInstance(RegimeType.OLD), 30000);
        System.out.println("tax: " + tax);
    }
}
