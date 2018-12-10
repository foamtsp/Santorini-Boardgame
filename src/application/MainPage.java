package application;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainPage extends GridPane{
	private ImageView title;
	private TextField t1,t2;
	private Image img;
	private Button playBtn, helpBtn;
	public MainPage() {
		super();
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25,25,25,25));
		String image_path = ClassLoader.getSystemResource("santorini_Logo.png").toString();
		Image n = new Image(image_path);
		title = new ImageView(n);
		t1 = new TextField();
		t1.setPromptText("Player1");
		t1.setFont(Font.font("LillyBelle",FontWeight.NORMAL,16));
		t1.setOnKeyTyped(event ->{
	        int maxCharacters = 5;
	        if(t1.getText().length() > maxCharacters) event.consume();
	    });
		t2 = new TextField();
		t2.setFont(Font.font("LillyBelle",FontWeight.NORMAL,16));
		t2.setPromptText("Player2");
		t2.setOnKeyTyped(event ->{
	        int maxCharacters = 5;
	        if(t2.getText().length() > maxCharacters) event.consume();
	    });
		String image_pathBg = ClassLoader.getSystemResource("bcmp.jpg").toString();
		img = new Image(image_pathBg);
		this.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
		this.add(title,1,0,1,1);
		this.add(t1, 1, 1);
		this.add(t2, 1, 2);
		HBox hb = new HBox(10);
		hb.setAlignment(Pos.BOTTOM_RIGHT);
		playBtn = new Button("PLAY");
		playBtn.setFont(Font.font("LillyBelle",FontWeight.NORMAL,32));
		helpBtn = new Button("HELP");
		helpBtn.setFont(Font.font("LillyBelle",FontWeight.NORMAL,32));
		hb.getChildren().addAll(playBtn,helpBtn);
		this.add(hb, 1, 3);
	}
	public Button getPlayBtn() {
		return playBtn;
	}
	public Button getHelpBtn() {
		return helpBtn;
	}
	public TextField getT1() {
		return t1;
	}
	public TextField getT2() {
		return t2;
	}
	
}
