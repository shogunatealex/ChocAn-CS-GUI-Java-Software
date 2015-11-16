import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;

/**
 * @author Alex Anderson
 * Allow for adding, editing, and deleting provider records.
 * Displays provider records.
 *
 */
public abstract class ManageRecordGUI extends JDialog implements ActionListener {

	protected JButton OkButton;
	protected JButton BackButton = null;
	protected JTextField NameTextField;
	protected JTextField CityTextField;
	protected JTextField StateTextField;
	protected JTextField ZipCodeTextField;
	protected JTextArea AddressTextField;
	protected JDialog Owner;
	protected Container window;
	protected boolean Cancel = true;
	/**
	 * Used primarily for testing/ independent launching
	 */
	public static void main(String[] args) {
		try {
			ProviderRecordGUI dialog = new ProviderRecordGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/*
 * @return canceled if canceled.	
 */
	public boolean isCanceled(){
		return Cancel;
	}
	/*
	 * Display contents.
	 */
	public void buildPane() {

		window = getContentPane();
		setTitle("Manage Record Editor");
		setBounds(100, 100, 450, 300);
		window.setLayout(null);
		setModal(true);
		
		OkButton = new JButton("Ok");
		OkButton.addActionListener(this);
		OkButton.setBounds(429, 257, 114, 33);
		window.add(OkButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(560, 257, 114, 33);
		BackButton.addActionListener(this);
		window.add(BackButton);
		
		NameTextField = new JTextField("");
		NameTextField.setBounds(159, 62, 86, 20);
		getContentPane().add(NameTextField);
		NameTextField.setColumns(10);
		
		CityTextField = new JTextField("");
		CityTextField.setBounds(457, 135, 142, 20);
		getContentPane().add(CityTextField);
		CityTextField.setColumns(10);
		
		StateTextField = new JTextField("");
		StateTextField.setBounds(457, 179, 62, 20);
		getContentPane().add(StateTextField);
		StateTextField.setColumns(10);
		
		ZipCodeTextField = new JTextField("");
		ZipCodeTextField.setBounds(159, 148, 86, 20);
		getContentPane().add(ZipCodeTextField);
		ZipCodeTextField.setColumns(10);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		NameLabel.setForeground(new Color(0, 100, 0));
		NameLabel.setBounds(45, 65, 104, 14);
		getContentPane().add(NameLabel);
		
		JLabel ZipcodeLabel = new JLabel("ZipCode");
		ZipcodeLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		ZipcodeLabel.setForeground(new Color(0, 100, 0));
		ZipcodeLabel.setBounds(45, 151, 104, 14);
		getContentPane().add(ZipcodeLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		lblNewLabel_3.setForeground(new Color(0, 100, 0));
		lblNewLabel_3.setBounds(331, 65, 116, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("City");
		lblNewLabel_4.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		lblNewLabel_4.setForeground(new Color(0, 100, 0));
		lblNewLabel_4.setBounds(333, 138, 114, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("State");
		lblNewLabel_5.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		lblNewLabel_5.setForeground(new Color(0, 100, 0));
		lblNewLabel_5.setBounds(331, 182, 116, 14);
		getContentPane().add(lblNewLabel_5);
		
		AddressTextField = new JTextArea();
		AddressTextField.setBackground(Color.WHITE);
		AddressTextField.setBounds(457, 42, 149, 69);
		AddressTextField.setLineWrap(true);
		getContentPane().add(AddressTextField);
		
	
		
		
	    setSize( 700, 340 );
	    setLocation( 100, 100 );
	}
/*
 * (non-Javadoc)
 * @see java.awt.Component#getName()
 * @return name
 */
	public String getName(){
		return NameTextField.getText();
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.Component#getName()
	 * @return city
	 */
	public String getCity(){
		return CityTextField.getText();
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.Component#getName()
	 * @return state
	 */
	public String getState(){
		return StateTextField.getText();
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.Component#getName()
	 * @return zipCode
	 */
	public int getZipCode(){
		return Integer.parseInt(ZipCodeTextField.getText());
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.Component#getName()
	 * @return address
	 */
	public String getAddress(){
		return AddressTextField.getText();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		
	}
}
