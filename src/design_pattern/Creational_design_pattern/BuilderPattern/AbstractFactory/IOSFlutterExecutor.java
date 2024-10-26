package design_pattern.AbstractFactory;

public class IOSFlutterExecutor implements FlutterExecutor{
    @Override
    public FlutterExecutorUIComponentFactory getFlutterExecutorUIComponentfactory() {
        return new IOSFlutterExecutorUIComponentFactory();
    }
}
