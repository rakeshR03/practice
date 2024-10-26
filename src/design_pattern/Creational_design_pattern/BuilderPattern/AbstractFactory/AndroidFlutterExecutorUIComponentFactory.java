package design_pattern.AbstractFactory;

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
