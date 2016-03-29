package model;

import org.uncc.util.IConnectionData;
import org.uncc.util.ProductionConnectionData;
import org.uncc.util.TestConnectionData;

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
