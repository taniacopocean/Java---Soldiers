public class Soldier{		//A class Soldier
	private double posX, posY, speed, timeToEnemy;
	
	//A soldier has a position determined by x and y coordinates and a speed, and the time it will take to get to his enemy
	public Soldier(double a, double b, double s){
	//The constructor of the class
		posX=a;

		posY=b;

		speed=s;

	}

	public double getPosX(){
	//A method to get de x coordinate of the position
		return posX;

	}

	public double getPosY(){
	//A method to get de x coordinate of the position
		return posY;

	}
	
	public double getDistance(Soldier s){
	//A method to calculate the distance from the current soldier to another soldier
		double distance;
				
		distance=Math.sqrt((posX-s.getPosX())*(posX-s.getPosX()) + (posY-s.getPosY())*(posY-s.getPosY()));

		return distance;

	}


	public void calculateTimeTo(Soldier s){		
	//A method to calculate the time the current soldier will need to reach another soldier, by dividing the distance between them by his speed
			timeToEnemy=getDistance(s)/speed;

	}
	public double getTimeToEnemy(){		//A method to get the time that the soldier needs to reach his enemy
		return timeToEnemy;
	}

	public void changePosition(double a, double b){
		
	//A method to change the position of a soldier by receiving 2 doubles, which will be the new x and y coordinates
		posX=a;

		posY=b;

	}

	public void remove(){	//A method to remove a soldier from the battlefield (by setting his position to (-1,-1))
		posX=-1.0;
		posY=-1.0;
	}
	public String positionToString(){	//A toString method, to return the position of a soldier
		return ("The position of your soldier is: ("+posX+" , "+posY+" )");
	}
	public double getSpeed(){	//A method to return the speed of the soldier
		return speed;
	}
}
