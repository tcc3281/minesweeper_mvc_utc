package Model;

import Controller.ControlGame;

import java.util.Timer;
import java.util.TimerTask;

public class TimeGame{
    private int time;
    private Timer timer;
    private final int MAX_TIME=999;
    private ControlGame controlGame;
    private boolean statusPause;
    private final boolean PAUSE=false;
    private final boolean CONTINUE=true;
    public TimeGame(ControlGame controlGame){
        time=0;
        timer=new Timer();
        this.statusPause=CONTINUE;
        this.controlGame=controlGame;
    }
    public void start(){
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                setTime();
                controlGame.setTime(getTime());
            }
        };
        timer.schedule(timerTask,0,1000L);
    }
    public void setTime(){
        if(this.statusPause) this.time++;
        else return;
        if(this.time==this.MAX_TIME){
            this.timer.cancel();
        }
    }
    public String getTime(){
        return String.format("%03d",this.time);
    }
    public void cancel(){
        this.timer.cancel();
    }
    public boolean getStatusPause(){
        return this.statusPause;
    }
    public void swapStatus(){
        this.statusPause=!this.statusPause;
    }
}
