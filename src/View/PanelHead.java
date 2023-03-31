package View;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHead extends JPanel {
	private ButtonSmile smile;
	private JPanel head;
	private JPanel boms, icon, times;
	private GamePanel gamepanel;
	private JLabel[] arrTime;
	private JLabel mins,remainBom;
	private String  remainboms="30";
	public PanelHead( GamePanel gamepanel) {
		this.gamepanel= gamepanel;
		arrTime= new JLabel[3];
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(boms = new JPanel(), BorderLayout.WEST);
		this.add(icon= new JPanel(), BorderLayout.CENTER);
		this.add(times= new JPanel(),BorderLayout.EAST);	
		icon.add(smile = new ButtonSmile());
		
//		times.setPreferredSize(new Dimension(85,40));
		times.setLayout(new GridLayout(1,0));
		for(int i=0;i<3;i++) this.arrTime[i]=new JLabel();
		setTime("000");
		
		boms.setLayout(new FlowLayout(FlowLayout.LEFT));
		boms.setPreferredSize(new Dimension(60,40));
		boms.add(mins= new JLabel());
		mins.setIcon(new ImageIcon("./Image/bom.png"));
		boms.add(remainBom= new JLabel(remainboms));

	}
	public void setNumberBoms(String number) {
		
	}
	
	public void setTime(String t) {
		for(int i=0; i< 3; i++) {
			String s=this.paintTime(t.charAt(i));
			arrTime[i].setIcon(new ImageIcon(s));
			this.times.add(arrTime[i]);
		}
	}
	
	public String paintTime(char tg) {
		switch (tg) {
		case '0':
			return "./Image/0.png";
		case '1':
			return "./Image/1.png";
		case '2':
			return "./Image/2.png";
		case '3':
			return "./Image/3.png";
		case '4':
			return "./Image/4.png";
		case '5':
			return "./Image/5.png";
		case '6':
			return "./Image/6.png";
		case '7':
			return "./Image/7.png";
		case '8':
			return "./Image/8.png";
		case '9':
			return "./Image/9.png";
		default:
			break;
		}
		return null;
	}
	public String getRemainboms() {
		return remainboms;
	}
	public void setRemainboms(String remainboms) {
		this.remainboms = remainboms;
	}
}
