package design_pattern.Creational_design_pattern.BuilderPattern.AbstractFactory;

public class IOSFlutterExecutorUIComponentFactory implements FlutterExecutorUIComponentFactory {

    @Override
    public Button getButton() {
        return new IOSButton();
    }

    @Override
    public List getList() {
        return new IOSList();
    }
}
