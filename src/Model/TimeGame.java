package Model;

import Controller.ControlGame;

import java.util.Timer;
import java.util.TimerTask;

public class TimeGame{
    private int time;
    private Timer timer;
    private final int MAX_TIME=999;
    private ControlGame controlGame;
    public TimeGame(ControlGame controlGame){
        time=0;
        timer=new Timer();
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
        this.time++;
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
}
