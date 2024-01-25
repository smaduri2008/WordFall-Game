import clara.Canvas;
import java.awt.*;
import WordHelper.*;

public class Ball{

	//variables will be associated with each Ball
	private int x,y,xInc,yInc,size;
	private Color color;

	// Constructor --> Sets values for a particular ball
	public Ball(int x, int y, int xInc, int yInc, int size, Color color)
	{
		this.x = x;
		this.y = y;
		this.xInc = xInc;
		this.yInc = yInc;
		this.size = size;
		this.color = color;
	}

	//accessor / getter methods --> this method allows access to public variables (NOT STATIC)

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getSize()
	{
		return size;
	}
	public Color getColor()
	{
		return color;
	}

	public void setxInc(int xinc)
	{
		xInc = xinc;
	}
	public void setyInc(int yinc)
	{
		yInc = yinc;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
	/*
	public void respawn()
	{
		x = ObjectCanvas.canvasWidth*2;
		y = (int)(Math.random()*1000);
		xInc = Math.abs(xInc);
		yInc = Math.abs(yInc);
		color = ObjectCanvas.randColor();
	}
	*/

	//should be called in a loop whenever we want to move Ball
	public void move()
	{
		x+= xInc;
		y+= yInc;

		if (y >= WordFall.canvasHeight-size || y < 0)
			yInc = -yInc;
		if (x >= WordFall.canvasWidth-size ||  x < 0)
			xInc = -xInc;
	}

	// b1.distance(b2); method call
	/*
	public double distance(Ball b2)
	{
		int r1 = this.size/2;
		int x1 = this.x + r1;
		int y1 = this.y + r1;
		int r2 = b2.size/2;
		int x2 = b2.x + r1;
		int y2 = b2.y + r1;
		return Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1))); //distance between color
	}

	public boolean intersect(Ball b2)
	{
		if(distance(b2) <= (this.size/2 + b2.size/2))
			return true;
		return false;
	}
	*/



}