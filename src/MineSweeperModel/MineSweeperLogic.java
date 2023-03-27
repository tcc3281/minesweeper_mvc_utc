package MineSweeperModel;

import java.util.Timer;
import java.util.TimerTask;

import MineSweeperController.MinesweeperController;

public class MineSweeperLogic {
    public MineSweeperData data;
    private Timer time;
    private int remainFlag;
    private int remainMine;
    private int remainSquare;
    private int intervalTime;
    private final int MAX_TIME=999;
    private boolean flagMine=true;
    private MinesweeperController controller;
    private final int N=16;
    private final int MINE=40;
    private boolean [][]opened;
    private boolean [][]markFlag;
    
    
    public MineSweeperLogic(MinesweeperController controller){
        remainFlag=40;
        data=null;
        intervalTime=MAX_TIME;
        time=new Timer();
        remainMine=MINE;
        remainSquare=N*N-MINE;
        setTime();
        this.controller=controller;
        this.opened=new boolean[N][N];
        this.markFlag=new boolean[N][N];
    }
    
    public void setTime(){
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                //fix
                setIntervalTime();
            }
        };
        this.time.schedule(task,1000,1000);
    }
    
    public void setIntervalTime(){
        this.intervalTime--;
        if(this.intervalTime==0){
            this.time.cancel();
        }
    }
    
    public int getIntervalTime(){
        return this.intervalTime;
    }
    
    public int open(int x, int y){
        if(this.data==null){
            this.data=new MineSweeperData(x,y);
        }
        if(this.data.getValueXY(x, y)!=-1){
            this.remainSquare--;
        }
        this.opened[x][y]=true;
        if(this.data.getValueXY(x,y)==-1) flagMine=false;
        if(this.data.getValueXY(x, y)==0) {
        	for(int i=x-1;i<=x+1;i++) {
        		for(int j=y-1;j<=y+1;j++) {
        			try {
        				if(this.opened[i][j]==false) this.controller.open(i, j);
        			}catch(ArrayIndexOutOfBoundsException e) {}
        		}
        	}
        }
        
        return this.data.getValueXY(x, y);
    }
    
    public void setFlag(int x, int y){
        this.remainFlag--;
        if(this.data!=null && this.data.getValueXY(x,y)==-1){
            this.remainMine--;
        }
        this.markFlag[x][y]=true;
    }
    
    public void unsetFlag(int x,int y){
        this.remainFlag++;
        if(this.data!=null && this.data.getValueXY(x,y)==-1){
            this.remainMine++;
        }
        this.markFlag[x][y]=false;
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

    public void checkTime(){
        System.out.println("Time: "+this.intervalTime);
    }
    
    public boolean getOpened(int x,int y) {
    	return this.opened[x][y];
    }
    
    public boolean getMarkFlag(int x, int y) {
    	return this.markFlag[x][y];
    }

    public void lose(){
        for(int i=0;i<this.N ;i++){
            for(int j=0;j<this.N;j++){
                if(this.data.getValueXY(i,j)==-1) this.controller.open(i,j);
            }
        }
    }
}
