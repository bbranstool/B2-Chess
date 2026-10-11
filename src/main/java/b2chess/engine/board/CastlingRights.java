package b2chess.engine.board;

import java.util.Arrays;

/**
 * Utility class that handles castling rights and determining if a move for a
 * square should update the castling rights.
 * 
 * Castling rights are stored as 4 bits, as follows:
 * 
 * 1 - White King Side
 * 
 * 2 - White Queen Side
 * 
 * 4 - Black King Side
 * 
 * 8 - Black Queen Side
 */
public class CastlingRights {

	public static final int WHITE_KING_SIDE = 1;
	public static final int WHITE_QUEEN_SIDE = 2;
	public static final int WHITE_BOTH = 3;

	public static final int BLACK_KING_SIDE = 4;
	public static final int BLACK_QUEEN_SIDE = 8;
	public static final int BLACK_BOTH = 12;

	public static final int EMPTY_CASTLING_RIGHTS = 0;
	public static final int ALL_CASTLING_RIGHTS = 15;

	/*
	 * Instructions on how to update castling rights if an interaction with any
	 * square happens.
	 */
	private static final int[] CASTLING_RIGHTS = new int[64];

	static {
		Arrays.fill(CASTLING_RIGHTS, ALL_CASTLING_RIGHTS);
		CASTLING_RIGHTS[0] = ALL_CASTLING_RIGHTS ^ WHITE_QUEEN_SIDE;
		CASTLING_RIGHTS[4] = ALL_CASTLING_RIGHTS ^ WHITE_BOTH;
		CASTLING_RIGHTS[7] = ALL_CASTLING_RIGHTS ^ WHITE_KING_SIDE;
		CASTLING_RIGHTS[56] = ALL_CASTLING_RIGHTS ^ BLACK_QUEEN_SIDE;
		CASTLING_RIGHTS[60] = ALL_CASTLING_RIGHTS ^ BLACK_BOTH;
		CASTLING_RIGHTS[63] = ALL_CASTLING_RIGHTS ^ BLACK_KING_SIDE;
	}

	private CastlingRights() {
		throw new UnsupportedOperationException("CastlingRights class should not be instantiated.");
	}

	/**
	 * Helper method that applies the update to castling rights from a given square.
	 * 
	 * @param castlingRights - The previous castling rights.
	 * @param square         - The square to get castling rights for.
	 * @return The updated castling rights.
	 */
	public static int updateCastlingRights(final int castlingRights, final int square) {
		return castlingRights & getCastlingRightsUpdate(square);
	}

	/**
	 * Returns the bitmask that represents the castling rights that need to be
	 * modified if the given square is interacted with.
	 * 
	 * For example, if square 0 (a1) is interacted with, then 0b1101 (13) would be
	 * returned because the queen side castle would no longer be available.
	 * 
	 * @param square - The square to get castling rights for.
	 * @return A 4 bit representation of which bits to update.
	 * @throws IndexOutOfBoundsException
	 */
	public static int getCastlingRightsUpdate(final int square) throws IndexOutOfBoundsException {
		return CASTLING_RIGHTS[square];
	}

}
