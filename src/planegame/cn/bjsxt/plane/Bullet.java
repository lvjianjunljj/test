package planegame.cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Graphics;

import planegame.cn.bjsxt.util.Constant;

public class Bullet extends GameObject {
	double degree;
	static int number=20;
	
	public Bullet(){
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_WIDTH/2;
		width = 5;
		height = 5;
	}
	
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed2*Math.cos(degree);
		y += speed2*Math.sin(degree);
		
		
		if(y>Constant.GAME_HEIGHT-height||y<30){
			degree = -degree;
		}
		
		if(x<0||x>Constant.GAME_WIDTH-width){
			degree = Math.PI-degree;
		}
		
		
		g.setColor(c);
	}
	
}
