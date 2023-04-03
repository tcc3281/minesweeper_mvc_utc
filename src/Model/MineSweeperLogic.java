package Model;

import java.util.Timer;
import java.util.TimerTask;



public class MineSweeperLogic {
    public MineSweeperData data; //data của game
    private Timer time; //bộ đếm thời gian game
    private int remainFlag; //số cờ còn lại
    private int remainMine; //số mìn còn lại
    private int remainSquare; //số ô không phải bom còn lại
    private int intervalTime; //hiện thời gian (s)
    private final int MAX_TIME=999;
    private boolean flagMine=true; //đánh dấu bấm vào bom hay chưa

    private final int N=16; //kích cỡ game
    private final int MINE=40; //sô lượng mìn max
    private boolean [][]opened; //đánh dấu ô đã mở
    private boolean [][]markFlag; //đánh dấu ô đang trạng thái cắm cờ hay ko
    private final boolean FLAG=true;
    private final boolean UNFLAG=false;
    
    
    public MineSweeperLogic(){
        remainFlag=40;
        data=null;
        intervalTime=0;
        time=new Timer();
        remainMine=MINE;
        remainSquare=N*N-MINE;
        setTime();
        this.opened=new boolean[N][N];
        this.markFlag=new boolean[N][N];
    }

    public void setTime(){
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                //goi controller
                setIntervalTime();
            }
        };
        this.time.schedule(task,1000,1000);
    }
    
    public void setIntervalTime(){
        this.intervalTime++;
        if(this.intervalTime==this.MAX_TIME){
            this.time.cancel();
        }
    }
    
    public String getIntervalTime(){
        String res;
        res=String.format("%03d",this.intervalTime);
        return res;
    }
    
    public String open(int x, int y){
        if(this.data==null) this.data=new MineSweeperData(x,y);

        if(this.data.getValueXY(x, y)!=-1) this.remainSquare--;

        this.opened[x][y]=true;

        if(this.data.getValueXY(x,y)==-1) flagMine=false;

        if(this.data.getValueXY(x, y)==0) {
        	for(int i=x-1;i<=x+1;i++) {
        		for(int j=y-1;j<=y+1;j++) {
        			try {
        				if(this.opened[i][j]==false);//code
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
        for(int i=0;i<this.N ;i++){
            for(int j=0;j<this.N;j++){
                if(this.data.getValueXY(i,j)==-1);//code
            }
        }
    }

    public int getRemainFlag(){
        return this.remainFlag;
    }

    //method bẫy để check time
    private void checkTime(){
        System.out.println("Time: "+this.intervalTime);
    }
}
