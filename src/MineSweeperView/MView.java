package MineSweeperView;

import MineSweeperController.MinesweeperController;

import java.util.Arrays;

public class MView {
    private final int N=16;
    private String[][] vMatrix;
    private MinesweeperController controller;
    public MView(MinesweeperController controller){
        this.controller=controller;
        vMatrix=new String[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(vMatrix[i],"-");
        }
    }
    
    public void showMatrix(){
    	for(int i=-1;i<N;i++) {
    		System.out.printf("%3d",i);
    	}
    	System.out.println();
        for(int i=0;i<this.N;i++){
            System.out.printf("%3d",i);
            for (int j=0;j<this.N;j++){
                System.out.printf("%3s",vMatrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public void showValue(int x,int y,String t){
        this.vMatrix[x][y]=t;
    }
    
    public void setFlag(int x,int y){
        this.vMatrix[x][y]="P";
    }
    
    public void unsetFlag(int x,int y){
        this.vMatrix[x][y]="-";
    }
}
