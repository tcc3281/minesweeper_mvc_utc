package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.Menu;

public class MenuActionlisten implements MouseListener {
    private ControlGame controlGame;
    private Menu menu;
    public MenuActionlisten(ControlGame controlGame, Menu menu){
        this.controlGame=controlGame;
        this.menu=menu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getClass());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getClass());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
