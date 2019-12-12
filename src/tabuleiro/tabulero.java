package tabuleiro;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class tabulero extends JFrame{
	
	boolean vez = false;
	
	tabulero(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(303,350);
		setTitle("Tabulero");
		qadrado q = new qadrado();
		q.addMouseListener(q);
		add(q, BorderLayout.CENTER);
		setVisible(true);
	}
	
}
