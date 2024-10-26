package design_pattern.Creational_design_pattern.BuilderPattern.AbstractFactory;

public class AndroidList implements List{

    @Override
    public void createList() {
        System.out.println("calling Android List");
    }
}
