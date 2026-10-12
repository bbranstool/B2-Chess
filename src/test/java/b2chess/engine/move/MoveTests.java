package b2chess.engine.move;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MoveTests {

	@Test
	void MoveTests_0001_CreateMove_EncodesFields() {
		int expected = (12 << 10) | (28 << 4);
		assertEquals(expected, Move.createMove(12, 28, Move.QUIET_MOVE));
	}

	@Test
	void MoveTests_0002_CreateMove_EncodesEveryFlag() {
		for (int flag = 0; flag < 16; flag++) {
			int expected = (12 << 10) | (28 << 4) | flag;
			assertEquals(expected, Move.createMove(12, 28, flag));
		}
	}

	@Test
	void MoveTests_0003_CreateMove_BoundarySquares() {
		assertEquals(0, Move.createMove(0, 0, Move.QUIET_MOVE));
		assertEquals(65535, Move.createMove(63, 63, 15));
	}

	@Test
	void MoveTests_0004_GetSquareFrom_ReturnsOrigin() {
		assertEquals(12, Move.getSquareFrom(Move.createMove(12, 28, Move.QUIET_MOVE)));
		assertEquals(63, Move.getSquareFrom(Move.createMove(63, 0, Move.QUIET_MOVE)));
	}

	@Test
	void MoveTests_0005_GetSquareTo_ReturnsDestination() {
		assertEquals(28, Move.getSquareTo(Move.createMove(12, 28, Move.QUIET_MOVE)));
		assertEquals(63, Move.getSquareTo(Move.createMove(0, 63, Move.QUIET_MOVE)));
	}

	@Test
	void MoveTests_0006_GetMoveFlag_ReturnsFlag() {
		for (int flag = 0; flag < 16; flag++) {
			assertEquals(flag, Move.getMoveFlag(Move.createMove(12, 28, flag)));
		}
	}

	@Test
	void MoveTests_0007_IsCaptureMove_RecognizesCaptures() {
		int[] captureFlags = { Move.CAPTURE, Move.EN_PASSANT_CAPTURE, Move.BISHOP_PROMOTION_CAPTURE,
				Move.KNIGHT_PROMOTION_CAPTURE, Move.ROOK_PROMOTION_CAPTURE, Move.QUEEN_PROMOTION_CAPTURE };

		for (int flag : captureFlags) {
			assertTrue(Move.isCaptureMove(Move.createMove(12, 28, flag)));
		}
	}

	@Test
	void MoveTests_0008_IsCaptureMove_RejectsNonCaptures() {
		int[] nonCaptureFlags = { Move.QUIET_MOVE, Move.DOUBLE_PAWN_PUSH, Move.KING_CASTLE, Move.QUEEN_CASTLE,
				Move.BISHOP_PROMOTION, Move.KNIGHT_PROMOTION, Move.ROOK_PROMOTION, Move.QUEEN_PROMOTION };

		for (int flag : nonCaptureFlags) {
			assertFalse(Move.isCaptureMove(Move.createMove(12, 28, flag)));
		}
	}

	@Test
	void MoveTests_0009_IsEnPassant_RecognizesEnPassant() {
		assertTrue(Move.isEnPassant(Move.createMove(36, 43, Move.EN_PASSANT_CAPTURE)));
	}

	@Test
	void MoveTests_0010_IsEnPassant_RejectsOtherFlags() {
		int[] nonEnPassantFlags = { Move.QUIET_MOVE, Move.DOUBLE_PAWN_PUSH, Move.KING_CASTLE, Move.QUEEN_CASTLE,
				Move.CAPTURE, Move.BISHOP_PROMOTION, Move.KNIGHT_PROMOTION, Move.ROOK_PROMOTION, Move.QUEEN_PROMOTION,
				Move.BISHOP_PROMOTION_CAPTURE, Move.KNIGHT_PROMOTION_CAPTURE, Move.ROOK_PROMOTION_CAPTURE,
				Move.QUEEN_PROMOTION_CAPTURE };

		for (int flag : nonEnPassantFlags) {
			assertFalse(Move.isEnPassant(Move.createMove(49, 56, flag)),
					"Unexpected en passant result for flag " + flag);
		}
	}

	@Test
	void MoveTests_0011_IsPromotion_RecognizesAllPromotions() {
		for (int flag = 8; flag <= 15; flag++) {
			assertTrue(Move.isPromotion(Move.createMove(48, 56, flag)));
		}
	}

	@Test
	void MoveTests_0012_IsPromotion_RejectsNonPromotions() {
		for (int flag = 0; flag < 8; flag++) {
			assertFalse(Move.isPromotion(Move.createMove(12, 28, flag)));
		}
	}

	@Test
	void MoveTests_0013_CreateMoveAndExtractFields_RoundTrip() {
		for (int from = 0; from < 64; from++) {
			for (int to = 0; to < 64; to++) {
				for (int flag = 0; flag < 16; flag++) {
					int move = Move.createMove(from, to, flag);

					assertEquals(from, Move.getSquareFrom(move));
					assertEquals(to, Move.getSquareTo(move));
					assertEquals(flag, Move.getMoveFlag(move));
				}
			}
		}
	}

}
