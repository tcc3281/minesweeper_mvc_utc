package View;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Controller.ControlGame;

public class PanelPlay extends JPanel {

	private GamePanel gamepanel;
	private ButtonPlay[][] arrButton;

	public PanelPlay(GamePanel gamepanel) {
		super();
		this.setLayout(new GridLayout(GamePanel.HEIGHT,GamePanel.WIDTH));
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		arrButton = new ButtonPlay[GamePanel.HEIGHT][GamePanel.WIDTH];
		for (int i = 0; i < arrButton.length; i++) {
			for (int j = 0; j < arrButton[i].length; j++) {
				this.add(arrButton[i][j] = new ButtonPlay());
			}
		}
	}
	public void newGame(){
		for (int i = 0; i < arrButton.length; i++) {
			for (int j = 0; j < arrButton[i].length; j++) {
				this.arrButton[i][j].setDefault();
			}
		}
	}


	public void open(String number, int x, int y) {
		this.arrButton[x][y].appearence(number);
	}
	public void setFlag(int x, int y) {
		this.arrButton[x][y].setflag();
	}
	public void unsetFlag(int x, int y) {
		this.arrButton[x][y].setremoveflag();
	}
	public GamePanel getGamepanel() {
		return gamepanel;
	}
	public void setGamepanel(GamePanel gamepanel) {
		this.gamepanel = gamepanel;
	}
	public ButtonPlay[][] getArrButton() {
		return arrButton;
	}
	public void setArrButton(ButtonPlay[][] arrButton) {
		this.arrButton = arrButton;
	}


	public void addMouse(ControlGame controlGame){
		for (int i = 0; i < this.arrButton.length; i++)
			for (int j = 0; j < this.arrButton[i].length; j++)
				this.arrButton[i][j].addMouseListener(controlGame);
	}

	public void setDefaultGUI(){
		for(int i=0;i<this.arrButton.length;i++){
			for(int j=0;j<this.arrButton[i].length;j++){
				this.arrButton[i][j].setDefault();
			}
		}
	}

}
