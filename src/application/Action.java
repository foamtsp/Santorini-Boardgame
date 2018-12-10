package application;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Action extends StackPane {

	public Action(String action) {
		// TODO Auto-generated constructor stub
		setWidth(150);
		setHeight(40);
		this.setBackground(new Background(new BackgroundFill(Color.WHITE,null, null)));
		Text act = new Text(action);
		act.setFont(Font.font("Angsana New", FontWeight.NORMAL, 30));
		setPadding(new Insets(10,10,10,10));
		act.relocate(10, 10);
		getChildren().add(act);
	}

}
