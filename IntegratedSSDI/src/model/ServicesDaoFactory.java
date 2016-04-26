package model;

import util.db.connection.IConnectionData;
import util.db.connection.ProductionConnectionData;
import util.db.connection.TestConnectionData;

public class ServicesDaoFactory {
	private static ServicesDaoFactory instance;
	
	private String environment;
	
	private ServicesDaoFactory(String environment) {
		this.environment = environment;
	}
	
	public static ServicesDaoFactory getInstance(String environment) {
		return instance  = new ServicesDaoFactory(environment);
	}
	
	public ServicesDao createServiceDao() {
		IConnectionData connectionData = null;
		
		if(environment.equals("production")) {
			connectionData = new ProductionConnectionData();
		} else if(environment.equals("test")) {
			connectionData = new TestConnectionData();
		}
		
		return new ServicesDao(connectionData);
	}
}
