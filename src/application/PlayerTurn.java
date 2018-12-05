package application;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PlayerTurn extends HBox{
	Text playerName;
	Canvas canvas;
	public PlayerTurn(String p) {
		// TODO Auto-generated constructor stub
		playerName = new Text(p);
		playerName.setFont(Font.font("Serif",FontWeight.NORMAL,22));
		canvas = new Canvas(30,30);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillOval(10, 10, 15, 15);
		this.setBackground(new Background(new BackgroundFill(Color.WHITE,null, null)));
		this.setSpacing(15);
		this.setPadding(new Insets(15,15,15,15));
		this.setMaxWidth(240);
		this.getChildren().addAll(canvas,playerName);
		//canvas.setVisible(false);
	}
}
