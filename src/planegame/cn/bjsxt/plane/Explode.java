package planegame.cn.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;

import planegame.cn.bjsxt.util.GameUtil;

public class Explode {
	double x,y;
	static Image[] imgs = new Image[16];
	static {
		for(int i=0;i<16;i++){
			imgs[i] = GameUtil.getImage("planegame/images/explode/e"+(i+1)+".gif");//可以如此调用图片
			imgs[i].getWidth(null);//通过调用这个方法可以真实地把images图片加载进来
		}
	}
	
	int count;
	
	public void draw(Graphics g){
		if(count<=15){
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}
	
	public Explode(double x,double y){
		this.x = x;
		this.y = y;
	}
}
