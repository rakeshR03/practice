package design_pattern.AbstractFactory;

public class IOSButton implements Button{

    @Override
    public void createButton() {
        System.out.println("calling ios button");
    }
}
