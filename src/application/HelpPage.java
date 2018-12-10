package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HelpPage extends BorderPane {

	private Button backBtn;

	public Button getBackBtn() {
		return backBtn;
	}

	public HelpPage() {
		super();
		setPadding(new Insets(10));
		String image_path = ClassLoader.getSystemResource("santorini-rules" + ".gif").toString();
		Image n = new Image(image_path);
		ImageView img = new ImageView(n);
		setCenter(img);

		backBtn = new Button("Back");
		backBtn.setFont(Font.font("LillyBelle", FontWeight.NORMAL, 12));
		setLeft(backBtn);
	}

}
