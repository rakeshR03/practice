package design_pattern.AbstractFactory;

public class AndroidList implements List{

    @Override
    public void createList() {
        System.out.println("calling Android List");
    }
}
