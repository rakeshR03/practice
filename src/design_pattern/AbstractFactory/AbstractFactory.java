package design_pattern.AbstractFactory;

import design_pattern.FactoryMethod.PLATFORM;

public class AbstractFactory {
    public static void main(String[] args) {
        FlutterExecutor executor = FlutterExecutorFactory.getFlutterExecutor(PLATFORM.IOS);

        Button button = executor.getFlutterExecutorUIComponentfactory().getButton();

        button.createButton();
    }
}
