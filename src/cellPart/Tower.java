package cellPart;

import boardPart.Location;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Tower extends Cell{
	
	protected int level;

	public Tower(Location location) {
		super(location);
		setLevel(1);
		// TODO Auto-generated constructor stub
	}
	
	public void setLevel(int level) {
		if (level > 3) {
			this.destroyed = true;
		}
		this.level = level;
	}
	
	
	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public int getLevel() {
		return level;
	}
	
	@Override
	public int getZ() {
		return 2;	
	}
	
	public void addLevel() {
		if(this.level <=3 )this.level++;
		if (this.level > 3) {
			setDestroyed(true);
		}
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		 image_path = ClassLoader.getSystemResource("GrassTiles"+getLevel()+".png").toString();
		 Image n = new Image(image_path);
		 setFill(new ImagePattern(n));
	}
}
