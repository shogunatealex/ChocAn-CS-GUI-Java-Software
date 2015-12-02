
//Haylie Helmold

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 * If valid member number, create new service record otherwise displays
 * "Invalid Member Number"
 * 
 * @author Haylie Helmold
 *
 */

public class CardSimulator extends JFrame implements ActionListener {

	private JTextField cardNum;
	private JButton enterButton;
	private JButton cancelButton;
	private JLabel cardNumLabel = null;
	private int readCardNumber;

	private Font font = new Font("Times New Roman", Font.PLAIN, 20);

	private boolean cancelled;

	/**
	 * 
	 * @return cancelled if canceled
	 */
	public boolean isCancelled() {
		return cancelled;
	}

	/**
	 * 
	 * @return cardNumber
	 */
	public String getCardNum() {
		return this.cardNum.getText();
	}

	/**
	 * Initialize CardSimulator to intake card/member number
	 */
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
		cardNum = new JTextField("");
		cardNum.addActionListener(this);
		cardNum.setSize(200, 30);
		cardNum.setLocation(100, 85);
		c.add(cardNum);

		setSize(400, 250);
		setVisible(true);
		setResizable(false);

	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 *      If Enter button selected, checks validity of member number If valid,
	 *      create a new service record If not valid, displays error message,
	 *      prompts new member number entered
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enterButton) {
			this.readCardNumber = Integer.parseInt(cardNum.getText());

			if (ChocAnSystem.MRC.isCardValid(readCardNumber)) {
				if (ChocAnSystem.MRC.isCardSuspended(readCardNumber)){
					JOptionPane.showMessageDialog(this, "Card Suspended");
				}
				else{
					CreateServiceRecordGUI CSR = new CreateServiceRecordGUI(readCardNumber);
				}

			} else { // Invalid card number
				JOptionPane.showMessageDialog(this, "Invalid Member Number");
			}
		} else if (e.getSource() == cancelButton) {
			cancelled = true;
			setVisible(false);
		}
	}
}
