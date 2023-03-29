package ViewMin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Control.Controlgame;

public class GamePanel extends JPanel implements MouseListener {
	
	private PanelPlay body;
	private PanelHead head;
	private Controlgame world;
	private GameFrame gameframe;


	private int w;
	private int h;
	private int boom;

	public GamePanel(int w, int h, int boom, GameFrame gameframe) {
		this.gameframe= gameframe;
		this.w = w;
		this.h = h;
		this.boom= boom;
		world = new Controlgame(w, h, boom);
		setLayout(new BorderLayout(8, 10));

		add(head = new PanelHead(this), BorderLayout.NORTH);
		
		add(body = new PanelPlay(this), BorderLayout.CENTER);
		
	}

	public Controlgame getWorld() {
		return world;
	}

	public void setWorld(Controlgame world) {
		this.world = world;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public GameFrame getGameframe() {
		return gameframe;
	}

	public void setGameframe(GameFrame gameframe) {
		this.gameframe = gameframe;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		ButtonPlayer[][] arrButton= body.getArrButton();
		for (int i = 0; i < arrButton.length; i++) {
			for (int j = 0; j < arrButton[i].length; j++) {
				if(e.getButton()==1 && e.getSource()== arrButton[i][j])
				{
//					if(!control.open(i,j)) {
//			         // thay het world= control nha roi hay test
//						int option=JOptionPane.showConfirmDialog(this, "You lose!Do you want to play again? ","Notification", JOptionPane.YES_NO_OPTION);
//						if(option==JOptionPane.YES_OPTION)
//						{
//							gameframe.setVisible(false);
//							new GameFrame();
//						}
//						
//							
//						}
					}
				}
			}
			
		}
	//}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
