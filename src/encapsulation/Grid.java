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
	
	public void set(int x, int y, double value) {
		if (x < 0 || x >= rows)
			throw new IndexOutOfBoundsException("The x coordinate is out of bounds");
		if (y < 0 || y >= columns)
			throw new IndexOutOfBoundsException("The y coordinate is out of bounds");
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
