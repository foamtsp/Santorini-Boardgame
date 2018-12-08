package application.Process.Cell;

import application.Process.Board;
import application.Process.Location;
import application.Process.Players.Player;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sharedObject.IRenderable;

public class Cell extends Rectangle implements IRenderable{
	
	protected Player player;
	protected Location location;
	protected boolean destroyed;
	
	public Cell(Location location) {
		setWidth(Board.TILE_SIZE);
        setHeight(Board.TILE_SIZE);
        setFill((location.getX()+location.getY())%2 == 0 ? Color.valueOf("#def") : Color.valueOf("#582"));//setFill(Color.valueOf("#582"));
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
		
		/*
		String image_path = ClassLoader.getSystemResource("GrassTiles.png").toString();
		Image n = new Image(image_path);
		setFill(new ImagePattern(n));
		*/
		
	}
	
	public Cell(Location location,Player player) {
		setWidth(Board.TILE_SIZE);
        setHeight(Board.TILE_SIZE);
        setFill(Color.valueOf("#582"));
		this.location = location;
		this.player = player;
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

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
