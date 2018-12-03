package application;

import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class StatusPage extends VBox{
	Label pt;
	
	
	public StatusPage() {
		// TODO Auto-generated constructor stub
		this.setSpacing(15);
		pt = new Label("Player's Turn:");
		pt.setFont(Font.font("Serif",FontWeight.NORMAL,24));
		this.getChildren().add(pt);
	
	}
	public void setPlayerName(String p1,String p2) {
		VBox P1SP = createPlayerSelectPanel(p1);
		VBox P2SP = createPlayerSelectPanel(p2);
		this.getChildren().clear();
		Text player1Name = new Text(p1);
		Text player2Name = new Text(p2);
		this.getChildren().addAll(player1Name,P1SP,player2Name,P2SP);
		//P2SP.setVisible(false);
		
	}
	
	private VBox createPlayerSelectPanel(String p) {
		VBox pNamePanel = new VBox();
		Button moveBtn = new Button("MOVE");
		Button buildBtn = new Button("Build");
		pNamePanel.getChildren().addAll(moveBtn,buildBtn);
		return pNamePanel;
	}

}
