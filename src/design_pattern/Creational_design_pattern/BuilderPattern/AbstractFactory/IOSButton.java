package design_pattern.Creational_design_pattern.BuilderPattern.AbstractFactory;

public class IOSButton implements Button{

    @Override
    public void createButton() {
        System.out.println("calling ios button");
    }
}
