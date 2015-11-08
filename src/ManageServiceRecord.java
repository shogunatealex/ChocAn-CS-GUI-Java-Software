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
import java.awt.Color;

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
		ServiceRecordsLabel.setBounds(227, 11, 226, 20);
		getContentPane().add(ServiceRecordsLabel);
		
		DateTextField = new JTextField();
		DateTextField.setBounds(106, 42, 142, 20);
		getContentPane().add(DateTextField);
		DateTextField.setColumns(10);
		
		CommentsTextField = new JTextField();
		CommentsTextField.setBounds(363, 42, 206, 69);
		getContentPane().add(CommentsTextField);
		CommentsTextField.setColumns(10);
		
		MemberNumberTextField = new JTextField();
		MemberNumberTextField.setBounds(106, 203, 142, 20);
		getContentPane().add(MemberNumberTextField);
		MemberNumberTextField.setColumns(10);
		
		ServiceCodeTextField = new JTextField();
		ServiceCodeTextField.setBounds(363, 168, 206, 20);
		getContentPane().add(ServiceCodeTextField);
		ServiceCodeTextField.setColumns(10);
		
		TimeTextField = new JTextField();
		TimeTextField.setBounds(106, 91, 142, 20);
		getContentPane().add(TimeTextField);
		TimeTextField.setColumns(10);
		
		ProviderNumberTextField = new JTextField();
		ProviderNumberTextField.setBounds(106, 145, 142, 20);
		getContentPane().add(ProviderNumberTextField);
		ProviderNumberTextField.setColumns(10);
		
		JLabel DateLabel = new JLabel("Date");
		DateLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		DateLabel.setForeground(new Color(0, 100, 0));
		DateLabel.setBounds(21, 46, 75, 14);
		getContentPane().add(DateLabel);
		
		JLabel TimeLabel = new JLabel("Time");
		TimeLabel.setForeground(new Color(0, 128, 0));
		TimeLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		TimeLabel.setBounds(21, 97, 75, 14);
		getContentPane().add(TimeLabel);
		
		JLabel ProviderNumberLabel = new JLabel("Provider Number");
		ProviderNumberLabel.setForeground(new Color(0, 128, 0));
		ProviderNumberLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		ProviderNumberLabel.setBounds(21, 149, 111, 14);
		getContentPane().add(ProviderNumberLabel);
		
		JLabel CommentsLabel = new JLabel("Comments");
		CommentsLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		CommentsLabel.setForeground(new Color(0, 128, 0));
		CommentsLabel.setBounds(284, 70, 68, 14);
		getContentPane().add(CommentsLabel);
		
		JLabel MemberLabel = new JLabel("Member Number");
		MemberLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		MemberLabel.setForeground(new Color(0, 128, 0));
		MemberLabel.setBounds(21, 207, 111, 14);
		getContentPane().add(MemberLabel);
		
		JLabel ServiceCodeLabel = new JLabel("Service Code");
		ServiceCodeLabel.setForeground(new Color(0, 128, 0));
		ServiceCodeLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		ServiceCodeLabel.setBounds(284, 172, 111, 14);
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
