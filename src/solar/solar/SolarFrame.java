package solar.solar;
//太阳系的主窗口
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import solar.util.Constant;
import solar.util.GameUtil;
import solar.util.MyFrame;


public class SolarFrame extends MyFrame{
	
	Image bg=GameUtil.getImage("images/4.jpg");
	
	Star sun=new Star("images/1.png", Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);
	
	Planet earth=new Planet("images/2.png",sun,400,200,30);
	
	Planet mars=new Planet("images/1.png",sun,300,150,50);
	
	Planet tian=new Planet("images/1.png",sun,110,110,30);
	
	Planet moon=new Planet("images/1.png",earth,150,100,50,true);
	
	public void paint(Graphics g){
		
		
		g.drawImage(bg,0,0,null);
		sun.draw(g);
		earth.draw(g);
		mars.draw(g);
		tian.draw(g);
		moon.draw(g);
	
	}
	
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}