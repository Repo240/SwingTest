package it.dv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JFrame3 extends JFrame implements ActionListener {
JLabel label;

public JFrame3() {
super("JFrame3");
setSize(300, 100);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
label = new JLabel("Label da modificare");
Color mioColore = new Color(250,0,250);
label.setBackground(mioColore);
label.setForeground(Color.blue);
//label.setBackground(Color.ORANGE);
label.setOpaque(true);


JButton button = new JButton("Modifica");
setLayout(new FlowLayout());
add(label);
add(button);
button.addActionListener(this);
}


public static void main(String[] args) {
JFrame3 frame = new JFrame3();
frame.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
label.setText("Label modificata");
}
}