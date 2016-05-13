/*
 * A game that resembles the game Whack-a-mole.
 * The user must click on the white circles that appear randomly throughout the window to score points. 
 * The round is 60 seconds, and a running tally, as well as a final tally is presented.
 * 
 * @author: Ibhan Kulkarni
 * @version 12/02/15
 */
package Processing;
//import nessesary processing software.
import processing.core.PApplet;

public class myGame extends PApplet{
	Mole2 mole;
	long startTime, currentTime, popTime ;
	float score = 0;
	float radius = 30;
//This allows this processing program to be run through the terminal
	//@param:none
	//@return: none
	public static void main(String args[]) {
		PApplet.main(new String[] { "MyGame" });
	}
/*
 * (non-Javadoc)
 * @see processing.core.PApplet#setup()
 */
	public void setup(){
		background(0);
		frameRate(600);
		mole = new Mole2(this);
		startTime = System.currentTimeMillis();
	} 
/*
 * (non-Javadoc)
 * @see processing.core.PApplet#draw()
 */
	public void draw(){	
//Lines 40-42 help keep a running tally of the points scored by the user.
		fill(255);                        
		text("Score: " + score,10,100);
		text("Click on the white circles before they vanish! Each circle is worth 10 points if you click on it!",10,900);
//This serves to execute the pop method, while also keep track of the time since the mole popped.
		if (popTime < 0) {
			mole.pop();
			popTime = System.currentTimeMillis();
		}
	//Here, we use the distance formula to see if the mouse actually clicked on the popped mole. 
	//If the area where the mouse clicked is between the center, and the radius, the click is true
		if(mousePressed == true){
			if(mouseButton== LEFT){
				if(sqrt(sq((mole.getX())-mouseX) + sq((mole.getY())-mouseY)) < radius/2){
					mole.down();
					//Iterates score per click
					score+=10;
				}
			}
		}
//Lines 60-67 clear the board through the use of the down method. They time this by subtracting the current time by the time passed since the mole popped.
//The difference between these two values is the amount of time the mole has appeared, and if that value is greater than a second, the mole is to go down again.
		currentTime = System.currentTimeMillis();
		if (currentTime - popTime >= 1000) {
			popTime = -1;
			mole.down();
//continues to present data of score on the cleared board.
			fill(255);                        
			text("Score: " + score,10,100);
			text("Click on the white circles before they vanish! Each circle is worth 10 points if you click on it!",10,900);
		}
//In lines 71-77, we use the same method for keeping time as we did above, but once 60 seconds have passed, the board clears.
//We then use the game over method to display the end screen.
		if(System.currentTimeMillis() - startTime > 60000){
			mole.gameOver();
			fill(0);
			text("Game over! Your Score: " + score, 500,500);
		}
	}
}

