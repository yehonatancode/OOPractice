package carManagmentSystem;
import java.util.ArrayList;
import java.util.Iterator;


public class CarFleet {
private String organizationName;
private ArrayList<Vehicle> cars = new ArrayList<Vehicle>();


public CarFleet(String organizationName)
{
	this.organizationName = organizationName;

}
public void Add(Vehicle v)
{
	this.cars.add(v);
}
public class CarIterator implements Iterator<Vehicle>
{
private int index;
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(cars.isEmpty())
		{
		return false;
	}
		else if((cars.get(index+1)==null))
				{
			return false;
				}
			
	return true;
				}

	@Override
	public Vehicle next() {
		// TODO Auto-generated method stub
		if(this.hasNext())
		{
			return cars.get(index+1);
		}
		return null;
	}
	

}
public Iterator<Vehicle> iterator() {
	return cars.iterator();
}
}



