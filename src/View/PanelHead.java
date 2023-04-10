package View;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ControlGame;
import Model.MineSweeperLogic;

public class PanelHead extends JPanel {
	private ButtonSmile smile;
	private JPanel boms, icon, times;
	private GamePanel gamepanel;
	private JLabel[] arrTime;
	private JLabel mins;
	private JLabel remainBomsJL;
	private String  remainboms= String.valueOf(MineSweeperLogic.MINE);
	public PanelHead( GamePanel gamepanel) {
		this.gamepanel= gamepanel;
		arrTime= new JLabel[3];
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(boms = new JPanel(), BorderLayout.WEST);
		this.add(icon= new JPanel(), BorderLayout.CENTER);
		this.add(times= new JPanel(),BorderLayout.EAST);
		icon.add(smile = new ButtonSmile());

		times.setPreferredSize(new Dimension(70,40));
		times.setLayout(new GridLayout(1,3,0,0));
		for(int i=0; i< 3; i++) {
			String s=this.paintTime('0');
			this.arrTime[i]=new JLabel(new ImageIcon(s));
			this.times.add(arrTime[i]);
		}

		boms.setLayout(new FlowLayout(FlowLayout.LEFT));
		boms.setPreferredSize(new Dimension(60,40));
		boms.add(mins= new JLabel());
		mins.setIcon(new ImageIcon("./Image/bom.png"));
		boms.add(remainBomsJL = new JLabel(this.getRemainboms()));
		newGame();
	}

	public void newGame(){
		this.setRemainboms(this.getRemainboms());
		this.setTime("000");
	}
	public void setTime(String t) {
		for(int i=0; i< 3; i++) {
			String s=this.paintTime(t.charAt(i));
			arrTime[i].setIcon(new ImageIcon(s));
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
		this.remainBomsJL.setText(remainboms);
	}
	public ButtonSmile getSmile() {
		return smile;
	}
	public void setSmile(ButtonSmile smile) {
		this.smile = smile;
	}

	public void lose()
	{
		this.smile.setSad();
	}
	public void win()
	{
		this.smile.setWin();
	}
	public void addMouse(ControlGame controlGame){
		this.smile.addMouseListener(controlGame);
	}

}
