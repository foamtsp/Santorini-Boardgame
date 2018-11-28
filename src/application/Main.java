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
	String p1, p2;
	StatusPage s;
	@Override
	public void start(Stage primaryStage) {
		
		MainPage mp = new MainPage();
		primaryStage.setResizable(false);
		
		HBox hb = new HBox(10);
		hb.setAlignment(Pos.BOTTOM_RIGHT);
		Button pbtn = new Button("Play");		
		Button hbtn = new Button("Help");
		hb.getChildren().addAll(pbtn,hbtn);
		mp.add(hb, 1, 3);
		pbtn.setOnAction(e->{
			p1 = mp.t1.getText().trim();
			p2 = mp.t2.getText().trim();
			s.setPlayerName(mp.t1.getText().trim(), mp.t2.getText().trim());
			primaryStage.setScene(scene2);
			primaryStage.setTitle("Santorini");
			primaryStage.show();
			
		});
		scene1 = new Scene(mp,1000,600);
		FlowPane f = new FlowPane();
		Button bbtn = new Button("Back");
		f.setPrefHeight(300);
		f.setPrefWidth(150);
		s = new StatusPage();
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
