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


	private JTextField MemNumTextField;
	private JRadioButton YesRadioButton;
	private JRadioButton NoRadioButton;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MemberRecordGUI dialog = new MemberRecordGUI();
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
		super.buildPane();
		setTitle("Manage Member Record Editor");
		
		JLabel MemberRecordsLabel = new JLabel("Member Records");
		MemberRecordsLabel.setFont(new Font("Myriad Pro", Font.BOLD, 19));
		MemberRecordsLabel.setBounds(278, 11, 207, 20);
		window.add(MemberRecordsLabel);
		

		MemNumTextField = new JTextField();
		MemNumTextField.setBounds(159, 103, 86, 20);
		window.add(MemNumTextField);
		MemNumTextField.setColumns(10);
		
		YesRadioButton = new JRadioButton("Yes");
		YesRadioButton.setBounds(80, 215, 62, 23);
		window.add(YesRadioButton);
		
		NoRadioButton = new JRadioButton("No");
		NoRadioButton.setBounds(161, 215, 62, 23);
		window.add(NoRadioButton);
		

		
		JLabel MemNumLabel = new JLabel("Member Number");
		MemNumLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		MemNumLabel.setForeground(new Color(0, 100, 0));
		MemNumLabel.setBounds(47, 107, 107, 14);
		window.add(MemNumLabel);
		
		JLabel ActiveLabel = new JLabel("Active");
		ActiveLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		ActiveLabel.setForeground(new Color(0, 100, 0));
		ActiveLabel.setBounds(47, 194, 46, 14);
		window.add(ActiveLabel);
		
	
	    setVisible(true);
	}
	public boolean getActive(){
		if (YesRadioButton.isSelected()){
			///return "Active";
			return true;
		}
		else
		{
			//return "Suspended";
			return false;
		}
	}
	public int getMemberNumber(){ 
		return Integer.parseInt(MemNumTextField.getText());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BackButton){
			setVisible(false);
		}
		else if (e.getSource() == OkButton){
			setVisible(false);
		}
		
	}
}
