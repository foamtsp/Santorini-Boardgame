package application.Process;

import application.Process.Cell.Cell;
import application.Process.Cell.Tower;
import application.Process.Exception.InvalidBuildException;
import application.Process.Exception.InvalidMoveException;
import application.Process.Players.Player;

public class Board implements BoardInterface{

	private Cell[][] grid = new Cell[SIDE][SIDE];
	private Player p1, p2;
	private boolean moved = false;
	private boolean builded = true;
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
		
		grid[y1][x1].setPlayer(p1);
		grid[y2][x2].setPlayer(p2);
	}

	@Override
	public void move(Player p, Location newLocation) throws InvalidMoveException{
		// TODO Auto-generated method stub
		if (!(p.tryMove(newLocation))|| isGameOver() || (p1Turn && p == p2)
				|| ((!(p1Turn) && p == p1))
				|| !(canMove(newLocation)) || isMoved() || !isBuilded()) {
			throw new InvalidMoveException();
		} else {
			
			int targetX = newLocation.getX();
			int targetY = newLocation.getY();

			grid[targetY][targetX].setPlayer(p);
			grid[p.getCurrentLocation().getY()][p.getCurrentLocation().getX()].setPlayer(null);
			this.moved = true;
			this.builded = false;
			this.p1Turn = !this.p1Turn;
		}
	}
	
	public void jump(Player p,Location newLocation) throws InvalidMoveException {
		int currentX = p.getCurrentLocation().getX();
		int currentY = p.getCurrentLocation().getY();
		
		int targetX = newLocation.getX();
		int targetY = newLocation.getY();
		
		Cell currentCell = grid[currentY][currentX];
		Cell targetCell = grid[targetY][targetX];
		
		int diffLevel = Math.abs(currentCell.getLevel()-targetCell.getLevel());
		
		if(targetCell instanceof Tower && diffLevel <= 1 && diffLevel >=0) {
			move(p,newLocation);
		}
		else return;
	}

	@Override
	public void build(Player p, Location location) throws InvalidBuildException{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return isWinner(p1) || isWinner(p2);
	}

	@Override
	public boolean isWinner(Player player) { 
		// TODO Auto-generated method stub
		int x = player.getCurrentLocation().getX();
		int y = player.getCurrentLocation().getY();


		if (grid[y][x].getLevel() == 3 
				|| ((player == p1) && hasNoMoves(p2) && getTurn() == p2)
				|| ((player == p2) && hasNoMoves(p1) && getTurn() == p1)) {
			return true;
		}

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
		if (isWinner(p1)) {
			return p1;
		} else if (isWinner(p2)) {
			return p2;
		} else {
			return null;
		}
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
		if (p1Turn) {
			return p1;
		} else {
			return p2;
		}
	}
	
	
	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	public boolean isMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}

	public boolean isBuilded() {
		return builded;
	}

	public void setBuilded(boolean builded) {
		this.builded = builded;
	}

	public boolean isP1Turn() {
		return p1Turn;
	}

	public void setP1Turn(boolean p1Turn) {
		this.p1Turn = p1Turn;
	}

	

	
}