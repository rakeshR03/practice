package design_pattern.AbstractFactory;

public class AndroidButton implements Button{

    @Override
    public void createButton() {
        System.out.println("calling android button");
    }
}
