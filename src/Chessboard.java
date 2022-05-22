
import java.util.ArrayList;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 *It displays the chessboard with all the complementary elements for the chessboard like the timer, player’s turn, etc.
 *@author Elias MEHIRA, Florent FRAITOT, Alexis JUST, Giovanni FIEUX
 *@version 1.0
 */

public class Chessboard extends Application {
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imageblackpawn = new Image("images/BlackPawn.png");
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imageblackknight = new Image("images/BlackKnight.png");
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imageblackrook = new Image("images/BlackRook.png");
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imageblackbishop = new Image("images/BlackBishop.png");
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imageblackqueen = new Image("images/BlackQueen.png");
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imageblackking = new Image("images/BlackKing.png");
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imagewhitepawn = new Image("images/WhitePawn.png");
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imagewhiteknight = new Image("images/WhiteKnight.png");
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imagewhiterook = new Image("images/WhiteRook.png");
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imagewhitebishop = new Image("images/WhiteBishop.png");
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imagewhitequeen = new Image("images/WhiteQueen.png");
	/**
	 * Get Images from “images” folder.
	 */
	public final Image imagewhiteking = new Image("images/WhiteKing.png");
	
	/**
	 * This attribute takes the information from the Position class’ methods used.
	 */
	Position pos = new Position();
	/**
	 * Used to retrieve the PGN in the Game class.
	 */
	Game g = new Game("");

	ArrayList<Rectangle> allCases = new ArrayList<Rectangle>();
	/**
	 * This function creates stackpanes that will contain elements from each section that will be around the chessboard.
	 * @param r1 corresponds to a rectangle for the black piece lost
	 * @param r2 corresponds to a rectangle for the white piece lost
	 * @param r3 corresponds to a rectangle for the PGN
	 * @param r4 corresponds to a rectangle for the timer for black player
	 * @param r5 corresponds to a rectangle for the timer for white player
	 * @param r6 corresponds to a rectangle for the state of the King
	 * @param l1 is the title for the black lost pieces
	 * @param l2 represents the unicode of black lost pieces
	 * @param l3 is the title for the white lost pieces 
	 * @param l4 represents the unicode of white lost pieces
	 * @param l5 displays the PGN
	 * @param l6 displays the timer of the black player
	 * @param l7 displays the timer of the white player
	 * @param l8 displays if the king is in check
	 * @return an arraylist of the stackpane list
	 */
	private ArrayList<StackPane> createStackPanes(Rectangle r1, Rectangle r2, Rectangle r3, Rectangle r4, Rectangle r5,
			Rectangle r6, Label l1, Label l2, Label l3, Label l4, Label l5, Label l6, Label l7, Label l8) {
		ArrayList<StackPane> stackList = new ArrayList<StackPane>();

		// Black lost pieces
		StackPane stackLeftTop = new StackPane();
		stackLeftTop.getChildren().addAll(r1, l1, l2);
		stackLeftTop.setStyle(
				"-fx-background-color: white; -fx-background-radius: 25; -fx-border-width: 2.5px; -fx-border-color: BEIGE; -fx-border-radius: 25;");
		VBox.setMargin(stackLeftTop, new Insets(50, 10, 50, 25));
		stackList.add(stackLeftTop);

		// White lost pieces
		StackPane stackLeftBottom = new StackPane();
		stackLeftBottom.getChildren().addAll(r2, l3, l4);
		stackLeftBottom.setStyle(
				"-fx-background-color: white; -fx-background-radius: 25; -fx-border-width: 2.5px; -fx-border-color: BEIGE; -fx-border-radius: 25;");
		VBox.setMargin(stackLeftBottom, new Insets(50, 10, 50, 25));
		stackList.add(stackLeftBottom);

		// PGN
		StackPane stackLeftCenterRight = new StackPane();
		stackLeftCenterRight.getChildren().addAll(r3, l5);
		stackLeftCenterRight.setStyle(
				"-fx-background-color: white; -fx-background-radius: 25; -fx-border-width: 2.5px; -fx-border-color: BEIGE; -fx-border-radius: 25;");
		VBox.setMargin(stackLeftCenterRight, new Insets(50, 10, 50, 25));
		stackList.add(stackLeftCenterRight);

		// Black player timer
		StackPane stackRightTop = new StackPane();
		stackRightTop.getChildren().addAll(r4, l6);
		stackRightTop.setStyle(
				"-fx-background-color: white; -fx-background-radius: 25; -fx-border-width: 2.5px; -fx-border-color: BEIGE; -fx-border-radius: 25;");
		VBox.setMargin(stackRightTop, new Insets(100, 25, 100, 10));
		stackList.add(stackRightTop);

		// White player timer
		StackPane stackRightBottom = new StackPane();
		stackRightBottom.getChildren().addAll(r5, l7);
		stackRightBottom.setStyle(
				"-fx-background-color: white; -fx-background-radius: 25; -fx-border-width: 2.5px; -fx-border-color: BEIGE; -fx-border-radius: 25;");
		VBox.setMargin(stackRightBottom, new Insets(100, 25, 100, 10));
		stackList.add(stackRightBottom);

		// King check state (change with the turn)
		StackPane stackRightCenter = new StackPane();
		stackRightCenter.getChildren().addAll(r6, l8);
		stackRightCenter.setStyle(
				"-fx-background-color: white; -fx-background-radius: 25; -fx-border-width: 2.5px; -fx-border-color: BEIGE; -fx-border-radius: 25;");
		VBox.setMargin(stackRightCenter, new Insets(25, 25, 25, 10));
		stackList.add(stackRightCenter);

		return stackList;
	}
	/**
	 * It creates rectangles that are required for the various sectors that will be all around the chessboard.
	 * @return an arrayList of the Rectangle list
	 */
	private ArrayList<Rectangle> createRectangles() {
		ArrayList<Rectangle> rList = new ArrayList<Rectangle>();

		// Black lost pieces
		Rectangle bPlayerLostPiece = new Rectangle(125, 150, Color.WHITE);
		bPlayerLostPiece.setArcHeight(50);
		bPlayerLostPiece.setArcWidth(50);
		rList.add(bPlayerLostPiece);

		// White lost pieces
		Rectangle wPlayerLostPiece = new Rectangle(125, 150, Color.WHITE);
		wPlayerLostPiece.setArcHeight(50);
		wPlayerLostPiece.setArcWidth(50);
		rList.add(wPlayerLostPiece);

		// PGN
		Rectangle rPGN = new Rectangle(125, 500, Color.WHITE);
		rPGN.setArcHeight(50);
		rPGN.setArcWidth(50);
		rList.add(rPGN);

		// Black player timer
		Rectangle bPlayer = new Rectangle(200, 50, Color.WHITE);
		bPlayer.setArcHeight(50);
		bPlayer.setArcWidth(50);
		rList.add(bPlayer);

		// White player timer
		Rectangle wPlayer = new Rectangle(275, 50, Color.WHITE);
		wPlayer.setArcHeight(50);
		wPlayer.setArcWidth(50);
		rList.add(wPlayer);

		// King check state (change with the turn)
		Rectangle playerCheckState = new Rectangle(275, 50, Color.WHITE);
		playerCheckState.setArcWidth(50);
		playerCheckState.setArcHeight(50);
		rList.add(playerCheckState);

		return rList;
	}

	/**
	 * It creates the various text zones (PGN, lost pieces, king state and timer) that will be added into the stackpanes.
	 * @return an arraylist of the Label list
	 */
	private ArrayList<Label> createLabels() {
		ArrayList<Label> labelList = new ArrayList<Label>();

		// Black lost pieces
		Label bPlayerLostPieces = new Label("BLACK player\nlost pieces");
		Label bLostPieces = new Label("\n\u2656 \u2655 ...");
		bPlayerLostPieces.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 17.5;");
		StackPane.setMargin(bPlayerLostPieces, new Insets(10));
		StackPane.setAlignment(bPlayerLostPieces, Pos.TOP_CENTER);
		labelList.add(bPlayerLostPieces);
		labelList.add(bLostPieces);

		// White lost pieces
		Label wPlayerLostPieces = new Label("WHITE player\nlost pieces");
		Label wLostPieces = new Label(
				"\n\u265D \u265F ...");
		wPlayerLostPieces.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 17.5;");
		StackPane.setMargin(wPlayerLostPieces, new Insets(10));
		StackPane.setAlignment(wPlayerLostPieces, Pos.TOP_CENTER);
		labelList.add(wPlayerLostPieces);
		labelList.add(wLostPieces);

		// PGN
		Label PGN = new Label("PGN"); // g.getPGN();
		PGN.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 15;");
		StackPane.setMargin(PGN, new Insets(10));
		StackPane.setAlignment(PGN, Pos.TOP_CENTER);
		labelList.add(PGN);

		// Black player timer
		Label bPlayerTimer = new Label("00:00");
		labelList.add(bPlayerTimer);
		// White player timer
		Label wPlayerTimer = new Label("00:00");
		labelList.add(wPlayerTimer);

		// King status with turn condition
		Label isWPlayerChecked = new Label();
		Label isBPlayerChecked = new Label();

		String color = "";
		if (pos.getTurn()) {
			color = "WHITE ";
			if (pos.isChecked()) {
				isWPlayerChecked = new Label(color + "King in check");
			} else {
				isWPlayerChecked = new Label(color + "King is safe");
			}
			isWPlayerChecked.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 17.5;");
			labelList.add(isWPlayerChecked);

		} else {
			color = "BLACK ";
			if (pos.isChecked()) {
				isBPlayerChecked = new Label(color + "King in check");
			} else {
				isBPlayerChecked = new Label(color + "King is safe");
			}
			isBPlayerChecked.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 17.5;");
			labelList.add(isBPlayerChecked);
		}
		wPlayerTimer.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 17.5;");
		bPlayerTimer.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 17.5;");

		return labelList;
	}

	/**
	 * It creates a GridPane which contains our chessboard and our EventHandler to select a case with a mouse click.
	 * @return a Gridpane created for the chesssboard
	 */
	private GridPane createGridPane(Position pos) {
		GridPane pane = new GridPane();
		double s = 65;
		ArrayList<Rectangle> listeRColor = new ArrayList<Rectangle>(); // list of all the rectangle's color
		ArrayList<Paint> listClickedColor = new ArrayList<Paint>(); // list of the clicked rectangle's color (size 1)
		ArrayList<Paint> rImageList = new ArrayList<Paint>(); // list of the clicked rectangle's image
		ArrayList<Rectangle> listeRSelected = new ArrayList<Rectangle>(); // list of the clicked rectangle (size 1)
		ArrayList<Circle> toRemove = new ArrayList<Circle>(); // list of all the accessible cases that need to be remove
																// (green circle)
		ArrayList<Coordinate> saveCoordinates = new ArrayList<Coordinate>(); // list of the saved clicked Coordinate

		int[] cArray = new int[2];
		Rectangle rCase = new Rectangle();
		Coordinate c = new Coordinate();
		Coordinate circleCoordinate = new Coordinate();

		char letter = 'a';
		int number = 8;
		int number2 = 64;

		for (byte i = 0; i < 8; i++) {
			for (byte j = 0; j < 8; j++) {
				c.setRow(j);
				c.setCol(i);
				Rectangle r = new Rectangle(s, s);

				// Alternate the color of the cases
				if ((i + j) % 2 == 0) {
					r.setFill(Color.BEIGE);
				} else {
					r.setFill(Color.BURLYWOOD);
				}
				pane.add(r, i, j);
				listeRColor.add(r);

				String letters = Character.toString(letter);
				String numbers = Integer.toString(number);
				String numbers2 = Integer.toString(number2);
				Text colLetter = new Text(letters);
				Text rowNumber = new Text(numbers);
				Text rowNumber2 = new Text(numbers2);
				if (i == 0) {
					pane.add(rowNumber, c.getCol(), c.getRow());
					GridPane.setHalignment(rowNumber, HPos.LEFT);
					GridPane.setValignment(rowNumber, VPos.BOTTOM);
				}
				if (i == 7) {
					rowNumber2.setRotate(180);
					pane.add(rowNumber2, c.getCol(), c.getRow());
					GridPane.setHalignment(rowNumber2, HPos.RIGHT);
					GridPane.setValignment(rowNumber2, VPos.TOP);
				}
				if (j == 7) {
					pane.add(colLetter, c.getCol(), c.getRow());
					GridPane.setHalignment(colLetter, HPos.RIGHT);
					GridPane.setValignment(colLetter, VPos.BOTTOM);
				}
				if (j == 0) {
					colLetter.setRotate(180);
					pane.add(colLetter, c.getCol(), c.getRow());
					GridPane.setHalignment(colLetter, HPos.LEFT);
					GridPane.setValignment(colLetter, VPos.TOP);
				}
				number--;
				number2--;

				switch (pos.getPosCase(c)) {
					case 0:
						break;
					case 1: // Piece is a White Rook
						rCase = new Rectangle(s, s, new ImagePattern(imagewhiterook));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
					case 2: // Piece is a White Knight
						rCase = new Rectangle(s, s, new ImagePattern(imagewhiteknight));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
					case 3: // Piece is a White Bishop
						rCase = new Rectangle(s, s, new ImagePattern(imagewhitebishop));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
					case 4: // Piece is a White Queen
						rCase = new Rectangle(s, s, new ImagePattern(imagewhitequeen));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
					case 5: // Piece is a White King
						rCase = new Rectangle(s, s, new ImagePattern(imagewhiteking));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
					case 6: // Piece is a White Pawn
						rCase = new Rectangle(s, s, new ImagePattern(imagewhitepawn));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
					case 7: // Piece is a Black Pawn
						rCase = new Rectangle(s, s, new ImagePattern(imageblackpawn));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
					case 8: // Piece is a Black Rook
						rCase = new Rectangle(s, s, new ImagePattern(imageblackrook));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
					case 9: // Piece is a Black Knight
						rCase = new Rectangle(s, s, new ImagePattern(imageblackknight));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
					case 10: // Piece is a Black Bishop
						rCase = new Rectangle(s, s, new ImagePattern(imageblackbishop));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
					case 11: // Piece is a Black Queen
						rCase = new Rectangle(s, s, new ImagePattern(imageblackqueen));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
					case 12: // Piece is a Black King
						rCase = new Rectangle(s, s, new ImagePattern(imageblackking));
						pane.add(rCase, c.getCol(), c.getRow());
						allCases.add(rCase);
						break;
				}

				pane.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent e) {
						Coordinate cClicked1 = new Coordinate();
						Rectangle rClicked1 = (Rectangle) e.getTarget();
						int rowClicked1 = GridPane.getRowIndex(rClicked1);
						int colClicked1 = GridPane.getColumnIndex(rClicked1);
						cClicked1.setRow((byte) rowClicked1);
						cClicked1.setCol((byte) colClicked1);

						Paint rColor = Color.TRANSPARENT;
						Circle circlePossibleCase = new Circle();
						if ((rowClicked1 + colClicked1) % 2 == 0) {
							rColor = Color.BEIGE;
						} else {
							rColor = Color.BURLYWOOD;
						}

						if (listeRSelected.size() == 0) {
							if (rClicked1.getFill() != Color.BURLYWOOD
									&& rClicked1.getFill() != Color.BEIGE) {
								saveCoordinates.add(cClicked1);
								byte[][] accessible = pos.caseAccess(saveCoordinates.get(0));
								for (byte i = 0; i < 8; i++) {
									for (byte j = 0; j < 8; j++) {
										switch (accessible[i][j]) {
											case 1: // Possible case where the selected piece can move
												circlePossibleCase = new Circle(15, Color.GREEN);
												circlePossibleCase.setOpacity(0.5);
												pane.add(circlePossibleCase, j, i);
												circleCoordinate.setRow(i);
												circleCoordinate.setCol(j);
												break;
											case 2: // Possible case where the selected piece can took another
													// piece
												circlePossibleCase = new Circle(15, Color.RED);
												circlePossibleCase.setOpacity(0.5);
												pane.add(circlePossibleCase, j, i);
												circleCoordinate.setRow(i);
												circleCoordinate.setCol(j);
												break;
										}
									}
								}
								// Center in their case (GridPane cell) all the childrens of pane that
								// are Circle
								for (Node node : pane.getChildren()) {
									if (node instanceof Circle) {
										GridPane.setHalignment(node, HPos.CENTER);
										int circleRow = GridPane.getRowIndex(node);
										int circleCol = GridPane.getColumnIndex(node);
										circleCoordinate.setRow((byte) circleRow);
										circleCoordinate.setCol((byte) circleCol);
										System.out.println("circleCoordinate: " + circleCoordinate);
									}
								}

								listClickedColor.add(rColor);

								rImageList.add(rClicked1.getFill());
								listeRColor.get(8 * colClicked1 + rowClicked1).setFill(Color.GREEN);
								listeRColor.get(8 * colClicked1 + rowClicked1).setOpacity(0.5);
								cArray[0] = 8 * colClicked1 + rowClicked1;
								listeRSelected.add(rClicked1);

								System.out.println("cClicked1: " + cClicked1 + " - PieceId: " +
										pos.getPosCase(cClicked1));

							}
						} else if (listeRSelected.size() == 1) {
							if (rClicked1.getFill() != Color.BURLYWOOD
									&& rClicked1.getFill() != Color.BEIGE) {
								System.out.println("test1");
								saveCoordinates.add(cClicked1);
								saveCoordinates.remove(saveCoordinates.get(0));
								for (Node node : pane.getChildren()) {
									if (node instanceof Circle) {
										toRemove.add((Circle) node);
									}
								}
								pane.getChildren().removeAll(toRemove);

								byte[][] accessible = pos.caseAccess(saveCoordinates.get(0));
								for (byte i = 0; i < 8; i++) {
									for (byte j = 0; j < 8; j++) {
										switch (accessible[i][j]) {
											case 1:
												circlePossibleCase = new Circle(15, Color.GREEN);
												circlePossibleCase.setOpacity(0.5);
												pane.add(circlePossibleCase, j, i);
												circleCoordinate.setRow((byte) i);
												circleCoordinate.setCol((byte) j);
												break;
											case 2:
												circlePossibleCase = new Circle(15, Color.RED);
												circlePossibleCase.setOpacity(0.5);
												pane.add(circlePossibleCase, j, i);
												circleCoordinate.setRow((byte) i);
												circleCoordinate.setCol((byte) j);
												break;
										}
									}
								}
								for (Node node : pane.getChildren()) {
									if (node instanceof Circle) {
										GridPane.setHalignment(node, HPos.CENTER);
										int circleRow = GridPane.getRowIndex(node);
										int circleCol = GridPane.getColumnIndex(node);
										circleCoordinate.setRow((byte) circleRow);
										circleCoordinate.setCol((byte) circleCol);
										System.out.println("circleCoordinate: " + circleCoordinate);
									}
								}

								listClickedColor.add(rColor);

								listeRColor.get(cArray[0]).setFill(listClickedColor.get(0));
								listeRSelected.get(0).setFill(rImageList.get(0));
								listeRColor.get(cArray[0]).setOpacity(1);
								listeRSelected.add(rClicked1);
								listeRColor.get(8 * colClicked1 + rowClicked1).setFill(Color.GREEN);
								listeRColor.get(8 * colClicked1 + rowClicked1).setOpacity(0.5);
								cArray[0] = 8 * colClicked1 + rowClicked1;
								rImageList.add(rClicked1.getFill());

								listeRSelected.remove(listeRSelected.get(0));
								listClickedColor.remove(listClickedColor.get(0));
								rImageList.remove(rImageList.get(0));

								System.out.println("cClicked1: " + cClicked1 + " - PieceId: " +
										pos.getPosCase(cClicked1));

							} else if (rClicked1.getFill() == Color.BURLYWOOD
									|| rClicked1.getFill() == Color.BEIGE) {
								System.out.println("test2");
								saveCoordinates.add(cClicked1);
								cArray[1] = 8 * colClicked1 + rowClicked1;
								try {
									pos.playMove(saveCoordinates.get(0), saveCoordinates.get(1), g);
									System.out.println(pos);
								} catch (NotAccessibleCaseException e1) {
									e1.printStackTrace();
								}
								saveCoordinates.remove(saveCoordinates.get(0));
								saveCoordinates.remove(saveCoordinates.get(0));
								for (Node node : pane.getChildren()) {
									if (node instanceof Circle) {
										toRemove.add((Circle) node);
									}
								}

								listeRColor.get(cArray[0]).setFill(listClickedColor.get(0));
								listeRSelected.get(0).setFill(listClickedColor.get(0));
								listeRColor.get(cArray[0]).setOpacity(1);
								listeRSelected.add(rClicked1);
								listeRColor.get(cArray[1]).setFill(rImageList.get(0));
								listeRSelected.get(0).setFill(listeRColor.get(cArray[0]).getFill());
								listeRColor.get(cArray[1]).setOpacity(1);

								cArray[0] = cArray[1];
								cArray[1] = 0;

								pane.getChildren().removeAll(toRemove);
								listClickedColor.removeAll(listClickedColor);
								rImageList.removeAll(rImageList);
								listeRSelected.removeAll(listeRSelected);
							}
						}
						System.out.println("SaveCoordinates : " + saveCoordinates);
					}
				});
			}
			letter++;
		}

		pane.setStyle("-fx-border-style: solid; -fx-border-color: rgb(139,69,19); -fx-border-width: 10px;");
		return pane;
	}

	int degree = 0;

	@Override
	public void start(Stage primaryStage) {

		VBox centerVBox = new VBox();
		VBox rightVBox = new VBox();
		VBox leftVBoxRight = new VBox();
		VBox leftVBoxLeft = new VBox();
		HBox leftHBox = new HBox();
		VBox bottomVBox = new VBox();

		BorderPane borderpane = new BorderPane();
		GridPane pane = createGridPane(pos);

		Rectangle r1 = createRectangles().get(0);
		Rectangle r2 = createRectangles().get(1);
		Rectangle r3 = createRectangles().get(2);
		Rectangle r4 = createRectangles().get(3);
		Rectangle r5 = createRectangles().get(4);
		Rectangle r6 = createRectangles().get(5);

		Label l1 = createLabels().get(0);
		Label l2 = createLabels().get(1);
		Label l3 = createLabels().get(2);
		Label l4 = createLabels().get(3);
		Label l5 = createLabels().get(4);
		Label l6 = createLabels().get(5);
		Label l7 = createLabels().get(6);
		Label l8 = createLabels().get(7);

		Button displayTurn = new Button("Rotate");
		displayTurn.setMaxWidth(100);
		displayTurn.setMaxHeight(125);
		displayTurn
				.setStyle(
						"-fx-background-color: white; -fx-background-radius: 25; -fx-border-width: 2.5px; -fx-border-color: rgb(125, 206, 160); -fx-border-radius: 25; -fx-font-family: 'Consolas'; -fx-font-size: 12;");
		VBox.setMargin(displayTurn, new Insets(25, 25, 50, 25));

		ArrayList<StackPane> stack = createStackPanes(r1, r2, r3, r4, r5, r6, l1, l2, l3, l4, l5, l6, l7, l8);

		borderpane.setStyle("-fx-background-color: rgb(222,184,135);");
		borderpane.setLeft(leftHBox);
		borderpane.setCenter(centerVBox);
		borderpane.setRight(rightVBox);
		borderpane.setBottom(bottomVBox);

		centerVBox.getChildren().add(pane);
		centerVBox.setMaxSize(225, 225);
		centerVBox.setAlignment(Pos.CENTER);
		VBox.setMargin(pane, new Insets(0, 30, 0, 0));

		leftVBoxLeft.getChildren().addAll(stack.get(0), stack.get(1));
		leftVBoxLeft.setAlignment(Pos.CENTER);

		leftVBoxRight.getChildren().addAll(stack.get(2));
		leftVBoxRight.setAlignment(Pos.CENTER_LEFT);

		leftHBox.getChildren().addAll(leftVBoxLeft, leftVBoxRight);
		leftHBox.setAlignment(Pos.CENTER);

		rightVBox.getChildren().addAll(stack.get(3), stack.get(5), stack.get(4));
		rightVBox.setAlignment(Pos.CENTER);

		bottomVBox.getChildren().addAll(displayTurn);
		bottomVBox.setAlignment(Pos.CENTER);

		displayTurn.setOnAction(e -> {
			if (e.getSource() == displayTurn) {
				RotateTransition rTransition = new RotateTransition(Duration.seconds(2), pane);
				rTransition.setByAngle(90);
				for (int i = 0; i < allCases.size(); i++) {
					RotateTransition rTransitionCase = new RotateTransition(Duration.seconds(2), allCases.get(i));
					rTransitionCase.setByAngle(-90);
					rTransitionCase.play();
				}
				rTransition.play();
			}
		});

		MenuBar menuBar = new MenuBar();
		Menu game = new Menu("Game");

		MenuItem restartGame = new MenuItem("Restart game");
		MenuItem saveGame = new MenuItem("Save game");
		MenuItem loadGame = new MenuItem("Load Game");

		game.getItems().addAll(restartGame, saveGame, loadGame);
		menuBar.getMenus().addAll(game);

		borderpane.setTop(menuBar);

		Scene scene = new Scene(borderpane);
		primaryStage.setTitle("Chessboard");
		primaryStage.getIcons().add(new Image("images/logo.png"));
		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}