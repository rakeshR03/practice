package design_pattern.Structural_design_pattern.Decoratorpattern;

public class ExtraCheese implements BasePizza{

    BasePizza basePizza;

    ExtraCheese(BasePizza pizza) {
        this.basePizza =  pizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 50;
    }
}
