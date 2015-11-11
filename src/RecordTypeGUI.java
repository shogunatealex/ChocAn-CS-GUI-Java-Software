import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecordTypeGUI extends JDialog implements ActionListener{


	private JButton BackButton = null;
	private JButton ProviderRecord = null;
	private JButton ServiceRecord  = null;
	private JButton MemberRecord = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RecordTypeGUI dialog = new RecordTypeGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RecordTypeGUI() {
		Container window = getContentPane();
		setTitle("Record Type Selector");
		setBounds(100, 100, 450, 300);
		window.setLayout(null);
		setModal(true);
		
		ProviderRecord = new JButton("Provider Record");
		ProviderRecord.addActionListener(this);
		ProviderRecord.setBounds(235, 50, 151, 49);
		window.add(ProviderRecord);
		
		ServiceRecord = new JButton("Service Record");
		ServiceRecord.addActionListener(this);
		ServiceRecord.setBounds(145, 141, 151, 49);
		window.add(ServiceRecord);
		
		MemberRecord = new JButton("Member Record");
		MemberRecord.addActionListener(this);
		MemberRecord.setBounds(60, 50, 151, 49);
		window.add(MemberRecord);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(370, 238, 89, 23);
		BackButton.addActionListener(this);
		window.add(BackButton);
	
		
		
	    setSize( 500, 310 );
	    setLocation( 100, 100 );
	    setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BackButton){
			setVisible(false);
		}
		else if (e.getSource() == MemberRecord){
			MemberRecordGUI memberRecord = new MemberRecordGUI();
			
		}
		else if (e.getSource() == ServiceRecord){
			ServiceRecordGUI serviceRecord = new ServiceRecordGUI();
		}
		else if (e.getSource() == ProviderRecord){
			ProviderRecordGUI providerRecord = new ProviderRecordGUI();
		}
	}
}
