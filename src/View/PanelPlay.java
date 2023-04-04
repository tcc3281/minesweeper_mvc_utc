package View;

import java.awt.GridLayout;
<<<<<<< HEAD
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
=======
>>>>>>> 6d0c6c5d97f2da64ceec374ba1c2834f5dc9da6c

import javax.swing.BorderFactory;
import javax.swing.JPanel;

<<<<<<< HEAD
public class PanelPlay extends JPanel{
	
	private GamePanel gamepanel;
	private ButtonPlay[][] arrButton;
	public PanelPlay(GamePanel gamepanel) {
		super();
		this.gamepanel= gamepanel;
		this.setLayout(new GridLayout(gamepanel.getW(), gamepanel.getH()));
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		arrButton = new ButtonPlay[gamepanel.getW()][gamepanel.getH()];
		for(int i= 0; i< arrButton.length;i++) {
			for (int j = 0; j < arrButton[i].length; j++) {
				this.add(arrButton[i][j]= new ButtonPlay());
				
			}
		}
		for(int i=0;i<this.arrButton.length;i++) {
			for(int j=0;j<this.arrButton[i].length;j++) {
				this.arrButton[i][j].addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						ButtonPlay[][]arrButton = getArrButton();
						for (int i = 0; i < arrButton.length; i++) {
							for (int j = 0; j < arrButton[i].length; j++) {
								if(e.getButton()== 1 && e.getSource()== arrButton[i][j]) {
									//code day
									//open("5", i, j);
								}
								else if(e.getButton()==3&& e.getSource()== arrButton[i][j]) {
									//code day
									//setFlag(i,j);
								}
							}
						}
					}
				});
=======
import Controller.ControlGame;

public class PanelPlay extends JPanel {

	private GamePanel gamepanel;
	private ButtonPlay[][] arrButton;

	public PanelPlay(GamePanel gamepanel) {
		super();
		this.setLayout(new GridLayout(gamepanel.getW(), gamepanel.getH()));
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		arrButton = new ButtonPlay[gamepanel.getW()][gamepanel.getH()];
		for (int i = 0; i < arrButton.length; i++) {
			for (int j = 0; j < arrButton[i].length; j++) {
				this.add(arrButton[i][j] = new ButtonPlay());

>>>>>>> 6d0c6c5d97f2da64ceec374ba1c2834f5dc9da6c
			}
		}
	}

<<<<<<< HEAD
=======

>>>>>>> 6d0c6c5d97f2da64ceec374ba1c2834f5dc9da6c
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
<<<<<<< HEAD
	
=======

	public void addMouse(ControlGame controlGame){
		for (int i = 0; i < this.arrButton.length; i++)
			for (int j = 0; j < this.arrButton[i].length; j++)
				this.arrButton[i][j].addMouseListener(controlGame);
	}
>>>>>>> 6d0c6c5d97f2da64ceec374ba1c2834f5dc9da6c
}
