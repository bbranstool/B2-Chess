package b2chess.engine.move;

//TODO: Look into making this a single int in the future.
public record MoveUndoInfo(int capturedPiece, int castlingRights, int enPassantSquare, int halfMoveClock) {

}
