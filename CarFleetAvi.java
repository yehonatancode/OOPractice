package carManagmentSystem;

import java.util.*;

public class CarFleetAvi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			CarFleet fleet=new CarFleet ("Avis");
			fleet.Add(new Vehicle(240000,5079930,"����� ����"));
			fleet.Add(new Vehicle(98000,3049377,"����� ���"));
			fleet.Add(new Vehicle(56000,5079930,"����� �����"));
			fleet.Add(new Vehicle(89000,20230786,"��� �����"));
			fleet.Add(new Vehicle(310000,9599,"��� ���"));
			Iterator<Vehicle> it= fleet.iterator();
			Vehicle v=null;
			while (it.hasNext()) 
			{
			    System.out.println(it.next());
			}
			System.out.println();
			it=fleet.iterator();
			while (it.hasNext()) 
			{
				v=it.next();
			if(v.getOwnerName().contains("���"));
			System.out.format("Car Licence %d costs %d%n",
			v.getLicensePlate(), v.getTotalValue());
			}
			}
	
	}


