package design_pattern.Creational_design_pattern.BuilderPattern.AbstractFactory;

public class AndroidButton implements Button{

    @Override
    public void createButton() {
        System.out.println("calling android button");
    }
}
