//Haylie Helmold


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class CardSimulator extends JDialog implements ActionListener {
	
	private JTextField cardNum;
	private JButton enterButton;
	private JButton cancelButton;
	private JLabel cardNumLabel = null;
	
	private boolean cancelled;

	public boolean isCancelled() {
		return cancelled;
	}
	
	public CardSimulator(JFrame owner, String title) {
		super(owner, title, true);
		init(owner);
	}
	
	public void init(JFrame owner){
		Container c = getContentPane();
		c.setLayout(null);
		
		cardNumLabel = new JLabel("Enter Card Number Below");
		cardNumLabel.setSize(200, 50);
		cardNumLabel.setForeground(Color.BLUE);
		cardNumLabel.setLocation(20, 20);
		c.add(cardNumLabel);
		
		// Implement Buttons
		enterButton = new JButton("Enter");
		enterButton.addActionListener(this);
		enterButton.setSize(150, 40);
		enterButton.setLocation(100, 510);
		c.add(enterButton);

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		cancelButton.setSize(150, 40);
		cancelButton.setLocation(350, 510);
		c.add(cancelButton);

		setSize(600, 600);
		setLocationRelativeTo(owner);
		setVisible(true);
		setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enterButton) {
			
		}
		
		else if (e.getSource() == cancelButton) {
			cancelled = true;
			setVisible(false);
		}
		
	}
	
	
}
