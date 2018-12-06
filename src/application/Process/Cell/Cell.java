package application.Process.Cell;

import application.Process.Board;
import application.Process.Location;
import application.Process.Players.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sharedObject.IRenderable;

public class Cell extends Rectangle implements IRenderable{
	
	protected Player player;
	protected Location location;
	
	public Cell(Location location) {
		setWidth(Board.TILE_SIZE);
        setHeight(Board.TILE_SIZE);
        setFill((location.getX()+location.getY())%2 == 0 ? Color.valueOf("#def") : Color.valueOf("#582"));//setFill(Color.valueOf("#582"));
        relocate(location.getX() * Board.TILE_SIZE, location.getY() * Board.TILE_SIZE);
		this.location = location;
		this.player = null;
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
	

}
