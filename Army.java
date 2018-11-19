import java.util.Scanner;

import Turtle.*;
public class Army {

	public static void BuildArmy()
	{
			Turtle[] turtlearmy = new Turtle[5];
	for (int i=0;i<5;i++)
	{
		System.out.println("please enter the type of turtle you'd like");
		Scanner s = new Scanner(System.in);
		int type = s.nextInt();
		if(type==1)
		{
			turtlearmy[i]= new SimpleTurtle();
		}
		if(type==2)
		{
			turtlearmy[i]=new SmartTurtle();
		}
		if(type==3)
		{
			turtlearmy[i]= new DrunkTurtle();
		}
		if(type==4)
		{
			turtlearmy[i]=new JumpyTurtle();
		}
	}
	for(int i=0;i<5;i++)
	{
		turtlearmy[i].tailDown();
	}
	for(int i=0;i<5;i++)
	{
		turtlearmy[i].moveForward(100);
	}
	for(int i=0;i<5;i++) 
	{
		turtlearmy[i].turnRight(90);
	}
	for(int i=0;i<5;i++)
	{
		turtlearmy[i].moveForward(60);
	}
	for(int i=0;i<5;i++)
	{
		if(turtlearmy[i] instanceof SmartTurtle)
		{
			((SmartTurtle) turtlearmy[i]).drawPolygon(6,70);
		}
		if(turtlearmy[i] instanceof JumpyTurtle)
		{
			((JumpyTurtle) turtlearmy[i]).drawPolygon(6,70);
		}
	}
	for(int i=0;i<5;i++)
	{
turtlearmy[i].hide();
	}
	}
		
}