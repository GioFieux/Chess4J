import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
import javafx.scene.layout.VBox;
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
		
		BorderPane paneborder= new BorderPane();
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);
		
		HBox hbox= new HBox();
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
				pane.add(r, i, j);
				count++;
			}
		}
		hbox.getChildren().add(vbox);
		hbox.getChildren().add(vbox2);
		hbox.getChildren().add(vbox1);
		
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
		vbox.setMargin(number8, new Insets(40,0,55,0));
		vbox.setMargin(number7, new Insets(15,0,55,0));
		vbox.setMargin(number6, new Insets(15,0,55,0));
		vbox.setMargin(number5, new Insets(15,0,55,0));
		vbox.setMargin(number4, new Insets(20,0,55,0));
		vbox.setMargin(number3, new Insets(20,0,55,0));
		vbox.setMargin(number2, new Insets(20,0,55,0));
		vbox.setMargin(number1, new Insets(15,0,55,0));
		
		vbox1.setMargin(number8bis, new Insets(40,0,55,0));
		vbox1.setMargin(number7bis, new Insets(15,0,55,0));
		vbox1.setMargin(number6bis, new Insets(15,0,55,0));
		vbox1.setMargin(number5bis, new Insets(15,0,55,0));
		vbox1.setMargin(number4bis, new Insets(20,0,55,0));
		vbox1.setMargin(number3bis, new Insets(20,0,55,0));
		vbox1.setMargin(number2bis, new Insets(20,0,55,0));
		vbox1.setMargin(number1bis, new Insets(15,0,55,0));
        
		hbox1.setMargin(lettera, new Insets(0,40,0,50));
		hbox1.setMargin(letterb, new Insets(0,40,0,40));
		hbox1.setMargin(letterc, new Insets(0,40,0,40));
		hbox1.setMargin(letterd, new Insets(0,40,0,40));
		hbox1.setMargin(lettere, new Insets(0,40,0,40));
		hbox1.setMargin(letterf, new Insets(0,40,0,45));
		hbox1.setMargin(letterg, new Insets(0,40,0,45));
		hbox1.setMargin(letterh, new Insets(0,40,0,45));
		
		hbox2.setMargin(letterabis, new Insets(0,40,0,50));
		hbox2.setMargin(letterbbis, new Insets(0,40,0,40));
		hbox2.setMargin(lettercbis, new Insets(0,40,0,40));
		hbox2.setMargin(letterdbis, new Insets(0,40,0,40));
		hbox2.setMargin(letterebis, new Insets(0,40,0,40));
		hbox2.setMargin(letterebis, new Insets(0,40,0,40));
		hbox2.setMargin(letterfbis, new Insets(0,40,0,45));
		hbox2.setMargin(lettergbis, new Insets(0,40,0,45));
		hbox2.setMargin(letterhbis, new Insets(0,40,0,45));
		
		paneborder.setMargin(hbox, new Insets(10,0,0,60));
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
