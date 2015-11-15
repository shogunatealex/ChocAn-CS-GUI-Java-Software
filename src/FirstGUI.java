
//Haylie Helmold
//Haylie Helmold

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class FirstGUI extends JFrame implements ActionListener {

	private JButton pButton;
	private JButton oButton;
	private JButton mButton;
	private JLabel ChocAn1 = null;
	private JLabel ChocAn2 = null;
	public static MemberRecordCollection MRC = new MemberRecordCollection("MemberRecords.txt");
	public static ProviderRecordCollection PRC = new ProviderRecordCollection("ProviderRecords.txt");
	public static ServiceRecordCollection SRC = new ServiceRecordCollection("ServiceRecords.txt");
	public static ProviderDirectoryCollection PDC = new ProviderDirectoryCollection("ProviderDirectory.txt");
	public static int providerNumber;

	private Font font = new Font("Cooper Black", Font.PLAIN, 40);

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
		pButton = new JButton("Provider");
		pButton.addActionListener(this);
		pButton.setSize(200, 100);
		pButton.setLocation(100, 150);
		c.add(pButton);
		
		// Operator Button
		oButton = new JButton("Operator");
		oButton.addActionListener(this);
		oButton.setSize(200, 100);
		oButton.setLocation(100, 300);
		c.add(oButton);
		
		// Manager Button
		mButton = new JButton("Manager");
		mButton.addActionListener(this);
		mButton.setSize(200, 100);
		mButton.setLocation(100, 450);
		c.add(mButton);

		//screen size
		setSize(400, 600);
		setVisible(true);
		setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pButton) {
			providerNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter Provider Number"));

			while(true){
				if (PRC.isProvider(providerNumber)){
					MainGUI providerActions = new MainGUI();
					providerActions.MainMenu.setVisible(true);
					return;
				}
				else{
					JOptionPane.showMessageDialog(this, "Not a valid Provider Number");
					providerNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter Provider Number"));
				}
			}



		}
		else if (e.getSource() == oButton) {
			RecordTypeGUI operatorActions = new RecordTypeGUI();
			operatorActions.setVisible(true);
		}
		else if (e.getSource() == mButton){
			MainGUI managerActions = new MainGUI();
			managerActions.MainMenu.setVisible(true);
		}
	}

	public static void main(String[] args) {
		FirstGUI titleScreen = new FirstGUI();
		titleScreen.setVisible(true);
	}

}
