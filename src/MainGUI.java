import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI {

	private JFrame MainMenu;
	public static MemberRecordCollection MRC = new MemberRecordCollection("MemberRecords.txt");
	public static ProviderRecordCollection PRC = new ProviderRecordCollection("ProviderRecords.txt");
	public static ServiceRecordCollection SRC = new ServiceRecordCollection("ServiceRecords.txt");
	public static ProviderDirectoryCollection PDC = new ProviderDirectoryCollection("ProviderDirectory.txt");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.MainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// To be switched over to main ChocAn System class when created
//		for (int i = 0; i < 20; i++)
//		{
//			MemberRecord temp = new MemberRecord("Alex Anderson", i, 19962, true, "Whereever I want", "Magnolia", "Delaware");
//			MRC.addRecord(temp);
//		}

		
		
		MainMenu = new JFrame();
		MainMenu.setTitle("Main Menu");
		MainMenu.setBounds(100, 100, 605, 346);
		MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainMenu.getContentPane().setLayout(null);
		
		JButton ProviderReport = new JButton("Provider Report");
		ProviderReport.setBounds(10, 78, 149, 127);
		MainMenu.getContentPane().add(ProviderReport);
		
		JButton EditRecord = new JButton("Edit Record");
		EditRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecordTypeGUI RecordGUI = new RecordTypeGUI();
				RecordGUI.setVisible(true);

				
			}
		});
		EditRecord.setBounds(430, 78, 149, 127);
		MainMenu.getContentPane().add(EditRecord);
		
		JButton SwipeCardSimulation = new JButton("Swipe Card Simulation");
		SwipeCardSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardSimulator test = new CardSimulator();
			}
		});
		SwipeCardSimulation.setBounds(218, 78, 149, 127);
		MainMenu.getContentPane().add(SwipeCardSimulation);
	}

}
