package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Controller.ControlGame;
import Model.MineSweeperLogic;

public class GameFrame extends JFrame {
	private int width= MineSweeperLogic.WIDTH;
	private int height=MineSweeperLogic.HEIGHT;
	private GamePanel gamepanel;
	private ControlGame controlGame;
	public GameFrame(ControlGame controlGame) {
		this.controlGame=controlGame;
		this.add(gamepanel = new GamePanel(width, height,this));
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
