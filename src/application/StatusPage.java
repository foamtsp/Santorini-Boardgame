package application;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class StatusPage extends VBox{
	PlayerTurn p1,p2;
	Button moveBtn;
	Button buildBtn;
	public StatusPage() {
		// TODO Auto-generated constructor stub
		this.setSpacing(5);
		this.setPadding(new Insets(5,5,5,5));;
		this.setMaxWidth(200);
		this.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE,null, null)));
		moveBtn = new Button("MOVE");
		buildBtn = new Button("Build");
		//this.getChildren().addAll(p1,p2,moveBtn,buildBtn);

	}
	public void setPlayerName(String n1,String n2) {
		p1 = new PlayerTurn(n1);
		p2 = new PlayerTurn(n2);
		p2.canvas.setVisible(false);
		this.getChildren().addAll(p1,p2,moveBtn,buildBtn);
		//P2SP.setVisible(false);
		
	}
	public void changeTurn(boolean b) {
		p1.canvas.setVisible(b);
		p2.canvas.setVisible(!b);
	}



}
