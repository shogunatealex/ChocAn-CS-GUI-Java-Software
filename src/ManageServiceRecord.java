import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;

public class ManageServiceRecord extends JDialog implements ActionListener{
	private DefaultListModel results;
	
	private JButton OkButton;
	private JButton BackButton = null;
	private JTextField DateTextField;
	private JTextField CommentsTextField;
	private JTextField MemberNumberTextField;
	private JTextField ServiceCodeTextField;
	private JTextField TimeTextField;
	private JTextField ProviderNumberTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ManageServiceRecord dialog = new ManageServiceRecord();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManageServiceRecord() {
		Container window = getContentPane();
		setTitle("Manage Service Record Editor");
		setBounds(100, 100, 450, 300);
		window.setLayout(null);
		
		OkButton = new JButton("Ok");
		OkButton.addActionListener(this);
		OkButton.setBounds(381, 242, 89, 23);
		window.add(OkButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(480, 242, 89, 23);
		BackButton.addActionListener(this);
		window.add(BackButton);
		
	
		
		JLabel ServiceRecordsLabel = new JLabel("Service Records");
		ServiceRecordsLabel.setFont(new Font("Myriad Pro", Font.BOLD, 19));
		ServiceRecordsLabel.setBounds(227, 0, 226, 20);
		getContentPane().add(ServiceRecordsLabel);
		
		DateTextField = new JTextField();
		DateTextField.setBounds(95, 31, 142, 20);
		getContentPane().add(DateTextField);
		DateTextField.setColumns(10);
		
		CommentsTextField = new JTextField();
		CommentsTextField.setBounds(363, 31, 206, 69);
		getContentPane().add(CommentsTextField);
		CommentsTextField.setColumns(10);
		
		MemberNumberTextField = new JTextField();
		MemberNumberTextField.setBounds(95, 162, 142, 20);
		getContentPane().add(MemberNumberTextField);
		MemberNumberTextField.setColumns(10);
		
		ServiceCodeTextField = new JTextField();
		ServiceCodeTextField.setBounds(363, 117, 206, 20);
		getContentPane().add(ServiceCodeTextField);
		ServiceCodeTextField.setColumns(10);
		
		TimeTextField = new JTextField();
		TimeTextField.setBounds(95, 73, 142, 20);
		getContentPane().add(TimeTextField);
		TimeTextField.setColumns(10);
		
		ProviderNumberTextField = new JTextField();
		ProviderNumberTextField.setBounds(95, 117, 142, 20);
		getContentPane().add(ProviderNumberTextField);
		ProviderNumberTextField.setColumns(10);
		
		JLabel DateLabel = new JLabel("Date");
		DateLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		DateLabel.setForeground(UIManager.getColor("activeCaption"));
		DateLabel.setBounds(10, 34, 75, 14);
		getContentPane().add(DateLabel);
		
		JLabel TimeLabel = new JLabel("Time");
		TimeLabel.setForeground(UIManager.getColor("activeCaption"));
		TimeLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		TimeLabel.setBounds(10, 76, 75, 14);
		getContentPane().add(TimeLabel);
		
		JLabel ProviderNumberLabel = new JLabel("Provider Number");
		ProviderNumberLabel.setForeground(UIManager.getColor("activeCaption"));
		ProviderNumberLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		ProviderNumberLabel.setBounds(10, 120, 111, 14);
		getContentPane().add(ProviderNumberLabel);
		
		JLabel CommentsLabel = new JLabel("Comments");
		CommentsLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		CommentsLabel.setForeground(UIManager.getColor("activeCaption"));
		CommentsLabel.setBounds(284, 34, 68, 14);
		getContentPane().add(CommentsLabel);
		
		JLabel MemberLabel = new JLabel("Member Number");
		MemberLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		MemberLabel.setForeground(UIManager.getColor("activeCaption"));
		MemberLabel.setBounds(10, 165, 111, 14);
		getContentPane().add(MemberLabel);
		
		JLabel ServiceCodeLabel = new JLabel("Service Code");
		ServiceCodeLabel.setForeground(UIManager.getColor("activeCaption"));
		ServiceCodeLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		ServiceCodeLabel.setBounds(284, 120, 111, 14);
		getContentPane().add(ServiceCodeLabel);
		
	
		
		
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
