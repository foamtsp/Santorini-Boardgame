package playersPart;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteObject extends Transition{
	    private final ImageView imageView;
	    private final int count;
	    private final int columns;
	    private final int offsetX;
	    private final int offsetY;
	    private final int width;
	    private final int height;

	    private int lastIndex;

	    public SpriteObject(
	            ImageView imageView, 
	            Duration duration, 
	            int count,   int columns,
	            int offsetX, int offsetY,
	            int width,   int height) {
	        this.imageView = imageView;
	        this.count     = count;
	        this.columns   = columns;
	        this.offsetX   = offsetX;
	        this.offsetY   = offsetY;
	        this.width     = width;
	        this.height    = height;
	        setCycleDuration(duration);
	        setInterpolator(Interpolator.LINEAR);
	    }

	    protected void interpolate(double k) {
	        final int index = Math.min((int) Math.floor(k * count), count - 1);
	        if (index != lastIndex) {
	            final int x = (index % columns) * width  + offsetX;
	            final int y = (index / columns) * height + offsetY;
	            imageView.setViewport(new Rectangle2D(x, y, width, height));
	            lastIndex = index;
	        }
	    }
	    /*
	    final int COLUMNS  =   4;
	    final int COUNT    =  10;
	    final int OFFSET_X =  18;
	    final int OFFSET_Y =  25;
	    final int WIDTH    = 374;
	    final int HEIGHT   = 243;
	    String image_pathx = ClassLoader.getSystemResource("Player"+type+"_"+"S"+".png").toString();
	    final Image IMAGE = new Image(image_pathx);
		ImageView imageView = new ImageView(IMAGE);
		imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
		Animation animation = new SpriteObject(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        */
}
