package application;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class HelpPage extends BorderPane {
		
	Button backBtn;
	
		public HelpPage() {
			super();
			String image_path = ClassLoader.getSystemResource("santorini-rules"+".gif").toString();
			Image n = new Image(image_path);
			ImageView img = new ImageView(n);
			setCenter(img);
			
			
			backBtn = new Button("Back");
			setLeft(backBtn);
	}
	
	
	
	
}
