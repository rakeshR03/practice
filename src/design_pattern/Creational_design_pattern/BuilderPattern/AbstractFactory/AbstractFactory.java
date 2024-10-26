package design_pattern.Creational_design_pattern.BuilderPattern.AbstractFactory;

import design_pattern.Creational_design_pattern.BuilderPattern.FactoryMethod.PLATFORM;

public class AbstractFactory {
    public static void main(String[] args) {
        FlutterExecutor executor = FlutterExecutorFactory.getFlutterExecutor(PLATFORM.IOS);

        Button button = executor.getFlutterExecutorUIComponentfactory().getButton();

        button.createButton();
    }
}
