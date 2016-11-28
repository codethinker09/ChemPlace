package com.chemplace.view;

import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestToolTest extends JFrame{
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestToolTest frame = new TestToolTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

public TestToolTest(){
    Panel p=new Panel();
    final JButton b=new JButton("button");

    p.add(b);
    this.add(p);


    b.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent mEvt) {
       b.setToolTipText("lakshman");

    }

});
}
}