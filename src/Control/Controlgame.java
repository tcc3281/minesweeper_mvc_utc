package Control;

import javax.swing.JButton;

import ViewMin.ButtonPlayer;
import ViewMin.ButtonSmile;

public class Controlgame {
	private ButtonPlayer[][] arrButton;
	private ButtonSmile smile;
	public ButtonSmile getSmile() {
		return smile;
	}

	public void setSmile(ButtonSmile smile) {
		this.smile = smile;
	}

	public Controlgame(int w, int h, int boom) {
		arrButton = new ButtonPlayer[w][h];
	}

	public ButtonPlayer[][] getArrButton() {
		return arrButton;
	}

	public void setArrButton(ButtonPlayer[][] arrButton) {
		this.arrButton = arrButton;
	}

}
