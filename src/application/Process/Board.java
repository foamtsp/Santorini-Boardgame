package application.Process;

import application.Process.Cell.Cell;

public class Board implements BoardInterface{

	private Cell[][] grid = new Cell[SIDE][SIDE];
	private Player p1, p2;
	private boolean moved = false;
	private boolean placed = true;
	private boolean p1Turn = true;
	
	public Board(Player p1, Player p2) {
		// TODO Auto-generated constructor stub
		this.p1 = p1;
		this.p2 = p2;
		
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				grid[y][x] = new Cell(new Location(y, x));
			}
		}
		
		int x1 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		int y1 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		int x2 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		int y2 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		
		grid[x1][y1].setPlayer(p1);
		grid[x2][y2].setPlayer(p2);
	}
	
	@Override
	public void move(Location newLocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void build(Location newLocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWinner(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasNoMoves(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canMove(Location location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canBuild(Location location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player getTurn() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
