package boardPart;

import java.util.ArrayList;

import cellPart.Cell;
import cellPart.Tower;
import exceptionPart.InvalidBuildException;
import exceptionPart.InvalidMoveException;
import exceptionPart.NullBuildException;
import exceptionPart.NullMoveException;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import playersPart.Player;

public class Board extends Pane implements BoardInterface {

	private Group tileGroup = new Group();
	private Group pieceGroup = new Group();

	private Cell[][] grid = new Cell[Board.WIDTH][Board.HEIGHT];
	// private Cell[][] grid = new Cell[SIDE][SIDE];
	private Player p1, p2;
	private boolean moved = false;
	private boolean builded = true;
	private boolean p1Turn = true;
	private Location nextMove;
	private Location buildLocation;

	public Location getNextMove() {
		return nextMove;
	}

	public Board() {
		// TODO Auto-generated constructor stub
		super();
		nextMove = null;
		buildLocation = null;
		this.setPrefSize(Board.WIDTH * Board.TILE_SIZE, Board.HEIGHT * Board.TILE_SIZE);
		this.getChildren().addAll(tileGroup, pieceGroup);

		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				Cell c = new Cell(new Location(y, x));
				c.setOnMouseClicked(e -> {
					if (moved == false) {
						nextMove = c.getLocation();
						System.out.println("move to " + nextMove.getX() + " " + nextMove.getY());
					} else {
						buildLocation = c.getLocation();
						System.out.println("build at " + buildLocation.getX() + " " + buildLocation.getY());
					}
				});

				grid[y][x] = c;
				tileGroup.getChildren().add(c);
			}
		}

		this.p1 = new Player("p1", "1");
		this.p2 = new Player("p2", "2");
		while ((this.p2.getCurrentLocation().getX() == this.p1.getCurrentLocation().getX())
				&& (this.p2.getCurrentLocation().getY() == this.p1.getCurrentLocation().getY())) {
			int nx = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
			int ny = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
			this.p2.setCurrentLocation(new Location(ny, nx));
		}
		this.p2.move(this.p2.getCurrentLocation().getX(), this.p2.getCurrentLocation().getY());

		grid[this.p1.getCurrentLocation().getY()][this.p1.getCurrentLocation().getX()].setPlayer(this.p1);
		grid[this.p2.getCurrentLocation().getY()][this.p2.getCurrentLocation().getX()].setPlayer(this.p2);

		pieceGroup.getChildren().addAll(this.p1, this.p2);
		System.out.println("p1: " + p1.getCurrentLocation().getX() + "," + p1.getCurrentLocation().getY());
		System.out.println("p2: " + p2.getCurrentLocation().getX() + "," + p2.getCurrentLocation().getY());

	}

	@Override
	public void move(Player p, Location newLocation) throws InvalidMoveException, NullMoveException {
		// TODO Auto-generated method stub
		if (newLocation == null) {
			throw new NullMoveException();
		} else if (!(p.tryMove(newLocation)) || isGameOver() || (p1Turn && p == p2) || ((!(p1Turn) && p == p1))
				|| !(canMove(p, newLocation)) || isMoved() || !isBuilded()) {
			throw new InvalidMoveException();
		} else {
			int targetX = newLocation.getX();
			int targetY = newLocation.getY();
			grid[targetY][targetX].setPlayer(p);
			grid[p.getCurrentLocation().getY()][p.getCurrentLocation().getX()].setPlayer(null);
			p.setCurrentLocation(new Location(targetY, targetX));
			// p.move(targetX, targetY);
			System.out.println(
					p.getName() + " is at " + p.getCurrentLocation().getX() + "," + p.getCurrentLocation().getY());
			this.moved = true;
			this.builded = false;
			// this.p1Turn = !this.p1Turn;
		}
	}

	public Location getBuildLocation() {
		return buildLocation;
	}

	public void setNextMove(Location nextMove) {
		this.nextMove = nextMove;
	}

	public void setBuildLocation(Location buildLocation) {
		this.buildLocation = buildLocation;
	}

	@Override
	public void build(Player p, Location location) throws InvalidBuildException, NullBuildException {
		// TODO Auto-generated method stub
		if (location == null) {
			throw new NullBuildException();
		} else if (!(p.tryBuild(location)) || isGameOver() || (p1Turn && p == p2) || ((!(p1Turn) && p == p1))
				|| !(canBuild(p, location)) || isBuilded()) {
			throw new InvalidBuildException();
		} else {

			int targetX = location.getX();
			int targetY = location.getY();

			Cell current = grid[targetY][targetX];
			if (!(current instanceof Tower) /* && current.getLevel() == 0 */) {
				Tower currentT = new Tower(location);
				grid[targetY][targetX] = currentT;
				grid[targetY][targetX].setOnMouseClicked(e -> {
					if (moved == false) {
						nextMove = grid[targetY][targetX].getLocation();
						System.out.println("move to " + nextMove.getX() + " " + nextMove.getY());
					} else {
						buildLocation = grid[targetY][targetX].getLocation();
						System.out.println("build at " + buildLocation.getX() + " " + buildLocation.getY());
					}
				});

				tileGroup.getChildren().set(targetY * 5 + targetX, grid[targetY][targetX]);

			} else {
				// Tower currentT = ((Tower) current);
				((Tower) grid[targetY][targetX]).addLevel();
			}
			System.out.println(getBuildLocation().getX() + "," + getBuildLocation().getY() + " has tower level"
					+ ((Tower) grid[targetY][targetX]).getLevel());
			this.moved = false;
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

		if (grid[y][x].getLevel() == 3 || ((player == p1) && hasNoMoves(p2) && getTurn() == p2)
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
			hasMoves = hasMoves | canMove(p, pMoves.remove(0));
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

		if (!(p.tryMove(location)) || (targetCell.isDestroyed())
				|| ((targetLevel > currentLevel) && (targetLevel - currentLevel > 1))
				|| targetCell.getPlayer() != null) {
			return false;
		}
		return true;

	}

	@Override
	public boolean canBuild(Player p, Location location) {
		// TODO Auto-generated method stub
		if (location == null) {
			return false;
		}

		Cell targetCell = grid[location.getY()][location.getX()];

		if (!(p.tryBuild(location)) || targetCell.isDestroyed() || targetCell.getPlayer() != null) {
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

	public void update() {
		getP1().update();
		getP2().update();
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				if (grid[y][x] instanceof Tower)
					((Tower) grid[y][x]).update();
			}
		}

	}

}