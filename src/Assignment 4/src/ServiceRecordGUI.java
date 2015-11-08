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

public class ServiceRecordGUI extends JDialog implements ActionListener {

	private JList SRCList;
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
			ServiceRecordGUI dialog = new ServiceRecordGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ServiceRecordGUI() {
		Container window = getContentPane();
		setTitle("Service Record Editor");
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
		SRCList = new JList(results);
		Font font = new Font("Courier", Font.BOLD,  12);
		SRCList.setFont(font);
		scrollPane = new JScrollPane(SRCList);
		scrollPane.setSize(425, 170);
		scrollPane.setLocation(30, 30);
		SRCList.setBounds(21, 30, 425, 159);
		window.add(scrollPane);
	
		
		JLabel MemberRecordsLabel = new JLabel("Service Records");
		MemberRecordsLabel.setBounds(21, 0, 100, 20);
		getContentPane().add(MemberRecordsLabel);
		
	
		
		
	    setSize( 500, 310 );
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
