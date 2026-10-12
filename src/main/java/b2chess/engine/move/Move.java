package b2chess.engine.move;

/**
 * Utility class to help with the generation and conversion of moves.
 * 
 * Moves are represented by 16 bits.
 * 
 * From left to right, the first 6 bits are the from square, the second 6 bits
 * are the to square, and the last 4 bits are flags for special move types.
 * 
 * These flags are specifically encoded where the left most bit flags a
 * promotion, and the 2nd from the left flags a capture move. If neither of
 * those bits are 1 then it will either define a double pawn push, castle, or no
 * special move.
 * 
 * Here is the list:
 * <ul>
 * <li>0 = Quiet Move</li>
 * <li>1 = Double Pawn Push</li>
 * <li>2 = King Side Castle</li>
 * <li>3 = Queen Side Castle</li>
 * <li>4 = Capture Move</li>
 * <li>5 = En Passant</li>
 * <li>8 = Bishop Promotion</li>
 * <li>9 = Knight Promotion</li>
 * <li>10 = Rook Promotion</li>
 * <li>11 = Queen Promotion</li>
 * <li>12 = Bishop Promotion Capture</li>
 * <li>13 = Knight Promotion Capture</li>
 * <li>14 = Rook Promotion Capture</li>
 * <li>15 = Queen Promotion Capture</li>
 * </ul>
 * 
 * Credit: {@link https://chessprogramming.org/Encoding_Moves}
 */
public class Move {

	public static final int QUIET_MOVE = 0b0000;
	public static final int DOUBLE_PAWN_PUSH = 0b0001;
	public static final int KING_CASTLE = 0b0010;
	public static final int QUEEN_CASTLE = 0b0011;

	public static final int CAPTURE = 0b0100;
	public static final int EN_PASSANT_CAPTURE = 0b0101;
	public static final int BISHOP_PROMOTION_CAPTURE = 0b1100;
	public static final int KNIGHT_PROMOTION_CAPTURE = 0b1101;
	public static final int ROOK_PROMOTION_CAPTURE = 0b1110;
	public static final int QUEEN_PROMOTION_CAPTURE = 0b1111;

	public static final int BISHOP_PROMOTION = 0b1000;
	public static final int KNIGHT_PROMOTION = 0b1001;
	public static final int ROOK_PROMOTION = 0b1010;
	public static final int QUEEN_PROMOTION = 0b1011;

	public static final int SQUARE_MASK = 63;
	public static final int FLAG_MASK = 15;

	private static final int CAPTURE_MASK = 0b0100;
	private static final int PROMOTION_MASK = 0b1000;
	private static final int CASTLE_MASK = 0b1110;
	
	private Move() {
		throw new UnsupportedOperationException("Move class should not be instantiated.");
	}

	/**
	 * Helper method that takes in key move features and creates an integer value
	 * representing the move.
	 * 
	 * @param squareFrom - The square the piece is moving from.
	 * @param squareTo   - The square the piece is moving to.
	 * @param flag       - One of the flag constants.
	 * @return The bit-shifted values that make the move.
	 */
	public static int createMove(final int squareFrom, final int squareTo, final int flag) {
		return (squareFrom << 10) | (squareTo << 4) | flag;
	}
	
	public static int getSquareFrom(final int move) {
		return move >> 10;
	}
	
	public static int getSquareTo(final int move) {
		return (move >> 4) & SQUARE_MASK;
	}
	
	public static int getMoveFlag(final int move) {
		return move & FLAG_MASK;
	}
	
	public static boolean isCaptureMove(final int move) {
		return (move & CAPTURE_MASK) == CAPTURE_MASK;
	}
	
	public static boolean isEnPassant(final int move) {
		return getMoveFlag(move) == EN_PASSANT_CAPTURE;
	}
	
	public static boolean isPromotion(final int move) {
		return (move & PROMOTION_MASK) == PROMOTION_MASK;
	}
	
	public static boolean isCastle(final int move) {
		return (move & CASTLE_MASK) == KING_CASTLE;
	}
}
