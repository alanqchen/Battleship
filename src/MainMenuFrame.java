/**
 * @author Alan Chen
 * AP Computer Science 2016-2017
 * Project: Battleship (final Graphics Project)
 * TODO: 
 */
//imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class MainMenuFrame implements MouseListener {
	private final int width = 1000;
	private final int height = 700;
	
	private JFrame mainmenu = new JFrame("Battleship"); // main frame
	private JPanel buttons = new JPanel(); // main panel, holds buttons
	private JButton launchButton = new JButton("LAUNCH!"); // launchButton button
	private JButton helpButton = new JButton(); // instruction button
	private JButton quitButton = new JButton(); //exit button
	private JButton settingsButton = new JButton();
	public SettingsFrame settings = new SettingsFrame();
	
	public MainMenuFrame() {

		// alter menu variables, resize and location
		mainmenu.setResizable(false);
		mainmenu.setSize(width, height); //default 600,500
		//mainmenu.setLocationRelativeTo(null);
		/* Make the frame border-less */
	    mainmenu.setUndecorated(true);
	    mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Set Position to middle of screen */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainmenu.setLocation(dim.width/2-mainmenu.getSize().width/2, dim.height/2-mainmenu.getSize().height/2);

		buttons.setLayout(null);

		// alter launchButton button, resize and position
		launchButton.setFont(new Font("Impact", Font.PLAIN, 18));
		launchButton.setBounds(425, 313, 150, 75);
		launchButton.addMouseListener(this);
		launchButton.setEnabled(true);
		launchButton.setFocusable(false);
		launchButton.setForeground(Color.WHITE);
		launchButton.setBackground(new Color(234,89,11));
		
		// alter instr button, resize and position
		helpButton.setToolTipText("Help");
		helpButton.setBounds(475, 625, 50, 50);
		helpButton.addMouseListener(this);
		helpButton.setEnabled(true);
		helpButton.setFocusable(false);
		helpButton.setOpaque(false);
		helpButton.setContentAreaFilled(false);
		helpButton.setBorderPainted(true);
		helpButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/helpIcon.png")));
		
		// alter quitButton button, resize and position
		quitButton.setToolTipText("Quit");
		quitButton.setBounds(425, 625, 50, 50);
		quitButton.addMouseListener(this);
		quitButton.setEnabled(true);
		quitButton.setFocusable(false);
		quitButton.setOpaque(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setBorderPainted(true);
		quitButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/quitIcon.png")));
		
		settingsButton.setToolTipText("Settings");
		settingsButton.setBounds(525,625,50,50);
		settingsButton.addMouseListener(this);
		settingsButton.setEnabled(true);
		settingsButton.setFocusable(false);
		settingsButton.setOpaque(false);
		settingsButton.setContentAreaFilled(false);
		settingsButton.setBorderPainted(true);
		settingsButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/settingsIcon.png")));

		//add buttons to JPanel
		buttons.add(launchButton);
		buttons.add(helpButton);
		buttons.add(quitButton);
		buttons.add(settingsButton);
		mainmenu.getContentPane().add(buttons); // add panel to button

		//background image
		JLabel backgroundImageLabel = new JLabel();
		backgroundImageLabel.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/mainmenuBackground.jpg")));
		backgroundImageLabel.setBounds(0, 0, width, height); //default: 0,0,600,500
		buttons.add(backgroundImageLabel);
		
		// show menu and set to terminate on close
		mainmenu.setVisible(true);
		mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mousePressed(MouseEvent mouse) {
		// checks if user clicks button
		if (mouse.getButton() == 1) { // left click
			if ((JButton) mouse.getSource() == launchButton) {
				launchGame(); // if clicked launchButton button, launch game window
			} else if ((JButton) mouse.getSource() == helpButton) {
				showInst(); // if clicked inst button, launch inst window
			} else if ((JButton) mouse.getSource() == quitButton) {
				System.exit(0); // terminate if user exits
			} else if ((JButton) mouse.getSource() == settingsButton) {
				showOps();
			}
		}

	}

	private void launchGame() {
		new GameFrame(settings.difficulty); // creates new Battleship frame
	}

	private void showInst() {
		new HelpFrame(); // creates new instruction frame
	}
	
	private void showOps() {
		settings.setVisible(true);
	}

	// Overrides
	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}
