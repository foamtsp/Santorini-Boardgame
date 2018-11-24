package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainPage extends GridPane{
	Text title;
	Label p1, p2;
	TextField t1,t2;
	public MainPage() {
		super();
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25,25,25,25));
		title = new Text("SANTORINI");
		title.setFont(Font.font("Serif",FontWeight.NORMAL,30));
		p1 = new Label("Player1:");
		p2 = new Label("Player2:");
		t1 = new TextField();
		t2 = new TextField();
		this.add(title,0,0,1,1);
		this.add(p1, 0, 1);
		this.add(p2, 0, 2);
		this.add(t1, 1, 1);
		this.add(t2, 1, 2);

	}

}
