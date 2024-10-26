package design_pattern.Behaviour_design_pattern.ObserverPattern;

public class EmailService implements PaymentSuccessEventSubscriber{
    @Override
    public void notify(int orderId) {
        sendEmail(orderId);
    }

    public void sendEmail(int orderId) {
        System.out.println("email sent");
    }
}
