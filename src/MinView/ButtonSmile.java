package MinView;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonSmile extends JButton {
			private PanelHead head;
			public ButtonSmile(PanelHead head) {
				this.head= head;
				this.setPreferredSize(new Dimension(40,40));
				this.setSmile();
				this.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						setSmile();
					}
				});
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
