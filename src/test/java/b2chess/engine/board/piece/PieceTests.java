package b2chess.engine.board.piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PieceTests {

	@Test
	void PieceTests_0001_GetPieceType_WhitePieces() {
		assertEquals(Piece.PAWN, Piece.getPieceType(Piece.WHITE_PAWN));
		assertEquals(Piece.BISHOP, Piece.getPieceType(Piece.WHITE_BISHOP));
		assertEquals(Piece.KNIGHT, Piece.getPieceType(Piece.WHITE_KNIGHT));
		assertEquals(Piece.ROOK, Piece.getPieceType(Piece.WHITE_ROOK));
		assertEquals(Piece.QUEEN, Piece.getPieceType(Piece.WHITE_QUEEN));
		assertEquals(Piece.KING, Piece.getPieceType(Piece.WHITE_KING));
	}

	@Test
	void PieceTests_0002_GetPieceType_BlackPieces() {
		assertEquals(Piece.PAWN, Piece.getPieceType(Piece.BLACK_PAWN));
		assertEquals(Piece.BISHOP, Piece.getPieceType(Piece.BLACK_BISHOP));
		assertEquals(Piece.KNIGHT, Piece.getPieceType(Piece.BLACK_KNIGHT));
		assertEquals(Piece.ROOK, Piece.getPieceType(Piece.BLACK_ROOK));
		assertEquals(Piece.QUEEN, Piece.getPieceType(Piece.BLACK_QUEEN));
		assertEquals(Piece.KING, Piece.getPieceType(Piece.BLACK_KING));
	}

	@Test
	void PieceTests_0003_GetPieceType_EmptySquare() {
		assertEquals(Piece.EMPTY_SQUARE, Piece.getPieceType(Piece.EMPTY_SQUARE));
	}

	@Test
	void PieceTests_0004_GetPieceType_IgnoresColorFlag() {
		assertEquals(Piece.getPieceType(Piece.WHITE_PAWN), Piece.getPieceType(Piece.BLACK_PAWN));
		assertEquals(Piece.getPieceType(Piece.WHITE_KING), Piece.getPieceType(Piece.BLACK_KING));
	}

	@Test
	void PieceTests_0005_GetPieceColor_WhitePieces() {
		assertEquals(Color.WHITE, Piece.getPieceColor(Piece.WHITE_PAWN));
		assertEquals(Color.WHITE, Piece.getPieceColor(Piece.WHITE_BISHOP));
		assertEquals(Color.WHITE, Piece.getPieceColor(Piece.WHITE_KNIGHT));
		assertEquals(Color.WHITE, Piece.getPieceColor(Piece.WHITE_ROOK));
		assertEquals(Color.WHITE, Piece.getPieceColor(Piece.WHITE_QUEEN));
		assertEquals(Color.WHITE, Piece.getPieceColor(Piece.WHITE_KING));
	}

	@Test
	void PieceTests_0006_GetPieceColor_BlackPieces() {
		assertEquals(Color.BLACK, Piece.getPieceColor(Piece.BLACK_PAWN));
		assertEquals(Color.BLACK, Piece.getPieceColor(Piece.BLACK_BISHOP));
		assertEquals(Color.BLACK, Piece.getPieceColor(Piece.BLACK_KNIGHT));
		assertEquals(Color.BLACK, Piece.getPieceColor(Piece.BLACK_ROOK));
		assertEquals(Color.BLACK, Piece.getPieceColor(Piece.BLACK_QUEEN));
		assertEquals(Color.BLACK, Piece.getPieceColor(Piece.BLACK_KING));
	}

	@Test
	void PieceTests_0007_FenToPiece_WhitePieces() {
		assertEquals(Piece.WHITE_PAWN, Piece.fenToPiece("P"));
		assertEquals(Piece.WHITE_BISHOP, Piece.fenToPiece("B"));
		assertEquals(Piece.WHITE_KNIGHT, Piece.fenToPiece("N"));
		assertEquals(Piece.WHITE_ROOK, Piece.fenToPiece("R"));
		assertEquals(Piece.WHITE_QUEEN, Piece.fenToPiece("Q"));
		assertEquals(Piece.WHITE_KING, Piece.fenToPiece("K"));
	}

	@Test
	void PieceTests_0008_FenToPiece_BlackPieces() {
		assertEquals(Piece.BLACK_PAWN, Piece.fenToPiece("p"));
		assertEquals(Piece.BLACK_BISHOP, Piece.fenToPiece("b"));
		assertEquals(Piece.BLACK_KNIGHT, Piece.fenToPiece("n"));
		assertEquals(Piece.BLACK_ROOK, Piece.fenToPiece("r"));
		assertEquals(Piece.BLACK_QUEEN, Piece.fenToPiece("q"));
		assertEquals(Piece.BLACK_KING, Piece.fenToPiece("k"));
	}

	@Test
	void PieceTests_0009_FenToPiece_InvalidCharacter() {
		assertThrows(IllegalArgumentException.class, () -> Piece.fenToPiece("X"));
	}

	@Test
	void PieceTests_0010_PieceToFenString_WhitePieces() {
		assertEquals("P", Piece.pieceToFenString(Piece.WHITE_PAWN));
		assertEquals("B", Piece.pieceToFenString(Piece.WHITE_BISHOP));
		assertEquals("N", Piece.pieceToFenString(Piece.WHITE_KNIGHT));
		assertEquals("R", Piece.pieceToFenString(Piece.WHITE_ROOK));
		assertEquals("Q", Piece.pieceToFenString(Piece.WHITE_QUEEN));
		assertEquals("K", Piece.pieceToFenString(Piece.WHITE_KING));
	}

	@Test
	void PieceTests_0011_PieceToFenString_BlackPieces() {
		assertEquals("p", Piece.pieceToFenString(Piece.BLACK_PAWN));
		assertEquals("b", Piece.pieceToFenString(Piece.BLACK_BISHOP));
		assertEquals("n", Piece.pieceToFenString(Piece.BLACK_KNIGHT));
		assertEquals("r", Piece.pieceToFenString(Piece.BLACK_ROOK));
		assertEquals("q", Piece.pieceToFenString(Piece.BLACK_QUEEN));
		assertEquals("k", Piece.pieceToFenString(Piece.BLACK_KING));
	}

	@Test
	void PieceTests_0012_FenToPieceAndBack_WhitePieces() {
		assertEquals("P", Piece.pieceToFenString(Piece.fenToPiece("P")));
		assertEquals("B", Piece.pieceToFenString(Piece.fenToPiece("B")));
		assertEquals("N", Piece.pieceToFenString(Piece.fenToPiece("N")));
		assertEquals("R", Piece.pieceToFenString(Piece.fenToPiece("R")));
		assertEquals("Q", Piece.pieceToFenString(Piece.fenToPiece("Q")));
		assertEquals("K", Piece.pieceToFenString(Piece.fenToPiece("K")));
	}

	@Test
	void PieceTests_0013_FenToPieceAndBack_BlackPieces() {
		assertEquals("p", Piece.pieceToFenString(Piece.fenToPiece("p")));
		assertEquals("b", Piece.pieceToFenString(Piece.fenToPiece("b")));
		assertEquals("n", Piece.pieceToFenString(Piece.fenToPiece("n")));
		assertEquals("r", Piece.pieceToFenString(Piece.fenToPiece("r")));
		assertEquals("q", Piece.pieceToFenString(Piece.fenToPiece("q")));
		assertEquals("k", Piece.pieceToFenString(Piece.fenToPiece("k")));
	}
}
