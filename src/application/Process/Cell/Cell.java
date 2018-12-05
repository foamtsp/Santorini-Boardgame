package application.Process.Cell;

import application.Process.Location;
import application.Process.Players.Player;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;

public class Cell implements IRenderable{
	protected Player player;
	protected Location location;
	
	public Cell(Location location) {
		this.location = location;
	}
	
	public Cell(Location location,Player player) {
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
