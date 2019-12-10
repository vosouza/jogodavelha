package tabuleiro;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class qadrado extends JPanel implements MouseListener{
	boolean vez = false;
	int[] pos;
	qadrado(){
		setSize(300,300);
		setVisible(true);
		pos = new int[9];
		for(int i=0;i<9;i++) {
			pos[i] = 3;
		}
	}
	
	protected void paintComponent(Graphics g) {		
		g.drawRect(0, 0, 300, 300);
		g.drawLine(100, 0, 100, 300);
		g.drawLine(200, 0, 200, 300);
		g.drawLine(0, 100, 300, 100);
		g.drawLine(0, 200, 300, 200);
		
		for(int i=0;i<9;i++) {
			if(pos[i] == 1){
				dx(g,i);
			}else if(pos[i] == 0){
				dc(g,i);
			}
		}

	}
	
	public void dx(Graphics g, int p) {
		int x = (p%3)*100;
		int y = (p/3)*100;
		g.drawLine(x, y, x + 100, y + 100);
		g.drawLine(x , y + 100 , x+100, y);
	}
	
	public void dc(Graphics g, int p) {
		int x = (p%3)*100 ;
		int y = (p/3)*100 ;
		g.drawOval(x, y, 100, 100);
	}
	
	public void atualizar(int x, int y,int val) {
		int i = 0;
		if((x>0 && x<100) && (y<100)) {
			i=1;
		}else if((x>0 && x<100) && (y>100 && y<200 )) {
			i=2;
		}else if((x>0 && x<100) && (y>200 && y<300 )) {
			i=3;
		}else if((x>100 && x<200) && ( y<100 )) {
			i=4;
		}else if((x>100 && x<200) && (y>100 && y<200 )) {
			i=5;
		}else if((x>100 && x<200) && (y>200 && y<300 )) {
			i=6;
		}else if((x>200 && x<300) && (y<100 )) {
			i=7;
		}else if((x>200 && x<300) && (y>100 && y<200 )) {
			i=8;
		}else if((x>200 && x<300) && (y>200 && y<300 )) {
			i=9;
		}
		pos[i] = val;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX()<300 && e.getY()<300) {
			if(vez) {
				atualizar(e.getX(),e.getY(),1);
			}else {
				atualizar(e.getX(),e.getY(),0);
			}
			vez = vez? false : true;
		}
		System.out.print(e.getX());
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
