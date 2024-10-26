package design_pattern.Creational_design_pattern.BuilderPattern.AbstractFactory;

public class AndroidFlutterExecutorUIComponentFactory implements FlutterExecutorUIComponentFactory {
    @Override
    public Button getButton() {
        return new AndroidButton();
    }

    @Override
    public List getList() {
        return new AndroidList();
    }
}
