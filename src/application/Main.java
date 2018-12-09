package application;
	
import boardPart.Board;
import exceptionPart.InvalidBuildException;
import exceptionPart.InvalidMoveException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import playersPart.Player;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;

public class Main extends Application {
	Scene scene1,scene2,scene3;
	Player player1;
	Player player2;
	StatusPage s;
	Board board;
	public static AudioClip bgmSound;
	@Override
	public void start(Stage primaryStage) {
		
		bgmSound = new AudioClip(ClassLoader.getSystemResource("bgm.mp3").toString());
		bgmSound.setVolume(1.0);
		bgmSound.play();
		MainPage mp = new MainPage();
		primaryStage.setResizable(false);

		mp.getPlayBtn().setOnAction(e->{
			String p1 = mp.getT1().getText().trim();
			String p2 = mp.getT2().getText().trim();
			board.getP1().setName(p1);
			board.getP2().setName(p2);
			/*
			player1 = new Player(p1);
			player2 = new Player(p2);
			while ((player2.getCurrentLocation().getX() == player1.getCurrentLocation().getX())
					&& (player2.getCurrentLocation().getY() == player1.getCurrentLocation().getY())) {
				int nx = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
				int ny = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
				player2.setCurrentLocation(new Location(ny, nx));
			}
			player2.move(player2.getCurrentLocation().getX(), player2.getCurrentLocation().getX());
			*/
			s.setPlayerName(p1, p2);
	
			primaryStage.setScene(scene2);
			primaryStage.setTitle("Santorini");
			primaryStage.show();
			
		});
		BorderPane des = new HelpPage();
		mp.getHelpBtn().setOnAction(e->{
			/*Canvas canvas = new Canvas(1000,600);
			GraphicsContext gc = canvas.getGraphicsContext2D(); 	
			des.getChildren().add(canvas);*/
			primaryStage.setScene(scene3);
			primaryStage.setTitle("Santorini-Help");
			primaryStage.show();
			
		});
		scene1 = new Scene(mp,1000,600);
		BorderPane f = new BorderPane();
		Button backBtn = new Button("Back");
		f.setPrefHeight(300);
		f.setPrefWidth(150);
		s = new StatusPage();
		s.moveBtn.setOnAction(e->{
			if(board.isP1Turn())
				try {
					board.move(board.getP1(), board.getNextMove());
				} catch (InvalidMoveException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			else  
				try {
					board.move(board.getP2(), board.getNextMove());
				} catch (InvalidMoveException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			board.update();
		});
		s.buildBtn.setOnAction(e->{
			if(board.isP1Turn())
				try {
					board.build(board.getP1(), board.getBuildLocation());
				} catch (InvalidBuildException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			else  
				try {
					board.build(board.getP2(), board.getBuildLocation());
				} catch (InvalidBuildException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			board.update();
			
		});
		board = new Board();
		f.setLeft(s);
		f.setBottom(backBtn);
		f.setMargin(s, new Insets(10, 10, 10, 10));
		f.setCenter(board);
		//f.getChildren().addAll(s,g);
		backBtn.setOnAction(e->{
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Santorini");			
			primaryStage.show();
			
		});
		
		scene2 = new Scene(f,1000,600);
		scene3 = new Scene(des,1000,730);
		
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Santorini");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	/*public void setBackground(GraphicsContext gc) {
		gc.setFill(Color.LIGHTCYAN);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}
	public void setHead(GraphicsContext gc) {
		Font f1 = Font.font("Serif",FontWeight.BLACK,40);
		gc.setFont(f1);
		gc.fillText("Description", 30, 60);	
	}
	public void setDescription(GraphicsContext gc) {
		Font f2 = Font.font("Serif",FontWeight.BLACK,30);
		gc.setFont(f2);
		gc.fillText("Description", 30, 150,800);
	}*/
	

}
