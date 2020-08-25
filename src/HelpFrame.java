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

public class HelpFrame implements MouseListener { // instruction frame
	
	private final int width = 700;
	private final int height = 650;
	
	private JFrame frame = new JFrame("Help"); // main frame container

	private JButton backButton = new JButton(); // button to close frame

	public HelpFrame() {

		// alter frame, resize and position
		frame.setResizable(false);
		frame.setSize(width, height);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);
		/* Make the frame border-less */
	    	frame.setUndecorated(true);
		/* Set Position to middle of screen */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// alter backButton button, resize and position
		backButton.setBorderPainted(false); // Java 8 MacOS fix
		backButton.setToolTipText("Back");
		backButton.setBounds(325, 575, 50, 50);
		backButton.addMouseListener(this);
		backButton.setEnabled(true);
		backButton.setFocusable(false);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/quitIcon.png")));
		frame.getContentPane().add(backButton);
		
		/* Background Image */
		JLabel backgroundImageLabel = new JLabel("");
		backgroundImageLabel.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/helpBackground.jpg")));
		backgroundImageLabel.setBounds(0, 0, width, height); //default: 0,0,600,500
		frame.add(backgroundImageLabel);
		// set frame visible and dispose contents on close
		frame.setVisible(true);
		
	}

	public void mousePressed(MouseEvent e) {
		//checks if button is clicked
		if (e.getButton() == 1) { // left click
			if ((JButton) e.getSource() == backButton) // if clicked on exit button
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); // close window

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
