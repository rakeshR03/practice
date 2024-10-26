package design_pattern.Creational_design_pattern.BuilderPattern.FactoryMethod;

public class AndroidButton implements Button {
    @Override
    public void createButton() {
        System.out.println("calling android button");
    }
}