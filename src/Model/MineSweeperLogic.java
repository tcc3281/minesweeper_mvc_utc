package Model;

import java.io.*;
import java.util.Arrays;

import Controller.ControlGame;

public class MineSweeperLogic{
    public static int MINE=MineSweeperData.MINE;
    public static int HEIGHT=MineSweeperData.HEIGHT;
    public static int WIDTH=MineSweeperData.WIDTH;
    public MineSweeperData data; //data của game
    private TimeGame time; //dem thoi gian
    private int remainFlag; //số cờ còn lại
    private int remainMine; //số mìn còn lại
    private int remainSquare; //số ô không phải bom còn lại
    private boolean flagMine; //đánh dấu bấm vào bom hay chưa
    private ControlGame controlGame; //biến control
    private boolean [][]opened; //đánh dấu ô đã mở
    private boolean [][]markFlag; //đánh dấu ô đang trạng thái cắm cờ hay ko
    private final boolean FLAG=true;
    private final boolean UNFLAG=false;

    public MineSweeperLogic(ControlGame controlGame){
        this.controlGame =controlGame;
        this.time=null;
        newGame();
    }
    public void newGame(){
        flagMine=true;
        remainFlag=MINE;
        remainMine=MINE;
        remainSquare= WIDTH * HEIGHT - MINE;
        data=null;
        if(this.time!=null) this.time.cancel();
        this.opened=new boolean[HEIGHT][WIDTH];
        this.markFlag=new boolean[HEIGHT][WIDTH];
        for(int i=0;i<markFlag.length;i++)
            Arrays.fill(markFlag[i],false);
        this.time=new TimeGame(this.controlGame);
    }
    public String open(int x, int y){
        if(this.data==null){
            this.data=new MineSweeperData(x,y);
            this.time.start();
        }
        if(this.data.getValueXY(x, y)!=-1) this.remainSquare--;

        this.opened[x][y]=true;

        if(this.data.getValueXY(x,y)==-1) flagMine=false;

        if(this.data.getValueXY(x, y)==0) {
            for(int i=x-1;i<=x+1;i++) {
                for(int j=y-1;j<=y+1;j++) {
                    try {
                        if(this.opened[i][j]==false) controlGame.open(i,j);
                    }catch(ArrayIndexOutOfBoundsException e) {}
                }
            }
        }

        return String.format("%d",this.data.getValueXY(x, y));
    }

    public boolean setFlag(int x, int y){
        if(this.opened[x][y]==true || this.markFlag[x][y]==this.FLAG) return false;
        this.remainFlag--;
        if(this.data!=null && this.data.getValueXY(x,y)==-1) {
            this.remainMine--;
        }
        this.markFlag[x][y]=this.FLAG;
        return true;
    }

    public boolean unsetFlag(int x,int y){
        if(this.opened[x][y]==true || this.markFlag[x][y]==this.UNFLAG) return false;
        this.remainFlag++;
        if(this.data!=null && this.data.getValueXY(x,y)==-1){
            this.remainMine++;
        }
        this.markFlag[x][y]=this.UNFLAG;
        return true;
    }

    public int validateGame(){
        if(!flagMine){
            this.time.cancel();
            return -1;
        }
        else if (this.remainMine==0 || this.remainSquare==0){
            this.time.cancel();
            return 1;
        }
        else return 0;
    }

    public boolean getOpened(int x,int y) {
        return this.opened[x][y];
    }

    public boolean getMarkFlag(int x, int y) {
        return this.markFlag[x][y];
    }


    public void lose(){
        for(int i = 0; i<HEIGHT; i++){
            for(int j = 0; j<WIDTH; j++){
                if(this.data.getValueXY(i,j)==-1);//code
            }
        }
    }

    public int getRemainFlag(){
        return this.remainFlag;
    }

    public MineSweeperData getData() {
        return data;
    }
    public void stopOpen() {
        for(int i = 0; i<this.HEIGHT; i++ ) {
            Arrays.fill(this.opened[i], true);
        }
    }

    public TimeGame getTime(){
        return this.time;
    }
    public void swapStatus(){
        if(this.data!=null) this.time.swapStatus();
    }
    public static void save(){

    }

}
