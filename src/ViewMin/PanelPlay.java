package ViewMin;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPlay extends JPanel {
	private GamePanel game;
	private ButtonPlayer[][] arrButton;
	public ButtonPlayer[][] getArrButton() {
		return arrButton;
	}

	public void setArrButton(ButtonPlayer[][] arrButton) {
		this.arrButton = arrButton;
	}

	public PanelPlay(GamePanel game) {
		super();
		this.game = game;
		setLayout(new GridLayout(game.getW(), game.getH()));
		arrButton= game.getWorld().getArrButton();
		setBorder(BorderFactory.createLoweredBevelBorder());
		
		
		for (int i = 0; i < arrButton.length; i++) {
			for (int j = 0; j < arrButton[i].length; j++) {
				add(arrButton[i][j] = new ButtonPlayer(this));				
				arrButton[i][j].addMouseListener(game);
			}
		}
		

	}

	public GamePanel getGame() {
		return game;
	}

	public void setGame(GamePanel game) {
		this.game = game;
	}

	
	
}
