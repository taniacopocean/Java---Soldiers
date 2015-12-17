import java.util.Random;
public class Fight{	//The Fight class 
	public static void main(String[] args){
		double x,y;
		Random rnd = new Random(); 	//This allows the program to receive random numbers
		for(int i=1;i<=3;i++){	//There are 3 battles, so the battle will happen 3 times
			x=rnd.nextDouble()*100;		
			//We generate a random number, which will have a value in [0,1), so we multiply it by 100 to get numbers between [0,100). This will be the x coordinate of our soldier
			y=rnd.nextDouble()*100;		//We do the same for the y coordinate
			Knight knight=new Knight(x,y,5.3);
	
			//We create a knight, by giving it a random position with the 2 random numbers generated and its speed - 5.3
			x=rnd.nextDouble()*100;
			y=rnd.nextDouble()*100;	
			Pikeman pikeman=new Pikeman(x,y,4.5);
	//We create a pikeman, the same way we created the knight, but his speed is 4.5
			x=rnd.nextDouble()*100;
			y=rnd.nextDouble()*100;	
			Bowman bowman=new Bowman(x,y,12.0,10.4);
	
			//We create a bowman, the same way we created the other soldiers, but we also add its range to the constructor - 10.4				
			Battlefield battlefield=new Battlefield(knight,bowman,pikeman);		//We create a battlefield and we add the 3 soldiers to it
			System.out.println("The winner of fight number "+i+" is "+battlefield.findWinner().toString());		
			//We find the winner by calling the method which does this and we print its name using the toString method
			battlefield.changePos();	//Finally, we change the positions of the soldiers
		}
	}
}
