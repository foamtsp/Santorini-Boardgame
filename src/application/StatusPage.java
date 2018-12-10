package application;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StatusPage extends VBox{
	PlayerTurn p1,p2;
	Button moveBtn;
	Button buildBtn;
	Action[] actions = new Action[2];
	public StatusPage() {
		// TODO Auto-generated constructor stub
		this.setSpacing(20);
		this.setPadding(new Insets(5,5,5,5));
		this.setPrefWidth(250);
		this.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE,null, null)));
		moveBtn = new Button("MOVE");
		buildBtn = new Button("BUILD");
		actions[0] = new Action("MOVE stage");
		actions[0].setBackground(new Background(new BackgroundFill(Color.LAWNGREEN,null, null)));
		actions[1] = new Action("BUILD stage");

	}
	public void setPlayerName(String n1,String n2) {
		this.getChildren().clear();
		Label pt = new Label("Player's turn:");
		pt.setFont(Font.font("Serif",FontWeight.NORMAL,32));
		p1 = new PlayerTurn("player1:"+n1);
		p2 = new PlayerTurn("player2:"+n2);
		p2.canvas.setVisible(false);
		HBox btns = new HBox();
		btns.setSpacing(20);
		btns.getChildren().addAll(moveBtn,buildBtn);
		this.getChildren().addAll(pt,p1,p2,btns,actions[0],actions[1]);
		//P2SP.setVisible(false);
		
	}
	public void changeTurn(boolean b) {
		p1.canvas.setVisible(b);
		p2.canvas.setVisible(!b);
	}
	public void nextAction(int n) {
		actions[n%2].setBackground(new Background(new BackgroundFill(Color.WHITE,null, null)));
		actions[(n+1)%2].setBackground(new Background(new BackgroundFill(Color.LAWNGREEN,null, null)));
	}
}
