package application;

import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class StatusPage extends VBox{
	Label pt;
	Rectangle r;
	Group g;
	public StatusPage() {
		// TODO Auto-generated constructor stub
		this.setSpacing(15);
		pt = new Label("Player's Turn:");
		pt.setFont(Font.font("Serif",FontWeight.NORMAL,24));
		this.getChildren().add(pt);
		r = new Rectangle(10,10,50,50);
		g = new Group();
		g.getChildren().add(r);
		this.getChildren().add(g);
	}

}
