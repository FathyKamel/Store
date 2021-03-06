package com.store.test;

import javax.swing.JFrame;

public class WindowCommunication {
	 private static void createAndShowUI() {
	      JFrame frame = new JFrame("WindowCommunication");
	      frame.getContentPane().add(new MyFramePanel());
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.pack();
	      frame.setLocationRelativeTo(null);
	      frame.setVisible(true);
	   }

	   // let's be sure to start Swing on the Swing event thread
	   public static void main(String[] args) {
	      java.awt.EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            createAndShowUI();
	         }
	      });
	   }
	}