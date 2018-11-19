package application.Process.Cell;

import application.Process.Location;
import application.Process.Player;

public class Cell {
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
	

}
