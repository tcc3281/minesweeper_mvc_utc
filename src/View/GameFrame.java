package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Controller.ControlGame;

public class GameFrame extends JFrame {
	private GamePanel gamepanel;
<<<<<<< HEAD
	public GameFrame() {
=======
	private ControlGame controlGame;
	public GameFrame(ControlGame controlGame) {
		this.controlGame=controlGame;
>>>>>>> 6d0c6c5d97f2da64ceec374ba1c2834f5dc9da6c
		this.add(gamepanel = new GamePanel(16, 16, 50, this));
		try {
			BufferedImage img = ImageIO.read(new File("./Image/minesweeper.png"));
			this.setIconImage(img);
		} catch (IOException e ) {
			e.printStackTrace();
		}
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

	}
	public GamePanel getGamepanel() {
		return gamepanel;
	}
	public void setGamepanel(GamePanel gamepanel) {
		this.gamepanel = gamepanel;
	}
}
