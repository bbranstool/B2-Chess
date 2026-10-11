package b2chess.engine.board.piece;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ColorTests {

	@Test
	void ColorTests_0001_OppositeColor() {
		assertEquals(Color.WHITE, Color.getOpponentColor(Color.BLACK));
		assertEquals(Color.BLACK, Color.getOpponentColor(Color.WHITE));
	}
	
}
