package View;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonPlay extends JButton {

	public ButtonPlay()
	{
		setPreferredSize(new Dimension(30, 30));
		this.appearence("-2");
	}
	public void appearence(String number) {
		switch (number) {
		case "-2":
			ImageIcon imgbegin=  new ImageIcon("./Image/begin.png/");
			setIcon(imgbegin);
			break;
		case "-1": // doi thanh bom chet
			ImageIcon imgboms= new ImageIcon("./Image/mistake.png/");
			setIcon(imgboms);
			break;
		case "0":
			ImageIcon img0=  new ImageIcon("./Image/empty box.png/");
			setIcon(img0);
			break;
		case "1":
			ImageIcon img1=  new ImageIcon("./Image/1 bom.png/");
			setIcon(img1);
			break;
		case "2":
			ImageIcon img2=  new ImageIcon("./Image/2 bom.png/");
			setIcon(img2);
			break;
		case "3":
			ImageIcon img3=  new ImageIcon("./Image/3 bom.png/");
			setIcon(img3);
			break;
		case "4":
			ImageIcon img4=  new ImageIcon("./Image/4 bom.png/");
			setIcon(img4);
			break;
		case "5":
			ImageIcon img5=  new ImageIcon("./Image/5 bom.png/");
			setIcon(img5);
			break;
		case "6":
			ImageIcon img6=  new ImageIcon("./Image/6 bom.png/");
			setIcon(img6);
			break;
		case "7":
			ImageIcon img7=  new ImageIcon("./Image/7 bom.png/");
			setIcon(img7);
			break;
		case "8":
			ImageIcon img8=  new ImageIcon("./Image/8 bom.png/");
			setIcon(img8);
			break;
		default:
			break;
		}
	}
	public void setflag() {
		this.setIcon(new ImageIcon("./Image/flag.png/"));
	}
	public void setremoveflag() {
		this.appearence("-2");
	}
}
