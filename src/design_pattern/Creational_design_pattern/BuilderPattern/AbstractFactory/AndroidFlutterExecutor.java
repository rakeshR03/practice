package design_pattern.Creational_design_pattern.BuilderPattern.AbstractFactory;

public class AndroidFlutterExecutor implements FlutterExecutor{

    @Override
    public FlutterExecutorUIComponentFactory getFlutterExecutorUIComponentfactory() {
        return new AndroidFlutterExecutorUIComponentFactory();
    }
}
