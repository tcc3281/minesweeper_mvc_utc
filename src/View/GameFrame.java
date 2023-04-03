package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Controller.controlgame;

public class GameFrame extends JFrame {
	private GamePanel gamepanel;
	public GameFrame() {
		
		
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
		
		controlgame controlgame = new controlgame(this.gamepanel.getPanelplay());
	}
	public GamePanel getGamepanel() {
		return gamepanel;
	}
	public void setGamepanel(GamePanel gamepanel) {
		this.gamepanel = gamepanel;
	}
}