package View;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonSmile extends JButton {
		public ButtonSmile() {
			this.setPreferredSize(new Dimension(40,40));
			this.setSmile();
		}
		public void setSmile() {
			this.setIcon(new ImageIcon("./Image/icon new.png"));
		}
		public void setSad() {
			this.setIcon(new ImageIcon("./Image/lose.png"));
		}
		public void setWin() {
			this.setIcon(new ImageIcon("./Image/win.png"));
		}
}
