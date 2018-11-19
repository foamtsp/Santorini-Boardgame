package application.Process;

public interface BoardInterface {
	int SIDE = 5;

	void move(Location newLocation);

	void build(Location newLocation);

	boolean isGameOver();

	boolean isWinner(Player player);

	boolean hasNoMoves(Player player);

	Player getWinner();

	boolean canMove(Location location);

	boolean canBuild(Location location);

	Player getTurn();

}
