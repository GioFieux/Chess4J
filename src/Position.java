import java.io.Serializable;

/**
 * This class has an attribute pos, a matrix 8 by 8, which represents the
 * chessboard where we put the pieces.
 * In this class, for each piece we can find its accessible cases.
 * If the piece has an accessible case, we can move the piece to the new
 * destination chosen by the player.<br>
 * Furthermore, the class can check if the kings are in check or not, in
 * checkmate or not, in stalemate position or not.
 * <br>
 * Note : the Position class implements Cloneable and Serializable to give an
 * implementation of
 * the method clone, and to allow the classe to serialize for saves.
 * and has classic methods such as toString(), and gives getters and setters for
 * every attributs.
 * 
 * @author Elias MEHIRA, Florent FRAITOT, Alexis JUST, Giovanni FIEUX
 * @version 1.0
 */

public class Position implements Cloneable, Serializable {

    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate a1 = new Coordinate("a1");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate a8 = new Coordinate("a8");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate h1 = new Coordinate("h1");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate h8 = new Coordinate("h8");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate c1 = new Coordinate("c1");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate d1 = new Coordinate("d1");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate f1 = new Coordinate("f1");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate g1 = new Coordinate("g1");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate c8 = new Coordinate("c8");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate d8 = new Coordinate("d8");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate f8 = new Coordinate("f8");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate g8 = new Coordinate("g8");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate b1 = new Coordinate("b1");
    /**
     * Corresponding the cases in the first and last line of the chessboard
     * in order to control the whiteCastle, blackCastle, whiteCastleLong,
     * blackCastleLong
     * with the rook and king pieces.
     */
    private final Coordinate b8 = new Coordinate("b8");

    /**
     * Matrix 8*8 of byte : A matrix corresponding to the exact position, from int
     * going to 0 to 12,
     * 0 being an empty case,
     * 1 to 6
     * and 7 to 12 representing white and black pieces.
     */
    private byte[][] pos = {
            { 0, Piece.BLACKKING.getId(), 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, Piece.WHITEQUEEN.getId(), 0, Piece.WHITEKING.getId(), 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { Piece.WHITEPAWN.getId(), Piece.WHITEPAWN.getId(), Piece.WHITEPAWN.getId(),
                    Piece.WHITEPAWN.getId(),
                    Piece.WHITEPAWN.getId(), Piece.WHITEPAWN.getId(), Piece.WHITEPAWN.getId(),
                    Piece.WHITEPAWN.getId() },
            { Piece.WHITEROOK.getId(), Piece.WHITEKNIGHT.getId(),
                    Piece.WHITEBISHOP.getId(),
                    0, 0,
                    Piece.WHITEBISHOP.getId(), Piece.WHITEKNIGHT.getId(),
                    Piece.WHITEROOK.getId() }
    };

    /**
     * Indicating if said castles are still allowed,
     * they're initialized as true
     * and can turn false when called the playMove method.
     */
    private boolean whiteCastle;
    /**
     * Indicating if said castles are still allowed,
     * they're initialized as true
     * and can turn false when called the playMove method.
     */
    private boolean blackCastle;
    /**
     * Indicating if said castles are still allowed,
     * they're initialized as true
     * and can turn false when called the playMove method.
     */
    private boolean whiteCastleLong;
    /**
     * Indicating if said castles are still allowed,
     * they're initialized as true
     * and can turn false when called the playMove method.
     */
    private boolean blackCastleLong;

    /**
     * Indicating which color it's to play. True is equal to white pieces� turn
     * and false corresponds at black pieces� turn.
     */
    private boolean turn;
    /**
     * Indicating, if possible, the case where it's possible to take "en passant".
     */
    private Coordinate enPassant;

    public Position() {
        this.blackCastle = true;
        this.blackCastleLong = true;
        this.turn = true; // whitePlayer turn
        this.whiteCastle = true;
        this.whiteCastleLong = true;
        this.enPassant = new Coordinate();
    }

    public boolean getWhiteCastle() {
        return this.whiteCastle;
    }

    public void setWhiteCastle(boolean b) {
        this.whiteCastle = b;
    }

    public boolean getBlackCastle() {
        return this.blackCastle;
    }

    public void setBlackCastle(boolean b) {
        this.blackCastle = b;
    }

    public boolean getWhiteCastleLong() {
        return this.whiteCastleLong;
    }

    public void setWhiteCastleLong(boolean b) {
        this.whiteCastleLong = b;
    }

    public boolean getBlackCastleLong() {
        return this.blackCastleLong;
    }

    public void setBlackCastleLong(boolean b) {
        this.blackCastleLong = b;
    }

    public boolean getTurn() {
        return this.turn;
    }

    public void setTurn(boolean b) {
        this.turn = b;
    }

    public byte[][] getPos() {
        return this.pos;
    }

    public void setPos(byte[][] tab) {
        this.pos = tab;
    }

    /**
     * The method returns the id of the piece on the coordinate c.
     * If there is no piece, it returns.
     * 
     * @param c coordinate of the case on the chessboard that we want to get the id.
     * @return The id of the piece.
     */
    public byte getPosCase(Coordinate c) {
        return this.pos[c.getRow()][c.getCol()];
    }

    /**
     * The method changes the attribute pos on the coordinate c by byte b.
     * 
     * @param c coordinate of the case on the chessboard.
     * @param b the number corresponding to the change we want to do.
     */
    public void setPosCase(Coordinate c, byte b) {
        this.pos[c.getRow()][c.getCol()] = b;
    }

    public Coordinate getEnPassant() {
        return enPassant;
    }

    public void setEnPassant(Coordinate enPassant) {
        this.enPassant = enPassant;
    }

    /**
     * The playMove method will check with caseAccess that c1 to c2 is a legal move
     * (if not, return NotAccessibleCaseException).
     * The normal behavior is to : <br>
     * - update the turn boolean, <br>
     * - update time PGN in game, <br>
     * - call pseudoPlayMove(c1,c2,game). <br>
     * <br>
     * The reason : the turn boolean is not updated in pseudoPlayMove,
     * because isChecked() method is called right after pseudoPlayMove to check
     * if the pseudo legal move is a real legal move,
     * so we don't want the "active" pos to change. (And isChecked() checks if the
     * king of the <b>active</b> player is in a check status...)
     * 
     * @param c1 the starting case of the displacement
     * @param c2 the destination case of the displacement
     * @param g  the game linked to the pos
     * @throws NotAccessibleCaseException If the player enters a coordinate to move
     *                                    a piece on a not accessible case, then the
     *                                    exception is thrown.
     * @see Position#playMove(Coordinate, Coordinate, Game, Piece)
     * @see Position#pseudoPlayMove(Coordinate, Coordinate)
     */
    public void playMove(Coordinate c1, Coordinate c2, Game g) throws NotAccessibleCaseException {
        byte[][] tmpMove = caseAccess(c1); // value of caseAccess(c1) in an array of array of byte

        if (tmpMove[c2.getRow()][c2.getCol()] > 0) { // check if c2 is in tmp (value of caseAccess(c1))
            pseudoPlayMove(c1, c2);
            // UpdateTimePGN
            System.out.println("Move done");
            this.setTurn(!(this.getTurn()));
        } else {
            throw new NotAccessibleCaseException("Vous n'avez pas choisi une case accessible");
        }
    }

    /**
     * This method calls the previous playMove method, and then just manages the
     * promotion if there is promotion.
     * 
     * @param c1 the starting case of the displacement
     * @param c2 the destination case of the displacement
     * @param g  the game linked to the pos
     * @param p  corresponds to the piece the player wants the pawn to be promoted
     *           in.
     * @throws NotAccessibleCaseException If the player enters a coordinate to move
     *                                    a piece on a not accessible case, then the
     *                                    exception is thrown.
     * @see Position#playMove(Coordinate, Coordinate, Game)
     */
    public void playMove(Coordinate c1, Coordinate c2, Game g, Piece p) throws NotAccessibleCaseException {
        this.playMove(c1, c2, g);
        if (!this.getTurn()) {
            if (c2.getRow() == 0 && this.getPosCase(c2) == Piece.WHITEPAWN.getId()) { // if WHITEPAWN is on last line
                this.setPosCase(c2, p.getId());
                g.setPGN(g.getPGN() + "Promotion in : " + p.name() + " ");
            }
        } else {
            if (c2.getRow() == 7 && this.getPosCase(c2) == Piece.BLACKPAWN.getId()) { // if BLACKPAWN is on first line
                this.setPosCase(c2, p.getId());
                g.setPGN(g.getPGN() + "Promotion in : " + p.name() + " ");
            }
        }
    }

    /**
     * Definition : a pseudo legal move is a move that would be legal if having his
     * king in a chess status at the end of its turn would be legal.<br>
     * pseudoPlayMove plays a pseudo legal move and updates relevant information
     * <b>except the turn.</b>
     * The reason for that is that pseudoPlayMove <b><span style="color:red">is only
     * called by playMove and caseAcess</span></b>.
     * The data updated by pseudoPlaymove are : <br>
     * - Castles Boolean, <br>
     * - enPassant coordinate <br>
     * - and of course, the pos attribute. <br>
     * <br>
     * Handling the pos attribute is done with the help of movePiece.
     * It is basically a switch(pos[startCase]), If the piece in case1 is a queen, a
     * rook, a bishop, or knight (mostly in 90% of occurrences), this will just call
     * movePiece(case1, case2).
     * If it is a pawn or a King, more complexe handling will happen in the case of
     * Castle, prise en passant, and promotion.
     * This method will also update relevant information such as : Castles Boolean,
     * Turn.
     * 
     * @param c1 the starting case of the displacement
     * @param c2 the destination case of the displacement
     * @see Position#testAdd(Coordinate, Coordinate, boolean)
     */
    private void pseudoPlayMove(Coordinate c1, Coordinate c2) {

        this.setEnPassant(new Coordinate());

        switch (this.getPosCase(c1)) {
            case 1: // WHITEROOK
                if (c1.equals(a1)) {
                    this.setWhiteCastleLong(false);
                }
                if (c1.equals(h1)) {
                    this.setWhiteCastle(false);
                }
                movePiece(c1, c2);
                break;
            case 8: // BLACKROOK
                if (c1.equals(a8)) {
                    this.setBlackCastleLong(false);
                }
                if (c1.equals(h8)) {
                    this.setBlackCastle(false);
                }
                movePiece(c1, c2);
                break;
            case 2, 3, 4, 9, 10, 11: // WHITEKNIGHT, WHITEBISHOP, WHITEQUEEN, BLACKKNIGHT, BLACKBISHOP, BLACKQUEEN
                movePiece(c1, c2);
                break;
            case 5: // WHITEKING
                this.setWhiteCastleLong(false);
                this.setWhiteCastle(false);
                if (Math.abs(c1.getCol() - c2.getCol()) == 2) { // translates roque condition
                    if (c2.getCol() == 2) {
                        movePiece(new Coordinate("a1"), new Coordinate("d1"));
                    }
                    if (c2.getCol() == 6) {
                        movePiece(new Coordinate("h1"), new Coordinate("f1"));
                    }
                }
                movePiece(c1, c2);
                break;

            case 12: // BLACKKING
                this.setBlackCastleLong(false);
                this.setBlackCastle(false);
                if (Math.abs(c1.getCol() - c2.getCol()) == 2) { // translates roque condition
                    if (c2.getCol() == 2) {
                        movePiece(new Coordinate("a8"), new Coordinate("d8"));
                    }
                    if (c2.getCol() == 6) {
                        movePiece(new Coordinate("h8"), new Coordinate("f8"));
                    }
                }
                movePiece(c1, c2);
                break;

            case 6: // WHITEPAWN
            case 7: // BLACKPAWN
                if (!(c1.getCol() == c2.getCol()) && this.getPosCase(c2) == 0) { // translates a take en passant
                                                                                 // condition
                    Coordinate ct = new Coordinate(c1.getRow(), c2.getCol());
                    movePiece(c1, ct);
                    movePiece(ct, c2);
                } else { // for the others moves : classic move, 2 cases moves, take and promotion
                    movePiece(c1, c2);
                }
                if (Math.abs(c1.getRow() - c2.getRow()) == 2) {
                    this.setEnPassant(new Coordinate((byte) ((c1.getRow() + c2.getRow()) / 2), c1.getCol()));
                    // if there is a 2 cases pawn move, then a take en passant is possible
                }
                break;
        }
    }

    /**
     * First of all, caseAccess initializes the return matrix with full 0. <br>
     * The 8*8 matrix of byte contains 0, 1 or 2:<br>
     * - 0 means the pieces in case cannot reach the coordinate,<br>
     * - 1 that the piece can reach the case, <br>
     * - 2 that she can reach the case and it'll be a capture.<br>
     * <br>
     * If case given is empty (0), if will return a full of 0 [8][8] matrix
     * This matrix will be used for : <br>
     * - checking that cases passed to playMove() represent a legal deplacement<br>
     * - highlighting properly cases for the graphic interface <br>
     * <br>
     * The way caseAccess is coded is such as it will generate every single
     * pseudo-legal move, and for each case that is a "pseudo-legal destination", it
     * will generate a new position object, call the pseudoPlayMove, and then check
     * if the new position is in a check status.
     * See the testAdd method.
     * This works out quite well because a pseudo legal move that does not end up in
     * a position where you are in check is in fact a legal move. It may be quite
     * expensive in term of computation but it is very short in term of code. <br>
     * <br>
     * Note : This is probably the longest function, as it needs to consider every
     * possibility, standard as well as castle, take en passant and promotions
     * <br>
     * <br>
     * Update : We have created two methods to search the cases accessible. On one
     * hand, one method called searchCaseAccess(), for all the pieces except the
     * Pawn.
     * On the other hand, the second method, called searchPawnCaseAccess() is only
     * used to search pawns' accessible cases.
     * 
     * @param c the case of the piece we want to know reachable cases on the
     *          chessboard.
     * @return All cases where the piece can go which are legal moves (plus roque
     *         for king pieces).
     * @see Position#searchCaseAccess(Coordinate, byte[][], int, byte[][])
     * @see Position#searchPawnCaseAccess(Coordinate, byte[][], byte[][])
     */
    public byte[][] caseAccess(Coordinate c) {

        int limit; // corresponds to the maximum advance of a piece in one direction

        byte[][] resultMatrix = new byte[8][8]; // corresponds to the matrix of accessible cases
        byte[][] direction; // corresponds to every piece possible move (see Piece enumeration)
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                resultMatrix[i][j] = 0;
            }
        } // resultMatrix initialized with 0

        switch (this.getPosCase(c)) {

            case 0: // case empty case
                break;

            case 1: // case WHITEROOK
                if (this.getTurn()) {

                    limit = Piece.WHITEROOK.getLimit();
                    direction = Piece.WHITEROOK.getDirection();

                    resultMatrix = searchCaseAccess(c, resultMatrix, limit, direction);
                }
                break;

            case 2: // case WHITEKNIGHT

                if (this.getTurn()) {

                    limit = Piece.WHITEKNIGHT.getLimit();
                    direction = Piece.WHITEKNIGHT.getDirection();

                    resultMatrix = searchCaseAccess(c, resultMatrix, limit, direction);
                }
                break;

            case 3: // case WHITEBISHOP

                if (this.getTurn()) {

                    limit = Piece.WHITEBISHOP.getLimit();
                    direction = Piece.WHITEBISHOP.getDirection();

                    resultMatrix = searchCaseAccess(c, resultMatrix, limit, direction);
                }
                break;

            case 4: // case WHITEQUEEN

                if (this.getTurn()) {

                    limit = Piece.WHITEQUEEN.getLimit();
                    direction = Piece.WHITEQUEEN.getDirection();

                    resultMatrix = searchCaseAccess(c, resultMatrix, limit, direction);
                }
                break;

            case 5: // case WHITEKING

                if (this.getTurn()) {

                    limit = Piece.WHITEKING.getLimit();
                    direction = Piece.WHITEKING.getDirection();

                    resultMatrix = searchCaseAccess(c, resultMatrix, limit, direction);

                    if (!(this.isChecked())) {
                        if (this.getWhiteCastle() && this.getPosCase(h1) == Piece.WHITEROOK.getId()) {
                            if (!(this.isControlled(f1)) && !(this.isControlled(g1))) {
                                if (this.getPosCase(f1) == 0 && this.getPosCase(g1) == 0) {
                                    resultMatrix[g1.getRow()][g1.getCol()] = 1;
                                } // no need to make other checks, roque move will be necessarily a legal move if
                                  // Castle attributes are true :
                            } // king and towers are on their position, and the cases between king and tower
                              // are empty and not Controlled
                        }
                        if (this.getWhiteCastleLong() && this.getPosCase(a1) == Piece.WHITEROOK.getId()) {
                            if (!(this.isControlled(c1)) && !(this.isControlled(d1)) && !(this.isControlled(b1))) {
                                if (this.getPosCase(c1) == 0 && this.getPosCase(d1) == 0 && this.getPosCase(b1) == 0) {
                                    resultMatrix[c1.getRow()][c1.getCol()] = 1;
                                }
                            }
                        }
                    }
                }
                break;

            case 6: // case WHITEPAWN

                if (this.getTurn()) {

                    direction = Piece.WHITEPAWN.getDirection();

                    resultMatrix = searchPawnCaseAccess(c, resultMatrix, direction);
                }

                break;

            case 7: // case BLACKPAWN

                if (!(this.getTurn())) {

                    direction = Piece.BLACKPAWN.getDirection();

                    resultMatrix = searchPawnCaseAccess(c, resultMatrix, direction);
                }

                break;

            case 8: // case BLACKROOK

                if (!(this.getTurn())) {

                    limit = Piece.BLACKROOK.getLimit();
                    direction = Piece.BLACKROOK.getDirection();

                    resultMatrix = searchCaseAccess(c, resultMatrix, limit, direction);
                }
                break;

            case 9: // case BLACKKNIGHT

                if (!(this.getTurn())) {

                    limit = Piece.BLACKKNIGHT.getLimit();
                    direction = Piece.BLACKKNIGHT.getDirection();

                    resultMatrix = searchCaseAccess(c, resultMatrix, limit, direction);
                }
                break;

            case 10: // case BLACKBISHOP

                if (!(this.getTurn())) {

                    limit = Piece.BLACKBISHOP.getLimit();
                    direction = Piece.BLACKBISHOP.getDirection();

                    resultMatrix = searchCaseAccess(c, resultMatrix, limit, direction);
                }
                break;

            case 11: // case BLACKQUEEN

                if (!(this.getTurn())) {

                    limit = Piece.BLACKQUEEN.getLimit();
                    direction = Piece.BLACKQUEEN.getDirection();

                    resultMatrix = searchCaseAccess(c, resultMatrix, limit, direction);
                }
                break;

            case 12: // case BLACKKING

                if (!(this.getTurn())) {

                    limit = Piece.BLACKKING.getLimit();
                    direction = Piece.BLACKKING.getDirection();

                    resultMatrix = searchCaseAccess(c, resultMatrix, limit, direction);

                    if (!(this.isChecked())) {
                        if (this.getBlackCastle() && this.getPosCase(a8) == Piece.BLACKROOK.getId()) {
                            if (!(this.isControlled(f8)) && !(this.isControlled(g8))) {
                                if (this.getPosCase(f8) == 0 && this.getPosCase(g8) == 0) {
                                    resultMatrix[g8.getRow()][g8.getCol()] = 1;
                                }
                            }
                        } else if (this.getBlackCastleLong() && this.getPosCase(h8) == Piece.BLACKROOK.getId()) {
                            if (!(this.isControlled(c8)) && !(this.isControlled(d8)) && !(this.isControlled(b8))) {
                                if (this.getPosCase(c8) == 0 && this.getPosCase(d8) == 0 && this.getPosCase(b8) == 0) {
                                    resultMatrix[c8.getRow()][c8.getCol()] = 1;
                                }
                            }
                        }
                    }
                }
                break;
        }
        return resultMatrix;
    }

    /**
     * This method is searching all the pseudos legal moves for all pieces on the
     * chessboard except the pawn.
     * It calls the testAdd method in order to verify if the piece can or not move
     * on the next case (in fact, it verifies if it is a real legal move).
     * The returned matrix contains the possibilities to move for each piece.
     * The way to search these cases is to browse the cases in the direction given
     * by the enumeration Piece.
     * We will call the cases where we look : caseTest.
     * Then, we look step by step : <br>
     * - Is the caseTest still on the chessboard ? <br>
     * - Is on caseTest already a piece ? Is it an allied or enemy piece ? <br>
     * Finally, we call testAdd to see if it is a real legal move.
     * 
     * @param c            initial coordinate of the case
     * @param resultMatrix corresponds to the matrix of accessible cases
     * @param limit        corresponds to the maximum advance of a piece in one
     *                     direction
     * @param direction    corresponds to the different directions of the piece
     * @return All cases where the piece can go which are legal moves
     */
    private byte[][] searchCaseAccess(Coordinate c, byte[][] resultMatrix, int limit,
            byte[][] direction) {

        Coordinate cTest = new Coordinate();
        int nbDirection = direction.length; // corresponds to the number of the different direction possible
        for (int j = 0; j < nbDirection; j++) {
            int step = 0; // corresponds to the advance of a piece in one direction at a certain time
            boolean keepgoing = true; // check if the next cases could be accessible
            byte[] currentDirection = direction[j]; // the direction in which we will move
            byte deltaX = currentDirection[0]; // corresponds to the displacement on rows
            byte deltaY = currentDirection[1]; // corresponds to the displacement on columns
            int y = c.getCol();
            int x = c.getRow();
            cTest.setCol((byte) y);
            cTest.setRow((byte) x);

            while (step < limit && keepgoing) {

                x = x + deltaX;
                y = y + deltaY;

                cTest.setRow((byte) x);
                cTest.setCol((byte) y);
                if (isOnChessboard(cTest)) {
                    switch (this.getPosCase(cTest)) {
                        case 0: // empty case
                            resultMatrix[cTest.getRow()][cTest.getCol()] = this.testAdd(c, cTest, false);
                            break;
                        case 7, 8, 9, 10, 11, 12: // black pieces
                            if (this.getTurn()) { // enemy piece for white player
                                resultMatrix[cTest.getRow()][cTest.getCol()] = this.testAdd(c, cTest, true);
                            }
                            keepgoing = false; // allied piece for black player
                            break;
                        case 1, 2, 3, 4, 5, 6: // white pieces
                            if (!this.getTurn()) { // enemy piece for black player
                                resultMatrix[cTest.getRow()][cTest.getCol()] = this.testAdd(c, cTest, true);
                            }
                            keepgoing = false; // allied piece for white player
                            break;
                    }
                }
                step++;
            }
        }
        return resultMatrix;
    }

    /**
     * In this method, we search the case access for the pawn piece. We have to
     * distinguish 5 cases : <br>
     * - classics moves <br>
     * - 2 cases moves<br>
     * - take moves<br>
     * - promotion moves<br>
     * - enPassant moves<br>
     * <br>
     * It is the same concept as searchCaseAccess method, for each caseTest, we look
     * if it is still on the chessboard and if there is already a piece or not on
     * the
     * caseTest.
     * Then, we call testAdd method.
     * 
     * @param c            initial coordinate of the case
     * @param resultMatrix corresponds to the matrix of accessible cases
     * @param direction    corresponds to every possible direction of pawn pieces
     *                     given by the enumeration Piece.
     * @return All cases where the pawn can go which are legal moves
     */
    private byte[][] searchPawnCaseAccess(Coordinate c, byte[][] resultMatrix,
            byte[][] direction) {

        Coordinate cTest = new Coordinate();

        byte[] classicDirection = direction[0]; // when a pawn move forward (one case)
        byte[] twoCasesDirection = direction[1]; // when a pawn move forward (two cases)
        byte[] iRight = direction[2]; // when a pawn can take a piece (diagonal right)
        byte[] iLeft = direction[3]; // when a pawn can take a piece (diagonal left)

        byte twoCasesRow; // corresponds to the line where pawns can move 2 cases forward
        Coordinate cTest2;
        byte enPassantRow; // corresponds to the line where pawns can take en Passant
        byte promotionRow; // correponds to the line where pawns can be promoted

        if (this.getTurn()) {
            twoCasesRow = 6;
            enPassantRow = 3;
            promotionRow = 1;
        } else {
            twoCasesRow = 1;
            enPassantRow = 4;
            promotionRow = 6;
        }

        if (c.getRow() != 1 && c.getRow() != 6) { // case classic move

            int a = c.getRow() + classicDirection[0];
            int b = c.getCol() + classicDirection[1];

            cTest.setRow((byte) a);
            cTest.setCol((byte) b);
            if (isOnChessboard(cTest)) {
                if (this.getPosCase(cTest) == 0) { // empty case
                    resultMatrix[cTest.getRow()][cTest.getCol()] = this.testAdd(c, cTest, false);
                } // there is no else because whatever it's a allied or enemy piece, the pawn
                  // cannot move forward
                  // so resultMatrix in cTest stays to 0
            }
        }

        if (c.getRow() == twoCasesRow) { // case move 2 cases

            int a = c.getRow() + twoCasesDirection[0];
            int b = c.getCol() + twoCasesDirection[1];

            if (this.getTurn()) {
                cTest2 = new Coordinate((byte) (a + 1), (byte) b);
            } else {
                cTest2 = new Coordinate((byte) (a - 1), (byte) b);
            }

            cTest.setCol((byte) b);
            cTest.setRow((byte) a);

            if (this.getPosCase(cTest2) == 0) {
                resultMatrix[cTest2.getRow()][cTest2.getCol()] = this.testAdd(c, cTest2, false);
                if (this.getPosCase(cTest) == 0 && resultMatrix[cTest2.getRow()][cTest2.getCol()] == 1) {
                    resultMatrix[cTest.getRow()][cTest.getCol()] = this.testAdd(c, cTest, false);
                }
            } // there is no else because whatever it's a allied or enemy piece, the pawn
              // cannot move forward
              // so resultMatrix in cTest stays to 0
        }

        // case pawn take

        int a = c.getRow() + iRight[0];
        int b = c.getCol() + iRight[1];

        cTest.setRow((byte) a);
        cTest.setCol((byte) b);

        Coordinate accessEnPassant = this.getEnPassant();

        if (isOnChessboard(cTest)) {
            switch (this.getPosCase(cTest)) {
                case 7, 8, 9, 10, 11, 12: // black pieces
                    if (this.getTurn()) { // enemy piece for white player
                        resultMatrix[cTest.getRow()][cTest.getCol()] = this.testAdd(c, cTest, true);
                    }
                    break;
                case 1, 2, 3, 4, 5, 6: // white pieces
                    if (!this.getTurn()) { // enemy piece for black player
                        resultMatrix[cTest.getRow()][cTest.getCol()] = this.testAdd(c, cTest, true);
                    }
                    break;
            }

            if (accessEnPassant.equals(cTest) && c.getRow() == enPassantRow) { // case prise en passant
                resultMatrix[accessEnPassant.getRow()][accessEnPassant.getCol()] = this.testAdd(c, cTest, true);
            }
        }

        a = c.getRow() + iLeft[0];
        b = c.getCol() + iLeft[1];

        cTest.setRow((byte) a);
        cTest.setCol((byte) b);

        if (isOnChessboard(cTest)) {
            switch (this.getPosCase(cTest)) {
                case 7, 8, 9, 10, 11, 12: // black pieces
                    if (this.getTurn()) { // enemy piece for white player
                        resultMatrix[cTest.getRow()][cTest.getCol()] = this.testAdd(c, cTest, true);
                    }
                    break;
                case 1, 2, 3, 4, 5, 6: // white pieces
                    if (!this.getTurn()) { // enemy piece for black player
                        resultMatrix[cTest.getRow()][cTest.getCol()] = this.testAdd(c, cTest, true);
                    }
                    break;
            }

            if (accessEnPassant.equals(cTest) && c.getRow() == enPassantRow) { // case prise en passant
                resultMatrix[accessEnPassant.getRow()][accessEnPassant.getCol()] = this.testAdd(c, cTest, true);
            }

            if (c.getRow() == promotionRow) {

                int a2 = c.getRow() + classicDirection[0];
                int b2 = c.getCol() + classicDirection[1];

                cTest.setRow((byte) a2);
                cTest.setCol((byte) b2);

                if (this.getPosCase(cTest) == 0) { // empty case
                    resultMatrix[cTest.getRow()][cTest.getCol()] = this.testAdd(c, cTest, false);
                }
            }
        }
        return resultMatrix;
    }

    /**
     * Display the different possibilities for each pieces in form of a matrix,
     * printed in the console : <br>
     * - 0 : case no accessible <br>
     * - 1 : case where the piece can go <br>
     * - 2 : case where the piece can move and take the enemy's piece <br>
     * <br>
     * This method is only used to play the game in console mode.
     * 
     * @param resultMatrix It is a matrix 8*8 corresponding to the accessible cases
     */
    public void displayCaseAccess(byte[][] resultMatrix) {
        String test = "";
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                test = test + resultMatrix[i][j] + " ";
            }
            test = test + "\n";
        }
        System.out.println(test);
    }

    /**
     * Check if the coordinate passed in parameter is in the chessboard.
     * It simply checks if the coordinates' row and column are lower than 8 and
     * higher than 0.
     * 
     * @param c coordinate of the case that we want to verify if it is on the
     *          chessboard.
     * @return true if c is on the chessboard, false if not.
     */
    public boolean isOnChessboard(Coordinate c) { // check if the case is on chessboard
        boolean onChessboard = true;
        byte a = c.getRow();
        byte b = c.getCol();
        if (a < (byte) 8 && a > (byte) -1) {
            if (b < (byte) 8 && b > (byte) -1) {
                onChessboard = true;
            } else {
                onChessboard = false;
            }
        } else {
            onChessboard = false;
        }
        return onChessboard;
    }

    /**
     * Check if a case around the king's current player is controlled <b>by the
     * opponent of the current player's turn</b> used for a simpler implementation
     * of handling legal moves and checkmate.
     * A case controlled means that in this case, the king's current player cannot
     * go.
     * The concept consists in checking if a piece can move in its pseudo legal
     * moves, only if the king will not be checked.
     * For each direction of each piece starting from the current player's king
     * position, we look if the caseTest is controlled or not.
     * In a certain way, it looks like the concept of searchCaseAccess.
     * 
     * @param c the case which will be said to be controlled or not by the opponent
     *          of the current's player, which in fact will always correspond to the
     *          current player's king's position.
     * @return True if a case is controlled by the opponent
     */
    private boolean isControlled(Coordinate c) {
        byte l = c.getRow();
        byte co = c.getCol();
        Coordinate casetest = new Coordinate((byte) 0, (byte) 0);
        byte[][] directions;

        directions = Piece.WHITEROOK.getDirection(); // Whatever it is WHITEROOK or BLACKROOK directions,
        for (byte[] direction : directions) {// it stays the same directions
            byte dx = direction[0]; // corresponds to the displacement on rows
            byte dy = direction[1]; // corresponds to the displacement on columns
            casetest.setCol(co);
            casetest.setRow(l);
            boolean keepgoing = true;
            while (keepgoing) {
                casetest.setCol((byte) (casetest.getCol() + dy));
                casetest.setRow((byte) (casetest.getRow() + dx));
                if (isOnChessboard(casetest)) {
                    switch (this.getPosCase(casetest)) {
                        case 0:
                            break;
                        case 2, 3, 6, 7, 9, 10, 12:
                            keepgoing = false;
                            break;
                        case 8, 11: // BLACKROOK, BLACKQUEEN
                            if (this.getTurn()) {
                                return true;
                            } else {
                                keepgoing = false;
                            }
                            break;
                        case 1, 4: // WHITEROOK, WHITEQUEEN
                            if (!(this.getTurn())) {
                                return true;
                            } else {
                                keepgoing = false;
                            }
                            break;
                    }
                } else {
                    keepgoing = false;
                }
            }
        }

        directions = Piece.WHITEBISHOP.getDirection();
        for (byte[] direction : directions) { // Bishop direction
            byte dx = direction[0];
            byte dy = direction[1];
            casetest.setCol(co);
            casetest.setRow(l);
            boolean keepgoing = true;
            while (keepgoing) {
                casetest.setCol((byte) (casetest.getCol() + dy));
                casetest.setRow((byte) (casetest.getRow() + dx));
                if (isOnChessboard(casetest)) {

                    switch (this.getPosCase(casetest)) {
                        case 0:
                            break;
                        case 1, 2, 6, 7, 8, 9, 12:
                            keepgoing = false;
                            break;
                        case 10, 11: // BLACKBISHOP, BLACKQUEEN
                            if (this.getTurn()) {
                                return true;
                            } else {
                                keepgoing = false;
                            }
                            break;
                        case 3, 4: // WHITEBISHOP, WHITEQUEEN
                            if (!this.getTurn()) {
                                return true;
                            } else {
                                keepgoing = false;
                            }
                            break;
                    }
                } else {
                    keepgoing = false;
                }
            }
        }

        directions = Piece.WHITEKNIGHT.getDirection();
        for (byte[] direction : directions) {// Knight direction
            byte dx = direction[0];
            byte dy = direction[1];
            casetest.setCol(co);
            casetest.setRow(l);
            casetest.setCol((byte) (casetest.getCol() + dy));
            casetest.setRow((byte) (casetest.getRow() + dx));
            if (isOnChessboard(casetest)) {

                switch (this.getPosCase(casetest)) {
                    case 0, 1, 3, 4, 6, 7, 8, 10, 11, 12:
                        break;
                    case 9: // BLACKKNIGHT
                        if (this.getTurn()) {
                            return true;
                        }
                        break;
                    case 2: // WHITEKNIGHT
                        if (!this.getTurn()) {
                            return true;
                        }
                        break;
                }
            }
        }

        directions = Piece.WHITEKING.getDirection();
        for (byte[] direction : directions) { // King direction
            byte dx = direction[0];
            byte dy = direction[1];
            casetest.setCol(co);
            casetest.setRow(l);
            casetest.setCol((byte) (casetest.getCol() + dy));
            casetest.setRow((byte) (casetest.getRow() + dx));
            if (isOnChessboard(casetest)) {

                switch (this.getPosCase(casetest)) {
                    case 0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11:
                        break;
                    case 12: // BLACKKING
                        if (this.getTurn()) {
                            return true;
                        }
                        break;
                    case 5: // WHITEKING
                        if (!this.getTurn()) {
                            return true;
                        }
                        break;
                }
            }
        }

        if (!this.getTurn()) {
            Coordinate casetest1 = new Coordinate((byte) (c.getRow() + 1), (byte) (c.getCol() - 1));
            Coordinate casetest2 = new Coordinate((byte) (c.getRow() + 1), (byte) (c.getCol() + 1));

            if (isOnChessboard(casetest1)) {
                if (this.getPosCase(casetest1) == Piece.WHITEPAWN.getId()) {
                    return true;
                }
            }
            if (isOnChessboard(casetest2)) {
                if (this.getPosCase(casetest2) == Piece.WHITEPAWN.getId()) {
                    return true;
                }
            }
        }

        if (this.getTurn()) {
            Coordinate casetest1 = new Coordinate((byte) (c.getRow() - 1), (byte) (c.getCol() - 1));
            Coordinate casetest2 = new Coordinate((byte) (c.getRow() - 1), (byte) (c.getCol() + 1));

            if (isOnChessboard(casetest1)) {
                if (this.getPosCase(casetest1) == Piece.BLACKPAWN.getId()) {
                    return true;
                }
            }
            if (isOnChessboard(casetest2)) {
                if (this.getPosCase(casetest2) == Piece.BLACKPAWN.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the current player's king is checked.
     * It simply searches the current player's king on the board and calls the
     * isControlled() method on it.
     * 
     * @return True if the current player's king is checked.
     */
    public boolean isChecked() {
        Coordinate c = new Coordinate((byte) 0, (byte) 0);
        boolean check = false;
        for (byte l = 0; l < 8; l++) {
            for (byte col = 0; col < 8; col++) {
                c.setCol(col);
                c.setRow(l);
                if (this.getTurn()) { // Player with White Pieces
                    if (this.getPosCase(c) == Piece.WHITEKING.getId()) {
                        check = isControlled(c);
                        return check;
                    }
                } else { // Player with Black Pieces
                    if (this.getPosCase(c) == Piece.BLACKKING.getId()) {
                        check = isControlled(c);
                        return check;
                    }
                }

            }
        }
        return check;
    }

    /**
     * If the current player's king is in check, the method calls the
     * isCheckStaleMate method.
     * If there is any possibility to counter or avoid the checkmate, then the
     * current player's king is in checkmate.
     * 
     * @return True if the current player's king is in check.
     * @see Position#isCheckStaleMate()
     */
    public boolean isCheckMate() {
        if (this.isChecked()) {
            return isCheckStaleMate();
        }
        return false;
    }

    /**
     * This method enables to see if the current player's king has no possibility to
     * move and if no allied piece has a legal move possible.
     * If the king was already checked, it's a CheckMate. If this king was not
     * already checked, it's a StaleMate.
     * The concept of the method consists in browsing every allied piece of the
     * current player and looking if one can move.
     * This method is only here to short the code, so that isCheckMate and
     * isStaleMate methods only check if the king is checked or not.
     * 
     * @return True if there is a CheckMate or a StaleMate.
     */
    private boolean isCheckStaleMate() {
        Coordinate cCheck = new Coordinate((byte) 0, (byte) 0);
        boolean checkStale = false;
        for (byte i = 0; i < 8; i++) {
            for (byte j = 0; j < 8; j++) {
                cCheck.setRow(i);
                cCheck.setCol(j);
                byte[][] tmpMove = caseAccess(cCheck);
                if (this.getTurn()) { // Player with White Pieces
                    if (this.getPosCase(cCheck) <= 6
                            && this.getPosCase(cCheck) > 0) { // if an allied piece
                        for (byte k = 0; k < 8; k++) {
                            for (byte l = 0; l < 8; l++) {
                                if (tmpMove[k][l] > 0) { // can move
                                    return checkStale; // then there is no checkMate or staleMate
                                }
                            }
                        }
                    }
                } else {
                    if (this.getPosCase(cCheck) <= 12
                            && this.getPosCase(cCheck) >= 7) {
                        for (byte k = 0; k < 8; k++) {
                            for (byte l = 0; l < 8; l++) {
                                if (tmpMove[k][l] > 0) {
                                    return checkStale;
                                }
                            }
                        }
                    }
                }
            }
        }
        checkStale = true;
        return checkStale;
    }

    /**
     * If the current player's king is not in check, the method calls the
     * isCheckStaleMate method.
     * If there is any possibility to counter or avoid the checked position around
     * the king,
     * then the current player's king is in a stalemate position.
     * 
     * @return True if the current player's king is in a stalemate position.
     * @see Position#isCheckStaleMate()
     */
    public boolean isStaleMate() {
        if (!(this.isChecked())) {
            return this.isCheckStaleMate();
        }
        return false;
    }

    /**
     * Move a piece from one case to another regardless of the value stored in case2
     * in pos.
     * This method is always called by pseudoPlayMove, at least once.
     * It may be called up to 2 times in the following case : Castle and take en
     * passant.
     * 
     * @param c1 the starting case of the displacement
     * @param c2 the destination case of the displacement
     */
    public void movePiece(Coordinate c1, Coordinate c2) {
        byte piece = this.getPosCase(c1);
        this.setPosCase(c1, (byte) 0);
        this.setPosCase(c2, piece);
    }

    /**
     * <b> <span style="color:red">testAdd is a method called only by
     * searchCaseAccess and searchPawnCaseAccess.</span> </b>
     * It will clone the instance of Position, called temp, then call
     * pseudoPlayMove(Case, Casetest) on tmp.
     * If tmp pos has a king checked, it returns 0, and so the move is illegal.
     * Otherwise it returns 1 (legal move) or 2 (legal move which is a take).
     * 
     * @param c1   the starting case of the displacement
     * @param c2   the destination case of the displacement, which we want to check
     *             if it is a legal move or not
     * @param take a boolean indicating if casetest contains an enemy piece.
     * @return 0, 1 or 2 as explained.
     */
    private byte testAdd(Coordinate c1, Coordinate c2, boolean take) {
        Position positionTMP = this.clone();
        positionTMP.pseudoPlayMove(c1, c2);
        if (positionTMP.isChecked()) {
            return 0;
        } else {
            if (take) {
                return 2;
            } else {
                return 1;
            }
        }
    }

    /**
     * Check if the game is over. The game is over for one the following reason :
     * <br>
     * - stalemate, <br>
     * - checkmate, <br>
     * - the time of one ot the player is over, <br>
     * <br>
     * It will end the game appropriately by updating the relevant attribute : PGN
     * 
     * @return True if the game is finished
     */
    public boolean isGameFinished(Game g) {
        if (this.isCheckMate()) {
            return true;
        }
        Position tmp = this.clone();// done in order to stop the game directly after the move
        tmp.setTurn(!tmp.getTurn());
        if (tmp.isStaleMate()) {
            return true;
        }

        if (this.isStaleMate()) {
            return true;
        }

        if (g.timeOutP1()) {
            return true;
        }
        if (g.timeOutP2()) {
            return true;
        }
        return false;
    }

    /**
     * This method displays a chessboard in console mode, drawn with character such
     * as +, -, |, etc.
     * The chessboard highlights all pieces present on the chessboard.
     * It also displays every Position attribute and the status of the current
     * player's king :<br>
     * - check,<br>
     * - checkmate,<br>
     * - stalemate.
     * 
     * @return A long String representing the chessboard.
     */
    public String toString() {
        String chessboard = "";
        int row = 9;
        String col = "    a   b   c   d   e   f   g   h  \n";
        chessboard = chessboard + col + "  ";
        for (byte i = 0; i < 8; i++) {
            for (byte k = 0; k < 8; k++) {
                chessboard = chessboard + "+---";
            }
            row--;
            chessboard = chessboard + "+";
            chessboard = chessboard + "\n" + row + " ";
            for (byte j = 0; j < 8; j++) {
                chessboard = chessboard + "| " + this.getAffichage(new Coordinate(i, j));
            }
            chessboard = chessboard + "| " + row + "\n  ";
        }
        for (int k = 0; k < 8; k++) {
            chessboard = chessboard + "+---";
        }
        chessboard = chessboard + "+\n";
        chessboard = chessboard + col + "\n";
        chessboard = chessboard + "whiteCastle     : " + this.getWhiteCastle() + "\n";
        chessboard = chessboard + "blackCastle     : " + this.getBlackCastle() + "\n";
        chessboard = chessboard + "whiteCastleLong : " + this.getWhiteCastleLong() + "\n";
        chessboard = chessboard + "blackCastleLong : " + this.getBlackCastleLong() + "\n";
        chessboard = chessboard + "turn            : " + this.getTurn() + "\n";
        chessboard = chessboard + "enPassant       : " + this.getEnPassant() + "\n";
        chessboard = chessboard + "isChecked       : " + this.isChecked() + "\n";
        chessboard = chessboard + "isCheckMate     : " + this.isCheckMate() + "\n";
        chessboard = chessboard + "isStaleMate     : " + this.isStaleMate() + "\n";
        return chessboard;
    }

    /**
     * It returns the pieces in the chessboard using the unicode corresponding to a
     * piece with her coordinate.
     * 
     * @param c coordinate of the case on the chessboard that we want to get the
     *          unicode
     * @return The unicode corresponding to the piece in the coordinate case.
     * @see Position#toString()
     */
    public String getAffichage(Coordinate c) {
        switch (this.getPosCase(c)) {
            case 0:
                return "  ";
            case 1:
                return "\u2656 ";
            case 2:
                return "\u2658 ";
            case 3:
                return "\u2657 ";
            case 4:
                return "\u2655 ";
            case 5:
                return "\u2654 ";
            case 6:
                return "\u2659 ";
            case 7:
                return "\u265F ";
            case 8:
                return "\u265C ";
            case 9:
                return "\u265E ";
            case 10:
                return "\u265D ";
            case 11:
                return "\u265B ";
            case 12:
                return "\u265A ";
            default:
                return "";
        }
    }

    public Position clone() {
        Position tmp = new Position();

        for (byte i = 0; i < 8; i++) { // copy of this.pos in tmp.pos
            for (byte j = 0; j < 8; j++) {
                tmp.setPosCase(new Coordinate(i, j), this.getPosCase(new Coordinate(i, j)));
            }
        }

        tmp.setTurn(this.getTurn());
        tmp.setBlackCastle(this.getBlackCastleLong());
        tmp.setBlackCastleLong(this.getBlackCastleLong());
        tmp.setWhiteCastle(this.getWhiteCastle());
        tmp.setWhiteCastleLong(this.getWhiteCastleLong());
        tmp.setEnPassant(this.getEnPassant());
        return tmp;
    }
}