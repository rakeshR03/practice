package design_pattern.FactoryMethod;

public class FlutterExecutorFactory {

    public static FlutterExecutor getFlutterExecutorByConfig(PLATFORM platform) {
        if (platform.equals(PLATFORM.ANDROID)) {
            return new AndroidFlutterExecutor();
        } else if (platform.equals(PLATFORM.IOS)) {
            return new IOSFlutterExecutor();
        }
        return null;
    }
}