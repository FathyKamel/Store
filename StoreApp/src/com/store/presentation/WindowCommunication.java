package com.store.presentation;

import javax.swing.JFrame;



public class WindowCommunication {
	
	 private static void createAndShowUI() {
//	      JFrame frame = new JFrame("WindowCommunication");
//	      frame.getContentPane().add(new MyFramePanel());
//	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 SalesInvoice salesInvoice  = new SalesInvoice();
		 
		 salesInvoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 salesInvoice.pack();
		 salesInvoice.setLocationRelativeTo(null);
		 salesInvoice.setVisible(true);
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
