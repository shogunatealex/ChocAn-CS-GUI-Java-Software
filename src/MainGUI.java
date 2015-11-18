import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Alex Anderson
 * Populate record collections with test data.
 * Allows for making the various reports, 
 * swiping a member's card, or editing a record.
 *
 */
public class MainGUI {
	
	protected JFrame MainMenu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for(int i = 0; i < 20; i++){
						FirstGUI.PDC.addRecord(i, "Something Important", i * 5);
					}
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
		MainMenu.setBounds(100, 100, 610, 250);
		MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainMenu.getContentPane().setLayout(null);
		
		Font font = new Font("Times New Roman", Font.PLAIN, 50);
		JLabel mMenu = new JLabel("Main Menu");
		mMenu.setSize(300, 50);
		mMenu.setLocation(180, 25);
		mMenu.setFont(font);
		MainMenu.getContentPane().add(mMenu);
		
		JButton ProviderReport = new JButton("Make Reports");
		ProviderReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MakeReportsGUI ReportGUI = new MakeReportsGUI();
				ReportGUI.setVisible(true);
			}
		});
		//ProviderReport.setBounds(10, 78, 149, 127);
		ProviderReport.setSize(150, 50);
		ProviderReport.setLocation(25, 100);
		MainMenu.getContentPane().add(ProviderReport);
		
		JButton EditRecord = new JButton("Edit Record");
		EditRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecordTypeGUI RecordGUI = new RecordTypeGUI();
				RecordGUI.setVisible(true);

				
			}
		});
		//EditRecord.setBounds(430, 78, 149, 127);
		EditRecord.setSize(150, 50);
		EditRecord.setLocation(425, 100);
		MainMenu.getContentPane().add(EditRecord);
		
		JButton SwipeCardSimulation = new JButton("Swipe Card Simulation");
		SwipeCardSimulation.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				CardSimulator test = new CardSimulator();
			}
		});
		//SwipeCardSimulation.setBounds(218, 78, 149, 127);
		SwipeCardSimulation.setSize(200, 50);
		SwipeCardSimulation.setLocation(200, 100);
		MainMenu.getContentPane().add(SwipeCardSimulation);
	}

}
