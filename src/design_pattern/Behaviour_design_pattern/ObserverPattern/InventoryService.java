package design_pattern.Behaviour_design_pattern.ObserverPattern;

public class InventoryService implements PaymentSuccessEventSubscriber{
    @Override
    public void notify(int orderId) {
        updateInventory(orderId);
    }

    void updateInventory(int orderId) {
        System.out.println("updated inventory");
    }
}
