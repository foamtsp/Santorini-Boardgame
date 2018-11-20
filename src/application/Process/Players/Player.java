package application.Process.Players;


import application.Process.Location;

public class Player implements Movable,Bulidable {
	private String name;
	private Location currentLocation;
	private int onLevel = 0;
	
	public Player(String name) {
		this.name = name;
		this.currentLocation = new Location(0,0);
		this.onLevel = 0;
	}

	public int getOnLevel() {
		return onLevel;
	}

	public void setOnLevel(int onLevel) {
		this.onLevel = onLevel;
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

	@Override
	public boolean tryMove(Location newLocation) {
		// TODO Auto-generated method stub
		int x = getCurrentLocation().getX();
		int y  = getCurrentLocation().getY();
		int newX = newLocation.getX();
		int newY = newLocation.getY();
		
		int up = y+1;
		int down = y-1;
		int right = x+1;
		int left = x-1;
		
		if((newX>=left && newX<=right) && (newY>=down && newY<=up)) return true;
		else return false;
			
	}

	@Override
	public void tryBuild(Location location) {
		// TODO Auto-generated method stub
		
	}
	
}
