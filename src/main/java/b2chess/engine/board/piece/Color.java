package b2chess.engine.board.piece;

/**
 * 
 * Utility class used for color identification.
 * 
 */
public class Color {

	public static final int WHITE = 0;
	public static final int BLACK = 1;

	private Color() {
		throw new UnsupportedOperationException("Color class should not be instantiated.");
	}

	/**
	 * Helper method to get the opposite color from a given color.
	 * 
	 * Uses the XOR operator to flip the color bit.
	 * 
	 * @param color - The color to find opponent of.
	 * @return 0 or 1 depending on color.
	 */
	public static int getOpponentColor(final int color) {
		return color ^ 1;
	}
	
}
