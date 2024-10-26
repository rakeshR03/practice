package design_pattern.Creational_design_pattern.BuilderPattern.AbstractFactory;

import design_pattern.Creational_design_pattern.BuilderPattern.FactoryMethod.PLATFORM;

public class FlutterExecutorFactory {

    static FlutterExecutor getFlutterExecutor(PLATFORM platform) {
        switch (platform) {
            case ANDROID :
                return new AndroidFlutterExecutor();

            case IOS:
                return new IOSFlutterExecutor();

            default:
                return null;

        }

    }
}
