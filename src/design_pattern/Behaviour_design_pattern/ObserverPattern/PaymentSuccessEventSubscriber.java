package design_pattern.Behaviour_design_pattern.ObserverPattern;

public interface PaymentSuccessEventSubscriber {

    void notify(int orderId);
}
