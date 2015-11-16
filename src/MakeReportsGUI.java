
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author David Glenn Selection for creating member report, provider report,
 *         EFT report, or summary report, or create all reports with run main
 *         accounting procedure.
 *
 */
public class MakeReportsGUI extends JFrame implements ActionListener {

	private JButton memberButton;
	private JButton providerButton;
	private JButton EFTButton;
	private JButton summaryButton;
	private JButton allButton;

	private Font font = new Font("Cooper Black", Font.PLAIN, 40);

	public MakeReportsGUI() {
		super("Choose a report type");

		Container c = getContentPane();
		c.setLayout(null);

		//Member Report Button
		memberButton = new JButton("Member Report");
		memberButton.addActionListener(this);
		memberButton.setSize(200, 100);
		memberButton.setLocation(50, 50);
		c.add(memberButton);
		
		//Provider Report Button
		providerButton = new JButton("Provider Report");
		providerButton.addActionListener(this);
		providerButton.setSize(200, 100);
		providerButton.setLocation(50, 200);
		c.add(providerButton);
		
		//EFT Report Button
		EFTButton = new JButton("EFT Report");
		EFTButton.addActionListener(this);
		EFTButton.setSize(200, 100);
		EFTButton.setLocation(300, 50);
		c.add(EFTButton);

		//Summary Report Button
		summaryButton = new JButton("Summary Report");
		summaryButton.addActionListener(this);
		summaryButton.setSize(200, 100);
		summaryButton.setLocation(300, 200);
		c.add(summaryButton);
		
		//Run All Reports Button
		allButton = new JButton("Run Main Accounting Procedure");
		allButton.addActionListener(this);
		allButton.setSize(450, 100);
		allButton.setLocation(50, 350);
		c.add(allButton);
		
		//screen size
		setSize(600, 600);
		setVisible(true);
		setResizable(false);

	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 *      Creates report based on which button is selected.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == memberButton) {
			try {
				int memberNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter Member Number"));
				if (FirstGUI.MRC.isMember(memberNumber)){
                    AccountingController AC = new AccountingController();
                    AC.createMemberReport(memberNumber);
     		    }
			    else{	
			    	JOptionPane.showMessageDialog(this, "Not a valid Member Number");
			        memberNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter Member Number"));
				}
		    }
			catch(NumberFormatException e1) {	
			}
		}
		
		else if (e.getSource() == providerButton) {
			try {
				int providerNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter Provider Number"));
				if (FirstGUI.PRC.isProvider(providerNumber)){
                    AccountingController AC = new AccountingController();
                    AC.createProviderReport(providerNumber);
     		    }
			    else{	
			    	JOptionPane.showMessageDialog(this, "Not a valid Provider Number");
			        providerNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter Provider Number"));
				}
		    }
			catch(NumberFormatException e1) {	
			}
		}
		
		else if (e.getSource() == EFTButton){
		    AccountingController AC = new AccountingController();
		    AC.createEFTReport();			
		}
		
		else if (e.getSource() == summaryButton) {
		    AccountingController AC = new AccountingController();
		    AC.createSummaryReport();     
		}
		
		else if (e.getSource() == allButton) {
		    AccountingController AC = new AccountingController();
		    AC.createReports();
		}
	}

	/**
	 * Used primarily for testing/independent launching.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MakeReportsGUI makeReportsScreen = new MakeReportsGUI();
		makeReportsScreen.setVisible(true);
	}

}
