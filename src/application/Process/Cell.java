package application.Process;

public class Cell {
	private int level;
	private boolean destroyed;
	private Player player;
	private Location location;
	
	public Cell(int level) {
		this.level = level;
	}

	// Getters

	public int getLevel() {
		return level;
	}

	public Player getPlayer() {
		return player;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public Location getLocation() {
		return this.location;
	}

	// Setters

	public void setLevel(int level) {
		if (level > 3) {
			this.destroyed = true;
		}
		this.level = level;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setLocation(Location loc) {
		this.location = loc;
	}

	public void addLevel() {
		this.level++;
		if (this.level > 3) {
			setDestroyed(true);
		}
	}
}
