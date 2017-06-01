package solar.solar;

import java.awt.Graphics;
import java.awt.Image;

import solar.util.GameUtil;

public class Star {
	Image img;
	double x,y;
	
	int width,height;
	
	
	public void draw(Graphics g){
		g.drawImage(img,(int)x,(int)y,null);
	}
	
	//写构造器
	public Star(){//需要加一个空构造器   子类继承的时候不会报错
	}
	
	public Star(Image img){
		this.img=img;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
	}
	
	public Star(Image img,double x,double y){
		this(img);//调上边的方法
		this.x=x;
		this.y=y;
		
		
	}
	
	public Star(String imgpath,double x,double y){
		this(GameUtil.getImage(imgpath),x,y);           //通过this调用另一个构造方法
		
		
	}
}
