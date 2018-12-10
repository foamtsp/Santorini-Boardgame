package application;
	
import boardPart.Board;
import exceptionPart.InvalidBuildException;
import exceptionPart.InvalidMoveException;
import exceptionPart.NullBuildException;
import exceptionPart.NullMoveException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Duration;
import playersPart.Player;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
	Scene scene1,scene2,scene3;
	Player player1;
	Player player2;
	StatusPage s;
	Board board;
	public static MediaPlayer bgmSound;
	@Override
	public void start(Stage primaryStage) {
		
		bgmSound = new MediaPlayer(new Media(ClassLoader.getSystemResource("bgm2.mp3").toString()));
		bgmSound.setVolume(1.0);	
		bgmSound.setOnEndOfMedia(new Runnable() {
		       public void run() {
		    	   bgmSound.seek(Duration.ZERO);
		       }
		   });
		bgmSound.play();
		MainPage mp = new MainPage();
		primaryStage.setResizable(false);

		mp.getPlayBtn().setOnAction(e->{
			String p1 = mp.getT1().getText().trim();
			if(p1.length()==0) p1 = "P1";
			String p2 = mp.getT2().getText().trim();
			if(p2.length()==0) p2 = "P2";
			board.getP1().setName(p1);
			board.getP2().setName(p2);
			s.setPlayerName(p1, p2);
	
			primaryStage.setScene(scene2);
			primaryStage.setTitle("Santorini");
			primaryStage.show();
			
		});
		HelpPage des = new HelpPage();
		des.backBtn.setOnAction(e->{
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Santorini");			
			primaryStage.show();
			
		});
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
		f.setPrefHeight(300);
		f.setPrefWidth(150);
		s = new StatusPage();
		s.getMoveBtn().setOnAction(e->{
			Player p;
			if(board.isP1Turn()) p = board.getP1();
			else p = board.getP2();
				try {
					board.move(p, board.getNextMove());
				} catch (InvalidMoveException e1) {
					// TODO Auto-generated catch block
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Can't move to this cell! Please select new cell");
					alert.setHeaderText("Error!");
					alert.setTitle("Error");
					alert.show();

				}
				catch (NullMoveException e1) {
					// TODO Auto-generated catch block
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Please choose your location to move first.");
					alert.setHeaderText("Error!");
					alert.setTitle("Error");
					alert.show();

				}
			s.changeTurn(board.isP1Turn());
			if(board.isMoved()) s.nextAction(0);
			board.update();
			board.setNextMove(null);
			if(board.isGameOver()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Congratulation!!!, "+board.getWinner().getName()+" wins the game.");
				alert.setTitle("Congratulation!!!");
				alert.show();
				s.nextAction(1);
				}
		});
		s.getBuildBtn().setOnAction(e->{
			Player p;
			if(board.isP1Turn()) p = board.getP1();
			else p = board.getP2();
				try {
					board.build(p, board.getBuildLocation());
				} catch (InvalidBuildException e1) {
					// TODO Auto-generated catch block
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Can't build on this cell! Please select new cell");
					alert.setHeaderText("Error!");
					alert.setTitle("Error");
					alert.show();
				}
				catch (NullBuildException e1) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Please choose your location to build first.");
					alert.setHeaderText("Error!");
					alert.setTitle("Error");
					alert.show();
				}
			s.changeTurn(board.isP1Turn());
			if(board.isBuilded()) s.nextAction(1);
			board.update();
			board.setBuildLocation(null);
			
		});
		board = new Board();
		VBox gameScreen = new VBox();
		String image_path = ClassLoader.getSystemResource("Character"+".jpg").toString();
		Image n = new Image(image_path);
		ImageView img = new ImageView(n); 
		gameScreen.setPrefHeight(600);
		gameScreen.getChildren().addAll(board,img);
		SymbolPage sym = new SymbolPage();
		f.setLeft(s);
		f.setRight(sym);
		BorderPane.setMargin(gameScreen, new Insets(10, 5, 5, 10));
		BorderPane.setMargin(s, new Insets(10, 5, 5, 10));
		BorderPane.setMargin(sym, new Insets(10, 10, 10, 10));
		f.setCenter(gameScreen);
		//f.getChildren().addAll(s,g);
		s.getBackBtn().setOnAction(e->{
			board = new Board();
			f.setCenter(board);
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Santorini");			
			primaryStage.show();
			
		});
		
		scene2 = new Scene(f,1050,620);
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
	void endGameAlert(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(board.getWinner().getName()+" wins the game.");
		alert.setTitle("Congratulation!!!");
		alert.show();
		board = new Board();
		s.nextAction(1);
	}

}
