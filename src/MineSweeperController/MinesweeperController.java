package MineSweeperController;
import MineSweeperView.MView;
import MineSweeperModel.MineSweeperLogic;

import java.util.Scanner;

public class MinesweeperController{
    MineSweeperLogic logic;
    MView mView;
    Scanner sc;
    
    public MinesweeperController(){
        this.newGame();
    }
    
    public void newGame(){
        sc=new Scanner(System.in);
        logic=new MineSweeperLogic(this);
        mView=new MView(this);
        this.play();
    }
    
    public void play(){
        int x;
        int flag=0;
        do {
            this.mView.showMatrix();
            this.menu();
            Scanner sc=new Scanner(System.in);
            System.out.println("Chosse: ");
            x=sc.nextInt(); if(x==5) break;
            chosse(x);
            flag=this.logic.validateGame();

        }while (x!=5 && flag==0);
        if(flag==1) this.win();
        else this.lose();
    }
    
    public void chosse(int x){
        int a,b;
        a= sc.nextInt();
        b= sc.nextInt();
        switch (x){
            case 1:
                this.open(a,b);
                break;
            case 2:
                this.setFlag(a,b);
                break;
            case 3:
                this.unsetFlag(a,b);
                break;
            case 4:
                this.newGame();
                break;
            default:
                break;
        }
    }
    
    public void menu(){
        System.out.println("1. Open");
        System.out.println("2. Set Flag");
        System.out.println("3. Unset Flag");
        System.out.println("4. New game");
        System.out.println("5. Out");
    }
    
    public void open(int x,int y){
        int t=this.logic.open(x, y);
        this.mView.showValue(x,y,t);
    }
    
    public void setFlag(int x, int y){
    	if(this.logic.getMarkFlag(x, y) == true || this.logic.getOpened(x, y)==true) return;
        this.mView.setFlag(x,y);
        this.logic.setFlag(x,y);
    }
    
    public void unsetFlag(int x,int y){
    	if(this.logic.getMarkFlag(x, y) == false || this.logic.getOpened(x, y)==true) return;
        this.mView.unsetFlag(x,y);
        this.logic.unsetFlag(x,y);
    }
    
    public void win(){
        System.out.println("win: "+this.logic.getIntervalTime());
        
    }
    
    public void lose() {
        System.out.println("lose: "+this.logic.getIntervalTime());
    }
}
