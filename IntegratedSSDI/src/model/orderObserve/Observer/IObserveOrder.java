package model.orderObserve.Observer;

import model.orderObserve.observable.IOrderData;

public interface IObserveOrder {
void notify(IOrderData data);
}
