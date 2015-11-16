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
import java.awt.Color;

/**
 * @author Alex Anderson Allows for entering/ editing information in provider
 *         record.
 *
 */
public class ManageProviderRecord extends ManageRecordGUI implements ActionListener {

	private JTextField ProvNumTextField;

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
	 * 
	 * @param PR
	 *            providerRecord
	 */

	public ManageProviderRecord(ProviderRecord PR) {
		buildLocalPane();
		ProvNumTextField.setText(String.format("%09d", PR.getProviderNumber()));
		NameTextField.setText(PR.getName());
		StateTextField.setText(PR.getState());
		CityTextField.setText(PR.getCity());
		ZipCodeTextField.setText(String.format("%d", PR.getZipCode()));
		AddressTextField.setText(PR.getAddress());
		setVisible(true);
	}

	public ManageProviderRecord() {
		buildLocalPane();
		setVisible(true);

	}

	/**
	 * Display components and fields of provider record.
	 */
	private void buildLocalPane() {
		super.buildPane();
		setTitle("Manage Provider Record Editor");

		JLabel ProviderRecordsLabel = new JLabel("Provider Records");
		ProviderRecordsLabel.setFont(new Font("Myriad Pro", Font.BOLD, 19));
		ProviderRecordsLabel.setBounds(272, 11, 271, 20);
		window.add(ProviderRecordsLabel);

		ProvNumTextField = new JTextField();
		ProvNumTextField.setBounds(159, 105, 86, 20);
		window.add(ProvNumTextField);
		ProvNumTextField.setColumns(10);

		JLabel ProviderNumberLabel = new JLabel("Provider Number");
		ProviderNumberLabel.setForeground(new Color(0, 100, 0));
		ProviderNumberLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		ProviderNumberLabel.setBounds(43, 108, 111, 14);
		window.add(ProviderNumberLabel);

	}

	/**
	 * @return providerNumber
	 */
	public int getProviderNumber() {
		return Integer.parseInt(ProvNumTextField.getText());
	}

	/**
	 * @see ManageRecordGUI#actionPerformed(java.awt.event.ActionEvent) If back
	 *      selected, do not update provider record. If Ok selected, update
	 *      provider record.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BackButton) {
			Cancel = true;
			setVisible(false);

		} else if (e.getSource() == OkButton) {
			Cancel = false;
			setVisible(false);
		}

	}
}
