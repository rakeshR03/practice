package design_pattern.FactoryMethod;

public class IOSFlutterExecutor implements FlutterExecutor {
    @Override
    public Button getButton() {
        return new IOSButton();
    }
}
