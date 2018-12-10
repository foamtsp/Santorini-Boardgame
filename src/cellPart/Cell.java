package cellPart;

import boardPart.Board;
import boardPart.Location;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import playersPart.Player;

public class Cell extends Rectangle {
	
	protected Player player;
	protected Location location;
	protected boolean destroyed;
	protected String image_path;
	
	public Cell(Location location) {
		setWidth(Board.TILE_SIZE);
        setHeight(Board.TILE_SIZE);
        relocate(location.getX() * Board.TILE_SIZE, location.getY() * Board.TILE_SIZE);
		this.location = location;
		this.player = null;
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setStroke(Color.YELLOW);
				setStrokeWidth(10);
			}
		});
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setStroke(new Color(0,0,0,0));
			}
		});
		if((location.getX()+location.getY())%2 == 0){
		this.image_path = ClassLoader.getSystemResource("GrassTiles"+getLevel()+"x"+".png").toString();
		}
		else {this.image_path = ClassLoader.getSystemResource("GrassTiles"+getLevel()+"y"+".png").toString();}
		Image n = new Image(image_path);
		setFill(new ImagePattern(n));
		
	}
	

	// Getters

	public Player getPlayer() {
		return player;
	}


	public Location getLocation() {
		return this.location;
	}

	// Setters


	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setLocation(Location loc) {
		this.location = loc;
	}

	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void update() {
		 if(getLevel()>0) {
			image_path = ClassLoader.getSystemResource("GrassTiles"+getLevel()+".png").toString();
		 	Image n = new Image(image_path);
		 	this.setFill(new ImagePattern(n));
		 }
	}

}
