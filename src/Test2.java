import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test2 implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JTextField textfield = new JTextField(15);
	JLabel label = new JLabel();
	
	void initialize() {
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(300, 120);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		label.setText("Why did the chicken cross the road?");
		button1.setText("Submit");
		button2.setText("Hint");
		
		panel.add(label);
		panel.add(textfield);
		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
		
	}
	
	public static void main(String[] args) {
		
		Test2 asdf = new Test2();
		asdf.initialize();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 //TODO Auto-generated method stub
		if (e.getSource() == button1) {
			if (textfield.getText().equals("to get to the other side")) {
				JOptionPane.showMessageDialog(null, "Correct!");
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect!");
			}
		}
			
	
		if (e.getSource() == button2) {
			JOptionPane.showMessageDialog(null, "To get to the other ...");
		}
	}
}
