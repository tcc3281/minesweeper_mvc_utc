package Model;

import java.util.Arrays;

public class MineSweeperData {
    static int WIDTH =16;
    static int HEIGHT=16;
    static int MINE=40;
    private int [][]board;
    private final double PROBILITYMINE=0.05;
    private final double PROBITITYZERO=0.33;
    private int limitZero=15;
    private int limitMine;
    private boolean firstClick=true;
    /*
    - mine = -1
    - nothing = 0;
    - number >0 : quality mine around
     */
    //
    public MineSweeperData(int x,int y){
        this.limitMine=MINE;
        this.board=new int[HEIGHT][WIDTH];
        for(int i = 0; i< HEIGHT; i++)
            Arrays.fill(this.board[i],-20);
        createGameData(x,y);
    }
    public int getValueXY(int x, int y){
        return this.board[x][y];
    }
    public void createGameData(int x,int y){
        this.setZero(x,y);
        this.setMine();
    }

    //khiến cho click đầu tiên không thể là mìn, và bằng 0;
    public void setZero(int x,int y){
        this.board[x][y]=0;
        this.limitZero--;
        if(this.firstClick==true){
            for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++)
                    try{
                        this.board[i][j]=0;
                    }catch (ArrayIndexOutOfBoundsException e){}
            }
            this.firstClick=false;
        }

        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                try {
                    if(Math.random()<this.PROBITITYZERO && this.limitZero>=0) this.setZero(i,j);
                }catch (ArrayIndexOutOfBoundsException e){}
            }
        }
    }
    //đặt mìn
    public void setMine(){
        while(this.limitMine>0){
            int x,y;
            x=(int)(Math.random()*this.HEIGHT)%this.HEIGHT;
            y=(int)(Math.random()*this.WIDTH)%this.WIDTH;
            if(this.board[x][y]==-20) createMine(x,y);
        }
        for(int i = 0; i< this.board.length; i++){
            for(int j = 0; j< this.board[i].length; j++)
                if(this.board[i][j]<-1) this.board[i][j]+=20;
        }
    }

    public void createMine(int x, int y){
        if(Math.random()<this.PROBILITYMINE && this.board[x][y]!=0 && this.limitMine>0 &&this.board[x][y]!=-1){
            this.board[x][y]=-1;
            this.limitMine--;
            for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++){
                    try{
                        if(this.board[i][j]!=-1){
                            this.board[i][j]++;
                            createMine(i,j);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){}
                }
            }
        }
    }

    private void print(){
        for(int i = -1; i< WIDTH; i++) {
            System.out.printf("%3d",i);
        }
        System.out.println();
        for(int i = 0; i< HEIGHT; i++){
            System.out.printf("%3d",i);
            for(int j = 0; j< WIDTH; j++){
                System.out.printf("%3d",this.board[i][j]);
            }
            System.out.println();
        }
        System.out.println(this.limitMine);
        this.check();
    }

    private boolean check(int x,int y){
        int res=0;
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                try{
                    if(this.board[i][j]==-1) res++;
                }
                catch (ArrayIndexOutOfBoundsException e){}
            }
        }
        if(res==this.board[x][y]) return true;
        return false;
    }

    private void check(){
        int countMine=0;
        for(int i = 0; i<this.HEIGHT; i++){
            for(int j = 0; j<this.WIDTH; j++){
                if(this.board[i][j]==-1) countMine++;
                if(this.board[i][j]>0){
                    if(!check(i,j)){
                        System.out.println("Incorrect: "+i+" "+j);
                        return;
                    }
                }
            }
        }
        if(countMine!=MINE){
            System.out.println("Incorrect: "+countMine);
            return;
        }
        System.out.println("Correct");
    }
}