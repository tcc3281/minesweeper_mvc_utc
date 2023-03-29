package ViewMin;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonSmile extends JButton {
	private PanelHead head;
	public ButtonSmile(PanelHead head)
	{
		this.head= head;
		setPreferredSize(new Dimension(30,30));
		ImageIcon imgsmile= new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//icon new.png/");
		setIcon(imgsmile);
	}
}
