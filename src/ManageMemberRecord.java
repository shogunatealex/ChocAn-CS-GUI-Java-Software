import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;

/**
 * Allow for adding, editing, and deleting of member records.
 * 
 * @author Alex Anderson
 *
 */
public class ManageMemberRecord extends ManageRecordGUI implements ActionListener {

	private JTextField MemNumTextField;
	private JRadioButton YesRadioButton;
	private JRadioButton NoRadioButton;
	private ButtonGroup ActiveGroup;

	/*
	 * /** Used primarily for testing/launching independently / public static
	 * void main(String[] args) { try { MemberRecordGUI dialog = new
	 * MemberRecordGUI();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */
	/**
	 * Create the dialog.
	 * 
	 * @param MR
	 *            memberRecord
	 */
	public ManageMemberRecord(MemberRecord MR) {
		buildLocalPane();
		MemNumTextField.setText(String.format("%09d", MR.getMemberNumber()));
		NameTextField.setText(MR.getName());
		StateTextField.setText(MR.getState());
		CityTextField.setText(MR.getCity());
		ZipCodeTextField.setText(String.format("%d", MR.getZipCode()));
		AddressTextField.setText(MR.getAddress());
		if (MR.isActive()) {
			YesRadioButton.setSelected(true);
		} else {
			NoRadioButton.setSelected(true);
		}

		setVisible(true);

	}

	public ManageMemberRecord() {
		buildLocalPane();

		setVisible(true);
	}

	/**
	 * Display memeber records and modification buttons.
	 */
	public void buildLocalPane() {
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

		ActiveGroup = new ButtonGroup();
		ActiveGroup.add(YesRadioButton);
		ActiveGroup.add(NoRadioButton);

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

	}

	/**
	 * @return memberStatus
	 */
	public boolean getActive() {
		if (YesRadioButton.isSelected()) {
			/// return "Active";
			return true;
		} else {
			// return "Suspended";
			return false;
		}
	}

	/**
	 * @return memberNumber
	 */
	public int getMemberNumber() {
		return Integer.parseInt(MemNumTextField.getText());
	}

	/**
	 * @see ManageRecordGUI#actionPerformed(java.awt.event.ActionEvent) If OK
	 *      selected, update member record collection.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BackButton) {
			Cancel = true;
			setVisible(false);
		} else if (e.getSource() == OkButton) {
			Cancel = false;
			if (MemNumTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please enter a Member Number");
				return;
			}
			if (ZipCodeTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please enter a ZipCode");
				return;
			}
			setVisible(false);
		}

	}
}
