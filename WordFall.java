import clara.Canvas;
import java.awt.*;
import WordHelper.*;
import java.util.ArrayList;

public class WordFall{

	public static final int canvasWidth = 1280, canvasHeight = 740;
	public static String displayText = "";
	public static ArrayList<String> words = new ArrayList<String>();
	public static boolean play = false;


	public static void main(String[]args){
		Canvas canvas = new Canvas(canvasWidth,canvasHeight); //create a canvas to draw on

		System.out.println(WordHelper.lookup("HELLO"));
		int points = 0;
		int rc = 0; //0-not a word; 1-could be a word; 2-word or part of a larger word; 3-longest possible word


		/*   INTRO */
		while (!canvas.returnKey().equalsIgnoreCase(" ")){
			canvas.drawColor(new Color(242, 240, 233));
			canvas.drawRect(0,0,canvasWidth,canvasHeight, true);
			canvas.drawColor(Color.DARK_GRAY);
  			canvas.drawText("GAME RULES:",20,80,45);
  			canvas.drawText("You are this ball --->",20,150,30);
			canvas.drawColor(Color.RED);
			canvas.drawOval(300,120,45,45,true);
			canvas.drawColor(Color.DARK_GRAY);
			canvas.drawText("Try to make as many words as you can with the falling letters",20,200,30);
			canvas.drawText("When you have a word, click space to enter it and get a score",20,250,30);
			canvas.drawText("Press Space to Start",20,400,25);
			canvas.addDelay(20);
			canvas.repaint();
		}

		letterFall[] letters = new letterFall[10];
		Ball player = new Ball(canvasWidth/2,20,0,0,50,Color.RED);

		for(int i = 0; i< letters.length; i++)
		{
			letters[i] = new letterFall();
		}

		//Ball player = new Ball(0

		int time = 0;
		long gameStartTime = System.currentTimeMillis();




		while (time < 60){ /**********   START GAME LOOP ******************/

			canvas.drawColor(new Color(242, 240, 233));
			canvas.drawRect(0,0,canvasWidth,canvasHeight, true); // Draw background.  True means filled in.

			canvas.drawColor(player.getColor());  // set color to index in array
			canvas.drawOval(player.getX(), player.getY(), player.getSize(), player.getSize(),true);




			for(int i = 0; i< letters.length; i++)
			{
				letterFall ltr = letters[i];
				canvas.drawColor(ltr.getColor());
				canvas.drawText(ltr.getLetter(),ltr.getX(), ltr.getY(),ltr.getSize());
				ltr.fall();
				if(ltr.intersects(player))
				{
					displayText+=ltr.getLetter();
					rc = WordHelper.lookup(displayText);
					ltr.setRandom();
				}
				ltr.fall();
			}
			player.move();

			//Left Top
			canvas.drawColor(Color.BLACK);
			canvas.drawText("Points = " + points,10,30,20);
			int y = 65;
			canvas.drawColor(Color.BLACK);
			canvas.drawText("Words Collected:",10,50,20);
			canvas.drawColor(Color.BLUE);
			for(String word: words)
			{
				if(word.indexOf("-") != -1)
				{
					canvas.drawColor(Color.RED);
					canvas.drawText(word,10,y,20); //x,y,size
					y+=17;
				}
				else
				{
					canvas.drawColor(Color.GREEN);
					canvas.drawText(word,10,y,20); //x,y,size
					y+=17;
				}
			}



			//Mid Screen2
			if(rc<2) //not a word
				canvas.drawColor(Color.RED);
			else if(rc==2)
				canvas.drawColor(Color.YELLOW);
			else
				canvas.drawColor(Color.GREEN);
			canvas.drawText(displayText,(canvasWidth/2)-20*displayText.length(),50,70);



			//Right Top
			canvas.drawColor(new Color(53, 36, 181));
			time = (int)(((System.currentTimeMillis()- gameStartTime)) / 1000.0+.5);
			canvas.drawText(time+" sec.",canvasWidth-80,30,20);
			canvas.repaint();
			canvas.addDelay(10);

			//Score Word?

			if(canvas.returnKey().equalsIgnoreCase(" "))
			{
				if(rc < 2)
				{//Not word -points
					points -= displayText.length();
				}
				else
				{//word +points
					points += displayText.length();
				}
				if(!displayText.equals(""))
				{
					if(rc<2)
					{
						words.add(displayText + "-" + displayText.length());
					}
					else
					{
						words.add(displayText + " " + displayText.length());
					}
				}
				displayText = ""; //reset displayword
				rc=1;
			}

			//if(canvas.returnKey().equalsIgnoreCase(""))
			if(canvas.returnKey().equalsIgnoreCase("a"))
				player.setxInc(-3);
			if(canvas.returnKey().equalsIgnoreCase("d"))
				player.setxInc(3);
			if(canvas.returnKey().equalsIgnoreCase(""))
				player.setxInc(0);
			if(canvas.returnKey().equalsIgnoreCase("w"))
				player.setyInc(-3);
			if(canvas.returnKey().equalsIgnoreCase("s"))
				player.setyInc(3);
			if(canvas.returnKey().equalsIgnoreCase(""))
				player.setyInc(0);

		}  /************   END GAME LOOP ******************/

		// GAME OVER --> Display end of Game Message
		while (time>=60){
			canvas.drawColor(new Color(242, 240, 233));
			canvas.drawRect(0,0,canvasWidth,canvasHeight, true);
			canvas.drawColor(Color.DARK_GRAY);
  			canvas.drawText("You got " +points+" in 60 seconds",20,80,45);
			canvas.addDelay(20);
			canvas.repaint();
		}


	}


}