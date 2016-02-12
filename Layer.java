package Project;
/**
 * Layer class.
 * Creates a 16x16 grid of booleans, all initially set to false.
 * Boolean value represents if button has been pressed.
 * The boolean value will then indicate when a sound is to be played.
 *
 * @author Jessica, Ecaterina, Natalia, Preslav
 * 
 * @version 1.1 9/2/16
 */
public class Layer {

	// Two dimensional array of matrix buttons.
	private boolean[][] grid = new boolean[16][16];

	
	/**
	 * Layer constructor.
	 * When the layer object is created all the values 
	 * in the grid /two dimensional array/ are initialized
	 * to false, because it is assumed none of the buttons in 
	 * the grid are active/have been pressed.
	 */
	public Layer() {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				grid[i][j] = false;
			}
		}
	}
	
	/**
	 * Method sets a Boolean value for specific button.
	 * 
	 * @param x		row coordinate x
	 * @param y		column coordinate y
	 * @param b		Boolean value
	 */
	public void setGrid(int x, int y, boolean b){
		grid[x][y] = b;
	}
	
	
	/**
	 * Method returns two-dimensional array of 
	 * Boolean values for current grid.
	 * 
	 * @return two-dimensional array of Boolean values
	 */
	public boolean getGrid(int x, int y){
		return grid[x][y];
	}
	
	/**
	 * Method allows to switch Boolean value 
	 * for a specific button on the matrix.
	 * 
	 * @param x 	row coordinate x
	 * @param y		column coordinate y
	 */
	public void toggle(int x, int y){
		grid[x][y]=!grid[x][y];
	}

}
	


