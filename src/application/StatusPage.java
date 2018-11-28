package application;

import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class StatusPage extends VBox{
	Label pt;

	public StatusPage() {
		// TODO Auto-generated constructor stub
		this.setSpacing(15);
		pt = new Label("Player's Turn:");
		pt.setFont(Font.font("Serif",FontWeight.NORMAL,24));
		this.getChildren().add(pt);
	
	}
	public void setPlayerName(String p1,String p2) {
		Text pr1 = new Text(p1);
		Text pr2 = new Text(p2);
		this.getChildren().addAll(pr1,pr2);
	}

}
