package model;

public class UserFactory {
	 public User getUser(String userType){
	      if(userType == null){
	         return null;
	      }		
	      if(userType.equalsIgnoreCase("Adm")){
	         return new Admin();
	         
	      } else if(userType.equalsIgnoreCase("Tec")){
	         return new technician();
	         
	      } else if(userType.equalsIgnoreCase("Str")){
	         return new Store();
	      }
	      else if(userType.equalsIgnoreCase("Del")){
		         return new deliveryStaff();
		      }
	      else if(userType.equalsIgnoreCase("Cus")){
		         return new Customer();
		      }
	      
	      return null;
	   }
}
