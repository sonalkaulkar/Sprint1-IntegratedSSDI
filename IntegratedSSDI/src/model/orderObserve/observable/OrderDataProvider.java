package model.orderObserve.observable;

import java.sql.*;
import java.util.ArrayList;

import model.ServicesDao;
import model.ServicesDaoFactory;
import model.orderObserve.Observer.IObserveOrder;

public class OrderDataProvider implements IProvideOrderData {
private ArrayList<IObserveOrder> subscribers;
private orderDetails data;
public OrderDataProvider() {
	// TODO Auto-generated constructor stub
	subscribers = new 	ArrayList<IObserveOrder>();
	data = new orderDetails();
		 
}
	@Override
	public void addSubscriber(IObserveOrder observer) {
		// TODO Auto-generated method stub
		subscribers.add(observer);
	}

	@Override
	public void removeSubscriber(IObserveOrder observer) {
		// TODO Auto-generated method stub
		subscribers.remove(observer);
	}
	public void notifySubscribers()
	{ System.out.println("inside notifu sunsribers");
		for (int i = 0; i < subscribers.size(); i++) {
			IObserveOrder observer = subscribers.get(i);
			observer.notify(data);
		}
	}
	
	public void checkOrderStatus (String stat,int order_id)

	{
	System.out.println("inside check order status :"+stat);
		data.setOrder_status(stat);
		data.setOrderId(order_id);
		notifySubscribers();
	}

}
