package ViewMin;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Data extends ImageIcon{
	private ArrayList<ImageIcon> imageList;

	public Data() {
		imageList = new ArrayList<>();
		ImageIcon image1 = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//1 bom.png/");
		ImageIcon image2 = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//2 bom.png/");
		ImageIcon image3 = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//3 bom.png/");
		ImageIcon image4 = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//4 bom.png/");
		ImageIcon image5 = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//5 bom.png/");
		ImageIcon image6 = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//6 bom.png/");
		ImageIcon image7 = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//7 bom.png/");
		ImageIcon image8 = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//8 bom.png/");
		ImageIcon imagebegin = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//begin.png/");
		ImageIcon imagebom = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//bom.png/");
		ImageIcon imageemptybox = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//empty box.png/");
		ImageIcon imagefalsebom = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//falsebom.png/");
		ImageIcon imageflag = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//flag.png/");
		ImageIcon imageiconnew = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//icon new.png/");
		ImageIcon imagelose = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//lose.png/");
		ImageIcon imageminesweeper = new ImageIcon(
				"C://Users//Admin//eclipse-workspace//mins//Image//minesweeper.png/");
		ImageIcon imagemistake = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//mistake.png/");
		ImageIcon imagewin = new ImageIcon("C://Users//Admin//eclipse-workspace//mins//Image//win.png/");
		imageList.add(image1);
		imageList.add(image2);
		imageList.add(image3);
		imageList.add(image4);
		imageList.add(image5);
		imageList.add(image6);
		imageList.add(image7);
		imageList.add(image8);
		imageList.add(imagebegin);
		imageList.add(imagebom);
		imageList.add(imageemptybox);
		imageList.add(imagefalsebom);
		imageList.add(imageiconnew);
		imageList.add(imagelose);
		imageList.add(imagefalsebom);
		imageList.add(imageminesweeper);
		imageList.add(imagemistake);
		imageList.add(imagewin);
		
	}
	public ImageIcon getIcon(int x) {
		return imageList.get(x);
	}
	public ArrayList<ImageIcon> getImageList() {
		return imageList;
		
	}
	
	public void setImageList(ArrayList<ImageIcon> imageList) {
		
		this.imageList = imageList;
	}
	private void paint(Graphics a) {
		// TODO Auto-generated method stub
		
	}

	
}
