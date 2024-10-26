package design_pattern.Creational_design_pattern.BuilderPattern.FactoryMethod;

public class IOSFlutterExecutor implements FlutterExecutor {
    @Override
    public Button getButton() {
        return new IOSButton();
    }
}
