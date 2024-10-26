package design_pattern.Behaviour_design_pattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Flipkart {

    List<PaymentSuccessEventSubscriber> paymentSuccessEventSubscriberList = new ArrayList<>();

    void subscribeService(PaymentSuccessEventSubscriber paymentSuccessEventSubscriber) {
        paymentSuccessEventSubscriberList.add(paymentSuccessEventSubscriber);
    }

    void unSubscribeService(PaymentSuccessEventSubscriber paymentSuccessEventSubscriber) {
        paymentSuccessEventSubscriberList.remove(paymentSuccessEventSubscriber);
    }

    public void paymentSuccess(int orderId){
        for (PaymentSuccessEventSubscriber paymentSuccessEventSubscriber : paymentSuccessEventSubscriberList) {
            paymentSuccessEventSubscriber.notify(orderId);
        }
    }

}
