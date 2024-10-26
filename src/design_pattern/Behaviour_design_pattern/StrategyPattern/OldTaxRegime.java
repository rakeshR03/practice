package design_pattern.Behaviour_design_pattern.StrategyPattern;

public class OldTaxRegime implements TaxRegimeInterface {

    @Override
    public double calculateTax(int salary) {
        double tax = 0.2 * salary;
        double hra = 0.1 * salary;
        return tax - hra;
    }
}
