package graph_calc;

import javax.swing.*;
import java.awt.FlowLayout;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPanel windowContent = new JPanel();
		
//		FlowLayout f1 = new FlowLayout();
		GridLayout gr = new GridLayput(4,2);
		windowContent.setLayout(f1);
		
		JLabel label1 = new JLabel("Number 1:");
		JTextField field1 = new JTextField(10);
		JLabel label2 = new JLabel("Number 2:");
		JTextField field2 = new JTextField(10);
		JLabel label3 = new JLabel("Sum:");
		JTextField result = new JTextField(10);
		JButton go = new JButton("Add");
		
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(result);
		windowContent.add(go);
		
		JFrame frame = new JFrame("My Calculator");
		frame.setContentPane(windowContent);
		
		frame.setSize(400,100);
		frame.setVisible(true);
		
		
	}

}
