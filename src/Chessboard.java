import java.io.File;
import java.sql.Blob;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.ListResourceBundle;
import java.util.Stack;
import java.util.prefs.BackingStoreException;

import javax.management.openmbean.CompositeDataInvocationHandler;
import javax.print.attribute.PrintServiceAttributeSet;

import org.w3c.dom.css.Rect;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.css.converter.InsetsConverter;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Chessboard extends Application {
	/*
	 * public Image imageblackpawn, imageblackknight, imageblackrook,
	 * imageblackbishop, imageblackqueen, imageblackking,
	 * imagewhitepawn, imagewhiteknight, imagewhiterook, imagewhitebishop,
	 * imagewhiteking, imagewhitequeen;
	 * /*
	 * ImageView blackpawn, blackknight, blackrook, blackbishop, blackqueen,
	 * blackking, whitepawn, whiteknight, whiterook,
	 * whitequeen, whitebishop, whiteking;
	 */

	public final Image imageblackpawn = new Image("images/BlackPawn.png");
	public final Image imageblackknight = new Image("images/BlackKnight.png");
	public final Image imageblackrook = new Image("images/BlackRook.png");
	public final Image imageblackbishop = new Image("images/BlackBishop.png");
	public final Image imageblackqueen = new Image("images/BlackQueen.png");
	public final Image imageblackking = new Image("images/BlackKing.png");
	public final Image imagewhitepawn = new Image("images/WhitePawn.png");
	public final Image imagewhiteknight = new Image("images/WhiteKnight.png");
	public final Image imagewhiterook = new Image("images/WhiteRook.png");
	public final Image imagewhitebishop = new Image("images/WhiteBishop.png");
	public final Image imagewhitequeen = new Image("images/WhiteQueen.png");
	public final Image imagewhiteking = new Image("images/WhiteKing.png");

	Position pos = new Position();
	Game g = new Game("");

	private ArrayList<StackPane> createStackPanes(Rectangle r1, Rectangle r2, Rectangle r3, Rectangle r4, Rectangle r5,
			Rectangle r6) {
		ArrayList<StackPane> stackList = new ArrayList<StackPane>();

		// Black lost pieces
		StackPane stackLeftTop = new StackPane();
		stackLeftTop.getChildren().addAll(r1, createLabels().get(0), createLabels().get(1));
		VBox.setMargin(stackLeftTop, new Insets(50, 10, 50, 25));
		stackList.add(stackLeftTop);

		// White lost pieces
		StackPane stackLeftBottom = new StackPane();
		stackLeftBottom.getChildren().addAll(r2, createLabels().get(2), createLabels().get(3));
		VBox.setMargin(stackLeftBottom, new Insets(50, 10, 50, 25));
		stackList.add(stackLeftBottom);

		// PGN
		StackPane stackLeftCenterRight = new StackPane();
		stackLeftCenterRight.getChildren().addAll(r3, createLabels().get(4));
		VBox.setMargin(stackLeftCenterRight, new Insets(50, 10, 50, 25));
		stackList.add(stackLeftCenterRight);

		StackPane stackRightTop = new StackPane();
		stackRightTop.getChildren().addAll(r4, createLabels().get(5));
		VBox.setMargin(stackRightTop, new Insets(100, 25, 100, 10));
		stackList.add(stackRightTop);

		StackPane stackRightBottom = new StackPane();
		stackRightBottom.getChildren().addAll(r5, createLabels().get(6));
		VBox.setMargin(stackRightBottom, new Insets(100, 25, 100, 10));
		stackList.add(stackRightBottom);

		StackPane stackRightCenter = new StackPane();
		stackRightCenter.getChildren().addAll(r6, createLabels().get(7));
		VBox.setMargin(stackRightCenter, new Insets(25, 25, 25, 10));
		stackList.add(stackRightCenter);

		return stackList;
	}

	private ArrayList<Rectangle> createRectangles() {
		ArrayList<Rectangle> rList = new ArrayList<Rectangle>();

		// Black lost pieces
		Rectangle bPlayerLostPiece = new Rectangle(150, 175, Color.WHITE);
		bPlayerLostPiece.setArcHeight(50);
		bPlayerLostPiece.setArcWidth(50);
		rList.add(bPlayerLostPiece);

		// White lost pieces
		Rectangle wPlayerLostPiece = new Rectangle(150, 175, Color.WHITE);
		wPlayerLostPiece.setArcHeight(50);
		wPlayerLostPiece.setArcWidth(50);
		rList.add(wPlayerLostPiece);

		// PGN
		Rectangle rPGN = new Rectangle(125, 800, Color.WHITE);
		rPGN.setArcHeight(50);
		rPGN.setArcWidth(50);
		rList.add(rPGN);

		Rectangle bPlayer = new Rectangle(275, 75, Color.WHITE);
		bPlayer.setArcHeight(50);
		bPlayer.setArcWidth(50);
		rList.add(bPlayer);

		Rectangle wPlayer = new Rectangle(275, 75, Color.WHITE);
		wPlayer.setArcHeight(50);
		wPlayer.setArcWidth(50);
		rList.add(wPlayer);

		Rectangle playerCheckState = new Rectangle(275, 75, Color.WHITE);
		playerCheckState.setArcWidth(50);
		playerCheckState.setArcHeight(50);
		rList.add(playerCheckState);

		return rList;
	}

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

		Label bPlayerTimer = new Label("00:00");
		labelList.add(bPlayerTimer);
		Label wPlayerTimer = new Label("00:00");
		labelList.add(wPlayerTimer);
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

	private Button displayTurnButton() {
		Button displayTurn = new Button("Rotate");
		displayTurn.setMaxWidth(100);
		displayTurn.setMaxHeight(150);
		displayTurn
				.setStyle(
						"-fx-background-color: white; -fx-background-radius: 25;-fx-border-width: 2.5px; -fx-border-color: BEIGE; -fx-border-radius: 25; -fx-font-family: 'Consolas'; -fx-font-size: 17.5;");
		VBox.setMargin(displayTurn, new Insets(25, 25, 50, 25));

		displayTurn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				RotateTransition rotate = new RotateTransition();
				Node node = (Node) e.getTarget();

				rotate.setByAngle(180);
				createGridPane().setRotate(180);
				rotate.play();
			}
		});

		return displayTurn;
	}

	private GridPane createGridPane() {
		GridPane pane = new GridPane();
		int count = 0;
		double s = 75;
		ArrayList<Rectangle> listeRColor = new ArrayList<Rectangle>();
		ArrayList<Paint> listClickedColor = new ArrayList<Paint>();
		ArrayList<Paint> rImageList = new ArrayList<Paint>();
		int[] cArray = new int[1];
		Coordinate c = new Coordinate();
		for (byte i = 0; i < 8; i++) {
			for (byte j = 0; j < 8; j++) {
				c.setRow(j);
				c.setCol(i);
				Rectangle r = new Rectangle(s, s);

				if ((i + j) % 2 == 0) {
					r.setFill(Color.BEIGE);
				} else {
					r.setFill(Color.BURLYWOOD);
				}
				pane.add(r, i, j);
				listeRColor.add(r);

				ArrayList<Rectangle> listeRSelected = new ArrayList<Rectangle>();

				switch (pos.getPosCase(c)) {
					case 0:
						break;
					case 1:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhiterook)), c.getCol(),
								c.getRow());
						break;
					case 2:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhiteknight)), c.getCol(),
								c.getRow());
						break;
					case 3:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhitebishop)), c.getCol(),
								c.getRow());
						break;
					case 4:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhitequeen)), c.getCol(),
								c.getRow());
						break;
					case 5:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhiteking)), c.getCol(),
								c.getRow());
						break;
					case 6:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhitepawn)), c.getCol(),
								c.getRow());
						break;
					case 7:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackpawn)), c.getCol(),
								c.getRow());
						break;
					case 8:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackrook)), c.getCol(),
								c.getRow());
						break;
					case 9:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackknight)), c.getCol(),
								c.getRow());
						break;
					case 10:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackbishop)), c.getCol(),
								c.getRow());
						break;
					case 11:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackqueen)), c.getCol(),
								c.getRow());
						break;
					case 12:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackking)), c.getCol(),
								c.getRow());
						break;
				}

				pane.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent e) {
						Coordinate cClicked = new Coordinate();
						Rectangle rClicked = (Rectangle) e.getTarget();
						int rowClicked = GridPane.getRowIndex(rClicked);
						int colClicked = GridPane.getColumnIndex(rClicked);
						cClicked.setRow((byte) rowClicked);
						cClicked.setCol((byte) colClicked);
						Paint rColor = Color.TRANSPARENT;
						if ((rowClicked + colClicked) % 2 == 0) {
							rColor = Color.BEIGE;
						} else {
							rColor = Color.BURLYWOOD;
						}

						if (listeRSelected.size() == 0) {
							if (rClicked.getFill() != Color.BURLYWOOD
									&& rClicked.getFill() != Color.BEIGE) {
								listClickedColor.add(rColor);

								rImageList.add(rClicked.getFill());
								listeRColor.get(8 * colClicked + rowClicked).setFill(Color.GREEN);
								listeRColor.get(8 * colClicked + rowClicked).setOpacity(0.5);
								cArray[0] = 8 * colClicked + rowClicked;
								listeRSelected.add(rClicked);
							}
						} else if (listeRSelected.size() == 1) {
							if (rClicked.getFill() != Color.BURLYWOOD
									&& rClicked.getFill() != Color.BEIGE) {
								listClickedColor.add(rColor);

								listeRColor.get(cArray[0]).setFill(listClickedColor.get(0));
								listeRSelected.get(0).setFill(rImageList.get(0));
								listeRColor.get(cArray[0]).setOpacity(1);
								listeRSelected.add(rClicked);
								listeRColor.get(8 * colClicked + rowClicked).setFill(Color.GREEN);
								listeRColor.get(8 * colClicked + rowClicked).setOpacity(0.5);
								cArray[0] = 8 * colClicked + rowClicked;
								rImageList.add(rClicked.getFill());

								listeRSelected.remove(listeRSelected.get(0));
								listClickedColor.remove(listClickedColor.get(0));
								rImageList.remove(rImageList.get(0));
							}
						}

						System.out.println("cClicked: " + cClicked + " - PieceId: " +
								pos.getPosCase(cClicked));
					}
				});

				int tmp;
				if (count == 1) {
					tmp = 1;
				} else {
					tmp = 2 * count - 1;
				}
				int index = tmp;

				count++;
			}
		}
		pane.setStyle(
				"-fx-border-style: solid; -fx-border-color: rgb(139,69,19); -fx-border-width: 10px;");
		return pane;
	}

	@Override
	public void start(Stage primaryStage) {

		/*
		 * blackpawn = new ImageView(imageblackpawn);
		 * blackknight = new ImageView(imageblackknight);
		 * blackrook = new ImageView(imageblackrook);
		 * blackbishop = new ImageView(imageblackbishop);
		 * blackqueen = new ImageView(imageblackqueen);
		 * blackking = new ImageView(imageblackking);
		 * whitepawn = new ImageView(imagewhitepawn);
		 * whiteknight = new ImageView(imagewhiteknight);
		 * whiterook = new ImageView(imagewhiterook);
		 * whitebishop = new ImageView(imagewhitebishop);
		 * whitequeen = new ImageView(imagewhitequeen);
		 * whiteking = new ImageView(imagewhiteking);
		 */
		VBox centerVBox = new VBox();
		VBox rightVBox = new VBox();
		VBox leftVBoxRight = new VBox();
		VBox leftVBoxLeft = new VBox();
		HBox leftHBox = new HBox();
		VBox bottomVBox = new VBox();

		BorderPane borderpane = new BorderPane();
		GridPane pane = createGridPane();

		Rectangle r1 = createRectangles().get(0);
		Rectangle r2 = createRectangles().get(1);
		Rectangle r3 = createRectangles().get(2);
		Rectangle r4 = createRectangles().get(3);
		Rectangle r5 = createRectangles().get(4);
		Rectangle r6 = createRectangles().get(5);

		ArrayList<StackPane> stack = createStackPanes(r1, r2, r3, r4, r5, r6);

		borderpane.setStyle("-fx-background-color: rgb(222,184,135);");
		borderpane.setLeft(leftHBox);
		borderpane.setCenter(centerVBox);
		borderpane.setRight(rightVBox);
		borderpane.setBottom(bottomVBox);

		centerVBox.getChildren().add(pane);
		centerVBox.setMaxSize(600, 600);
		centerVBox.setAlignment(Pos.CENTER);
		VBox.setMargin(pane, new Insets(0, 125, 0, 100));

		/*
		 * for (int i = 0; i < 8; i++) {
		 * StackPane square = new StackPane();
		 * char[] letter = new char[] { (char) ('a' + i) };
		 * Label label = new Label(new String(letter));
		 * square.getChildren().add(label);
		 * square.setStyle("-fx-background-color: white;");
		 * pane.add(square, i, 8);
		 * }
		 */

		// Left side where the pieces lost by the black and white player are displayed
		leftVBoxLeft.getChildren().addAll(stack.get(0), stack.get(1));
		leftVBoxLeft.setAlignment(Pos.CENTER);

		leftVBoxRight.getChildren().addAll(stack.get(2));
		leftVBoxRight.setAlignment(Pos.CENTER_LEFT);

		leftHBox.getChildren().addAll(leftVBoxLeft, leftVBoxRight);
		leftHBox.setAlignment(Pos.CENTER);

		rightVBox.getChildren().addAll(stack.get(3), stack.get(5), stack.get(4));
		rightVBox.setAlignment(Pos.CENTER);

		bottomVBox.getChildren().addAll(displayTurnButton());
		bottomVBox.setAlignment(Pos.CENTER);

		/*
		 * CtrlChessboard ctrlchess = new CtrlChessboard(pos, pane);
		 * pos.addObserver(ctrlchess);
		 */

		MenuBar menuBar = new MenuBar();
		Menu game = new Menu("Game");

		MenuItem restartGame = new MenuItem("Restart game");
		MenuItem saveGame = new MenuItem("Save game");
		MenuItem loadGame = new MenuItem("Load Game");

		game.getItems().addAll(restartGame, saveGame, loadGame);
		menuBar.getMenus().addAll(game);

		borderpane.setTop(menuBar);

		Scene scene = new Scene(
				borderpane, 1500, 1000);
		primaryStage.setTitle("Chessboard");
		primaryStage.getIcons().add(new Image("images/logo.png"));
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}