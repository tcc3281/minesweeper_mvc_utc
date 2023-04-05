package View;

import java.awt.BorderLayout;
import Controller.ControlGame;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private ButtonPlay buttonplay;
	private PanelPlay panelplay;
	private PanelHead panelhead;
	private GameFrame game;
	private int w;
	private int h;
	private int boom;
	public PanelPlay getPanelplay() {
		return panelplay;
	}
	public void setPanelplay(PanelPlay panelplay) {
		this.panelplay = panelplay;
	}
	public PanelHead getPanelhead() {
		return panelhead;
	}
	public void setPanelhead(PanelHead panelhead) {
		this.panelhead = panelhead;
	}

	public GamePanel(int w, int h, int boom, GameFrame game) {
		this.game= game;
		this.w=w;
		this.h= h;
		this.boom= boom;
		this.setLayout(new BorderLayout(8,10));
		this.add(panelplay= new PanelPlay(this), BorderLayout.SOUTH);
		this.add(panelhead= new PanelHead(this), BorderLayout.NORTH);
	}
	public GameFrame getGame() {
		return game;
	}
	public void setGame(GameFrame game) {
		this.game = game;
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
	public int getBoom() {
		return boom;
	}
	public void setBoom(int boom) {
		this.boom = boom;
	}

}
