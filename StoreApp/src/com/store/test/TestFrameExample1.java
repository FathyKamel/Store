package com.store.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


class TestFrameExample1 extends JFrame  implements ActionListener {
  JTextField t;
  TestFrameExample test;
  public TestFrameExample1()
  {
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        t=new JTextField();
        t.setBounds(100,20,150,20);
        JButton button=new JButton("oK");
        button.setBounds(100,50,100,30);
        button.addActionListener(this);
        add(t);
        add(button);
    }
    public void actionPerformed(ActionEvent a)
   {
    	test.label.setText(t.getText());
   }
  }
