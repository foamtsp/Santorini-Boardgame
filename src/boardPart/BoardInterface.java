package boardPart;

import exceptionPart.InvalidBuildException;
import exceptionPart.InvalidMoveException;
import exceptionPart.NullBuildException;
import exceptionPart.NullMoveException;
import playersPart.Player;

public interface BoardInterface {
	int SIDE = 5;
	
	public static final int TILE_SIZE = 100;
    public static final int WIDTH = 5;
    public static final int HEIGHT = 5;

	void move(Player p,Location newLocation) throws InvalidMoveException, NullMoveException;
	
	void build(Player p,Location location) throws InvalidBuildException, NullBuildException;
	
	boolean isGameOver();

	boolean isWinner(Player player);

	boolean hasNoMoves(Player player);

	Player getWinner();

	boolean canMove(Player p, Location location);
	
	boolean canBuild(Player p, Location location);

	Player getTurn();



}
