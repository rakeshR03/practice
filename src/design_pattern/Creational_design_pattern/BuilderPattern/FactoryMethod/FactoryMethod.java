package design_pattern.Creational_design_pattern.BuilderPattern.FactoryMethod;

public class FactoryMethod {
    public static void main(String[] args) {
        FlutterExecutor executor = FlutterExecutorFactory.getFlutterExecutorByConfig(PLATFORM.IOS);
        Button button = executor.getButton();
        button.createButton();
    }
}
