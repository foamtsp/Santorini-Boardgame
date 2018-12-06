package application.Process.Players;


import java.util.ArrayList;

import application.Process.Board;
import application.Process.Location;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import sharedObject.IRenderable;

public class Player extends StackPane implements Movable,Bulidable,IRenderable {
	//private double mouseX, mouseY;
    //private double oldX, oldY;
	private String name;
	private Location currentLocation;
	
	public Player(String name) {
		this.name = name;
		int x = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		int y = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		this.currentLocation = new Location(y,x);
		
		relocate(currentLocation.getX() * Board.TILE_SIZE, currentLocation.getY() * Board.TILE_SIZE);
		
		Ellipse bg = new Ellipse(Board.TILE_SIZE * 0.3125, Board.TILE_SIZE * 0.26);
        bg.setFill(Color.BLACK);

        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(Board.TILE_SIZE * 0.03);

        bg.setTranslateX((Board.TILE_SIZE - Board.TILE_SIZE * 0.3125 * 2) / 2);
        bg.setTranslateY((Board.TILE_SIZE - Board.TILE_SIZE * 0.26 * 2) / 2 + Board.TILE_SIZE * 0.07);

        Ellipse ellipse = new Ellipse(Board.TILE_SIZE * 0.3125, Board.TILE_SIZE * 0.26);
        ellipse.setFill(Color.valueOf("#c40003"));

        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(Board.TILE_SIZE * 0.03);

        ellipse.setTranslateX((Board.TILE_SIZE - Board.TILE_SIZE * 0.3125 * 2) / 2);
        ellipse.setTranslateY((Board.TILE_SIZE - Board.TILE_SIZE * 0.26 * 2) / 2);

        getChildren().addAll(bg, ellipse);
        /*
        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
        */
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

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	
}
