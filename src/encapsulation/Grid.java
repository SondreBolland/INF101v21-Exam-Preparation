package encapsulation;

public class Grid {

	private double[][] grid;
	
	private int rows;
	private int columns;
	
	public Grid(int height, int width) {
		rows = height;
		columns = width;
		
		grid = new double[rows][columns];
	}
	
	/**
	 * Set element in grid at coordinates x and y.
	 * No values above 100.0 are allowed.
	 * @param x coordinate
	 * @param y coordinate
	 * @param value, element to set in the grid
	 */
	public void set(int x, int y, double value) {
		if (x < 0 || x >= rows)
			throw new IndexOutOfBoundsException("The x coordinate is out of bounds");
		if (y < 0 || y >= columns)
			throw new IndexOutOfBoundsException("The y coordinate is out of bounds");
		if (value > 100.0)
			throw new IllegalArgumentException("No values above 100.0 are allowed");
		grid[x][y] = value;
	}
	
	public double get(int x, int y) {
		if (x < 0 || x >= rows)
			throw new IndexOutOfBoundsException("The x coordinate is out of bounds");
		if (y < 0 || y >= columns)
			throw new IndexOutOfBoundsException("The y coordinate is out of bounds");
		return grid[x][y];
	}
}
