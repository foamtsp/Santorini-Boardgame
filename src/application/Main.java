package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	Scene scene1,scene2;
	@Override
	public void start(Stage primaryStage) {
		/*try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		MainPage mp = new MainPage();
		
		HBox hb = new HBox(10);
		hb.setAlignment(Pos.BOTTOM_RIGHT);
		Button pbtn = new Button("Play");		
		Button hbtn = new Button("Help");
		hb.getChildren().addAll(pbtn,hbtn);
		mp.add(hb, 1, 3);
		pbtn.setOnAction(e->{
			primaryStage.setScene(scene2);
			primaryStage.setTitle("Santorini");
			primaryStage.show();
			
		});
		scene1 = new Scene(mp,400,400);
		FlowPane f = new FlowPane();
		Button bbtn = new Button("Back");
		f.setPrefHeight(300);
		f.setPrefWidth(150);
		StatusPage s = new StatusPage();
		f.getChildren().addAll(bbtn,s);
		bbtn.setOnAction(e->{
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Santorini");
			primaryStage.show();
			
		});
		scene2 = new Scene(f,400,400);
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Santorini");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
