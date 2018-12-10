package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;

public class SymbolPage extends VBox{

	public SymbolPage() {
		// TODO Auto-generated constructor stub
		super();
		setPrefWidth(250);
		String image_path = ClassLoader.getSystemResource("SimplePage"+".jpg").toString();
	 	Image n = new Image(image_path);
	 	ImageView img = new ImageView(n); 
	 	getChildren().add(img);
	}

}
