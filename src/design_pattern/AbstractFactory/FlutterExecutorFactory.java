package design_pattern.AbstractFactory;

import design_pattern.FactoryMethod.PLATFORM;

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
