package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.MineSweeperLogic;
import View.PanelHead;
import View.PanelPlay;
public class controlgame implements MouseListener{
	private MineSweeperLogic logic;
	private PanelHead pHead;
	private PanelPlay play;
	
	public controlgame(PanelPlay play) {
		this.play = play;
		this.logic = new MineSweeperLogic(this);
	}
	public controlgame(PanelHead plHead)
	{
		this.pHead = plHead;
		this.logic = new MineSweeperLogic(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i=0;i<this.play.getArrButton().length;i++) {
			for(int j=0;j<this.play.getArrButton()[i].length;j++)
			{
				if(e.getButton()== 1 && e.getSource()== this.play.getArrButton()[i][j]) {
					this.open(i, j);
				}
				else if(e.getButton()==3&& e.getSource()== this.play.getArrButton()[i][j]) {
					if(this.logic.getMarkFlag(i, j) == true)
						this.unsetFlag(i, j);
					else 
						this.setFlag(i,j);
				}
			}
		}
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
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
	
	
	void open(int x, int y)
	{	if(this.logic.getMarkFlag(x, y) == true ) return;
		String t = this.logic.open(x, y);
		this.play.open(t, x, y);
	}
	void setFlag(int x, int y)
	{
		if(this.logic.getMarkFlag(x, y) == true || this.logic.getOpened(x, y)==true) return;
		this.logic.setFlag(x, y);
		this.play.setFlag(x,y);
	}
	void unsetFlag(int x, int y)
	{
		if(this.logic.getMarkFlag(x, y) == false || this.logic.getOpened(x, y)==true) return;
		this.logic.unsetFlag(x, y);
		this.play.unsetFlag(x, y);
	}
	void win()
	{
	     
	}
	void lose()
	{
		
		
	}
	
	
	
	
}
