import java.util.concurrent.ThreadLocalRandom;

import Turtle.*;
public class DrunkTurtle extends Turtle {
	SimpleTurtle drunked = new SimpleTurtle();
public static int randomAngle(int min, int max)//  returns int random number
{
	double randomNum = ThreadLocalRandom.current().nextDouble(min, max + 1);
	return (int) (randomNum);
}
@Override
public void moveForward(double step)
{
	int temp = randomAngle(-30, 30);
	drunked.tailDown();
	drunked.moveForward(step);
	drunked.turnLeft(temp);
}
}
