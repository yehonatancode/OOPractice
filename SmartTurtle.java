import Turtle.*;
public class SmartTurtle extends Turtle {
SimpleTurtle smart = new SimpleTurtle();
public void drawSquare (double size) // draw a square in the given size 
{
	smart.tailDown();
	smart.moveForward(size);
	smart.turnLeft(90);
	smart.moveForward(size);
	smart.turnLeft(90);
	smart.moveForward(size);
	smart.turnLeft(90);
	smart.moveForward(size);
	smart.turnLeft(90);
}
public void drawPolygon (int sides, double size)
// draw a polygon in the given sides and size 
{
	smart.tailDown();
	int temp = ((sides-2)*180)/sides;
	for(int i=0;i<sides;i++)
	{
		smart.moveForward(size);
		smart.turnLeft(180-temp);
	}
}
	
}
