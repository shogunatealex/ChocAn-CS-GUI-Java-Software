import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Alex Anderson Display member records. Allow for adding, editing, and
 *         deleting member records.
 *
 */
public class MemberRecordGUI extends JDialog implements ActionListener {

	private JButton AddButton = null;
	private JButton DeleteButton = null;
	private JButton EditButton = null;
	private JButton BackButton = null;
	private JTable table;
	private DefaultTableModel recs;
/*
	/**
	 * Used primarily for testing/ independent launching
	 * 
	 * @param args
	 /
	public static void main(String[] args) {
		try {
			MemberRecordGUI dialog = new MemberRecordGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog with GUI components.
	 */
	public MemberRecordGUI() {
		Container window = getContentPane();
		setTitle("Member Record Editor");
		window.setLayout(null);
		setModal(true);

		AddButton = new JButton("Add");
		AddButton.addActionListener(this);
		AddButton.setBounds(60, 209, 150, 33);
		window.add(AddButton);

		DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(this);
		DeleteButton.setBounds(405, 209, 150, 32);
		window.add(DeleteButton);

		EditButton = new JButton("Edit");
		EditButton.addActionListener(this);
		EditButton.setBounds(230, 209, 150, 33);
		window.add(EditButton);

		BackButton = new JButton("Back");
		BackButton.setBounds(580, 209, 150, 33);
		BackButton.addActionListener(this);
		window.add(BackButton);

		JLabel MemberRecordsLabel = new JLabel("Member Records");
		MemberRecordsLabel.setBounds(21, 0, 100, 20);
		window.add(MemberRecordsLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 31, 745, 167);
		window.add(scrollPane);

		ArrayList<MemberRecord> temp = ChocAnSystem.MRC.retrieveRecords();
		recs = new DefaultTableModel() {
			// prevents users from editing the table, must use buttons
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable();
		String header[] = new String[] { "Name", "ID", "Zipcode", "Status", "Address", "City", "State" };
		recs.setColumnIdentifiers(header);
		table.setModel(recs);
		for (MemberRecord record : temp) {
			String formatter = "";
			if (record.isActive())
				formatter = "Active";
			else {
				formatter = "Suspended";
			}
			recs.addRow((new Object[] { record.getName(), String.format("%09d", record.getMemberNumber()),
					record.getZipCode(), formatter, record.getAddress(), record.getCity(), record.getState() }));
		}

		scrollPane.setFocusable(false);
		scrollPane.setViewportView(table);

		setSize(800, 310);
		setLocation(100, 100);
		setVisible(true);
	}

	/**
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 *      If back selected, do not update record. If add selected, add new
	 *      member record. If edit selected, edit selected member record. If
	 *      delete selected, delete selected member record.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BackButton) {
			setVisible(false);
		} else if (e.getSource() == AddButton) {
			ManageMemberRecord MMR = new ManageMemberRecord();
			if (MMR.isCanceled() == false) {
				String formatter = "";
				if (MMR.getActive())
					formatter = "Active";
				else {
					formatter = "Suspended";
				}
				ChocAnSystem.MRC.addRecord(MMR.getName(), MMR.getMemberNumber(), MMR.getZipCode(), MMR.getActive(),
						MMR.getAddress(), MMR.getCity(), MMR.getState());
				recs.addRow((new Object[] { MMR.getName(), MMR.getMemberNumber(), MMR.getZipCode(), formatter,
						MMR.getAddress(), MMR.getCity(), MMR.getState() }));
			}

		} else if (e.getSource() == EditButton) {
			try {
				int index = table.getSelectedRow();
				MemberRecord toEdit = ChocAnSystem.MRC.getSpecificRecord(index);
				ManageMemberRecord MMR = new ManageMemberRecord(toEdit);
				if (MMR.isCanceled() == false) {
					String formatter = "";
					if (MMR.getActive())
						formatter = "Active";
					else {
						formatter = "Suspended";
					}
					ChocAnSystem.MRC.editRecord(index, MMR.getName(), MMR.getMemberNumber(), MMR.getZipCode(),
							MMR.getActive(), MMR.getAddress(), MMR.getCity(), MMR.getState());
					recs.removeRow(index);
					recs.insertRow(index, (new Object[] { MMR.getName(), String.format("%09d", MMR.getMemberNumber()),
							MMR.getZipCode(), formatter, MMR.getAddress(), MMR.getCity(), MMR.getState() }));

				}
			} catch (ArrayIndexOutOfBoundsException e1) { // catches the
															// exception for no
															// selected row
			}
		} else if (e.getSource() == DeleteButton) {
			try {
				int index = table.getSelectedRow();
				ChocAnSystem.MRC.removeRecord(index);
				recs.removeRow(index);
			} catch (ArrayIndexOutOfBoundsException e1) { // catches the
															// exception for no
															// selected row
			}
		}
	}
}
