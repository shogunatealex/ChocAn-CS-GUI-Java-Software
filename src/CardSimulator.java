//Haylie Helmold

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class CardSimulator extends JFrame implements ActionListener {

	private JTextField cardNum;
	private JButton enterButton;
	private JButton cancelButton;
	private JLabel cardNumLabel = null;
	private Font font = new Font("Times New Roman", Font.PLAIN, 20);

	private boolean cancelled;

	public boolean isCancelled() {
		return cancelled;
	}

	public CardSimulator() {
		super("Card Swipe Simulator");

		Container c = getContentPane();
		c.setLayout(null);

		cardNumLabel = new JLabel("Enter Card Number Below");
		cardNumLabel.setSize(215, 50);
		cardNumLabel.setForeground(Color.BLUE);
		cardNumLabel.setLocation(90, 20);
		cardNumLabel.setFont(font);
		c.add(cardNumLabel);

		// Implement Buttons
		enterButton = new JButton("Enter");
		enterButton.addActionListener(this);
		enterButton.setSize(100, 40);
		enterButton.setLocation(75, 150);
		c.add(enterButton);

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		cancelButton.setSize(100, 40);
		cancelButton.setLocation(225, 150);
		c.add(cancelButton);

		// TextField
		cardNum = new JTextField(" ");
		cardNum.addActionListener(this);
		cardNum.setSize(200, 30);
		cardNum.setLocation(100, 85);
		c.add(cardNum);

		setSize(400, 250);
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
