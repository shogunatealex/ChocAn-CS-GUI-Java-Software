import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class ManageMemberRecord extends JDialog implements ActionListener {
	private DefaultListModel results;
	
	private JButton AddButton = null;
	private JButton OkButton;
	private JButton DeleteButton = null;
	private JButton EditButton = null;
	private JButton BackButton = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	/**
	 * Launch the application.
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

	/**
	 * Create the dialog.
	 */
	public ManageMemberRecord() {
		Container window = getContentPane();
		setTitle("Manage Member Record Editor");
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
		
		results = new DefaultListModel();
		Font font = new Font("Courier", Font.BOLD,  12);
	
		
		JLabel MemberRecordsLabel = new JLabel("Provider Records");
		MemberRecordsLabel.setBounds(21, 0, 100, 20);
		getContentPane().add(MemberRecordsLabel);
		
		textField = new JTextField();
		textField.setBounds(97, 31, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(313, 31, 142, 51);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(313, 104, 142, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(313, 148, 62, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(97, 73, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
		rdbtnNewRadioButton.setBounds(40, 200, 62, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.setBounds(121, 200, 62, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(97, 117, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setBounds(10, 34, 46, 14);
		getContentPane().add(NameLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Member Number");
		lblNewLabel_1.setBounds(10, 76, 89, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ZipCode");
		lblNewLabel_2.setBounds(10, 120, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(255, 34, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("City");
		lblNewLabel_4.setBounds(257, 107, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("State");
		lblNewLabel_5.setBounds(255, 151, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("Active");
		lblNewLabel.setBounds(10, 166, 46, 14);
		getContentPane().add(lblNewLabel);
		
	
		
		
	    setSize( 500, 310 );
	    setLocation( 100, 100 );
	    setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BackButton){
			setVisible(false);
		}
		
	}
}
