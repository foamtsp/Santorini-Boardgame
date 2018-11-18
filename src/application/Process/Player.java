package application.Process;


public class Player {
	private String name;
	private Location currentLocation;
	
	public Player(String name) {
		this.name = name;
		int x = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		int y = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		this.currentLocation = new Location(x,y);
	}

	public String getName() {
		return name;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
