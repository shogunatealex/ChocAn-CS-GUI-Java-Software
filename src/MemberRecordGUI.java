import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;

public class MemberRecordGUI extends JDialog implements ActionListener {

	private JList MRCList;
	private DefaultListModel results;
	private JScrollPane scrollPane;
	
	private JButton AddButton = null;
	private JButton DeleteButton = null;
	private JButton EditButton = null;
	private JButton BackButton = null;
	
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
		
		results = new DefaultListModel();
		MRCList = new JList(results);
		Font font = new Font("Courier", Font.BOLD,  12);
		MRCList.setFont(font);
		scrollPane = new JScrollPane(MRCList);
		scrollPane.setSize(425, 170);
		scrollPane.setLocation(30, 30);
		MRCList.setBounds(21, 30, 425, 159);
		window.add(scrollPane);
	
		
		JLabel MemberRecordsLabel = new JLabel("Member Records");
		MemberRecordsLabel.setBounds(21, 0, 100, 20);
		getContentPane().add(MemberRecordsLabel);
		
	
		
		
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