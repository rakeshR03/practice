package design_pattern.FactoryMethod;

public class AndroidFlutterExecutor implements FlutterExecutor{

    @Override
    public Button getButton(){
        return new AndroidButton();
    }
}
