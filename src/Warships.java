/**
 * @author Alan Chen
 * AP Computer Science 2016-2017
 * Project: Battleship (final Graphics Project)
 * TODO: 
 */
//random class import
import java.util.Random;

public class Warships { // class that holds ship objects

	int size = 0; // ship # of tiles
	int shipType = 0; // ship shipType
	Random rand = new Random(); // random object
	int location[] = new int[3]; // stores random variables
	boolean goodLoc = false; // stores if able to be placed in position
	boolean sunk = false; // stores if sink is sunk or not
	int health = 0; // stores spaces of ship not hit (# of tiles left)

	Warships(int shipType) { // constructor- constructs with ship shipType

		if (shipType == 1) // if shipType = 1, ship is 3 tile
			size = 3; // set size to 3
		else // any other shipType, ship is shipType tile
			size = shipType; // set size to shipType

		this.shipType = shipType; // passes shipType into object
		health = size; // sets spaces left to size 

	}

	public void FindArea(int[][] loc) { // finds area for CPU ships

		do { // loops until a good location is found

			boolean exit = false; // sets exit to false (exit becomes true if bad location)
			
			/*
			 * location[0]/location[1]: used for the row/column number
			 * location[2]: used for direction to place, 1 for up, 2 for down, 3 for left, 4 for right
			 */
			location[0] = rand.nextInt(8);
			location[1] = rand.nextInt(8);
			location[2] = rand.nextInt(4) + 1; 

			if (loc[location[0]][location[1]] == 0) { //continue if space is blank

				if (location[2] == 1) {//up
					if (9 - size > location[0]) {
						loc[location[0]][location[1]] = shipType; //sets first spot
						for (int y = 1; y < size; y++) {
							if (loc[location[0] + y][location[1]] > 0) { // if location !=0 (already taken)
								loc[location[0]][location[1]] = 0;
								exit = true; // exits 
							}
						}
						if (!exit) { // good location
							goodLoc = true;
							for (int z = 1; z < size; z++)
								loc[location[0] + z][location[1]] = shipType; // fill 

						} else
							exit = false;
					}
				} else if (location[2] == 2) { //down
					if (9 - size > location[1]) {
						loc[location[0]][location[1]] = shipType;
						for (int y = 1; y < size; y++) {
							if (loc[location[0]][location[1] + y] != 0) {
								loc[location[0]][location[1]] = 0;
								exit = true;
							}
						}
						if (!exit) {
							goodLoc = true;
							for (int z = 1; z < size; z++)
								loc[location[0]][location[1] + z] = shipType;

						} else
							exit = false;
					}
				} else if (location[2] == 3) { // left
					if (location[0] > size - 2) {
						loc[location[0]][location[1]] = shipType;
						for (int y = 1; y < size; y++) {
							if (loc[location[0] - y][location[1]] != 0) {
								loc[location[0]][location[1]] = 0;
								exit = true;
							}
						}
						if (!exit) {
							goodLoc = true;
							for (int z = 1; z < size; z++)
								loc[location[0] - z][location[1]] = shipType;

						} else
							exit = false;
					}
				} else if (location[2] == 4) { // right
					if (location[1] > size - 2) {
						loc[location[0]][location[1]] = shipType;
						for (int y = 1; y < size; y++) {
							if (loc[location[0]][location[1] - y] != 0) {
								loc[location[0]][location[1]] = 0;
								exit = true;
							}
						}
						if (!exit) {
							goodLoc = true;
							for (int z = 1; z < size; z++)
								loc[location[0]][location[1] - z] = shipType;

						} else
							exit = false;
					}
				}

			}

		} while (!goodLoc);

	}

	public boolean CheckArea(int[][] loc, int vert, int horiz, int dir) { // checks player clicks

		boolean exit = false;
		
		// variables passed from gameframe
		location[0] = vert;
		location[1] = horiz;
		location[2] = dir; // 1 = down, 2 = right

		if (loc[location[0]][location[1]] == 0) {

			if (location[2] == 1) {
				if (9 - size > location[0]) {
					loc[location[0]][location[1]] = shipType;
					for (int y = 1; y < size; y++) {
						if (loc[location[0] + y][location[1]] > 0) {
							loc[location[0]][location[1]] = 0;
							exit = true;

						}
					}
					if (!exit) {
						goodLoc = true;
						for (int z = 1; z < size; z++)
							loc[location[0] + z][location[1]] = shipType;
						for (int z = 0; z < size; z++) {

						}
					} else
						exit = false;
				}

			} else if (location[2] == 2) {
				if (9 - size > location[1]) {
					loc[location[0]][location[1]] = shipType;
					for (int y = 1; y < size; y++) {
						if (loc[location[0]][location[1] + y] != 0) {
							loc[location[0]][location[1]] = 0;
							exit = true;
						}
					}
					if (!exit) {
						goodLoc = true;
						for (int z = 1; z < size; z++)
							loc[location[0]][location[1] + z] = shipType;

					} else
						exit = false;
				} 
			}

		}

		if (goodLoc) // returns true so the ship can be placed on board
			return true;
		else // returns false so another location can be chosen
			return false;
	}
}
