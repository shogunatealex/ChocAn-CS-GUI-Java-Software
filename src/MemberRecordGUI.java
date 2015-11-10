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

public class MemberRecordGUI extends JDialog implements ActionListener {
	private DefaultListModel results;
	
	private JButton AddButton = null;
	private JButton DeleteButton = null;
	private JButton EditButton = null;
	private JButton BackButton = null;
	private JTable table;
	
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
	public MemberRecordGUI() {
		Container window = getContentPane();
		setTitle("Member Record Editor");
		setBounds(100, 100, 450, 300);
		window.setLayout(null);
		
		AddButton = new JButton("Add");
		AddButton.addActionListener(this);
		AddButton.setBounds(31, 209, 98, 33);
		window.add(AddButton);
		
		DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(this);
		DeleteButton.setBounds(247, 209, 100, 32);
		window.add(DeleteButton);
		
		EditButton = new JButton("Edit");
		EditButton.addActionListener(this);
		EditButton.setBounds(139, 209, 98, 33);
		window.add(EditButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(357, 209, 100, 33);
		BackButton.addActionListener(this);
		window.add(BackButton);
		
		results = new DefaultListModel();
		Font font = new Font("Courier", Font.BOLD,  12);
	
		
		JLabel MemberRecordsLabel = new JLabel("Member Records");
		MemberRecordsLabel.setBounds(21, 0, 100, 20);
		window.add(MemberRecordsLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 31, 451, 167);
		window.add(scrollPane);
		
		
		
		ArrayList<MemberRecord> temp = MainGUI.MRC.retrieveRecords();
		DefaultTableModel recs = new DefaultTableModel(0,0);
		table = new JTable();
		String header[] = new String[] {
				"Name", "ID", "Zipcode", "Status", "Address", "City", "State"
			};
		recs.setColumnIdentifiers(header);
		table.setModel(recs);
		for(MemberRecord record: temp){
			recs.addRow((new Object[] { record.getName(), record.getMemberNumber(), record.getZipCode(), record.isActive(), record.getAddress(), record.getCity(), record.getState()}));
		}
		scrollPane.setViewportView(table);
		
	
		
		
	    setSize( 500, 310 );
	    setLocation( 100, 100 );
	    setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BackButton){
			setVisible(false);
		}
		else if (e.getSource() == AddButton){
			ManageMemberRecord MMR = new ManageMemberRecord();
		}
		
	}
}
