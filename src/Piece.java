/**
 * This enumeration contains all the pieces with attributes : id, limit and
 * possible moves (direction).
 * Limit corresponds to the maximum advance the piece can do.
 * 
 * @author Elias MEHIRA, Florent FRAITOT, Alexis JUST, Giovanni FIEUX
 * @version 1.0
 */
public enum Piece {
        BLACKKING(12, 1,
                        new byte[][] { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, 0 },
                                        { -1, -1 } }),
        BLACKQUEEN(11, 7,
                        new byte[][] { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, 0 },
                                        { -1, -1 } }),
        BLACKBISHOP(10, 7, new byte[][] { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } }),
        BLACKKNIGHT(9, 1,
                        new byte[][] { { 2, 1 }, { 2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { -2, 1 },
                                        { -2, -1 } }),
        BLACKROOK(8, 7, new byte[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } }),
        BLACKPAWN(7, 0, new byte[][] { { 1, 0 }, { 2, 0 }, { 1, 1 }, { 1, -1 } }),

        WHITEKING(5, 1,
                        new byte[][] { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, 0 },
                                        { -1, -1 } }),
        WHITEQUEEN(4, 7,
                        new byte[][] { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, 0 },
                                        { -1, -1 } }),
        WHITEBISHOP(3, 7, new byte[][] { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } }),
        WHITEKNIGHT(2, 1,
                        new byte[][] { { 2, 1 }, { 2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { -2, 1 },
                                        { -2, -1 } }),
        WHITEROOK(1, 7, new byte[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } }),
        WHITEPAWN(6, 0, new byte[][] { { -1, 0 }, { -2, 0 }, { -1, 1 }, { -1, -1 } });

        /**
         * Represents the number of the piece.
         */
        private final int id;
        /**
         * Corresponds to the maximum advance of a piece in one direction.
         */
        private final int limit;
        /**
         * Represents all the possible directions to move the piece.
         */
        private final byte[][] direction;

        private Piece(int i, int l, byte[][] dir) {
                this.limit = l;
                this.direction = dir;
                this.id = i;
        }

        public int getLimit() {
                return this.limit;
        }

        public byte[][] getDirection() {
                return this.direction;
        }

        public byte getId() {
                return (byte) this.id;
        }
}