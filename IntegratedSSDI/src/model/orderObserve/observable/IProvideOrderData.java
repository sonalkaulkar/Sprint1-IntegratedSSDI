package model.orderObserve.observable;

import model.orderObserve.Observer.IObserveOrder;

public interface IProvideOrderData {
void addSubscriber(IObserveOrder observer);
void removeSubscriber(IObserveOrder observer);
}
