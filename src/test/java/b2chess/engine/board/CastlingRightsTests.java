package b2chess.engine.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class CastlingRightsTests {

	@Test
	void CastlingRightsTests_0001_UpdateCastlingRights_WhiteQueenRookSquare() {
		assertEquals(13, CastlingRights.updateCastlingRights(CastlingRights.ALL_CASTLING_RIGHTS, 0));
	}

	@Test
	void CastlingRightsTests_0002_UpdateCastlingRights_WhiteKingSquare() {
		assertEquals(CastlingRights.BLACK_BOTH,
				CastlingRights.updateCastlingRights(CastlingRights.ALL_CASTLING_RIGHTS, 4));
	}

	@Test
	void CastlingRightsTests_0003_UpdateCastlingRights_WhiteKingRookSquare() {
		assertEquals(14, CastlingRights.updateCastlingRights(CastlingRights.ALL_CASTLING_RIGHTS, 7));
	}

	@Test
	void CastlingRightsTests_0004_UpdateCastlingRights_BlackQueenRookSquare() {
		assertEquals(7, CastlingRights.updateCastlingRights(CastlingRights.ALL_CASTLING_RIGHTS, 56));
	}

	@Test
	void CastlingRightsTests_0005_UpdateCastlingRights_BlackKingSquare() {
		assertEquals(CastlingRights.WHITE_BOTH,
				CastlingRights.updateCastlingRights(CastlingRights.ALL_CASTLING_RIGHTS, 60));
	}

	@Test
	void CastlingRightsTests_0006_UpdateCastlingRights_BlackKingRookSquare() {
		assertEquals(11, CastlingRights.updateCastlingRights(CastlingRights.ALL_CASTLING_RIGHTS, 63));
	}

	@Test
	void CastlingRightsTests_0007_UpdateCastlingRights_OtherSquarePreservesAllRights() {
		assertEquals(CastlingRights.ALL_CASTLING_RIGHTS, CastlingRights.updateCastlingRights(15, 27));
	}

	@Test
	void CastlingRightsTests_0008_UpdateCastlingRights_PreservesPreviouslyRemovedRights() {
		assertEquals(12, CastlingRights.updateCastlingRights(13, 4));
	}

	@Test
	void CastlingRightsTests_0009_UpdateCastlingRights_ZeroRightsRemainZero() {
		assertEquals(CastlingRights.EMPTY_CASTLING_RIGHTS,
				CastlingRights.updateCastlingRights(CastlingRights.EMPTY_CASTLING_RIGHTS, 4));
		assertEquals(CastlingRights.EMPTY_CASTLING_RIGHTS,
				CastlingRights.updateCastlingRights(CastlingRights.EMPTY_CASTLING_RIGHTS, 27));
	}

}
