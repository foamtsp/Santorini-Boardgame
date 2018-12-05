package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import application.Process.Cell.Cell;
import application.Process.Cell.Tower;
import application.Process.Players.Player;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;


public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image Tile;
	public static Image Character;
	public static AudioClip  explosionSound;

	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		Tile = new Image(ClassLoader.getSystemResource("BlockTiles.png").toString());
		Character = new Image(ClassLoader.getSystemResource("p1Character.png").toString());
		explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
		for(IRenderable x: entities){
			if(x instanceof Cell) System.out.println("Cell");
			if(x instanceof Tower) System.out.println("Tower");
			if(x instanceof Player) System.out.println("Player");
			
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}
