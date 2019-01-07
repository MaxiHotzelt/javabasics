package com.empirie.aufgaben.basics.tests;

import java.awt.event.*;  
import javax.swing.*;    
public class Test {  
	public static void main(String[] args) {  
		
	    JFrame f = new JFrame("Button Example");  
	    final JTextField tf = new JTextField();  
	    tf.setBounds(50,50, 150,20);  
	    JButton b = new JButton("Click Here");  
	    b.setBounds(50,100,95,30);  
	    b.addActionListener(e -> {
	    	tf.setText("Welcome to Javatpoint.");
	    });
	    f.add(b);
	    f.add(tf);  
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
	
	public static void actionPerformed(){  
    }
}  
