package application;
	
import application.Process.Board;
import application.Process.Location;
import application.Process.Cell.Cell;
import application.Process.Players.Player;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Main extends Application {
	Scene scene1,scene2,scene3;
	Player player1 = new Player("") , player2 = new Player("");
	StatusPage s;
	Board board;
	private Pane g;
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
		BorderPane f = new BorderPane();
		Button backBtn = new Button("Back");
		f.setPrefHeight(300);
		f.setPrefWidth(150);
		s = new StatusPage();
		g = (Pane) createContent();
		f.setLeft(s);
		f.setMargin(s, new Insets(10, 10, 10, 10));
		f.setCenter(g);
		//f.getChildren().addAll(s,g);
		backBtn.setOnAction(e->{
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Santorini");			
			primaryStage.show();
			
		});
		
		scene2 = new Scene(f,1000,600);
		scene3 = new Scene(des,1000,600);
		//Scene scene4 = new Scene(g,1000,600);
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
	

	    private Group tileGroup = new Group();
	    private Group pieceGroup = new Group();
	    
	    private Cell[][] nboard = new Cell[Board.WIDTH][Board.HEIGHT];
	    private Pane createContent() {
	        Pane root = new Pane();
	        root.setPrefSize(Board.WIDTH * Board.TILE_SIZE, Board.HEIGHT * Board.TILE_SIZE);
	        root.getChildren().addAll(tileGroup, pieceGroup);

	        for (int y = 0; y < 5; y++) {
	            for (int x = 0; x < 5; x++) {
	            	Cell c = new Cell(new Location(y, x));
	                nboard[y][x] =  c;

	                tileGroup.getChildren().add(c);
	            }
	        }
	        /*
	        int x1 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
			int y1 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
			int x2 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
			int y2 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
			
			nboard[y1][x1].setPlayer(player1);
			player1.setCurrentLocation(new Location(y1,x1));
			nboard[y2][x2].setPlayer(player2);
			player2.setCurrentLocation(new Location(y2,x2));
			*/
	        pieceGroup.getChildren().addAll(player1,player2);
	        return root;
	    }
	
}
