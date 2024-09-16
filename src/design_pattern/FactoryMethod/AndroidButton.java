package design_pattern.FactoryMethod;

public class AndroidButton implements Button {
    @Override
    public void createButton() {
        System.out.println("calling android button");
    }
}