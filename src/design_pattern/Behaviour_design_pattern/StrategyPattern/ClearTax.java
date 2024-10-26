package design_pattern.Behaviour_design_pattern.StrategyPattern;

public class ClearTax {

    public double calculateTax(TaxRegimeInterface taxRegimeInterface, int salary) {
        return taxRegimeInterface.calculateTax(salary);
    }
}
