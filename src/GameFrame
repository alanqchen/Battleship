/**
 * @author Alan Chen
 * AP Computer Science 2016-2017
 * Project: Battleship (final Graphics Project)
 * TODO: 
 */
//imports 
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;

public class GameFrame implements MouseListener { // main class
	
	/* WINDOW SIZE */
	private final int width = 490;
	private final int height = 650;
	
	boolean gameStarted = false; // boolean to check if game has started or not
	boolean disable = false; // boolean to disable game buttons
	Random rand = new Random(); // randomizer
	JFrame window = new JFrame("Place Your Ships!"); // main window, holds
														// panels
	JPanel gridPanel = new JPanel(); // panel to hold 8x8 grid PLayer ships
	JPanel CPUgrid = new JPanel(); // panel to hold 8x8 grid CPU ships

	JButton locations[][] = new JButton[8][8]; // stores button form of CPU
												// ships
	int textLoc[][] = new int[8][8]; // stores int form of CPU ships
	JButton CPUlocations[][] = new JButton[8][8]; // stores button form of CPU
													// ships
	int CPUtextLoc[][] = new int[8][8]; // stores int form of CPU ships
	int row, row2 = 0; // stores rows picked
	int column, column2 = 0; // stores rows picked
	boolean hit = false;
	int difficulty = 0;

	JPanel buttonBox = new JPanel(); // panel to hold confirm and reset
	JButton confirmButton = new JButton(); // confirm button
	JButton resetButton = new JButton(); // reset button
	JButton quitButton = new JButton(); // close window button

	Warships carrierP, battleshipP, cruiserP, submarineP, destroyerP = null; 
	Warships carrierC, battleshipC, cruiserC, submarineC, destroyerC = null;  
	int selectedShip = 5; // stores selected ship
	//Displays what ship they are currently placing
	JLabel whichShip = new JLabel("You are curently placing the Carrier (5 long)"); 
	JLabel infoLabel = new JLabel("Left click to place your ship horizontally, right click to place it vertically"); // generic
																													// information
																													// label
	JLabel infoLabel2 = new JLabel(); // generic information label
	JLabel cpuBoardLabel = new JLabel("CPU's Board"); // label for cpu board

	public GameFrame(int dificulty) { // constructed with object
		
		this.difficulty = dificulty;
		// sets window, panel and generic button size, location and other variables
	    window.setUndecorated(true);
		window.getContentPane().setLayout(null);
		window.getContentPane().setBackground(Color.WHITE);
		window.setSize(width, height);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gridPanel.setLayout(null);
		gridPanel.setSize(490, 490);
		gridPanel.setBackground(Color.RED);
		buttonBox.setLocation(170, 550);
		buttonBox.setLayout(null);
		buttonBox.setSize(100, 50);
		window.getContentPane().add(quitButton);
		window.getContentPane().add(gridPanel);
		window.getContentPane().add(buttonBox);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
		window.setVisible(true);
		for (int x = 0; x < locations[1].length; x++) { // creates array of
														// buttons for 8x8 grid
			for (int y = 0; y < locations[2].length; y++) {
				Color sea = new Color(24,156,239);
				locations[x][y] = new JButton("W");
				locations[x][y].setForeground(sea);
				locations[x][y].setBounds((x * 60) + 5, (y * 60) + 5, 60, 60);
				locations[x][y].addMouseListener(this);
				gridPanel.add(locations[x][y]); // adds to gridPanel panel
				locations[x][y].setEnabled(true);
				locations[x][y].setFocusable(false);
				locations[x][y].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/WaterIcon.jpg")));
				locations[x][y].setIconTextGap(-6);
				locations[x][y].setHorizontalAlignment(SwingConstants.CENTER);
			}
		}

		// Sets Button and Panel location and other properties
		/* Confirm Button */
		confirmButton.setToolTipText("Confirm");
		confirmButton.addMouseListener(this);
		confirmButton.setBounds(0, 0, 50, 50);
		confirmButton.setFocusable(false);
		confirmButton.setEnabled(false);
		confirmButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/confirmIcon.png")));
		/* Reset Button */
		resetButton.setToolTipText("Reset");
		resetButton.addMouseListener(this);
		resetButton.setEnabled(true);
		resetButton.setBounds(50, 0, 50, 50);
		resetButton.setFocusable(false);
		resetButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/resetIcon.png")));
		/* Quit Button */
		quitButton.setToolTipText("Quit");
		quitButton.addMouseListener(this);
		quitButton.setEnabled(true);
		quitButton.setBounds(270, 550, 50, 50);
		quitButton.setFocusable(false);
		quitButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/quitIcon.png")));
		/* Button Holder */
		buttonBox.add(confirmButton);
		buttonBox.add(resetButton);
		buttonBox.setBackground(Color.WHITE);
		whichShip.setHorizontalAlignment(SwingConstants.CENTER);
		whichShip.setBounds(40, 525, 410, 17);
		window.getContentPane().add(whichShip);

		infoLabel.setFont(new Font("Impact", Font.PLAIN, 12));
		infoLabel.setForeground(Color.RED);
		whichShip.setForeground(Color.BLACK);
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBounds(40, 500, 410, 16);
		window.getContentPane().add(infoLabel);

		placeCPUShips(); // calls method to place cpu ships
	}

	public void placeCPUShips() { // places CPU ships
		// creates 5 ships
		carrierC = new Warships(5);
		battleshipC = new Warships(4);
		cruiserC = new Warships(3);
		submarineC = new Warships(1);
		destroyerC = new Warships(2);

		// finds area for 5 ships
		carrierC.FindArea(CPUtextLoc);
		battleshipC.FindArea(CPUtextLoc);
		cruiserC.FindArea(CPUtextLoc);
		submarineC.FindArea(CPUtextLoc);
		destroyerC.FindArea(CPUtextLoc);

		// sets variables for the CPU ship grid
		CPUgrid.setLocation(555, 0);
		CPUgrid.setLayout(null);
		CPUgrid.setSize(490, 490);
		window.getContentPane().add(CPUgrid);
		//Text Label for the CPU Board
		cpuBoardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cpuBoardLabel.setBounds(750, 500, 100, 22);
		cpuBoardLabel.setOpaque(true);
		cpuBoardLabel.setForeground(Color.BLACK);
		cpuBoardLabel.setBackground(Color.WHITE);
		cpuBoardLabel.setFont(new Font("Impact", Font.PLAIN, 18));
		window.getContentPane().add(cpuBoardLabel);
		CPUgrid.setVisible(false);

		// creates 8x8 grid for cpu ships and sets variables
		for (int x = 0; x < CPUlocations[1].length; x++) {
			for (int y = 0; y < CPUlocations[2].length; y++) {
				Color sea = new Color(24,156,239);
				CPUlocations[x][y] = new JButton("W");
				CPUlocations[x][y].setForeground(sea);
				CPUlocations[x][y].setBounds((x * 60) + 5, (y * 60) + 5, 60, 60);
				CPUlocations[x][y].addMouseListener(this);
				CPUgrid.add(CPUlocations[x][y]); // adds to gridPanel panel
				CPUlocations[x][y].setEnabled(true);
				CPUlocations[x][y].setFocusable(false);
				CPUlocations[x][y].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/WaterIcon.jpg")));
				CPUlocations[x][y].setIconTextGap(-6);
				CPUlocations[x][y].setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) { // checks which button is pressed
												// and does stuff with them
		if (!disable) { // runs if game is still going
			if (gameStarted == false) {
				JButton selected = (JButton) e.getSource(); // temp button
				boolean found = false;
				//Confirm button
				if ((selected == confirmButton) && (selectedShip == 0)) {
					startGame(); // start
				} else if (selected == resetButton) { // if clicked reset
					resetButtons(); // reset
				} else { // finds button clicked
					for (int x = 0; x < locations[1].length; x++) {
						for (int y = 0; y < locations[2].length; y++) {
							JButton find = locations[x][y];

							if (find == selected) {
								row = x;
								column = y;
								found = true;
							}
						}
					}
					if ((e.getButton() == 3) && (found)) // right click
						checkDown();

					if ((e.getButton() == 1) && (found)) // left click
						checkRight();

				}
			} else { // firing
				JButton selected = (JButton) e.getSource();
				boolean found = false;
				for (int x = 0; x < CPUlocations[1].length; x++) {
					for (int y = 0; y < CPUlocations[2].length; y++) {
						JButton find = CPUlocations[x][y];

						if (find == selected) { // finds button clicked
							row = x;
							column = y;
							found = true;
						}
					}
				}
				if ((e.getButton() == 1) && (found)) {// left click shoots
					fire();
				}

			}
		} 
		if ((JButton) e.getSource() == quitButton)
			window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING)); 
	}

	public void checkDown() { // checks down
		if (selectedShip == 5) { // ship ID 5
			carrierP = new Warships(5);// create ship
			if (carrierP.CheckArea(textLoc, row, column, 2)) { // if good loc
				UpdateButtons();// updates
				selectedShip--; // down to ship ID 4
				whichShip.setText("You are curently placing the Battleship (4 long)"); // update
																						// text
			}

		}
		if (selectedShip == 4) { // ship ID 4
			battleshipP = new Warships(4);// create ship
			if (battleshipP.CheckArea(textLoc, row, column, 2)) { // if good
																	// loc
				UpdateButtons();// updates
				selectedShip--; // down to ship ID 3
				whichShip.setText("You are curently placing the Cruiser (3 long)"); // update
																					// text
			}
		}
		if (selectedShip == 3) { // ship ID 3
			cruiserP = new Warships(3); // create ship
			if (cruiserP.CheckArea(textLoc, row, column, 2)) { // if good loc
				UpdateButtons();// updates
				selectedShip--; // down to ship ID 2
				whichShip.setText("You are curently placing the Destroyer (2 long)"); // update
																						// text
			}
		}
		if (selectedShip == 1) { // ship ID 1
			submarineP = new Warships(1); // placing ship ID 1
			if (submarineP.CheckArea(textLoc, row, column, 2)) { // if good
																	// location
				UpdateButtons();// updates
				selectedShip--; // down to 0
				whichShip.setText("You have placed all of your ships!"); // update
																			// text
				confirmButton.setEnabled(true);
			}
		}
		if (selectedShip == 2) { // placing ship ID 2
			destroyerP = new Warships(2); // creates ship with id 2
			if (destroyerP.CheckArea(textLoc, row, column, 2)) { // if location
																	// is good
				UpdateButtons(); // updates
				selectedShip--; // down to ship ID 1
				whichShip.setText("You are curently placing the Submarine (3 long)"); // update
																						// text
			}
		}
	}

	public void checkRight() { // same as checkDown() except checks right
		if (selectedShip == 5) {
			carrierP = new Warships(5);
			if (carrierP.CheckArea(textLoc, row, column, 1)) {
				UpdateButtons();
				selectedShip--;
				whichShip.setText("You are curently placing the Battleship (4 long)");
			}
		}
		if (selectedShip == 4) {
			battleshipP = new Warships(4);
			if (battleshipP.CheckArea(textLoc, row, column, 1)) {
				UpdateButtons();
				selectedShip--;
				whichShip.setText("You are curently placing the Cruiser (3 long)");
			}
		}
		if (selectedShip == 3) {
			cruiserP = new Warships(3);
			if (cruiserP.CheckArea(textLoc, row, column, 1)) {
				UpdateButtons();
				selectedShip--;
				whichShip.setText("You are curently placing the Destroyer (2 long)");
			}
		}
		if (selectedShip == 1) {
			submarineP = new Warships(1);
			if (submarineP.CheckArea(textLoc, row, column, 1)) {
				UpdateButtons();
				selectedShip--;
				whichShip.setText("You have placed all of your ships!");
				confirmButton.setEnabled(true);
			}
		}
		if (selectedShip == 2) {
			destroyerP = new Warships(2);
			if (destroyerP.CheckArea(textLoc, row, column, 1)) {
				UpdateButtons();
				selectedShip--;
				whichShip.setText("You are curently placing the Submarine (3 long)");
			}
		}
	}

	public void UpdateButtons() { // updates button colours and text if selected

		for (int x = 0; x < locations[1].length; x++) {
			for (int y = 0; y < locations[2].length; y++) {
				if (textLoc[x][y] != 0) { // if not empty space
					locations[x][y].setEnabled(false); // disable button
					locations[x][y].setOpaque(true); // opaque
				}
				if (textLoc[x][y] == 1) { // id 1
					locations[x][y].setBackground(Color.MAGENTA);
					locations[x][y].setText("");
					locations[x][y].setIcon(null);
				} else if (textLoc[x][y] == 2) { // id 2
					locations[x][y].setBackground(Color.ORANGE);
					locations[x][y].setText("");
					locations[x][y].setIcon(null);
				} else if (textLoc[x][y] == 3) { // id 3
					locations[x][y].setBackground(Color.GREEN);
					locations[x][y].setText("");
					locations[x][y].setIcon(null);
				} else if (textLoc[x][y] == 4) { // id 4
					locations[x][y].setBackground(Color.CYAN);
					locations[x][y].setText("");
					locations[x][y].setIcon(null);
				} else if (textLoc[x][y] == 5) { // id 5
					locations[x][y].setBackground(Color.YELLOW);
					locations[x][y].setText("");
					locations[x][y].setIcon(null);
				}
			}
		}
	}

	public void resetButtons() { // resets ship placements and buttons
		for (int x = 0; x < locations[1].length; x++) {
			for (int y = 0; y < locations[2].length; y++) {
				Color sea = new Color(24,156,239);
				locations[x][y].setForeground(sea);
				locations[x][y].setEnabled(true);
				locations[x][y].setOpaque(false);
				locations[x][y].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/WaterIcon.jpg")));
				locations[x][y].setIconTextGap(-6);
				locations[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				locations[x][y].setText("W");
				textLoc[x][y] = 0;
			}
		}
		selectedShip = 5; // sets sel ship back
		whichShip.setText("You are curently placing the Carrier (5 long)"); // sets
																			// text
																			// back
		confirmButton.setEnabled(false); // disable confirm
	}

	public void startGame() { // initiates actual game

		gameStarted = true; // swaps mouselistener to game
		window.setSize(1045, 700); // resizes window
		window.setLocationRelativeTo(null); // recenters
		window.setTitle("BATTLESHIP!");
		
		//move buttonBox off-screen		
		buttonBox.setLocation(0,1000);
		
		//move quit button and add icon
		quitButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/quitIcon.png")));
		quitButton.setSize(50, 50);
		quitButton.setLocation(500,600);
		quitButton.setOpaque(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setBorderPainted(true);
		// updates labels
		infoLabel.setBounds(310, 500, 425, 22);
		infoLabel.setFont(new Font("Impact", Font.PLAIN, 18));
		infoLabel.setText("Click on a square on the CPU's board to fire at it.");
		infoLabel.setOpaque(true);
		infoLabel.setForeground(Color.BLACK);
		infoLabel.setBackground(Color.WHITE);
		infoLabel2.setFont(new Font("Impact", Font.PLAIN, 18));
		infoLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel2.setOpaque(true);
		infoLabel2.setForeground(Color.BLACK);
		infoLabel2.setBackground(Color.WHITE);
		infoLabel2.setBounds(310, 525, 425, 22);
		window.getContentPane().add(infoLabel2);
		resetButton.setVisible(false);
		confirmButton.setVisible(false);
		//Ship displayer changes into the label for the player's board
		whichShip.setText("Your Board");
		whichShip.setFont(new Font("Impact", Font.PLAIN, 18));
		whichShip.setBounds(200, 500, 100, 22);
		whichShip.setOpaque(true);
		whichShip.setForeground(Color.BLACK);
		whichShip.setBackground(Color.WHITE);
		CPUgrid.setVisible(true);
		CPUgrid.setBackground(Color.BLUE);
		cpuBoardLabel.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
		//background image
		JLabel backgroundImageLabel = new JLabel("S");
		backgroundImageLabel.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/gameBackground.jpg")));
		backgroundImageLabel.setBounds(0, 0, 1050, 700); 
		window.add(backgroundImageLabel);
	}

	public void fire() { // pick location to shoot
		if (CPUlocations[row][column].getText().equals("W")) {
			/*
			 * Checks the square to check its ID to determine what to do with it
			 */
			/* ID 5 (CARRIER) */
			if (CPUtextLoc[row][column] == 5) { 
				infoLabel.setText("You hit a CPU's ship!");
				Color hit = new Color(247,81,64);
				CPUlocations[row][column].setForeground(hit);
				CPUlocations[row][column].setText("H"); // sets button to hit
				CPUlocations[row][column].setEnabled(false); // disables button
				CPUlocations[row][column].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				CPUlocations[row][column].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				CPUlocations[row][column].setIconTextGap(-6);
				CPUlocations[row][column].setHorizontalAlignment(SwingConstants.CENTER);
				//CPUlocations[row][column].setForeground(Color.RED);
				carrierC.health -= 1; // subtracts space
				if (carrierC.health == 0) { // if no spaces left (sunk)
					infoLabel.setText("You sank CPU's Carrier!");
					carrierC.sunk = true; // sets obj sunk to true
					showSunk(5, 1); // updates buttons

				}
			/* ID 4 (BATTLESHIP) */
			} else if (CPUtextLoc[row][column] == 4) {
				infoLabel.setText("You hit a CPU's ship!");
				Color hit = new Color(247,81,64);
				CPUlocations[row][column].setForeground(hit);
				CPUlocations[row][column].setText("H");
				CPUlocations[row][column].setEnabled(false);
				CPUlocations[row][column].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				CPUlocations[row][column].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				CPUlocations[row][column].setIconTextGap(-6);
				CPUlocations[row][column].setHorizontalAlignment(SwingConstants.CENTER);
				battleshipC.health -= 1;
				if (battleshipC.health == 0) {
					infoLabel.setText("You sank CPU's Battleship!");
					battleshipC.sunk = true;
					showSunk(4, 1);

				}
			/* ID 3 (CRUISER) */
			} else if (CPUtextLoc[row][column] == 3) { 
				infoLabel.setText("You hit a CPU's ship!");
				Color hit = new Color(247,81,64);
				CPUlocations[row][column].setForeground(hit);
				CPUlocations[row][column].setText("H");
				CPUlocations[row][column].setEnabled(false);
				CPUlocations[row][column].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				CPUlocations[row][column].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				CPUlocations[row][column].setIconTextGap(-6);
				CPUlocations[row][column].setHorizontalAlignment(SwingConstants.CENTER);
				cruiserC.health -= 1;
				if (cruiserC.health == 0) {
					infoLabel.setText("You sank CPU's Cruiser!");
					cruiserC.sunk = true;
					showSunk(3, 1);

				}
			/* ID 2 (DESTROYER) */
			} else if (CPUtextLoc[row][column] == 2) {
				infoLabel.setText("You hit a CPU's ship!");
				Color hit = new Color(247,81,64);
				CPUlocations[row][column].setForeground(hit);
				CPUlocations[row][column].setText("H");
				CPUlocations[row][column].setEnabled(false);
				CPUlocations[row][column].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				CPUlocations[row][column].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				CPUlocations[row][column].setIconTextGap(-6);
				CPUlocations[row][column].setHorizontalAlignment(SwingConstants.CENTER);
				destroyerC.health -= 1;
				if (destroyerC.health == 0) {
					infoLabel.setText("You sank CPU's Destroyer!");
					destroyerC.sunk = true;
					showSunk(2, 1);

				}
			/* ID 1 (SUBMARINE) */
			} else if (CPUtextLoc[row][column] == 1) { 
				infoLabel.setText("You hit a CPU's ship!");
				Color hit = new Color(247,81,64);
				CPUlocations[row][column].setForeground(hit);
				CPUlocations[row][column].setText("H");
				CPUlocations[row][column].setEnabled(false);
				CPUlocations[row][column].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				CPUlocations[row][column].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				CPUlocations[row][column].setIconTextGap(-6);
				CPUlocations[row][column].setHorizontalAlignment(SwingConstants.CENTER);
				submarineC.health -= 1;
				if (submarineC.health == 0) {
					infoLabel.setText("You sank CPU's Submarine!");
					submarineC.sunk = true;
					showSunk(1, 1);

				}
			/* ID 0 (WATER) */
			} else if (CPUtextLoc[row][column] == 0) {
				infoLabel.setText("You missed!");
				//sets button to missed
				CPUlocations[row][column].setText("M");
				CPUlocations[row][column].setEnabled(false);
				CPUlocations[row][column].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/missIcon.png")));
				CPUlocations[row][column].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/missIcon.png")));
			}
			CPUfire();
		}

	}

	public void CPUfire() { // cpu picks location to shoot

		if (!disable) { // will not activate if buttons disabled

			while (true) {
				cpuAI();
				if (!((locations[row2][column2].getText().equals("H"))
						|| (locations[row2][column2].getText().equals("M"))
						|| (locations[row2][column2].getText().equals("S"))))
					break;
			}

			if (textLoc[row2][column2] == 5) { // hit ship ID 5
				infoLabel2.setText("CPU hit your Carrier!");
				locations[row2][column2].setText("H");
				locations[row2][column2].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				locations[row2][column2].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				//CPUlocations[row][column].setForeground(Color.RED);
				carrierP.health -= 1; // subtracts a space remaining
											// from Ship
				if (carrierP.health == 0) { // if no spaces remaining
					infoLabel2.setText("CPU sank your Carrier!");
					carrierP.sunk = true; // sets ship object to sunk
					showSunk(5, 0); // update buttons to show sunken ship

				}
			} else if (textLoc[row2][column2] == 4) { // same as above for
														// ship ID 4
				infoLabel2.setText("CPU hit your Battleship!");
				locations[row2][column2].setText("H");
				locations[row2][column2].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				locations[row2][column2].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				//CPUlocations[row][column].setForeground(Color.RED);
				battleshipP.health -= 1;
				if (battleshipP.health == 0) {
					infoLabel2.setText("CPU sank your Battleship!");
					battleshipP.sunk = true;
					showSunk(4, 0);

				}
			} else if (textLoc[row2][column2] == 3) {// same as above for
														// ship ID 3
				infoLabel2.setText("CPU hit your Cruiser!");
				locations[row2][column2].setText("H");
				locations[row2][column2].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				locations[row2][column2].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				//CPUlocations[row][column].setForeground(Color.RED);
				cruiserP.health -= 1;
				if (cruiserP.health == 0) {
					infoLabel2.setText("CPU sank your Cruiser!");
					cruiserP.sunk = true;
					showSunk(3, 0);

				}
			} else if (textLoc[row2][column2] == 2) {// same as above for
														// ship ID 2
				infoLabel2.setText("CPU hit your Destroyer!");
				locations[row2][column2].setText("H");
				locations[row2][column2].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				locations[row2][column2].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				//CPUlocations[row][column].setForeground(Color.RED);
				destroyerP.health -= 1;
				if (destroyerP.health == 0) {
					infoLabel2.setText("CPU sank your Destroyer!");
					destroyerP.sunk = true;
					showSunk(2, 0);

				}
			} else if (textLoc[row2][column2] == 1) {// same as above for
														// ship ID 2
				infoLabel2.setText("CPU hit your Submarine!");
				locations[row2][column2].setText("H");
				locations[row2][column2].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				locations[row2][column2].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/explosionIcon.png")));
				//CPUlocations[row][column].setForeground(Color.RED);
				submarineP.health -= 1;
				if (submarineP.health == 0) {
					infoLabel2.setText("CPU sank your Submarine!");
					submarineP.sunk = true;
					showSunk(1, 0);

				}
			} else if (textLoc[row2][column2] == 0) {
				infoLabel2.setText("CPU missed!");
				locations[row2][column2].setText("M");
				locations[row2][column2].setEnabled(false);
				locations[row2][column2].setIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/missIcon.png")));
				locations[row2][column2].setDisabledIcon(new ImageIcon(MainMenuFrame.class.getResource("/images/missIcon.png")));
			}
		}
	}

	public void cpuAI() {
		/* Difficulty EASY: picks a random spot to fire*/
		if (difficulty == 1) {
			row2 = rand.nextInt(8);
			column2 = rand.nextInt(8);
		/* Difficulty Medium: CPU chooses a random position, but once it gets a hit, it's smarter and chooses adjacent squares */
		} else if (difficulty == 2) {
			hit = false;
			for (int x = 0; x < CPUlocations[1].length; x++) {
				for (int y = 0; y < CPUlocations[2].length; y++) {
					if (locations[x][y].getText().equals("H")) {
						int counter = 0;
						boolean hold = true;
						//locked will store the directions that has been tried before
						boolean locked[] = { false, false, false, false };
						do {
							int random = rand.nextInt(4);
							while (hold) {
								if (locked[random] == true) {
									random = rand.nextInt(4);
								} else
									hold = false;
							}

							counter++;
							// 4 cases, for the 4 directions it will try
							if ((random == 0) && (x - 1 != -1)) {
								//makes sure the adjacent tile is water
								if (!((locations[x - 1][y].getText().equals("H")) || (locations[x - 1][y].getText().equals("M")) || (locations[x - 1][y].getText().equals("S")))) {
									//fires at the adjacent tile
									row2 = x - 1;
									column2 = y;
									hit = true;
								} else
									//lock that direction since the tile it has already been used
									locked[0] = true;

							}

							if ((random == 1) && (x + 1 != 8) && (!hit)) {
								if (!((locations[x + 1][y].getText().equals("H")) || (locations[x + 1][y].getText().equals("M")) || (locations[x + 1][y].getText().equals("S")))) {
									row2 = x + 1;
									column2 = y;
									hit = true;
								} else
									locked[1] = true;
							}
								
							if ((random == 2) && (y - 1 != -1) && (!hit)) {
								if (!((locations[x][y - 1].getText().equals("H")) || (locations[x][y - 1].getText().equals("M")) || (locations[x][y - 1].getText().equals("S")))) {
									row2 = x;
									column2 = y - 1;
									hit = true;
								} else
									locked[2] = true;
							}

							if ((random == 3) && (y + 1 != 8) && (!hit)) {
								if (!((locations[x][y + 1].getText().equals("H")) || (locations[x][y + 1].getText().equals("M")) || (locations[x][y + 1].getText().equals("S")))) {
									row2 = x;
									column2 = y + 1;
									hit = true;
								} else
									locked[3] = true;
							}

						} while ((!hit) && (counter < 4));
					}
					if (hit)
						break;
				}
				if (hit)
					break;
			}
			if (!hit) {
				row2 = rand.nextInt(8);
				column2 = rand.nextInt(8);
			}
		/* Difficulty Hard: CPU knows where the ships are */
		} else if (difficulty == 3) {
			while (true) {
				row2 = rand.nextInt(8);
				column2 = rand.nextInt(8);
				if (textLoc[row2][column2] != 0)
					break;
			}
		}

	}

	public void showSunk(int ID, int who) {
		if (who == 0) { // player ships
			for (int x = 0; x < locations[1].length; x++) {
				for (int y = 0; y < locations[2].length; y++) {
					if (textLoc[x][y] == ID) // finds sunken ship
						locations[x][y].setText("S"); // button text SUNK
				}
			}
			CheckWinLose(); // checks if game over

		} else if (who == 1) { // cpu ships
			for (int x = 0; x < CPUlocations[1].length; x++) {
				for (int y = 0; y < CPUlocations[2].length; y++) {
					if (CPUtextLoc[x][y] == ID) { // find sunken ship
						CPUlocations[x][y].setText("S");
						CPUlocations[x][y].setOpaque(true);
						// updates colour to show ship
						if (CPUtextLoc[x][y] == 1) {
							CPUlocations[x][y].setBackground(Color.MAGENTA);
						} else if (CPUtextLoc[x][y] == 2) {
							CPUlocations[x][y].setBackground(Color.ORANGE);
						} else if (CPUtextLoc[x][y] == 3) {
							CPUlocations[x][y].setBackground(Color.GREEN);
						} else if (CPUtextLoc[x][y] == 4) {
							CPUlocations[x][y].setBackground(Color.CYAN);
						} else if (CPUtextLoc[x][y] == 5) {
							CPUlocations[x][y].setBackground(Color.YELLOW);
						}
					}
				}

			}
			CheckWinLose(); // checks if game over
		}

	}

	/* This method checks if the player has won or lost yet and changes the labels accordingly */
	public void CheckWinLose() {
		//Checks if all CPU ships are sunk (WIN)
		if ((carrierC.sunk) && (battleshipC.sunk) && (cruiserC.sunk) && (submarineC.sunk) && (destroyerC.sunk)) {
			// all CPU ships sunk
			// win
			infoLabel2.setVisible(false);
			// resize and name label
			infoLabel.setForeground(Color.RED);
			infoLabel.setFont(new Font("Impact", Font.BOLD, 56));
			infoLabel.setBounds(400, 500, 250, 56);
			infoLabel.setText("VICTORY!");
			disable = true; // disable buttons
		}
		//Checks if all player ships are sunk (LOSE)
		if ((!disable) && (carrierP.sunk) && (battleshipP.sunk) && (cruiserP.sunk) && (submarineP.sunk)
				&& (destroyerP.sunk)) { // all player ship sunk
			// lose
			infoLabel2.setVisible(false);
			// resize and name label
			infoLabel.setForeground(Color.RED);
			infoLabel.setFont(new Font("Impact", Font.BOLD, 56));
			infoLabel.setBounds(422, 500, 200, 56);
			infoLabel.setText("DEFEAT!");
			disable = true; // disable buttons
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
	public void mouseReleased(MouseEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}
