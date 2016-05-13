/*
 * This program represents the Mole in the Whack-a-Mole game.
 * 
 * @author:Ibhan Kulkarni
 * @version: 12/2/15
 */
package Processing;

import processing.core.PApplet;

public class Mole2 {
//data fields
	PApplet canvas;
//These variables are protected because they should be acsessed by other classes, but not by the user.
	protected float x;
	protected float y;
	protected float rx;
	protected float ry;
	protected float x1;
	protected float y1;

	public Mole2(PApplet canvas){
		this.canvas=canvas;
		x=canvas.random(0,canvas.width);
		y=canvas.random(0,canvas.height);
		rx=30;
		ry=30;
		x1=0;
		y1=0;
	}
/*
 * This method simulates the mole popping out of a random hole.
 * The mole, in this case, is represented by a white circle.
 * 
 * @param:none
 * @return:none
 */
	public void pop(){	
	//Creates a circle at a new point, and also keeps track of the ever moving point.
		x=canvas.random(0,canvas.width);
		y=canvas.random(0,canvas.height);
		x1=x;
		y1=y;
		canvas.fill(255);
		this.canvas.ellipse(x, y, rx, ry);
	}
/*
 * This method simulates the mole going down into its burrow again.
 * This method creates a black rectangle as large as the window over the circle that just appeared, simulating it "disappearing"
 * 
 * @param:none
 * @return:none
 */
	public void down(){
		canvas.fill(0);
		this.canvas.rect(0,0,canvas.width,canvas.height);
	}
/*
 * This method return the last popped Mole's X coordinate
 * 
 * @param:none
 * @return:Mole's x coordinate
 */
	public float getX(){
		return x1;
	}
/*
 * This method returns the last popped Mole's Y coordinate.
 * 
 * @param:none
 * @return:Mole's Y coordinate
 */
	public float getY(){
		return y1;
	}
/*
 * This method prints a "Game Over" Screen over the game board.
 * It does so by printing a white rectangle over the board, with text to be added later. The rectangle essentially "clears" the board
 * 
 * @param:none
 * @raturn:none
 */
	public void gameOver(){
		canvas.fill(255);
		this.canvas.rect(0, 0, canvas.width, canvas.height);
	}
}

