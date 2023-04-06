package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.MineSweeperLogic;
import View.GameFrame;
import View.GamePanel;
import View.PanelHead;
import View.PanelPlay;
public class ControlGame implements MouseListener{
    private MineSweeperLogic logic;
    private PanelHead pHead;
    private PanelPlay play;
    private GameFrame gameFrame;

    public ControlGame() {
        this.gameFrame=new GameFrame(this);
        this.logic=new MineSweeperLogic(this);
        this.play=this.gameFrame.getGamepanel().getPanelplay();
        this.pHead=this.gameFrame.getGamepanel().getPanelhead();
        this.gameFrame.getGamepanel().getPanelplay().addMouse(this);
        this.gameFrame.getGamepanel().getPanelhead().addMouse(this);

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()== 1 && e.getSource()==this.pHead.getSmile())
            this.newGame();
        for(int i=0;i<this.play.getArrButton().length;i++) {
            for(int j=0;j<this.play.getArrButton()[i].length;j++)
            {
                if(e.getButton()== 1 && e.getSource()== this.play.getArrButton()[i][j]) {
                    this.open(i, j);
                    if(this.logic.validateGame() == -1)
                    {
                        this.lose();
                        return;
                    }
                    else if(this.logic.validateGame()== 1)
                        this.win();
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
        if(e.getButton()== 1 && e.getSource()==this.pHead.getSmile())
        {
            this.newGame();
        }
        for(int i=0;i<this.play.getArrButton().length;i++) {
            for(int j=0;j<this.play.getArrButton()[i].length;j++)
            {
                if(e.getButton()== 1 && e.getSource()== this.play.getArrButton()[i][j]) {
                    this.open(i, j);
                    if(this.logic.validateGame() == -1)
                    {
                        this.lose();
                        return;
                    }
                    else if(this.logic.validateGame()== 1)
                        this.win();
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

    public void open(int x, int y)
    {
        if(this.logic.getMarkFlag(x, y) == true ) return;
        String t = this.logic.open(x, y);
        this.play.open(t, x, y);
    }
    public void setFlag(int x, int y)
    {
        if(this.logic.getMarkFlag(x, y) == true || this.logic.getOpened(x, y)==true) return;
        this.logic.setFlag(x, y);
        this.play.setFlag(x,y);
    }
    public void unsetFlag(int x, int y)
    {
        if(this.logic.getMarkFlag(x, y) == false || this.logic.getOpened(x, y)==true) return;
        this.logic.unsetFlag(x, y);
        this.play.unsetFlag(x, y);
    }

    public void newGame()
    {
        new ControlGame();
    }
    public void win()
    {
        this.pHead.win();
    }
    public void lose()
    {
        for(int i=0;i<this.play.getArrButton().length;i++) {
            for(int j=0;j<this.play.getArrButton()[i].length;j++)
                if(this.logic.getData().getValueXY(i, j)==-1) this.open(i, j);
        }
        this.pHead.lose();
    }
    public void setTime(String time){
        this.pHead.setTime(time);
    }

}
