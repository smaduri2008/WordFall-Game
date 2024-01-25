import java.awt.Color;
import WordHelper.*;

public class letterFall
{
	private int x, y, speed, size;
	private Color color;
	private String letter;

	public letterFall()
	{
		setRandom();
	}
	public void setRandom()
	{
		x = (int)(Math.random()*WordFall.canvasWidth);
		y = 0;
		size = 20; // randomize later if wanted
		speed = (int)(Math.random()*3)+1;
		letter = "" + (char)(Math.random()*26+65);
		color = Color.RED; // randomize later if wanted
	}

	//getter methods

	public int getX()
	{
		return x;
	}
	public void setSpeed(int s)
	{
		this.speed = s;
	}
	public void setColor(Color c)
	{
		this.color = c;
	}
	public void setSize(int siz)
	{
		this.size = siz;
	}
	public int getY()
	{
		return y;
	}

	public int getSpeed()
	{
		return speed;
	}

	public int getSize()
	{
		return size;
	}
	public void setLetter(String word)
	{
		letter = word;
	}
	public String getLetter()
	{
		return letter;
	}

	public Color getColor()
	{
		return color;
	}

	public void fall()
	{
		y += speed;
		if(y > WordFall.canvasHeight)
			setRandom();
	}

	public boolean intersects(Ball ball)
	{
		int r1 = (int)(size*.8)/2;  //r1,x1,y1 for Letter
		int x1 = x+r1;
		int y1 = y-r1;
		int r2 = ball.getSize()/2;  //r2,x2,y2 for Ball
		int x2 = ball.getX() + r2;
		int y2 = ball.getY() + r2;
		double distance = Math.sqrt( (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2) );
		if (distance < r1+r2)
			return true;
		else
			return false;
	}
}