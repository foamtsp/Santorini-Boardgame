package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StatusPage extends VBox {
	private PlayerTurn p1, p2;
	private Button moveBtn;
	private Button buildBtn;
	private Button backBtn;
	private Action[] actions = new Action[2];

	public StatusPage() {
		// TODO Auto-generated constructor stub
		this.setSpacing(20);
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setPrefWidth(250);
		this.setPrefHeight(580);
		String image_path = ClassLoader.getSystemResource("Statusbg" + ".jpg").toString();
		Image n = new Image(image_path);
		this.setBackground(new Background(new BackgroundImage(n, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
		moveBtn = new Button("MOVE");
		moveBtn.setFont(Font.font("LillyBelle", FontWeight.NORMAL, 16));
		buildBtn = new Button("BUILD");
		buildBtn.setFont(Font.font("LillyBelle", FontWeight.NORMAL, 16));
		backBtn = new Button("BACK");
		backBtn.setFont(Font.font("LillyBelle", FontWeight.NORMAL, 16));
		actions[0] = new Action("MOVE STAGE");
		actions[0].setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, null, null)));
		actions[1] = new Action("BUILD STAGE");

	}

	public void setPlayerName(String n1, String n2) {
		this.getChildren().clear();
		Label pt = new Label(" Player's turn:");
		// setAlignment(Pos.CENTER);
		pt.setFont(Font.font("LillyBelle", FontWeight.NORMAL, 30));
		p1 = new PlayerTurn("player1 : " + n1);
		p2 = new PlayerTurn("player2 : " + n2);
		p2.getCanvas().setVisible(false);
		HBox btns = new HBox();
		btns.setSpacing(20);
		btns.getChildren().addAll(moveBtn, buildBtn);
		this.getChildren().addAll(pt, p1, p2, btns, actions[0], actions[1], backBtn);
		// P2SP.setVisible(false);

	}

	public PlayerTurn getP1() {
		return p1;
	}

	public PlayerTurn getP2() {
		return p2;
	}

	public Button getMoveBtn() {
		return moveBtn;
	}

	public Button getBuildBtn() {
		return buildBtn;
	}

	public Button getBackBtn() {
		return backBtn;
	}

	public Action[] getActions() {
		return actions;
	}

	public void changeTurn(boolean b) {
		p1.getCanvas().setVisible(b);
		p2.getCanvas().setVisible(!b);
	}

	public void nextAction(int n) {
		actions[n % 2].setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		actions[(n + 1) % 2].setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, null, null)));
	}
}
