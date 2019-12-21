package sample;

import javafx.geometry.Dimension2D;

import java.util.ArrayList;
import java.util.Random;

public class ListSnow {
  private ArrayList<Snowflake> snowflakes = new ArrayList<>();
  private final Dimension2D dimension2D;
  private final int sizeFont;
  private Random random;

  ListSnow(Dimension2D dimension2D, int sizeFont) {
    this.dimension2D =  dimension2D;
    this.sizeFont = sizeFont;

    generateStartSnow();
  }

  private void generateStartSnow() {
    random = new Random();
    random = new Random();
    for (int i = 0; i < 400; i++) {
      snowflakes.add(buildSnowflake(random.nextInt((int)(dimension2D.getHeight() - sizeFont))));
    }
  }

  private Snowflake buildSnowflake(int height) {
    return new Snowflake(random.nextInt((int)(dimension2D.getWidth() - sizeFont)), height);
  }

  synchronized public ArrayList<Snowflake> getSnowflakes() {
    return snowflakes;
  }

  synchronized public void addSnowflake() {
    snowflakes.add(buildSnowflake(0));
  }

  synchronized public void removeSnowflake(int i) {
    snowflakes.remove(i);
  }
}
