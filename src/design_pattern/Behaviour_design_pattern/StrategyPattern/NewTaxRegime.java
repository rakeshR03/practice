package design_pattern.Behaviour_design_pattern.StrategyPattern;

public class NewTaxRegime implements TaxRegimeInterface{
    @Override
    public double calculateTax(int salary) {
        double tax = 0.3 * salary;
        double hra = 0.1 * salary;
        return tax - hra;
    }
}
