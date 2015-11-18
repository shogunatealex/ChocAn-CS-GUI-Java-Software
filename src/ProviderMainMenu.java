import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Haylie Helmold
 * Allows for requesting the provider directory and 
 * swiping a member's card.
 *
 */

public class ProviderMainMenu extends JFrame implements ActionListener {

	// variables for buttons on main window
	protected JFrame MainMenu1;
	private JLabel MM = null;
	private JButton RequestPD, CardSimulation = null;
	private Font font = new Font("Times New Roman", Font.BOLD, 40);

	public ProviderMainMenu() {
		super("Provider Menu");

		Container c = getContentPane();
		c.setLayout(null);

		// Request Provider Directory Button
		RequestPD = new JButton("Request Provider Directory");
		RequestPD.setSize(200, 50);
		RequestPD.setLocation(100, 150);
		RequestPD.addActionListener(this);
		c.add(RequestPD);

		// Swipe Card Simulation Button
		CardSimulation = new JButton("Swipe Card Simulation");
		CardSimulation.setSize(200, 50);
		CardSimulation.setLocation(100, 250);
		CardSimulation.addActionListener(this);
		c.add(CardSimulation);

		// List Labels;
		MM = new JLabel("Main Menu");
		MM.setSize(200, 50);
		MM.setLocation(100, 50);
		MM.setForeground(Color.BLACK);
		MM.setFont(font);
		c.add(MM);
		
		// Size and location of panel on window
		setSize(400, 400);
		setLocation(100, 100);
		setVisible(true);
		setResizable(false);
	}

	// When each button is pressed...
	public void actionPerformed(ActionEvent e) {
		// Request Provider Directory
		if (e.getSource() == RequestPD) {
	
			
		}
		// Swipe Card Simulation
		else if (e.getSource() == CardSimulation){
			
		}
	}

	public static void main(String[] args) {
		ProviderMainMenu mainWnd = new ProviderMainMenu();
	}
}
