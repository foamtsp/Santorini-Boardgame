package application.Process;

import application.Process.Exception.InvalidBuildException;
import application.Process.Exception.InvalidMoveException;
import application.Process.Players.Player;

public interface BoardInterface {
	int SIDE = 5;

	void move(Player p,Location newLocation) throws InvalidMoveException;
	
	void build(Player p,Location location) throws InvalidBuildException;
	
	boolean isGameOver();

	boolean isWinner(Player player);

	boolean hasNoMoves(Player player);

	Player getWinner();

	boolean canMove(Location location);

	boolean canBuild(Location location);

	Player getTurn();


}
