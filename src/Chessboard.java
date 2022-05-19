import java.io.File;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.ListResourceBundle;
import java.util.prefs.BackingStoreException;

import javax.management.openmbean.CompositeDataInvocationHandler;
import javax.print.attribute.PrintServiceAttributeSet;

import org.w3c.dom.css.Rect;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.ListCellSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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

	Label player = new Label("Player turn : ");
	Label bPlayerTime = new Label("Black timer : ");
	Label wPlayerTime = new Label("White timer : ");
	Label kingState = new Label("King status : ");
	Label pgn = new Label("PGN : ");
	Label displayPGN = new Label(g.getPGN());
	Label bLostPieces = new Label("Black player lost pieces : ");
	Label wLostPieces = new Label("White player lost pieces : ");
	Button turn = new Button("ROTATE CHESSBOARD");

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
		HBox generalHBox = new HBox();
		VBox numberVBox1 = new VBox();
		numberVBox1.setMaxHeight(760);
		VBox numberVBox2 = new VBox();
		numberVBox2.setMaxHeight(760);
		HBox letterHBox1 = new HBox();
		HBox letterHBox2 = new HBox();
		VBox leftVBox = new VBox();

		VBox rightVBoxLeft = new VBox();
		rightVBoxLeft.setSpacing(15);

		VBox rightVBoxCenter = new VBox();
		rightVBoxCenter.setSpacing(15);

		VBox rightVBoxRight = new VBox();
		rightVBoxRight.setSpacing(15);

		Separator separator = new Separator(
				Orientation.VERTICAL);
		separator.setStyle("-fx-border-style: solid;; -fx-border-color: lightgrey;");
		separator.setMaxHeight(775);

		generalHBox.getChildren().addAll(numberVBox1, leftVBox, numberVBox2, separator, rightVBoxLeft, rightVBoxCenter);
		generalHBox.setSpacing(20);

		Rectangle r1 = new Rectangle(150, 50, Color.LIGHTGRAY);
		r1.setArcHeight(15);
		r1.setArcWidth(15);
		StackPane stack = new StackPane();
		Label playerTxt;
		if (pos.getTurn()) {
			playerTxt = new Label("Turn : WHITE");
		} else {
			playerTxt = new Label("Turn : BLACK");
		}

		stack.getChildren().addAll(r1, playerTxt);

		Rectangle r2 = new Rectangle(150, 50, Color.LIGHTGRAY);
		r2.setArcHeight(15);
		r2.setArcWidth(15);
		StackPane stack2 = new StackPane();
		Label kingState;
		if (pos.isChecked()) {
			kingState = new Label("King in check");
		} else {
			kingState = new Label("King is safe");
		}
		stack2.getChildren().addAll(r2, kingState);
		rightVBoxLeft.getChildren().addAll(stack, stack2);

		StackPane stack3 = new StackPane();
		Rectangle r3 = new Rectangle(150, 150, Color.LIGHTGRAY);
		r3.setArcHeight(15);
		r3.setArcWidth(15);
		Label wLostPieces = new Label("WHITE lost pieces");
		StackPane.setAlignment(wLostPieces, Pos.TOP_CENTER);
		stack3.getChildren().addAll(r3, wLostPieces);

		StackPane stack4 = new StackPane();
		Rectangle r4 = new Rectangle(150, 150, Color.LIGHTGRAY);
		r4.setArcHeight(15);
		r4.setArcWidth(15);
		Label bLostPieces = new Label("BLACK lost pieces");
		StackPane.setAlignment(bLostPieces, Pos.TOP_CENTER);
		stack4.getChildren().addAll(r4, bLostPieces);

		rightVBoxCenter.getChildren().addAll(stack3, stack4);

		StackPane stack5 = new StackPane();
		Rectangle r5 = new Rectangle(150, 50, Color.LIGHTGRAY);
		r5.setArcHeight(15);
		r5.setArcWidth(15);
		Label whiteTimer = new Label("WHITE time : ");
		StackPane.setAlignment(whiteTimer, Pos.CENTER_LEFT);
		stack5.getChildren().addAll(r5, whiteTimer);

		StackPane stack6 = new StackPane();
		Rectangle r6 = new Rectangle(150, 50, Color.LIGHTGRAY);
		r5.setArcHeight(15);
		r5.setArcWidth(15);
		Label blackTimer = new Label("BLACK time : ");
		StackPane.setAlignment(blackTimer, Pos.CENTER_LEFT);
		stack6.getChildren().addAll(r6, blackTimer);

		rightVBoxRight.getChildren().addAll(stack5, stack6);

		BorderPane paneborder = new BorderPane();
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);

		char letter = 'a';
		for (int i = 0; i < 8; i++) {
			Label colLetter = new Label(Character.toString(letter));
			letterHBox1.getChildren().add(colLetter);
			letterHBox1.setAlignment(Pos.CENTER);
			letterHBox1.setSpacing(80);
			letter++;
		}

		char letter2 = 'a';
		for (int i = 0; i < 8; i++) {
			Label colLetter = new Label(Character.toString(letter2));
			letterHBox2.getChildren().add(colLetter);
			letterHBox2.setAlignment(Pos.CENTER);
			letterHBox2.setSpacing(80);
			letter2++;
		}

		int number = 8;
		for (int i = 0; i < 8; i++) {
			Label rowNumber = new Label(Integer.toString(number));
			numberVBox1.getChildren().add(rowNumber);
			numberVBox1.setAlignment(Pos.CENTER);
			numberVBox1.setSpacing(75);
			number--;
		}

		int number2 = 8;
		for (int i = 0; i < 8; i++) {
			Label rowNumber = new Label(Integer.toString(number2));
			numberVBox2.getChildren().add(rowNumber);
			numberVBox2.setAlignment(Pos.CENTER);
			numberVBox2.setSpacing(75);
			number2--;
		}

		leftVBox.getChildren().add(letterHBox1);
		leftVBox.getChildren().add(pane);
		leftVBox.getChildren().add(letterHBox2);
		leftVBox.setSpacing(3);

		int count = 0;
		double s = 90;
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
					r.setFill(Color.BROWN);
				}
				pane.add(r, i, j);
				listeRColor.add(r);

				ArrayList<Rectangle> listeRSelected = new ArrayList<Rectangle>();

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
							rColor = Color.BROWN;
						}
						listClickedColor.add(rColor);

						if (listeRSelected.size() == 0) {
							if (rClicked.getFill() != Color.BROWN && rClicked.getFill() != Color.BEIGE) {

								rImageList.add(rClicked.getFill());
								listeRColor.get(8 * colClicked + rowClicked).setFill(Color.GREEN);
								listeRColor.get(8 * colClicked + rowClicked).setOpacity(0.5);
								cArray[0] = 8 * colClicked + rowClicked;
								listeRSelected.add(rClicked);
							}
						} else if (listeRSelected.size() == 1) {
							if (rClicked.getFill() != Color.BROWN && rClicked.getFill() != Color.BEIGE) {
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

				int tmp;
				if (count == 1) {
					tmp = 1;
				} else {
					tmp = 2 * count - 1;
				}
				int index = tmp;

				int row = i;
				int col = j;
				int[] pieceSelected = { 0 };

				count++;
			}
		}

		/*
		 * CtrlChessboard ctrlchess = new CtrlChessboard(pos, pane);
		 * pos.addObserver(ctrlchess);
		 */

		MenuBar menuBar = new MenuBar();
		Menu partie = new Menu("Partie");

		MenuItem recommencer = new MenuItem("Recommencer d�s le d�but");
		MenuItem sauvegarder = new MenuItem("Sauvegarder la partie");
		MenuItem charger = new MenuItem("Charger la partie");

		partie.getItems().addAll(recommencer, sauvegarder, charger);
		menuBar.getMenus().addAll(partie);

		paneborder.setTop(menuBar);
		paneborder.setCenter(generalHBox);

		BorderPane.setMargin(generalHBox, new Insets(5, 0, 0, 30));
		Scene scene = new Scene(
				paneborder);
		primaryStage.setTitle("Chessboard");
		primaryStage.getIcons().add(new Image("images/logo.png"));
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
