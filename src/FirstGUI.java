
//Haylie Helmold
//Haylie Helmold

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Haylie Helmold Holds collections of the different records. Allows for
 *         selection of which type of employee is accessing records, provider,
 *         operator, or manager.
 *         Launches entire program.
 *
 */
public class FirstGUI extends JFrame implements ActionListener {

	private JButton providerButton;
	private JButton operatorButton;
	private JButton managerButton;
	private JLabel ChocAn1 = null;
	private JLabel ChocAn2 = null;
	public static MemberRecordCollection MRC = new MemberRecordCollection("MemberRecords.txt");
	public static ProviderRecordCollection PRC = new ProviderRecordCollection("ProviderRecords.txt");
	public static ServiceRecordCollection SRC = new ServiceRecordCollection("ServiceRecords.txt");
	public static ProviderDirectoryCollection PDC = new ProviderDirectoryCollection("ProviderDirectory.txt");
	public static int providerNumber;

	private Font font = new Font("Cooper Black", Font.PLAIN, 40);

	/**
	 * Display options for type of employee accessing terminal.
	 */
	public FirstGUI() {
		super("Welcome to Chocoholics Anonymous!");

		Container c = getContentPane();
		c.setLayout(null);

		// Chocoholics
		ChocAn1 = new JLabel("Chocoholics");
		ChocAn1.setSize(275, 50);
		ChocAn1.setForeground(Color.BLACK);
		ChocAn1.setLocation(70, 20);
		ChocAn1.setFont(font);
		c.add(ChocAn1);

		// Anonymous
		ChocAn2 = new JLabel("Anonymous");
		ChocAn2.setSize(275, 50);
		ChocAn2.setForeground(Color.BLACK);
		ChocAn2.setLocation(70, 60);
		ChocAn2.setFont(font);
		c.add(ChocAn2);

		// Provider Button
		providerButton = new JButton("Provider");
		providerButton.addActionListener(this);
		providerButton.setSize(200, 100);
		providerButton.setLocation(100, 150);
		c.add(providerButton);

		// Operator Button
		operatorButton = new JButton("Operator");
		operatorButton.addActionListener(this);
		operatorButton.setSize(200, 100);
		operatorButton.setLocation(100, 300);
		c.add(operatorButton);

		// Manager Button
		managerButton = new JButton("Manager");
		managerButton.addActionListener(this);
		managerButton.setSize(200, 100);
		managerButton.setLocation(100, 450);
		c.add(managerButton);

		// screen size
		setSize(400, 600);
		setVisible(true);
		setResizable(false);

	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 *      If provider selected, prompt for provider number. If operator,
	 *      display operator options. If manager, display manager options.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == providerButton) {
			try {
				providerNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter Provider Number"));

				while (true) {
					if (PRC.isProvider(providerNumber)) {
						MainGUI providerActions = new MainGUI();
						providerActions.MainMenu.setVisible(true);
						return;
					} else {
						JOptionPane.showMessageDialog(this, "Not a valid Provider Number");
						providerNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter Provider Number"));
					}
				}
			} catch (NumberFormatException e1) {
			}
		} else if (e.getSource() == operatorButton) {
			RecordTypeGUI operatorActions = new RecordTypeGUI();
			operatorActions.setVisible(true);
		} else if (e.getSource() == managerButton) {
			MainGUI managerActions = new MainGUI();
			managerActions.MainMenu.setVisible(true);
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FirstGUI titleScreen = new FirstGUI();
		titleScreen.setVisible(true);
	}
}
