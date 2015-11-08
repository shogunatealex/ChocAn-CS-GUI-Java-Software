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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ManageProviderRecord extends JDialog implements ActionListener{

	private DefaultListModel results;
	
	private JButton OkButton;
	private JButton BackButton = null;
	private JTextField NameTextField;
	private JTextField AddressTextField;
	private JTextField CityTextField;
	private JTextField StateTextField;
	private JTextField MemNumTextField;
	private JTextField ZipCodeTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ManageProviderRecord dialog = new ManageProviderRecord();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManageProviderRecord() {
		Container window = getContentPane();
		setTitle("Manage Provider Record Editor");
		setBounds(100, 100, 450, 300);
		window.setLayout(null);
		
		OkButton = new JButton("Ok");
		OkButton.addActionListener(this);
		OkButton.setBounds(284, 242, 89, 23);
		window.add(OkButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(383, 242, 89, 23);
		BackButton.addActionListener(this);
		window.add(BackButton);
		
	
		
		JLabel MemberRecordsLabel = new JLabel("Provider Records");
		MemberRecordsLabel.setBounds(21, 0, 100, 20);
		getContentPane().add(MemberRecordsLabel);
		
		NameTextField = new JTextField();
		NameTextField.setBounds(151, 31, 86, 20);
		getContentPane().add(NameTextField);
		NameTextField.setColumns(10);
		
		AddressTextField = new JTextField();
		AddressTextField.setBounds(363, 31, 142, 51);
		getContentPane().add(AddressTextField);
		AddressTextField.setColumns(10);
		
		CityTextField = new JTextField();
		CityTextField.setBounds(363, 104, 142, 20);
		getContentPane().add(CityTextField);
		CityTextField.setColumns(10);
		
		StateTextField = new JTextField();
		StateTextField.setBounds(363, 148, 62, 20);
		getContentPane().add(StateTextField);
		StateTextField.setColumns(10);
		
		MemNumTextField = new JTextField();
		MemNumTextField.setBounds(151, 73, 86, 20);
		getContentPane().add(MemNumTextField);
		MemNumTextField.setColumns(10);
		
		ZipCodeTextField = new JTextField();
		ZipCodeTextField.setBounds(151, 117, 86, 20);
		getContentPane().add(ZipCodeTextField);
		ZipCodeTextField.setColumns(10);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setBounds(10, 34, 46, 14);
		getContentPane().add(NameLabel);
		
		JLabel ProviderNumberLabel = new JLabel("Provider Number");
		ProviderNumberLabel.setBounds(10, 76, 111, 14);
		getContentPane().add(ProviderNumberLabel);
		
		JLabel ZipCodeLabel = new JLabel("ZipCode");
		ZipCodeLabel.setBounds(10, 120, 46, 14);
		getContentPane().add(ZipCodeLabel);
		
		JLabel AddressLabel = new JLabel("Address");
		AddressLabel.setBounds(305, 34, 46, 14);
		getContentPane().add(AddressLabel);
		
		JLabel CityLabel = new JLabel("City");
		CityLabel.setBounds(305, 107, 46, 14);
		getContentPane().add(CityLabel);
		
		JLabel StateLabel = new JLabel("State");
		StateLabel.setBounds(305, 151, 46, 14);
		getContentPane().add(StateLabel);
		
	
		
		
	    setSize( 595, 322 );
	    setLocation( 100, 100 );
	    setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BackButton){
			setVisible(false);
		}
		
	}
}
