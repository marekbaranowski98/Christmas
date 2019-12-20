package sample;

import javafx.scene.paint.Color;

import java.util.Random;

public class Bauble {
  public final Color[] colors = { Color.BLUE, Color.DEEPPINK, Color.WHITE, Color.RED, Color.YELLOW};
  private int numberOfColors;
  private int x;
  public final int size;

  public Bauble(int size) {
    this.size = size;
  }

  public void genereteBauble(int lengthBranch) {
    Random random = new Random();
    numberOfColors = random.nextInt(colors.length);

    x = random.nextInt(lengthBranch);
  }

  public int getNumberOfColors() {
    return numberOfColors;
  }

  public int getX() {
    return x;
  }
}
