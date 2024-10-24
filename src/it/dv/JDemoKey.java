package it.dv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JDemoKey extends JFrame {
	private JLabel prompt = new JLabel("Scrivere qualcosa:");
	private JLabel outputLabel = new JLabel();
	private JTextField textField = new JTextField(10);

	public JDemoKey() {
		setTitle("KeyTyped");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(prompt, BorderLayout.NORTH);
		add(textField, BorderLayout.CENTER);
		add(outputLabel, BorderLayout.SOUTH);
		MyKeyAdapter adapter = new MyKeyAdapter();
		textField.addKeyListener(adapter);
	}

	public static void main(String[] args) {
		JDemoKey keyFrame = new JDemoKey();
		keyFrame.setSize(250, 100);
		keyFrame.setVisible(true);
	}

	class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			outputLabel.setText("Ultimo tasto premuto: " + c);
		}
	}
}