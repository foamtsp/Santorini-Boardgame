package application;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainPage extends GridPane{
	Text title;
	Label p1, p2;
	TextField t1,t2;
	BackgroundImage myBI;
	Image img;
	public MainPage() {
		super();
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25,25,25,25));
		title = new Text("SANTORINI");
		title.setFont(Font.font("Serif",FontWeight.BLACK,40));
		p1 = new Label("Player1:");
		p2 = new Label("Player2:");
		t1 = new TextField();
		t2 = new TextField();
		img = new Image("bcmp.jpg");
		this.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
		this.add(title,0,0,1,1);
		this.add(p1, 0, 1);
		this.add(p2, 0, 2);
		this.add(t1, 1, 1);
		this.add(t2, 1, 2);
	}

}
