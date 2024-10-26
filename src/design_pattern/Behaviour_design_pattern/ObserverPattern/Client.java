package design_pattern.Behaviour_design_pattern.ObserverPattern;


public class Client {

    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        InventoryService inventoryService = new InventoryService();
        Flipkart flipkart = new Flipkart();
        flipkart.subscribeService(emailService);
        flipkart.subscribeService(inventoryService);
        flipkart.paymentSuccess(123);
    }
}
