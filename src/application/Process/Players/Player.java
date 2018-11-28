package application.Process.Players;


import java.util.ArrayList;

import application.Process.Location;

public class Player implements Movable,Bulidable {
	private String name;
	private Location currentLocation;
	
	public Player(String name) {
		this.name = name;
		this.currentLocation = new Location(0,0);
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
	public ArrayList<Location> tryAllMove() {
		// TODO Auto-generated method stub
		ArrayList<Location> allMovesPossible =  new ArrayList<Location>();
		int x = getCurrentLocation().getX();
		int y  = getCurrentLocation().getY();
		
		Location Up = new Location(y+1,x); if(Up.onGrid()) allMovesPossible.add(Up);
		Location Down = new Location(y-1,x); if(Down.onGrid()) allMovesPossible.add(Down);
		Location Right = new Location(y,x+1); if(Right.onGrid()) allMovesPossible.add(Right);
		Location Left = new Location(y,x-1); if(Left.onGrid()) allMovesPossible.add(Left);
		Location UpRight = new Location(y+1,x+1); if(UpRight.onGrid()) allMovesPossible.add(UpRight);
		Location UpLeft = new Location(y+1,x-1); if(UpLeft.onGrid()) allMovesPossible.add(UpLeft);
		Location DownRight = new Location(y-1,x+1); if(DownRight.onGrid()) allMovesPossible.add(DownRight);
		Location DownLeft = new Location(y-1,x-1); if(DownLeft.onGrid()) allMovesPossible.add(DownLeft);
		
		return allMovesPossible;
		
		
	}
	
	@Override
	public boolean tryBuild(Location location) {
		// TODO Auto-generated method stub
		int x = getCurrentLocation().getX();
		int y  = getCurrentLocation().getY();
		int newX = location.getX();
		int newY = location.getY();
		
		int up = y+1;
		int down = y-1;
		int right = x+1;
		int left = x-1;
		
		if((newX>=left && newX<=right) && (newY>=down && newY<=up)) return true;
		else return false;
		
		
	}
	
}
