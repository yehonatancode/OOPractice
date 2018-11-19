import Turtle.*;

public class JumpyTurtle extends SmartTurtle{
	SimpleTurtle jumpy = new SimpleTurtle();

@Override

public void moveForward(double step)
{
	for(int i=0;i<step/2; i++)
	{
		jumpy.tailDown();
		jumpy.moveForward(2);
		jumpy.tailUp();
		jumpy.moveForward(2);
	}
}

@Override
public void drawSquare (double size) // draw a square in the given size 
{
	smart.tailDown();
	moveForward(size);
	smart.turnLeft(90);
	moveForward(size);
	smart.turnLeft(90);
	moveForward(size);
	smart.turnLeft(90);
	moveForward(size);
	smart.turnLeft(90);
}
@Override
public void drawPolygon (int sides, double size)
// draw a polygon in the given sides and size 
{
	smart.tailDown();
	int temp = ((sides-2)*180)/sides;
	for(int i=0;i<sides;i++)
	{
		moveForward(size);
		smart.turnLeft(180-temp);
	}
}
}
