package application.Process.Cell;

import application.Process.Location;

public class Tower extends Cell{
	
	protected int level;
	protected boolean destroyed;

	public Tower(Location location) {
		super(location);
		setLevel(1);
		// TODO Auto-generated constructor stub
	}
	
	public void setLevel(int level) {
		if (level > 3) {
			this.destroyed = true;
		}
		this.level = level;
	}
	
	
	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public int getLevel() {
		return level;
	}

	public void addLevel() {
		this.level++;
		if (this.level > 3) {
			setDestroyed(true);
		}
	}

}
