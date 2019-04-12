import java.awt.*;
import javax.swing.*;
public class specialBall extends Ball{
  int size = 30;
	public specialBall(Game game){
		super(game);
	}
  public specialBall(Game game, int size){
    super(game);
    this.size = size;
  }
	public void move() {
		if (System.currentTimeMillis() - lastMove < ballSpeed){
			return;
		}
		lastMove= (System.currentTimeMillis());
		if (y == game.getHeight() - size){game.gameOver();return;}
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - size)
			xa = -1;
		if ((y + ya >= 331 - size && y + ya <= 331 - size + 2) && x >= game.getRacket().getX() - size && x <= game.getRacket().getX() + size + 60){
			ya = -1;hits++; speedUp = true;
		}
		if (y + ya < 0)
			ya = 1;
		x = x + xa;
		y = y + ya;
		if ((this.getHits()) % 3 == 0 && ballSpeed > 3 && speedUp){ballSpeed/=1.1; speedUp = false;}
	}
	public void paint(Graphics2D g){
		g.fillOval(x,y,size,size);
	}
}
