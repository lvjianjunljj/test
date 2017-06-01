package planegame.cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import planegame.cn.bjsxt.util.Constant;
import planegame.cn.bjsxt.util.GameUtil;
import planegame.cn.bjsxt.util.MyFrame;

public class PlaneGameFrame extends MyFrame {
	Image bg = GameUtil.getImage("planegame/images/bg.jpg");
	Plane p = new Plane("planegame/images/plane.png",50,50);
	ArrayList  bulletList = new ArrayList();   //定义一个容器放子弹（泛型暂时没学）
	
	Date startTime;
	Date endTime;
	
	Explode bao;
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		for(int i=0;i<bulletList.size();i++){
			Bullet b = (Bullet) bulletList.get(i);
			b.draw(g);
			boolean peng = b.getRect().intersects(p.getRect());//判断两个矩形有没有相交的
			if(peng){
				p.setLive(false);  //飞机死掉
				if(bao==null){
					endTime = new Date();//定义结束时间
					bao = new Explode(p.x,p.y);
				}
				bao.draw(g);
				
				break;
			}
		}
		
		if(!p.isLive()){
			int period = (int)((endTime.getTime()-startTime.getTime())/1000);//计算存活时间
			printInfo(g, "存活了"+period+"秒", 20, 120, 260, Color.white);//在g的位置输出文字
			
			switch (period/10) {
			case 0:
			case 1:
				printInfo(g, "一般", 50,100,200,Color.white);
				break;
			case 2:
				printInfo(g, "还行", 50,100,200,Color.white);
				break;
			case 3:
				printInfo(g, "很好", 50,100,200,Color.yellow);
				break;
			case 4:
				printInfo(g, "非常好", 50,100,200,Color.yellow);
				break;
			default:
				printInfo(g, "不可思议", 50,100,200,Color.yellow);
				break;
			}
			
			
		}
		
	}
	
	
	
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color){
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("黑体",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str,x,y);
		g.setColor(c);

	}
	
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	
	public void launchFrame(){
		super.launchFrame();//launchFrame的其他方法也要执行
		//增加键盘的监听
		addKeyListener(new KeyMonitor());
		
		//生成一堆子弹
		for(int i=0;i<Bullet.number;i++){
			Bullet b = new Bullet();
			bulletList.add(b);//放到容器中
		}
		
		startTime = new Date();//定义开始时间
	}
	
	
	//定义内部类，可以方便使用外部类的属性   定义完了以后一定要注册一下才能使用（往launchFrame里注册  重写父类launchFrame方法）
	class KeyMonitor extends KeyAdapter {//键盘控制

		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("按下"+e.getKeyCode());
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.println("抬起"+e.getKeyCode());
			p.minusDirection(e);
		}
		
	}
	
	
	
}
