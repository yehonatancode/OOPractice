
package carManagmentSystem;
import java.util.*;
public class Vehicle implements Comparable <Vehicle> {
	 private int totalValue; // שווי
	 private int licensePlate;
	 private String ownerName; // בעלים שם

	 public Vehicle(int totalValue,int licenseePlate,String ownerName) {
	 this.setTotalValue(totalValue);
	 this.licensePlate = licensePlate;
	 this.ownerName=ownerName;
}

	@Override
	public int compareTo(Vehicle o) {
		// TODO Auto-generated method stub
		if(this.totalValue>o.totalValue)
		{
			return -1;
		}
		else if(this.totalValue==o.totalValue)
		{
			return 0;
		}
		else return 1;
	}

	public String getOwnerName() {
		// TODO Auto-generated method stub
		return this.ownerName;
	}

	public int getLicensePlate() {
		// TODO Auto-generated method stub
		return this.licensePlate;
	}

	public int getTotalValue() {
		// TODO Auto-generated method stub
		return this.totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
}