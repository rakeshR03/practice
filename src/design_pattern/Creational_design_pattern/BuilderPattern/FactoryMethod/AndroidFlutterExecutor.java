package design_pattern.Creational_design_pattern.BuilderPattern.FactoryMethod;

public class AndroidFlutterExecutor implements FlutterExecutor{

    @Override
    public Button getButton(){
        return new AndroidButton();
    }
}
