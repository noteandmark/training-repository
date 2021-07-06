import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

public class Test1 implements ActionListener {

	JButton button;
	
	public static void main(String[] args) {
		Test1 gui = new Test1();
		gui.go();
	}
		
		public void go() {
			JFrame frame = new JFrame();
			JButton button = new JButton("click me");	
			button.addActionListener(this);
			frame.getContentPane().add(BorderLayout.EAST,button);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(300,300);
			frame.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent event) throws NullPointerException {
			try {
				button.setText("I've been clicked!");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
}