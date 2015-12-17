public class Battlefield{	
//A class Battlefield, in which we put 3 soldiers: a knight, a bowman and a pikeman. We also create another soldier, who will be the winner
	private Knight knight;
	private Bowman bowman;
	private Pikeman pikeman;
	private Soldier winner;
	public Battlefield(Knight k, Bowman b, Pikeman p){	
	//The constructor of the class, in which we put the soldiers and we calculate the times they need to reach their targets
		knight=k;
		bowman=b;
		pikeman=p;
		knight.calculateTimeTo(bowman);
		pikeman.calculateTimeTo(knight);
		bowman.calculateTimeTo(pikeman);
	}		
	public Soldier findWinner(){	//A method to find the winner, by calculating the minimum time required for a soldier to reach its target
		double minTime=pikeman.getTimeToEnemy();	//We assume that the pikeman wins, to his time is the minimum
		winner=pikeman;
		if(knight.getTimeToEnemy()<minTime){		
		//We check if there are ohter soldiers who would need less time to reach their targets. If we find one, we change the miminum time and the winner
			minTime=pikeman.getTimeToEnemy();
			winner=knight;
		}
		if(bowman.checkRange(pikeman)==true&&bowman.getTimeToEnemy()<minTime){	
		//In order for a bowman to win the fight, his target also needs to be in the range of his arrow
			minTime=bowman.getTimeToEnemy();
			winner=bowman;
		}
		return winner;
	}
	public void changePos(){	//A method to change the positions after the fight
		if(winner instanceof Knight){	//If the knight wins, he takes bowman's position and the bowman disappears
			knight.changePosition(bowman.getPosX(),bowman.getPosY());
			bowman.remove();
		}
		else if(winner instanceof Bowman)	//If the bowman wins, the pikeman disappears
				pikeman.remove();
			else pikeman.changePosition(knight.getPosX(),knight.getPosY());		//If the pikeman wins, he takes the knight's position
	}
}
