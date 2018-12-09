package playersPart;

import java.util.ArrayList;

import boardPart.Location;

public interface Movable {
	

	boolean tryMove(Location newLocation);

	ArrayList<Location> tryAllMove();
	 
}
