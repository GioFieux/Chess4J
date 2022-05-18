import java.io.File;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Chessboard extends Application {
	Image imageblackpawn, imageblackknight, imageblackrook, imageblackbishop, imageblackqueen, imageblackking,
			imagewhitepawn, imagewhiteknight, imagewhiterook, imagewhitebishop, imagewhiteking, imagewhitequeen;
	ImageView blackpawn, blackknight, blackrook, blackbishop, blackqueen, blackking, whitepawn, whiteknight, whiterook,
			whitequeen, whitebishop, whiteking;

	@Override
	public void start(Stage primaryStage) {

		imageblackpawn = new Image("images/BlackPawn.png");
		imageblackknight = new Image("images/BlackKnight.png");
		imageblackrook = new Image("images/BlackRook.png");
		imageblackbishop = new Image("images/BlackBishop.png");
		imageblackqueen = new Image("images/BlackQueen.png");
		imageblackking = new Image("images/BlackKing.png");
		imagewhitepawn = new Image("images/WhitePawn.png");
		imagewhiteknight = new Image("images/WhiteKnight.png");
		imagewhiterook = new Image("images/WhiteRook.png");
		imagewhitebishop = new Image("images/WhiteBishop.png");
		imagewhitequeen = new Image("images/WhiteQueen.png");
		imagewhiteking = new Image("images/WhiteKing.png");

		blackpawn = new ImageView(imageblackpawn);
		blackknight = new ImageView(imageblackknight);
		blackrook = new ImageView(imageblackrook);
		blackbishop = new ImageView(imageblackbishop);
		blackqueen = new ImageView(imageblackqueen);
		blackking = new ImageView(imageblackking);
		whitepawn = new ImageView(imagewhitepawn);
		whiteknight = new ImageView(imagewhiteknight);
		whiterook = new ImageView(imagewhiterook);
		whitebishop = new ImageView(imagewhitebishop);
		whitequeen = new ImageView(imagewhitequeen);
		whiteking = new ImageView(imagewhiteking);

		Label number1 = new Label("1");
		Label number2 = new Label("2");
		Label number3 = new Label("3");
		Label number4 = new Label("4");
		Label number5 = new Label("5");
		Label number6 = new Label("6");
		Label number7 = new Label("7");
		Label number8 = new Label("8");

		Label lettera = new Label("a");
		Label letterb = new Label("b");
		Label letterc = new Label("c");
		Label letterd = new Label("d");
		Label lettere = new Label("e");
		Label letterf = new Label("f");
		Label letterg = new Label("g");
		Label letterh = new Label("h");

		Label number1bis = new Label("1");
		Label number2bis = new Label("2");
		Label number3bis = new Label("3");
		Label number4bis = new Label("4");
		Label number5bis = new Label("5");
		Label number6bis = new Label("6");
		Label number7bis = new Label("7");
		Label number8bis = new Label("8");

		Label letterabis = new Label("a");
		Label letterbbis = new Label("b");
		Label lettercbis = new Label("c");
		Label letterdbis = new Label("d");
		Label letterebis = new Label("e");
		Label letterfbis = new Label("f");
		Label lettergbis = new Label("g");
		Label letterhbis = new Label("h");

		BorderPane paneborder = new BorderPane();
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);

		HBox hbox = new HBox();
		VBox vbox = new VBox();
		VBox vbox1 = new VBox();
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		VBox vbox2 = new VBox();

		vbox.getChildren().add(number8);
		vbox.getChildren().add(number7);
		vbox.getChildren().add(number6);
		vbox.getChildren().add(number5);
		vbox.getChildren().add(number4);
		vbox.getChildren().add(number3);
		vbox.getChildren().add(number2);
		vbox.getChildren().add(number1);

		vbox1.getChildren().add(number8bis);
		vbox1.getChildren().add(number7bis);
		vbox1.getChildren().add(number6bis);
		vbox1.getChildren().add(number5bis);
		vbox1.getChildren().add(number4bis);
		vbox1.getChildren().add(number3bis);
		vbox1.getChildren().add(number2bis);
		vbox1.getChildren().add(number1bis);

		hbox1.getChildren().add(lettera);
		hbox1.getChildren().add(letterb);
		hbox1.getChildren().add(letterc);
		hbox1.getChildren().add(letterd);
		hbox1.getChildren().add(lettere);
		hbox1.getChildren().add(letterf);
		hbox1.getChildren().add(letterg);
		hbox1.getChildren().add(letterh);

		hbox2.getChildren().add(letterabis);
		hbox2.getChildren().add(letterbbis);
		hbox2.getChildren().add(lettercbis);
		hbox2.getChildren().add(letterdbis);
		hbox2.getChildren().add(letterebis);
		hbox2.getChildren().add(letterfbis);
		hbox2.getChildren().add(lettergbis);
		hbox2.getChildren().add(letterhbis);

		vbox2.getChildren().add(hbox1);
		vbox2.getChildren().add(pane);
		vbox2.getChildren().add(hbox2);
		vbox2.setSpacing(3);

		int count = 0;
		double s = 90;
		Coordinate c = new Coordinate();
		Position pos = new Position();
		Piece p;
		byte[][] matrix = new byte[8][8];
		for (byte i = 0; i < 8; i++) {
			count++;
			for (byte j = 0; j < 8; j++) {
				c.setRow(j);
				c.setCol(i);
				Rectangle r = new Rectangle(s, s, s, s);
				matrix[i][j] = pos.getPosCase(c);

				if (count % 2 == 0) {
					r.setFill(Color.BROWN);
				} else {
					r.setFill(Color.BEIGE);
				}

				switch (pos.getPosCase(c)) {
					case 0:
						break;
					case 1:
						r.setFill(new ImagePattern(imagewhiterook));
						break;
					case 2:
						r.setFill(new ImagePattern(imagewhiteknight));
						break;
					case 3:
						r.setFill(new ImagePattern(imagewhitebishop));
						break;
					case 4:
						r.setFill(new ImagePattern(imagewhitequeen));
						break;
					case 5:
						r.setFill(new ImagePattern(imagewhiteking));
						break;
					case 6:
						r.setFill(new ImagePattern(imagewhitepawn));
						break;
					case 7:
						r.setFill(new ImagePattern(imageblackpawn));
						break;
					case 8:
						r.setFill(new ImagePattern(imageblackrook));
						break;
					case 9:
						r.setFill(new ImagePattern(imageblackknight));
						break;
					case 10:
						r.setFill(new ImagePattern(imageblackbishop));
						break;
					case 11:
						r.setFill(new ImagePattern(imageblackqueen));
						break;
					case 12:
						r.setFill(new ImagePattern(imageblackking));
						break;
				}

				pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						Node node = (Node) e.getTarget();
						int rowClicked = GridPane.getRowIndex(node);
						int colClicked = GridPane.getColumnIndex(node);
						c.setRow((byte) rowClicked);
						c.setCol((byte) colClicked);
						System.out.println("c: " + c + " - PieceId: " + pos.getPosCase(c));
					}
				});
				pane.add(r, i, j);
				count++;
			}
		}

		hbox.getChildren().add(vbox);
		hbox.getChildren().add(vbox2);
		hbox.getChildren().add(vbox1);
		hbox.setSpacing(20);
		MenuBar menuBar = new MenuBar();
		Menu partie = new Menu("Partie");

		MenuItem recommencer = new MenuItem("Recommencer dès le début");
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
		VBox.setMargin(number8, new Insets(55, 0, 0, 0));
		VBox.setMargin(number7, new Insets(75, 0, 0, 0));
		VBox.setMargin(number6, new Insets(75, 0, 0, 0));
		VBox.setMargin(number5, new Insets(70, 0, 0, 0));
		VBox.setMargin(number4, new Insets(70, 0, 0, 0));
		VBox.setMargin(number3, new Insets(75, 0, 0, 0));
		VBox.setMargin(number2, new Insets(70, 0, 0, 0));
		VBox.setMargin(number1, new Insets(70, 0, 0, 0));

		VBox.setMargin(number8bis, new Insets(55, 0, 0, 0));
		VBox.setMargin(number7bis, new Insets(75, 0, 0, 0));
		VBox.setMargin(number6bis, new Insets(75, 0, 0, 0));
		VBox.setMargin(number5bis, new Insets(70, 0, 0, 0));
		VBox.setMargin(number4bis, new Insets(70, 0, 0, 0));
		VBox.setMargin(number3bis, new Insets(75, 0, 0, 0));
		VBox.setMargin(number2bis, new Insets(70, 0, 0, 0));
		VBox.setMargin(number1bis, new Insets(70, 0, 0, 0));

		HBox.setMargin(lettera, new Insets(0, 40, 0, 50));
		HBox.setMargin(letterb, new Insets(0, 40, 0, 40));
		HBox.setMargin(letterc, new Insets(0, 40, 0, 40));
		HBox.setMargin(letterd, new Insets(0, 40, 0, 40));
		HBox.setMargin(lettere, new Insets(0, 40, 0, 40));
		HBox.setMargin(letterf, new Insets(0, 40, 0, 45));
		HBox.setMargin(letterg, new Insets(0, 40, 0, 45));
		HBox.setMargin(letterh, new Insets(0, 40, 0, 45));

		HBox.setMargin(letterabis, new Insets(0, 40, 0, 50));
		HBox.setMargin(letterbbis, new Insets(0, 40, 0, 40));
		HBox.setMargin(lettercbis, new Insets(0, 40, 0, 40));
		HBox.setMargin(letterdbis, new Insets(0, 40, 0, 40));
		HBox.setMargin(letterebis, new Insets(0, 40, 0, 40));
		HBox.setMargin(letterebis, new Insets(0, 40, 0, 40));
		HBox.setMargin(letterfbis, new Insets(0, 40, 0, 45));
		HBox.setMargin(lettergbis, new Insets(0, 40, 0, 45));
		HBox.setMargin(letterhbis, new Insets(0, 40, 0, 45));

		BorderPane.setMargin(hbox, new Insets(5, 0, 0, 30));
		Scene scene = new Scene(paneborder);
		primaryStage.setTitle("ChessGame");
		primaryStage.getIcons().add(new Image("images/logo.png"));
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
