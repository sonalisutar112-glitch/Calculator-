package com.gain.java.knowledge;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorApp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	static JFrame frame;
	static JTextField textfield;
	String first, second, operator;

	CalculatorApp() {
		first = second = operator = "";
	}

	public static void main(String[] args) {
		frame = new JFrame("Calculator");
		CalculatorApp calculator = new CalculatorApp();

		textfield = new JTextField(16);
		textfield.setEditable(false);

		// Create buttons
		JButton btn0 = new JButton("0");
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");
		JButton btn7 = new JButton("7");
		JButton btn8 = new JButton("8");
		JButton btn9 = new JButton("9");
		JButton btnAdd = new JButton("+");
		JButton btnSub = new JButton("-");
		JButton btnMul = new JButton("*");
		JButton btnDiv = new JButton("/");
		JButton btnDot = new JButton(".");
		JButton btnClr = new JButton("C");
		JButton btnEq = new JButton("=");

		// Add ActionListeners
		JButton[] buttons = { btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
				btnAdd, btnSub, btnMul, btnDiv, btnDot, btnClr, btnEq };
		for (JButton b : buttons) {
			b.addActionListener(calculator);
		}

		// Add components to panel
		JPanel panel = new JPanel();
		panel.add(textfield);
		panel.add(btn7);
		panel.add(btn8);
		panel.add(btn9);
		panel.add(btnDiv);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(btnMul);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btnSub);
		panel.add(btnDot);
		panel.add(btn0);
		panel.add(btnEq);
		panel.add(btnAdd);
		panel.add(btnClr);

		panel.setBackground(Color.lightGray);
		panel.setLayout(new GridLayout(5, 4, 5, 5));
		frame.add(panel);
		frame.setSize(250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		if ((action.charAt(0) >= '0' && action.charAt(0) <= '9') || action.equals(".")) {
			if (!operator.equals("")) {
				second += action;
			} else {
				first += action;
			}
			textfield.setText(first + operator + second);
		} else if (action.equals("C")) {
			first = second = operator = "";
			textfield.setText("");
		} else if (action.equals("=")) {
			double result = 0;
			if (!first.equals("") && !second.equals("")) {
				double a = Double.parseDouble(first);
				double b = Double.parseDouble(second);
				switch (operator) {
					case "+":
						result = a + b;
						break;
					case "-":
						result = a - b;
						break;
					case "*":
						result = a * b;
						break;
					case "/":
						if (b != 0)
							result = a / b;
						else
							textfield.setText("Error");
						break;
				}
				first = Double.toString(result);
				operator = "";
				second = "";
				textfield.setText(first);
			}
		} else {
			if (!first.equals("") && second.equals("")) {
				operator = action;
				textfield.setText(first + operator);
			}
		}
	}
}