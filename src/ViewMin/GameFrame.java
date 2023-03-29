package ViewMin;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame  extends JFrame{
	private GamePanel panel;
	private Data loadData;
	public GameFrame( ) {
		add(panel = new GamePanel(16, 16, 10,this)); 
		try{
		BufferedImage img = ImageIO.read(new File("Image//minesweeper.png"));
		 setIconImage(img);
		}catch (IOException ex) {
		ex.printStackTrace();
		}
		
	
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setVisible(true);
		
	}

public GamePanel getPanel() {
		return panel;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}
	public static void main(String[] args) {
		new GameFrame();
	}
	
}

