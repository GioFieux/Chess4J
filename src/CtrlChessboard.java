import java.util.Observable;
import java.util.Observer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class CtrlChessboard implements Observer, ChangeListener<Number> {
	private Position jeu;
	private GridPane pane;

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

	public CtrlChessboard(Position pos, GridPane p) {
		this.jeu = pos;
		this.pane = p;
	}

	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {

	}

	@Override
	public void update(Observable o, Object arg) {
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

				switch (jeu.getPosCase(c)) {
					case 0:
						pane.add(new Rectangle(s, s, Color.TRANSPARENT), c.getCol(), c.getRow());
						break;
					case 1:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhiterook)), c.getCol(), c.getRow());
						break;
					case 2:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhiteknight)), c.getCol(), c.getRow());
						break;
					case 3:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhitebishop)), c.getCol(), c.getRow());
						break;
					case 4:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhitequeen)), c.getCol(), c.getRow());
						break;
					case 5:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhiteking)), c.getCol(), c.getRow());
						break;
					case 6:
						pane.add(new Rectangle(s, s, new ImagePattern(imagewhitepawn)), c.getCol(), c.getRow());
						break;
					case 7:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackpawn)), c.getCol(), c.getRow());
						break;
					case 8:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackrook)), c.getCol(), c.getRow());
						break;
					case 9:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackknight)), c.getCol(), c.getRow());
						break;
					case 10:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackbishop)), c.getCol(), c.getRow());
						break;
					case 11:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackqueen)), c.getCol(), c.getRow());
						break;
					case 12:
						pane.add(new Rectangle(s, s, new ImagePattern(imageblackking)), c.getCol(), c.getRow());
						break;
				}
			}
		}
	}
}
