package application;
	
import application.Process.Board;
import application.Process.Players.Player;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	Scene scene1,scene2,scene3;
	Player player1, player2;
	StatusPage s;
	Board board;
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
			String p1 = mp.t1.getText().trim();
			String p2 = mp.t2.getText().trim();
			player1 = new Player(p1);
			player2 = new Player(p2);
			board = new Board(player1,player2);
			s.setPlayerName(mp.t1.getText().trim(), mp.t2.getText().trim());
			primaryStage.setScene(scene2);
			primaryStage.setTitle("Santorini");
			primaryStage.show();
			
		});
		VBox des = new VBox();
		hbtn.setOnAction(e->{
			/*Canvas canvas = new Canvas(1000,600);
			GraphicsContext gc = canvas.getGraphicsContext2D(); 	
			des.getChildren().add(canvas);*/
			primaryStage.setScene(scene3);
			primaryStage.setTitle("Santorini");
			primaryStage.show();
			
		});
		scene1 = new Scene(mp,1000,600);
		VBox f = new VBox();
		Button backBtn = new Button("Back");
		f.setPrefHeight(300);
		f.setPrefWidth(150);
		s = new StatusPage();
		/*s.moveBtn.setOnAction(e->{
			if(board.isP1Turn()) board.move(player1, null);//mouse click event
			else board.move(player2, null);
		});
		s.buildBtn.setOnAction(e->{
			if(board.isP1Turn()) board.build(player1, null);//mouse click event
			else board.build(player2, null);
			s.changeTurn(board.isP1Turn());
		});*/
		f.getChildren().addAll(s,backBtn);
		backBtn.setOnAction(e->{
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Santorini");			
			primaryStage.show();
			
		});
		
		scene2 = new Scene(f,1000,600);
		scene3 = new Scene(des,1000,600);
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
