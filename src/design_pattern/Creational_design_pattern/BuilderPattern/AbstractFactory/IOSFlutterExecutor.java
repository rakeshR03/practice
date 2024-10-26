package design_pattern.Creational_design_pattern.BuilderPattern.AbstractFactory;

public class IOSFlutterExecutor implements FlutterExecutor{
    @Override
    public FlutterExecutorUIComponentFactory getFlutterExecutorUIComponentfactory() {
        return new IOSFlutterExecutorUIComponentFactory();
    }
}
