import java.io.File;

import javax.management.openmbean.CompositeDataInvocationHandler;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
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

		BorderPane paneborder = new BorderPane();
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);

		HBox hbox = new HBox();
		VBox vbox = new VBox();
		VBox vbox1 = new VBox();
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		VBox vbox2 = new VBox();

		char letter = 'a';
		for (int i = 0; i < 8; i++) {
			Label colLetter = new Label(Character.toString(letter));
			hbox1.getChildren().add(colLetter);
			hbox1.setAlignment(Pos.CENTER);
			hbox1.setSpacing(85);
			letter++;
		}

		char letter2 = 'a';
		for (int i = 0; i < 8; i++) {
			Label colLetter = new Label(Character.toString(letter2));
			hbox2.getChildren().add(colLetter);
			hbox2.setAlignment(Pos.CENTER);
			hbox2.setSpacing(85);
			letter2++;
		}

		int number = 1;
		for (int i = 0; i < 8; i++) {
			Label rowNumber = new Label(Integer.toString(number));
			vbox.getChildren().add(rowNumber);
			vbox.setAlignment(Pos.CENTER);
			vbox.setSpacing(75);
			number++;
		}

		int number2 = 1;
		for (int i = 0; i < 8; i++) {
			Label rowNumber = new Label(Integer.toString(number2));
			vbox1.getChildren().add(rowNumber);
			vbox1.setAlignment(Pos.CENTER);
			vbox1.setSpacing(75);
			number2++;
		}

		vbox2.getChildren().add(hbox1);
		vbox2.getChildren().add(pane);
		vbox2.getChildren().add(hbox2);
		vbox2.setSpacing(3);

		double s = 90;
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

				switch (pos.getPosCase(c)) {
					case 0:
						pane.add(new Rectangle(s, s, Color.TRANSPARENT), c.getCol(), c.getRow());
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
						Node node = (Node) e.getTarget();
						int rowClicked = GridPane.getRowIndex(node);
						int colClicked = GridPane.getColumnIndex(node);
						cClicked.setRow((byte) rowClicked);
						cClicked.setCol((byte) colClicked);
						System.out.println("cClicked: " + cClicked + " - PieceId: " +
								pos.getPosCase(cClicked));
					}
				});
			}
		}

		/*
		 * CtrlChessboard ctrlchess = new CtrlChessboard(pos, pane);
		 * pos.addObserver(ctrlchess);
		 */

		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Coordinate cClicked = new Coordinate();
				Node node = (Node) e.getTarget();
				int rowClicked = GridPane.getRowIndex(node);
				int colClicked = GridPane.getColumnIndex(node);
				cClicked.setRow((byte) rowClicked);
				cClicked.setCol((byte) colClicked);
				System.out.println("cClicked: " + cClicked + " - PieceId: " + pos.getPosCase(cClicked));
			}
		});

		hbox.getChildren().add(vbox);
		hbox.getChildren().add(vbox2);
		hbox.getChildren().add(vbox1);
		hbox.setSpacing(20);
		MenuBar menuBar = new MenuBar();
		Menu partie = new Menu("Partie");

		MenuItem recommencer = new MenuItem("Recommencer d�s le d�but");
		MenuItem sauvegarder = new MenuItem("Sauvegarder la partie");
		MenuItem charger = new MenuItem("Charger la partie");

		partie.getItems().addAll(recommencer, sauvegarder, charger);
		menuBar.getMenus().addAll(partie);

		Separator separator = new Separator(Orientation.VERTICAL);
		separator.setStyle("-fx-border-colClickedor : #e79423; -fx-border-style: solid;");
		hbox.getChildren().add(separator);

		TextField textField = new TextField("");
		textField.setPrefWidth(110);
		hbox.getChildren().add(textField);

		paneborder.setTop(menuBar);
		paneborder.setCenter(hbox);

		BorderPane.setMargin(hbox, new Insets(5, 0, 0, 30));
		Scene scene = new Scene(paneborder);
		primaryStage.setTitle("Chessboard");
		primaryStage.getIcons().add(new Image("images/logo.png"));
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
