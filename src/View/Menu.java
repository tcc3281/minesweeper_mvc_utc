package View;

import Controller.ControlGame;
import View.Save.SaveJD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {
    private JMenu fileMenu;
    private JMenu actionMenu;
    private ControlGame controlGame;
    String stopItem;
    final String PAUSE="Pause";
    final String CONTINUE="Continue";
    JMenuItem stop;
    public Menu(ControlGame controlGame) {
        super();
        this.setControlGame(controlGame);
        this.prepareGUI();
    }
    public void prepareGUI(){
        this.fileMenu=new JMenu("File");
        this.actionMenu=new JMenu("Action");
        this.stopItem=PAUSE;
        stop=new JMenuItem(stopItem);
        actionMenu.add(stop);
        stop.addMouseListener(controlGame);
        this.add(fileMenu);
        this.add(actionMenu);

    }
    public void setControlGame(ControlGame controlGame){
        this.controlGame=controlGame;
    }
    public void swap(){
        if(this.stopItem==PAUSE) this.stopItem=CONTINUE;
        else this.stopItem=PAUSE;
    }
    public JMenuItem getStop(){
        return this.stop;
    }
}
