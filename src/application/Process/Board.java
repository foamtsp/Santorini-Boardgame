package application.Process;

import java.util.ArrayList;

import application.Process.Cell.Cell;
import application.Process.Cell.Tower;
import application.Process.Exception.InvalidBuildException;
import application.Process.Exception.InvalidMoveException;
import application.Process.Players.Player;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Board implements BoardInterface{

	
	private Cell[][] grid = new Cell[SIDE][SIDE];
	private Player p1, p2;
	private boolean moved = false;
	private boolean builded = true;
	private boolean p1Turn = true;
	
	private GridPane cellGroup = new GridPane();
    //private Group playerGroup = new Group();
    
	public Board(Player p1, Player p2) {
		// TODO Auto-generated constructor stub
		this.p1 = p1;
		this.p2 = p2;
		
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				Cell c = new Cell(new Location(y, x));
				grid[y][x] = c;
				cellGroup.add(c,x,y,1,1);
			}
		}
		
		int x1 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		int y1 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		int x2 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		int y2 = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		
		grid[y1][x1].setPlayer(p1);
		grid[y2][x2].setPlayer(p2);
		
		//playerGroup.getChildren().addAll(p1,p2);
		
	}

	public GridPane getCellGroup() {
		return cellGroup;
	}

	public void setCellGroup(GridPane cellGroup) {
		this.cellGroup = cellGroup;
	}
/*

	public Group getPlayerGroup() {
		return playerGroup;
	}

	public void setPlayerGroup(Group playerGroup) {
		this.playerGroup = playerGroup;
	}
*/
	@Override
	public void move(Player p, Location newLocation) throws InvalidMoveException{
		// TODO Auto-generated method stub
		if (!(p.tryMove(newLocation))|| isGameOver() || (p1Turn && p == p2)
				|| ((!(p1Turn) && p == p1))
				|| !(canMove(p,newLocation)) || isMoved() || !isBuilded()) {
			throw new InvalidMoveException();
		} else {
			
			int targetX = newLocation.getX();
			int targetY = newLocation.getY();

			grid[targetY][targetX].setPlayer(p);
			grid[p.getCurrentLocation().getY()][p.getCurrentLocation().getX()].setPlayer(null);
			this.moved = true;
			this.builded = false;
		}
	}
	
	public void jump(Player p,Location newLocation) throws InvalidMoveException {
		int currentX = p.getCurrentLocation().getX();
		int currentY = p.getCurrentLocation().getY();
		
		int targetX = newLocation.getX();
		int targetY = newLocation.getY();
		
		Cell currentCell = grid[currentY][currentX];
		Tower targetCell = (Tower) grid[targetY][targetX];
		
		if(targetCell.getLevel() == 4) {
			throw new InvalidMoveException();
		}
		
		int diffLevel = targetCell.getLevel()-currentCell.getLevel();
		
		if(targetCell instanceof Tower && diffLevel <= 1) {
			move(p,newLocation);
		}
		else throw new InvalidMoveException();
	}

	@Override
	public void build(Player p, Location location) throws InvalidBuildException{
		// TODO Auto-generated method stub
		if (!(p.tryBuild(location))|| isGameOver() || (p1Turn && p == p2)
				|| ((!(p1Turn) && p == p1))
				|| !(canBuild(p,location)) || !isBuilded()) {
			throw new InvalidBuildException();
		} else {
			
			int targetX = location.getX();
			int targetY = location.getY();

			Cell current = grid[targetY][targetX];
			if ( !(current instanceof Tower) && current.getLevel() == 0) {
				Tower currentT = new Tower(location);
				current = currentT;
			}
			else {
				Tower currentT = (Tower) current;
				currentT.addLevel();
			}
			this.moved = true;
			this.builded = true;
			this.p1Turn = !this.p1Turn;
		}
		
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
	public boolean hasNoMoves(Player p) {
		ArrayList<Location> pMoves = new ArrayList<Location>();
		
		pMoves.addAll(p.tryAllMove());
		boolean hasMoves = false;

		if (pMoves.isEmpty()) {
			return true;
		}

		while (!pMoves.isEmpty()) {
			hasMoves = hasMoves
					| canMove(p, pMoves.remove(0));
		}

		return !hasMoves;
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
	public boolean canMove(Player p, Location location) {
		// TODO Auto-generated method stub
		if (location == null) {
			return false;
		}

		Cell currentCell = grid[p.getCurrentLocation().getY()][p.getCurrentLocation().getX()];
		int currentLevel = currentCell.getLevel();

		Cell targetCell = grid[location.getY()][location.getX()];
		int targetLevel = targetCell.getLevel();

		if (!(p.tryMove(location))
				|| ((Tower) targetCell).isDestroyed()
				|| ((targetLevel > currentLevel) && (targetLevel - currentLevel > 1))
				|| targetCell.getPlayer() != null) {
			return false;
		}
		return true;

	}

	@Override
	public boolean canBuild(Player p,Location location) {
		// TODO Auto-generated method stub
		if (location == null) {
			return false;
		}

		Cell targetCell = grid[location.getY()][location.getX()];

		if (!(p.tryBuild(location))
				|| ((Tower) targetCell).isDestroyed()
				|| targetCell.getPlayer() != null) {
			return false;
		}
		return true;
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