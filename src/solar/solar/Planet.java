package solar.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import solar.util.GameUtil;

public class Planet extends Star{
	//除了图片，坐标，还有行星沿着某个椭圆运行、长轴、短轴、角度、速度、绕着某个Star飞行。
	Star center;//绕行的中心
	double longAxis;//椭圆的长轴
	double shortAxis;//椭圆的短轴
	double speed;//飞行的速度
	double degree;
	boolean satellite;
	
	public void drawTrace(Graphics g){
		double ovalX,ovalY,ovalwidth,ovalheight;
		ovalX=center.x+center.width/2-longAxis+img.getWidth(null)/2;
		ovalY=center.y+center.height/2-shortAxis+img.getHeight(null)/2;
		ovalwidth=longAxis*2;
		ovalheight=shortAxis*2;
		
		Color c=g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX,(int)ovalY,(int)ovalwidth,(int)ovalheight);
		g.setColor(c);
	}
	 
	public void draw(Graphics g){
		super.draw(g);
		move();
		if(!satellite){
			drawTrace(g);
		}
		
	}
	
	public void move(){
		
		//沿着椭圆轨迹飞行
		x=center.x+center.width/2+longAxis*Math.cos(degree);
		y=center.y+center.height/2+shortAxis*Math.sin(degree);
		
		degree+=(2*speed/(longAxis+shortAxis));
		
		
	}
	
	

	public Planet(String imgpath,Star center, double longAxis,
			double shortAxis, double speed) {
		
		super(GameUtil.getImage(imgpath));//这样一调父类的构造器，width和height就都有了
		
		this.center = center;
		this.x=center.x+longAxis;
		this.y=center.y;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		
	}
	
	public Planet(String imgpath,Star center, double longAxis,
			double shortAxis, double speed,boolean satellite){
		this(imgpath, center, longAxis, shortAxis, speed);
		this.satellite=satellite;
	}

	public Planet(Image img,double x,double y){
		super(img,x,y);
	}
	
	public Planet(String imgpath,double x,double y){
		super(imgpath,x,y);
	}
}
