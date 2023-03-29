package ViewMin;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHead extends JPanel {
	private JPanel head;
	private JPanel bom, icon, time;
	private ButtonSmile smile;
	private JLabel times, boms,sobom;
	private GamePanel  game;
	private String soboms="35";
	
	public PanelHead(GamePanel game) {
		this.game= game;
		smile= game.getWorld().getSmile();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLoweredBevelBorder());
		add(bom = new JPanel(), BorderLayout.WEST);
		add(icon = new JPanel(), BorderLayout.CENTER);
		add(time = new JPanel(), BorderLayout.EAST);
		
		bom.add(boms = new JLabel());
		bom.add(sobom= new JLabel(soboms));
		icon.add(smile= new ButtonSmile(this));
		time.add(times = new JLabel("Times"));
		
		boms.setPreferredSize(new Dimension(30,30));
		ImageIcon imIcon1=  new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//bom.png/");
		boms.setIcon(imIcon1);
		

	}
	public GamePanel getGame() {
		return game;
	}
	public void setGame(GamePanel game) {
		this.game = game;
	}
}
