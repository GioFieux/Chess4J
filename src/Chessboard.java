import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Chessboard extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane paneborder= new BorderPane();
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);
		
		HBox hbox= new HBox();
		hbox.setSpacing(30);
		int count =0;
		double s = 50;
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
		
		MenuBar menuBar = new MenuBar();
		Menu partie= new Menu("Partie");
		
		MenuItem recommencer= new MenuItem("Recommencer dès le début");
		MenuItem sauvegarder = new MenuItem("Sauvegarder la partie");
		MenuItem charger = new MenuItem("Charger la partie");
		
		partie.getItems().addAll(recommencer, sauvegarder, charger);
		menuBar.getMenus().addAll(partie);
		
		hbox.getChildren().add(pane);
		
		Separator separator = new Separator(Orientation.VERTICAL);
		separator.setStyle("-fx-border-style: solid; -fx-border-color:#D2691E; -fx-border-width: 10;");
		hbox.getChildren().add(separator);
		
		TextField textField = new TextField("Text Field");
        textField.setPrefWidth(110);
        hbox.getChildren().add(textField);
        
        paneborder.setTop(menuBar);
		paneborder.setCenter(hbox);
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
