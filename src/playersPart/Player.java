package playersPart;


import java.util.ArrayList;

import boardPart.Board;
import boardPart.Location;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import sharedObject.IRenderable;

public class Player extends StackPane implements Movable,Bulidable,IRenderable {
	private double mouseX, mouseY;
    private double oldX, oldY;
	private String name;
	private Location currentLocation;
	private String image_path;
	private String type;
	
	public boolean isDestroyed() {
		return false;
	}

	public Player(String name,String type) {
		this.name = name;
		int x = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		int y = (int) ((Math.random() * ((4 - 0) + 1)) + 0);
		this.currentLocation = new Location(y,x);
		this.type = type;
		
		move(getCurrentLocation().getX(), getCurrentLocation().getY());
		
		/*
		Ellipse bg = new Ellipse(Board.TILE_SIZE * 0.3125, Board.TILE_SIZE * 0.26);
        bg.setFill(Color.BLACK);

        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(Board.TILE_SIZE * 0.03);

        bg.setTranslateX((Board.TILE_SIZE - Board.TILE_SIZE * 0.3125 * 2) / 2);
        bg.setTranslateY((Board.TILE_SIZE - Board.TILE_SIZE * 0.26 * 2) / 2 + Board.TILE_SIZE * 0.07);
		*/
        Ellipse ellipse = new Ellipse(Board.TILE_SIZE * 0.3125, Board.TILE_SIZE * 0.26);
        
        image_path = ClassLoader.getSystemResource("Player"+type+"_"+"i"+".png").toString();
		Image n = new Image(image_path);
		ellipse.setFill(new ImagePattern(n));
  
        ellipse.setStroke(new Color(0,0,0,0));

        ellipse.setTranslateX((Board.TILE_SIZE - Board.TILE_SIZE * 0.3125 * 2) / 2);
        ellipse.setTranslateY((Board.TILE_SIZE - Board.TILE_SIZE * 0.26 * 2) / 2);

        getChildren().addAll(ellipse);
        
        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
            System.out.println(getCurrentLocation().getX()+" "+getCurrentLocation().getY());
        });
        
        setOnMouseClicked(e -> {
            System.out.println(getName()); 
        });
	}
	
	public void move(int x, int y) {
        oldX = x * Board.TILE_SIZE;
        oldY = y * Board.TILE_SIZE;
        relocate(oldX, oldY);
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

	public void update() {
		// TODO Auto-generated method stub
		move(getCurrentLocation().getX(),getCurrentLocation().getY());
		
	}
	
}
