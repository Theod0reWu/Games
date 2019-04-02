import java.awt.event.*;
import java.awt.Graphics2D;
public class Racket{
	int xa = 0;
	int x = 100;
	private Game game;
	
	Racket(Game g){this.game = g;}

	public void move(){
		if (x + xa <= game.getWidth() - 60 && x + xa > 0){
			x+=xa;
		}
	}
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 1;
	}
	public void paint(Graphics2D g){
		g.fillRect(x,330,60,10);
	}
	public int getX(){
		return x;
	}
}