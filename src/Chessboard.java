import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Chessboard extends Application {
	Image imageblackpawn,imageblackknight,imageblackrook,imageblackbishop,imageblackqueen,imageblackking,imagewhitepawn,imagewhiteknight,imagewhiterook,imagewhitebishop,imagewhiteking, imagewhitequeen;
	ImageView blackpawn,blackknight,blackrook,blackbishop,blackqueen,blackking,whitepawn,whiteknight,whiterook,whitequeen,whitebishop,whiteking;
	@Override
	public void start(Stage primaryStage) {
		
		imageblackpawn= new Image("file:BlackPawn.png");
		imageblackknight= new Image("file:BlackKnight.png");
		imageblackrook= new Image("file:BlackRook.png");
		imageblackbishop= new Image("file:BlackBishop.png");
		imageblackqueen= new Image("file:BlackQueen.png");
		imageblackking= new Image("file:BlackKing.png");
		imagewhitepawn= new Image("file:WhitePawn.png");
		imagewhiteknight= new Image("file:WhiteKnight.png");
		imagewhiterook= new Image("file:WhiteRook.png");
		imagewhitebishop= new Image("file:WhiteBishop.png");
		imagewhitequeen= new Image("file:WhiteQueen.png");
		imagewhiteking= new Image("file:WhiteKing.png");
		
		blackpawn= new ImageView(imageblackpawn);
		blackknight= new ImageView(imageblackknight);
		blackrook = new ImageView(imageblackrook);
		blackbishop = new ImageView(imageblackbishop);
		blackqueen = new ImageView(imageblackqueen);
		blackking = new ImageView(imageblackking);
		whitepawn= new ImageView(imagewhitepawn);
		whiteknight= new ImageView(imagewhiteknight);
		whiterook= new ImageView(imagewhiterook);
		whitebishop= new ImageView(imagewhitebishop);
		whitequeen= new ImageView(imagewhitequeen);
		whiteking= new ImageView(imagewhiteking);
		
		BorderPane paneborder= new BorderPane();
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);
		
		HBox hbox= new HBox();
		hbox.setSpacing(50);
		int count =0;
		double s = 90;
		for(byte i=0; i<8; i++) {
			count++;
			for(byte j=0; j<8; j++) {
				Rectangle r = new Rectangle(s,s,s,s);
				if(count % 2 == 0) {
					r.setFill(Color.BROWN);
				}
				else {
					r.setFill(Color.BEIGE);
				}
				if(i<8 && j==1) {
					r.setFill(new ImagePattern(imageblackpawn));
					r.setStyle("-fx-background-color: rgba (0,0,0,0);");
				}
				if ((i==0 && j==0) || (i==0 && j==7)) {
					r.setStyle("-fx-background-color: rgba (0,0,0,0);");
					r.setFill(Color.TRANSPARENT);
					r.setFill(new ImagePattern(imageblackrook));
				}
				if((i==7 && j==7) || (i==0 && j==7)) {
					r.setFill(new ImagePattern(imagewhiterook));
				}
				
				pane.add(r, i, j);
				count++;
			}
		}
		hbox.getChildren().add(pane);
		
		MenuBar menuBar = new MenuBar();
		Menu partie= new Menu("Partie");
		
		MenuItem recommencer= new MenuItem("Recommencer dès le début");
		MenuItem sauvegarder = new MenuItem("Sauvegarder la partie");
		MenuItem charger = new MenuItem("Charger la partie");
		
		partie.getItems().addAll(recommencer, sauvegarder, charger);
		menuBar.getMenus().addAll(partie);
		
		
		
		Separator separator = new Separator(Orientation.VERTICAL);
		separator.setStyle("-fx-border-color : #e79423; -fx-border-style: solid;");
		hbox.getChildren().add(separator);
		
		TextField textField = new TextField("Text Field");
        textField.setPrefWidth(110);
        hbox.getChildren().add(textField);
        
        paneborder.setTop(menuBar);
        paneborder.setCenter(hbox);
		paneborder.setMargin(hbox, new Insets(20,0,0,60));
		Scene scene= new Scene(paneborder);
		primaryStage.setTitle("Chessboard");
		primaryStage.getIcons().add(new Image("file:logo.png"));
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
