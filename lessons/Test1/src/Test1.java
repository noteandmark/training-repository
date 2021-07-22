import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test1 {

	int x = 20;
	int y = 20;
	
	JFrame frame;
	JButton button;
	
	public static void main(String[] args) {
		Test1 gui = new Test1();
		gui.go();
	}
		
		public void go() {
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			MyDrawPanel drawPanel = new MyDrawPanel();
			
			button = new JButton("click me");
			button.addActionListener((ActionListener) new ButtonListener());
			
			frame.getContentPane().add(BorderLayout.EAST,button);
			frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
			
			frame.setSize(300,300);
			frame.setVisible(true);
			
			for (int i = 0; i < 130; i++) {
				x++;
				y++;
				drawPanel.repaint();
				try {
					Thread.sleep(50);
				} catch(Exception ex) {}
			}
		}
		
		class MyDrawPanel extends JPanel {
			public void paintComponent(Graphics g) {
				g.setColor(Color.black);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				g.setColor(Color.green);
				g.fillOval(x, y, 40, 40);
			}
		}
		
		class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				button.setText("I've been clicked!");
			}
		}

}