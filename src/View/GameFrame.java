package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.ControlGame;

public class GameFrame extends JFrame {
	private GamePanel gamepanel;
	private ControlGame controlGame;
	private Menu menu;
	public GameFrame(ControlGame controlGame) {
		this.controlGame=controlGame;
		this.add(gamepanel = new GamePanel(this));
		try {
			BufferedImage img = ImageIO.read(new File("./Image/minesweeper.png"));
			this.setIconImage(img);
		} catch (IOException e ) {
			e.printStackTrace();
		}
		this.setTitle("Mine Sweeper");
		this.menu=new Menu(controlGame);
		this.setJMenuBar(menu);
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
	public Menu getMenu(){
		return this.menu;
	}
}
