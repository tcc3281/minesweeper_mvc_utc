package View;

import Controller.ControlGame;

import javax.swing.*;

public class Menugame extends JMenuBar {
    private JMenu fileMenu;
    private JMenu actionMenu;
    private ControlGame controlGame;
    String stopItem;
    final String PAUSE="Pause";
    final String CONTINUE="Continue";
    JMenuItem stop;
    JMenuItem newGame;
    public Menugame(ControlGame controlGame) {
        super();
        this.setControlGame(controlGame);
        this.prepareGUI();
    }
    public void prepareGUI(){
        this.fileMenu=new JMenu("File");
        this.actionMenu=new JMenu("Action");
        this.addFileMenu();
        this.addActionMenu();
        this.add(fileMenu);
        this.add(actionMenu);
        this.setVisible(true);
    }
    public void addFileMenu(){
        newGame=new JMenuItem("New");
        newGame.addMouseListener(this.controlGame);
        this.fileMenu.add(newGame);
        //

    }
    public void addActionMenu(){
        this.stopItem=PAUSE;
        stop=new JMenuItem(stopItem);
        actionMenu.add(stop);
        stop.addMouseListener(controlGame);
    }
    public void setControlGame(ControlGame controlGame){
        this.controlGame=controlGame;
    }
    public void swap(){
        System.out.println(actionMenu.isShowing());
        if(this.stopItem.equals(PAUSE)) this.stopItem=CONTINUE;
        else this.stopItem=PAUSE;
        this.stop.setText(stopItem);
    }
    public JMenuItem getStop(){
        return this.stop;
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public JMenu getActionMenu() {
        return actionMenu;
    }

    public void setActionMenu(JMenu actionMenu) {
        this.actionMenu = actionMenu;
    }

    public ControlGame getControlGame() {
        return controlGame;
    }

    public String getStopItem() {
        return stopItem;
    }

    public void setStopItem(String stopItem) {
        this.stopItem = stopItem;
    }

    public String getPAUSE() {
        return PAUSE;
    }

    public String getCONTINUE() {
        return CONTINUE;
    }

    public void setStop(JMenuItem stop) {
        this.stop = stop;
    }

    public JMenuItem getNewGame() {
        return newGame;
    }

    public void setNewGame(JMenuItem newGame) {
        this.newGame = newGame;
    }

}
