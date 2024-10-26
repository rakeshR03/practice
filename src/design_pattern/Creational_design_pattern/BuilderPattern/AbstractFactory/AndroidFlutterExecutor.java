package design_pattern.AbstractFactory;

public class AndroidFlutterExecutor implements FlutterExecutor{

    @Override
    public FlutterExecutorUIComponentFactory getFlutterExecutorUIComponentfactory() {
        return new AndroidFlutterExecutorUIComponentFactory();
    }
}
