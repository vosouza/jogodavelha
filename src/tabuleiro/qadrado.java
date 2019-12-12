package tabuleiro;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;
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
		int i = 9;
		if((y>0 && y<100) && (x<100)) {
			i=0;
		}else if((y>0 && y<100) && (x>100 && x<200 )) {
			i=1;
		}else if((y>0 && y<100) && (x>200 && x<300 )) {
			i=2;
		}else if((y>100 && y<200) && ( x<100 )) {
			i=3;
		}else if((y>100 && y<200) && (x>100 && x<200 )) {
			i=4;
		}else if((y>100 && y<200) && (x>200 && x<300 )) {
			i=5;
		}else if((y>200 && y<300) && (x<100 )) {
			i=6;
		}else if((y>200 && y<300) && (x>100 && x<200 )) {
			i=7;
		}else if((y>200 && y<300) && (x>200 && x<300 )) {
			i=8;
		}
		
		if(pos[i] == 3)pos[i] = val;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX()<300 && e.getY()<300) {
			if(vez) {
				atualizar(e.getX(),e.getY(),1);
			}else {
				atualizar(e.getX(),e.getY(),0);
			}
			repaint();
			vez = vez? false : true;
			try {
				verificar();
			} catch (IOException e1) {
				String j = (vez)? " O" : " X";
				JOptionPane.showMessageDialog(this ,e1 + j);
			}
		}
		
	}

	private void verificar() throws IOException{
		boolean g = false;
		if(pos[0] == pos[1] && pos[1] == pos[2]) {
			if(pos[0] != 3 && pos[1] != 3 && pos[2] != 3) {
				g = true;
			}
		}else if(pos[3] == pos[4] && pos[4] == pos[5]) {
			if(pos[3] != 3 && pos[4] != 3 && pos[5] != 3) {
				g = true;
			}
		}else if(pos[6] == pos[7] && pos[7]  == pos[8]) {
			if(pos[6] != 3 && pos[7] != 3 && pos[8] != 3) {
				g = true;
			}
		}else if(pos[0] == pos[3] && pos[3]  == pos[6]) {
			if(pos[0] != 3 && pos[3] != 3 && pos[6] != 3) {
				g = true;
			}
		}else if(pos[1] == pos[4] && pos[4]  == pos[7]) {
			if(pos[1] != 3 && pos[4] != 3 && pos[7] != 3) {
				g = true;
			}
		}else if(pos[2] == pos[5] && pos[5]  == pos[8]) {
			if(pos[2] != 3 && pos[5] != 3 && pos[8] != 3) {
				g = true;
			}
		}else if(pos[0] == pos[4] && pos[4]  == pos[8]) {
			if(pos[0] != 3 && pos[4] != 3 && pos[8] != 3) {
				g = true;
			}
		}else if(pos[2] == pos[4] && pos[4]  == pos[6]) {
			if(pos[2] != 3 && pos[4] != 3 && pos[6] != 3) {
				g = true;
			}
		}
		
		if(g) throw new IOException("Ganhou arrombado");
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
