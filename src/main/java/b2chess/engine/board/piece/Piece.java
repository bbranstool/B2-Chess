package b2chess.engine.board.piece;

/**
 * 
 * Utility class that stores all pieces as integers and handles the conversions
 * from piece to string.
 * 
 * 0 = Empty Square
 * 
 * 1 - 6 = White Pieces (0001 - 0110)
 * 
 * 9 - 14 = Black Pieces (1001 - 1110)
 * 
 * The 4th bit acts as the color flag/bit.
 * 
 */
public class Piece {

	// Empty Square (duh)
	public static final int EMPTY_SQUARE = 0;

	// All pieces ignoring the color bit.
	public static final int PAWN = 1;
	public static final int BISHOP = 2;
	public static final int KNIGHT = 3;
	public static final int ROOK = 4;
	public static final int QUEEN = 5;
	public static final int KING = 6;

	// Color bit 1000 = 8
	public static final int COLOR_FLAG = 8;

	// Helper mask for only keeping the piece information.
	public static final int PIECE_MASK = 7;

	// White Pieces
	public static final int WHITE_PAWN = PAWN;
	public static final int WHITE_BISHOP = BISHOP;
	public static final int WHITE_KNIGHT = KNIGHT;
	public static final int WHITE_ROOK = ROOK;
	public static final int WHITE_QUEEN = QUEEN;
	public static final int WHITE_KING = KING;

	// Black Pieces
	public static final int BLACK_PAWN = COLOR_FLAG | PAWN;
	public static final int BLACK_BISHOP = COLOR_FLAG | BISHOP;
	public static final int BLACK_KNIGHT = COLOR_FLAG | KNIGHT;
	public static final int BLACK_ROOK = COLOR_FLAG | ROOK;
	public static final int BLACK_QUEEN = COLOR_FLAG | QUEEN;
	public static final int BLACK_KING = COLOR_FLAG | KING;

	private Piece() {
		throw new UnsupportedOperationException("Piece class should not be instantiated.");
	}

	/**
	 * helper method to get the integer value representing the piece type.
	 * 
	 * @param piece - The integer representation of the piece.
	 * @return The last 3 bits of the piece, identifying the piece type.
	 */
	public static int getPieceType(final int piece) {
		return piece & PIECE_MASK;
	}

	/**
	 * Helper method to get the integer value representing the piece color.
	 * 
	 * @param piece - The integer representation of the piece.
	 * @return 0 if the piece is white, or 1 if the piece is black.
	 */
	public static int getPieceColor(final int piece) {
		return (piece & COLOR_FLAG) >> 3;
	}

	/**
	 * Helper method to convert a FEN character into an integer representation of a
	 * piece.
	 * 
	 * @param pieceFenString - The single FEN character representing a piece as a
	 *                       String.
	 * @return The integer representation of a piece.
	 * @throws IllegalArgumentException if an invalid FEN character is passed in.
	 */
	public static int fenToPiece(final String pieceFenString) throws IllegalArgumentException {
		return switch (pieceFenString) {
			// White Pieces
			case "P":
				yield WHITE_PAWN;
			case "B":
				yield WHITE_BISHOP;
			case "N":
				yield WHITE_KNIGHT;
			case "R":
				yield WHITE_ROOK;
			case "Q":
				yield WHITE_QUEEN;
			case "K":
				yield WHITE_KING;

			// Black Pieces
			case "p":
				yield BLACK_PAWN;
			case "b":
				yield BLACK_BISHOP;
			case "n":
				yield BLACK_KNIGHT;
			case "r":
				yield BLACK_ROOK;
			case "q":
				yield BLACK_QUEEN;
			case "k":
				yield BLACK_KING;

			default:
				throw new IllegalArgumentException("Invalid FEN piece character: " + pieceFenString);
		};
	}

	/**
	 * Helper method to convert a piece into its FEN string representation.
	 * 
	 * @param piece - The integer representation of the piece.
	 * @return The FEN string representation of the piece.
	 * @throws IllegalArgumentException if an invalid piece integer is passed in.
	 */
	public static String pieceToFenString(final int piece) throws IllegalArgumentException {
		return switch (piece) {
			// White Pieces
			case WHITE_PAWN:
				yield "P";
			case WHITE_KNIGHT:
				yield "N";
			case WHITE_BISHOP:
				yield "B";
			case WHITE_ROOK:
				yield "R";
			case WHITE_QUEEN:
				yield "Q";
			case WHITE_KING:
				yield "K";

			// Black Pieces
			case BLACK_PAWN:
				yield "p";
			case BLACK_KNIGHT:
				yield "n";
			case BLACK_BISHOP:
				yield "b";
			case BLACK_ROOK:
				yield "r";
			case BLACK_QUEEN:
				yield "q";
			case BLACK_KING:
				yield "k";

			default:
				throw new IllegalArgumentException("Invalid piece value: " + piece);
		};
	}

}
