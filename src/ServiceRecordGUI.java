import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Display service records. Allow for adding, editing, and deleting service
 * records.
 * 
 * @author Alex Anderson
 */
public class ServiceRecordGUI extends JDialog implements ActionListener {

	private DefaultListModel results;

	private JButton AddButton = null;
	private JButton DeleteButton = null;
	private JButton EditButton = null;
	private JButton BackButton = null;
	private JTable table;
	private DefaultTableModel recs;

	/*
	 * /** Used primarily for testing/ independently launching. / public static
	 * void main(String[] args) { try { ServiceRecordGUI dialog = new
	 * ServiceRecordGUI();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */
	/**
	 * Create the dialog with contents.
	 */
	public ServiceRecordGUI() {
		Container window = getContentPane();
		setTitle("Service Record Editor");
		setBounds(100, 100, 450, 300);
		window.setLayout(null);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		AddButton = new JButton("Add");
		AddButton.addActionListener(this);
		AddButton.setBounds(59, 207, 98, 33);
		window.add(AddButton);

		DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(this);
		DeleteButton.setBounds(318, 207, 100, 32);
		window.add(DeleteButton);

		EditButton = new JButton("Edit");
		EditButton.addActionListener(this);
		EditButton.setBounds(191, 207, 98, 33);
		window.add(EditButton);

		BackButton = new JButton("Back");
		BackButton.setBounds(383, 242, 89, 23);
		BackButton.addActionListener(this);
		window.add(BackButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 31, 451, 167);
		window.add(scrollPane);

		results = new DefaultListModel();

		ArrayList<ServiceRecord> temp = ChocAnSystem.SRC.retrieveRecords();
		recs = new DefaultTableModel() {
			// prevents users from editing the table, must use buttons
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable();
		String header[] = new String[] { "Date", "Time", "Provider Number", "Member Number", "Service Code",
				"Comment" };
		recs.setColumnIdentifiers(header);
		table.setModel(recs);
		for (ServiceRecord record : temp) {
			recs.addRow((new Object[] { record.getDate(), record.getTime(),
					String.format("%09d", record.getProviderNumber()), String.format("%09d", record.getMemberNumber()),
					String.format("%06d", record.getServiceCode()), record.getComments() }));
		}

		scrollPane.setFocusable(false);
		scrollPane.setViewportView(table);

		JLabel ProviderRecordsLabel = new JLabel("Service Records");
		ProviderRecordsLabel.setBounds(21, 0, 100, 20);
		getContentPane().add(ProviderRecordsLabel);

		setSize(500, 310);
		setLocation(100, 100);
		setVisible(true);
	}

	/**
	 * *
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 *      If back selected, do not update service record. If add selected, add
	 *      a service record. If edit selected, edit selected service record. If
	 *      delete selected, delete selected service record.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BackButton) {
			setVisible(false);
		} else if (e.getSource() == AddButton) {
			ManageServiceRecord MSR = new ManageServiceRecord();
			if (MSR.isCanceled() == false) {
				ChocAnSystem.SRC.addRecord(MSR.getDate(), MSR.getTime(), MSR.getProviderNumber(), MSR.getMemberNumber(),
						MSR.getServiceCode(), MSR.getComments());
				recs.addRow((new Object[] { MSR.getDate(), MSR.getTime(),
						String.format("%09d", MSR.getProviderNumber()), String.format("%09d", MSR.getMemberNumber()),
						String.format("%06d", MSR.getServiceCode()), MSR.getComments() }));
			}

		} else if (e.getSource() == EditButton) {
			try {
				int index = table.getSelectedRow();

				ServiceRecord toEdit = ChocAnSystem.SRC.getSpecificRecord(index);
				ManageServiceRecord MSR = new ManageServiceRecord(toEdit);
				if (MSR.isCanceled() == false) {
					ChocAnSystem.SRC.editRecord(index, MSR.getDate(), MSR.getTime(), MSR.getProviderNumber(),
							MSR.getMemberNumber(), MSR.getServiceCode(), MSR.getComments());
					recs.removeRow(index);
					recs.insertRow(index,
							(new Object[] { MSR.getDate(), MSR.getTime(),
									String.format("%09d", MSR.getProviderNumber()),
									String.format("%09d", MSR.getMemberNumber()),
									String.format("%06d", MSR.getServiceCode()), MSR.getComments() }));
				}
			} catch (ArrayIndexOutOfBoundsException e1) { // catches the
															// exception for no
															// selected row
			}
		} else if (e.getSource() == DeleteButton) {
			try {
				int index = table.getSelectedRow();
				ChocAnSystem.SRC.removeRecord(index);
				recs.removeRow(index);
			} catch (ArrayIndexOutOfBoundsException e1) { // catches the
															// exception for no
															// selected row
			}
		}
	}
}
