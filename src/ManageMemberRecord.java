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
import java.awt.Color;

public class ManageMemberRecord extends ManageRecordGUI implements ActionListener {


	private JTextField NameTextField;
	private JTextField MemNumTextField;

	
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
		
	
		
		JLabel MemberRecordsLabel = new JLabel("Member Records");
		MemberRecordsLabel.setFont(new Font("Myriad Pro", Font.BOLD, 19));
		MemberRecordsLabel.setBounds(278, 11, 207, 20);
		getContentPane().add(MemberRecordsLabel);
		

		MemNumTextField = new JTextField();
		MemNumTextField.setBounds(159, 103, 86, 20);
		getContentPane().add(MemNumTextField);
		MemNumTextField.setColumns(10);
		
		JRadioButton YesRadioButton = new JRadioButton("Yes");
		YesRadioButton.setBounds(80, 215, 62, 23);
		getContentPane().add(YesRadioButton);
		
		JRadioButton NoRadioButton = new JRadioButton("No");
		NoRadioButton.setBounds(161, 215, 62, 23);
		getContentPane().add(NoRadioButton);
		

		
		JLabel MemNumLabel = new JLabel("Member Number");
		MemNumLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		MemNumLabel.setForeground(new Color(0, 100, 0));
		MemNumLabel.setBounds(47, 107, 107, 14);
		getContentPane().add(MemNumLabel);
		
		JLabel ActiveLabel = new JLabel("Active");
		ActiveLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		ActiveLabel.setForeground(new Color(0, 100, 0));
		ActiveLabel.setBounds(47, 194, 46, 14);
		getContentPane().add(ActiveLabel);
		
	
		
		
	    setSize( 700, 340 );
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
