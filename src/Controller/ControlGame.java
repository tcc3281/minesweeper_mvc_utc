package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.MineSweeperLogic;
import Sound.SoundGame;
import View.GameFrame;
import View.PanelHead;
import View.PanelPlay;

public class ControlGame implements MouseListener{
    private MineSweeperLogic logic;
    private PanelHead pHead;
    private PanelPlay play;
    private GameFrame gameFrame;
    private SoundGame soundGame;

    public ControlGame() {
        this.soundGame =new SoundGame();
        this.gameFrame=new GameFrame(this);
        this.logic=new MineSweeperLogic(this);
        this.play=this.gameFrame.getGamepanel().getPanelplay();
        this.pHead=this.gameFrame.getGamepanel().getPanelhead();
        this.gameFrame.getGamepanel().getPanelplay().addMouse(this);
        this.gameFrame.getGamepanel().getPanelhead().addMouse(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i=0;i<this.play.getArrButton().length;i++)
            for(int j=0;j<this.play.getArrButton()[i].length;j++)
        if(e.getButton()==3&& e.getSource()== this.play.getArrButton()[i][j]) {
            if(this.logic.getMarkFlag(i, j) == true)
                this.unsetFlag(i, j);
            else
                this.setFlag(i,j);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==1 && e.getSource()==this.gameFrame.getMenu().getStop()){
            this.pause();
        }
        if(e.getButton()== 1 && e.getSource()==this.pHead.getSmile())
            this.newGame();
        if(!this.logic.getTime().getStatusPause()) return;
        for(int i=0;i<this.play.getArrButton().length;i++) {
            for(int j=0;j<this.play.getArrButton()[i].length;j++)
            {
                if(e.getButton()== 1 && e.getSource()== this.play.getArrButton()[i][j]) {
                    this.open(i, j);
                }
                if(this.logic.validateGame() == -1)
                {
                    this.lose();
                    return;
                }
                else if(this.logic.validateGame()== 1)
                    this.win();
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==this.gameFrame.getMenuBar()){
            this.gameFrame.getMenuBar().getMenu(0);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void open(int x, int y)
    {
        if(this.logic.getTime().getStatusPause()  && (this.logic.getMarkFlag(x, y) == true || this.logic.getOpened(x, y))) return;
        String t = this.logic.open(x, y);
        this.play.open(t, x, y);
    }
    public void setFlag(int x, int y)
    {
        if(this.logic.getTime().getStatusPause()  && (this.logic.getMarkFlag(x, y) == true || this.logic.getOpened(x, y))) return;
        this.logic.setFlag(x, y);
        this.play.setFlag(x,y);
        this.remainMine();
    }
    public void unsetFlag(int x, int y)
    {
        if(this.logic.getMarkFlag(x, y) == false || this.logic.getOpened(x, y)==true) return;
        this.logic.unsetFlag(x, y);
        this.play.unsetFlag(x, y);
        this.remainMine();
    }

    public void newGame()
    {
        this.logic.newGame();
        this.play.newGame();
        this.pHead.newGame();
        this.remainMine();
    }
    public void win()
    {
        this.soundGame.soundWin();
        this.pHead.win();
        this.winOpen();
    }
    public void lose()
    {
        this.soundGame.soundLose();
        for(int i=0;i<this.play.getArrButton().length;i++) {
            for(int j=0;j<this.play.getArrButton()[i].length;j++)
                if(this.logic.getData().getValueXY(i, j)==-1) this.open(i, j);
        }
        this.pHead.lose();
        this.logic.stopOpen();
    }
    public void setTime(String time){
        this.pHead.setTime(time);
    }

    public void remainMine() {
        String t = String.valueOf(this.logic.getRemainFlag());
        this.pHead.setRemainboms(t);
    }
    public void winOpen(){
        for(int i=0;i<this.play.getArrButton().length;i++) {
            for(int j=0;j<this.play.getArrButton()[i].length;j++){
                if(this.logic.getData().getValueXY(i,j)!=-1)this.open(i, j);
                else this.setFlag(i,j);
            }
        }
    }

    public void pause(){
        if(this.logic.validateGame()!=0) return;
        if(this.logic.getTime().getStatusPause()){
            this.play.setDefaultGUI();
            this.logic.swapStatus();
        }
        else{
            for(int i=0;i<MineSweeperLogic.HEIGHT;i++){
                for(int j=0;j<MineSweeperLogic.WIDTH;j++){
                    if(this.logic.getOpened(i,j)==true) this.open(i,j);
                    if(this.logic.getMarkFlag(i,j)) this.setFlag(i,j);
                }
            }
            this.logic.swapStatus();
        }
        this.gameFrame.getMenu().swap();
    }
}
