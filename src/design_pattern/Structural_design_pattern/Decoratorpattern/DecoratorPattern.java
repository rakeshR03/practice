package design_pattern.Structural_design_pattern.Decoratorpattern;

public class DecoratorPattern {
    public static void main(String[] args) {
        BasePizza pizza = new Mushroom(new ExtraCheese(new Margherita()));
        System.out.println("cost : " + pizza.cost());
    }
}
