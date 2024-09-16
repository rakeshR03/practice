package design_pattern.AbstractFactory;

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
