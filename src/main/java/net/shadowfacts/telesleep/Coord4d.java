package net.shadowfacts.telesleep;

/**
 * Simple class for storage four dimensional coordinates in.
 * (x, y, z, dimension)
 * @author shadowfacts
 */
public class Coord4d {

	public int x;
	public int y;
	public int z;
	public int dim;

	public Coord4d(int x, int y, int z, int dim) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.dim = dim;
	}

	public Coord4d(String s) {
		String[] ints = s.split(", ");
		x = Integer.parseInt(ints[0]);
		y = Integer.parseInt(ints[1]);
		z = Integer.parseInt(ints[2]);
		dim = Integer.parseInt(ints[3]);
	}

	@Override
	public String toString() {
		return x + ", " + y + ", " + z + ", " + dim;
	}
}
