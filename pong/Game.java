import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
@SuppressWarnings("serial")
public class Game extends JPanel{
//http://www.edu4java.com/en/game/game1.html
	private Ball ball = new specialBall(this,30);
	private Racket racket = new Racket(this);
	private long lastMove = System.currentTimeMillis();
	private Ball[] balls = new Ball[4];

	public long getLastMove(){
		return lastMove;
	}
	public void setLastMove(long time){
		lastMove = time;
	}
	public Racket getRacket(){
		return racket;
	}
	public Game(){
		addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racket.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racket.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		for (Ball b:balls){
			if (b != null){b.paint(g2d);}
		}
		racket.paint(g2d);
		g.drawString("Points: " + Ball.getHits(),0,10);
	}
	public void update(){
		ball.move();
		if (Ball.getHits() == 5){balls[0] = new specialBall(this,30);}
		for (Ball b : balls){
			if (b != null){b.move();}
		}
		racket.move();
		this.repaint();
	}
	public void gameOver(){
		try {
			File f = new File("Highscore.txt"); Scanner s = new Scanner(f);
			int in = 0;
			if (s.hasNext()){in = Integer.parseInt(s.next());}
			int high = ball.getHits();
			if (high > in){PrintWriter p = new PrintWriter(f);
				p.print(high+"");
				p.close();
			}else {high = in;}
			JOptionPane.showMessageDialog(this, "Game Over. Your Highscore is " + high, "Game Over", JOptionPane.YES_NO_OPTION);
			System.exit(ABORT);
		}catch(FileNotFoundException a){
			System.out.println("highscore.txt not found");
		}
	}
	public void start(){
		JOptionPane.showMessageDialog(this, "Hit ok to play", "Game Over", JOptionPane.YES_OPTION);
	}
	public static void main(String[] args) throws InterruptedException, FileNotFoundException{
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		game.start();

		while(true){
			game.update();
			Thread.sleep(1);

		}
	}
}
