package ViewMin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.event.SwingPropertyChangeSupport;

public class ButtonPlayer extends JButton  {
	private PanelPlay p;
	//private boolean firstClicked;
	
	private int number;

	public ButtonPlayer(PanelPlay p) {
		number= -1;
		this.p=p;
		setPreferredSize(new Dimension(30, 30));
		switch (number) {
		case -1:
			
			ImageIcon imIcon=  new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//begin.png/");
			setIcon(imIcon);
			break;
		case 0:
			ImageIcon imIcon0=  new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//empty box.png/");
			setIcon(imIcon0);
			break;	
		case 1:
			ImageIcon imIcon1=  new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//1 bom.png/");
			setIcon(imIcon1);
			break;
		case 2:
			ImageIcon imIcon2=  new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//2 bom.png/");
			setIcon(imIcon2);
			break;
		case 3:
			ImageIcon imIcon3=  new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//3 bom.png/");
			setIcon(imIcon3);
			break;
		case 4:
			ImageIcon imIcon4=  new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//4 bom.png/");
			setIcon(imIcon4);
			break;
		case 5:
			ImageIcon imIcon5=  new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//5 bom.png/");
			setIcon(imIcon5);
			break;
		case 6:
			ImageIcon imIcon6=  new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//6 bom.png/");
			setIcon(imIcon6);
			break;
		case 7:
			ImageIcon imIcon7=  new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//7 bom.png/");
			setIcon(imIcon7);
			break;
		case 8:
			ImageIcon imIcon8=  new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//8 bom.png/");
			setIcon(imIcon8);
			break;
        default:
        	break;
		}
		
	}
	public void setNumber(int number)
	{
		this.number= number;
		
	}
	
	
	
}
