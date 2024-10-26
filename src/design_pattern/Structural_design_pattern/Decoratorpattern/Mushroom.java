package design_pattern.Structural_design_pattern.Decoratorpattern;

public class Mushroom implements PizzaTopping{
    BasePizza pizza;

    Mushroom(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return this.pizza.cost() + 60;
    }
}
