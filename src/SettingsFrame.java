/**
 * @author Alan Chen
 * AP Computer Science 2016-2017
 * Project: Battleship (final Graphics Project)
 * TODO: 
 */
//imports 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/* 
 * === SETTINGS FRAME ===
 * This allows the user to change the CPU difficulty
 * Difficulty is set by values 1,2,3 for easy ,medium, hard, respectively
 * Easy: CPU chooses a random position
 * Medium: CPU chooses a random position, but once it gets a hit, it's smarter and chooses adjacent squares
 * Hard (or as I like to call it, Impossible): CPU knows where your ships are, and there is no escape!
 * 
 * Note: This extends JFrame as this frame is only hidden/shown, never disposed so we retain the difficulty value
 */
public class SettingsFrame extends JFrame implements MouseListener {
	
	private static final long serialVersionUID = 1L;

	private final int width = 700;
	private final int height = 650;
	
	private JButton easyButton = new JButton("Easy");
	private JButton mediumButton = new JButton("Medium");
	private JButton hardButton = new JButton("Hard");
	private JButton backButton = new JButton();
	int difficulty = 2;

	public SettingsFrame() {

		// alter frame, resize and position
		setTitle("Settings");
		setResizable(false);
		setSize(width, height);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		//Make the frame border-less
	    	setUndecorated(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	    	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		easyButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));

		// alter buttons
		easyButton.setBorderPainted(false); // Java 8 MacOS fix
		easyButton.setBounds(250, 213, 200, 75);
		easyButton.addMouseListener(this);
		easyButton.setEnabled(true);
		easyButton.setFocusable(false);
		easyButton.setBackground(Color.WHITE);
		easyButton.setOpaque(true);
		easyButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/easyIcon.png")));
		
		mediumButton.setBorderPainted(false); // Java 8 MacOS fix
		mediumButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		mediumButton.setBounds(250, 288, 200, 75);
		mediumButton.addMouseListener(this);
		mediumButton.setEnabled(false);
		mediumButton.setFocusable(false);
		mediumButton.setBackground(Color.WHITE);
		mediumButton.setOpaque(true);
		mediumButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/mediumIcon.png")));
		
		hardButton.setBorderPainted(false); // Java 8 MacOS fix
		hardButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		hardButton.setBounds(250, 363, 200, 75);
		hardButton.addMouseListener(this);
		hardButton.setFocusable(false);
		hardButton.setBackground(Color.WHITE);
		hardButton.setOpaque(true);
		hardButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/hardIcon.png")));
		
		backButton.setBorderPainted(false); // Java 8 MacOS fix
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		backButton.setToolTipText("Back");
		backButton.setBounds(325, 575, 50, 50);
		backButton.addMouseListener(this);
		backButton.setEnabled(true);
		backButton.setFocusable(false);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/quitIcon.png")));
		getContentPane().add(backButton);

		JLabel backgroundImageLabel = new JLabel("");
		backgroundImageLabel.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/settingsBackground.jpg")));
		backgroundImageLabel.setBounds(0, 0, width, height);
		
		/* Add items to the frame */
		getContentPane().add(easyButton);
		getContentPane().add(mediumButton);
		getContentPane().add(hardButton);
		add(backgroundImageLabel);

	}

	public void mousePressed(MouseEvent e) {
		// checks if button is clicked
		if (e.getButton() == 1) { // left click
			if ((JButton) e.getSource() == easyButton) {
				difficulty = 1;
				easyButton.setEnabled(false);
				mediumButton.setEnabled(true);
				hardButton.setEnabled(true);
			}
			if ((JButton) e.getSource() == mediumButton) {
				difficulty = 2;
				easyButton.setEnabled(true);
				mediumButton.setEnabled(false);
				hardButton.setEnabled(true);
			}
			if ((JButton) e.getSource() == hardButton) {
				difficulty = 3;
				easyButton.setEnabled(true);
				mediumButton.setEnabled(true);
				hardButton.setEnabled(false);
			}
			if ((JButton) e.getSource() == backButton) // if clicked on exit button
				 setVisible(false);

		}

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
