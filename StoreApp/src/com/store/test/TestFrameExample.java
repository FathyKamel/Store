package com.store.test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TestFrameExample extends JFrame  implements ActionListener{
    static JLabel label ; 
    public static TestFrameExample test;
    TestFrameExample()
   {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      label = new JLabel("This is a label!");
      JButton button = new JButton("Open");
      button.setText("Press me");
      button.addActionListener(this);
      panel.add(label);
      panel.add(button);
      add(panel);
      setSize(300, 300);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
  }

   public void actionPerformed(ActionEvent a)
   {
          new TestFrameExample1();
  }
  public static void main(String s[]) {
      test=new TestFrameExample();
  }
}
