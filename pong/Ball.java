import java.awt.*;
import javax.swing.*;
public class Ball{
	private static int hits = 0;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private static long ballSpeed = 14;
	private long lastMove = System.currentTimeMillis();
	private boolean speedUp = false;

	private Game game;
	public Ball(Game game){
		this.game = game; 
	}
	public void move() {
		if (System.currentTimeMillis() - lastMove < ballSpeed){
			return;
		}
		lastMove = System.currentTimeMillis();
		if (y == game.getHeight() - 30){game.gameOver();return;}
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - 30)
			xa = -1;
		if (y + ya == 301 && x >= game.getRacket().getX() - 20 && x <= game.getRacket().getX() + 80){
			ya = -1;hits++; speedUp = true;
		}
		if (y + ya < 0)
			ya = 1;
		
		x = x + xa;
		y = y + ya;
		if ((hits) % 3 == 0 && ballSpeed > 2 && speedUp){ballSpeed/=1.1; speedUp = false;}
	}
	public static int getHits(){return hits;}
	public void paint(Graphics2D g){
		g.fillOval(x,y,30,30);
	}
}