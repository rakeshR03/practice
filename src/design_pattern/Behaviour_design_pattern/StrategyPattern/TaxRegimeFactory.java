package design_pattern.Behaviour_design_pattern.StrategyPattern;

public class TaxRegimeFactory {

    static TaxRegimeInterface getInstance(RegimeType regimeType) {
        if (regimeType == RegimeType.NEW) {
            return new NewTaxRegime();
        } else if (regimeType == RegimeType.OLD) {
            return new OldTaxRegime();
        } else {
            return null;
        }
    }
}
