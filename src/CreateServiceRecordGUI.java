import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//JTable holds provider Directory, service record values

public class CreateServiceRecordGUI extends JDialog implements ActionListener {

	private JButton SubmitButton = null;
	private JButton BackButton = null;
	private JTextField date;
	private JTextField time;
	private JTextArea comments;
	private JLabel dateLabel;
	private JLabel timeLabel;
	private JLabel commentsLabel;
	private JTable table;
	private DefaultTableModel recs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateServiceRecordGUI dialog = new CreateServiceRecordGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateServiceRecordGUI() {
		Container window = getContentPane();
		setTitle("Member Record Editor");
		window.setLayout(null);
		setModal(true);

		SubmitButton = new JButton("Submit");
		SubmitButton.addActionListener(this);
		SubmitButton.setBounds(580, 250, 150, 33);
		window.add(SubmitButton);

		BackButton = new JButton("Back");
		BackButton.setBounds(580, 300, 150, 33);
		BackButton.addActionListener(this);
		window.add(BackButton);

		date = new JTextField();
		date.setSize(70, 35);
		date.setLocation(75, 225);
		window.add(date);
		
		dateLabel = new JLabel("Date:");
		dateLabel.setSize(200, 50);
		dateLabel.setLocation(25, 215);
		dateLabel.setForeground(Color.blue);
		window.add(dateLabel);
		
		time = new JTextField();
		time.setSize(70, 35);
		time.setLocation(75, 275);
		window.add(time);
		
		timeLabel = new JLabel("Time:");
		timeLabel.setSize(200, 50);
		timeLabel.setLocation(25, 260);
		timeLabel.setForeground(Color.blue);
		window.add(timeLabel);
		
		comments = new JTextArea();
		comments.setSize(200, 100);
		comments.setLocation(250, 225);
		comments.setLineWrap(true);
		window.add(comments);
		
		commentsLabel = new JLabel("Comment:");
		commentsLabel.setSize(200, 50);
		commentsLabel.setLocation(175, 225);
		commentsLabel.setForeground(Color.blue);
		window.add(commentsLabel);

		JLabel MemberRecordsLabel = new JLabel("Member Records");
		MemberRecordsLabel.setBounds(21, 0, 100, 20);
		window.add(MemberRecordsLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 31, 745, 167);
		window.add(scrollPane);

		ArrayList<ProviderDirectory> temp = FirstGUI.PDC.retrieveRecords();
		recs = new DefaultTableModel() {
			// prevents users from editing the table, must use buttons
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable();
		String header[] = new String[] { "Service", "Number", "Cost"  };
		recs.setColumnIdentifiers(header);
		table.setModel(recs);
		for (ProviderDirectory record : temp) {
			recs.addRow((new Object[] { record.get_Service(), String.format("%06d", record.get_sNumber()),
				record.get_Cost()}));
		}

		scrollPane.setFocusable(false);
		scrollPane.setViewportView(table);

		setSize(800, 400);
		setLocation(100, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BackButton) {
			setVisible(false);
		} else if (e.getSource() == SubmitButton) {
			// ManageMemberRecord MMR = new ManageMemberRecord();
			// if (MMR.isCanceled() == false){
			// String formatter = "";
			// if (MMR.getActive())
			// formatter = "Active";
			// else{
			// formatter = "Suspended";
			// }
			// MainGUI.MRC.addRecord(MMR.getName(), MMR.getMemberNumber(),
			// MMR.getZipCode(), MMR.getActive(), MMR.getAddress(),
			// MMR.getCity(), MMR.getState());
			// recs.addRow((new Object[] {MMR.getName(), MMR.getMemberNumber(),
			// MMR.getZipCode(), formatter, MMR.getAddress(), MMR.getCity(),
			// MMR.getState()}));
			// }

		}
		// else if (e.getSource() == EditButton){
		// int index = table.getSelectedRow();
		// MemberRecord toEdit = MainGUI.MRC.getSpecificRecord(index);
		// ManageMemberRecord MMR = new ManageMemberRecord(toEdit);
		// if (MMR.isCanceled() == false){
		// String formatter = "";
		// if (MMR.getActive())
		// formatter = "Active";
		// else{
		// formatter = "Suspended";
		// }
		// MainGUI.MRC.editRecord(index,MMR.getName(), MMR.getMemberNumber(),
		// MMR.getZipCode(), MMR.getActive(), MMR.getAddress(), MMR.getCity(),
		// MMR.getState());
		// recs.removeRow(index);
		// recs.insertRow(index, (new Object[]
		// {MMR.getName(),String.format("%09d",MMR.getMemberNumber()),
		// MMR.getZipCode(), formatter, MMR.getAddress(), MMR.getCity(),
		// MMR.getState()}));
		// }
		// }
		// else if (e.getSource() == DeleteButton){
		// int index = table.getSelectedRow();
		// MainGUI.MRC.removeRecord(index);
		// recs.removeRow(index);

		// }

	}
}
