package View;

import Model.MineSweeperData;
import Model.MineSweeperLogic;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private PanelPlay panelplay;
	private PanelHead panelhead;
	private GameFrame game;
	static int WIDTH= MineSweeperLogic.WIDTH;
	static int HEIGHT= MineSweeperLogic.HEIGHT;
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

	public GamePanel(GameFrame game) {
		this.game= game;
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
	public int getBoom() {
		return boom;
	}
	public void setBoom(int boom) {
		this.boom = boom;
	}

}
