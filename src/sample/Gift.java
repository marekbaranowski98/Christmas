package sample;

import javafx.scene.paint.Color;

import java.util.Random;

public class Gift {
  public final Color[] listOfColorBox = { Color.CRIMSON, Color.DARKORANGE, Color.DARKORCHID, Color.FORESTGREEN, Color.YELLOWGREEN };
  public final Color[] listOfColorRibbon = { Color.GOLD, Color.GRAY, Color.WHITE };
  private int width;
  private int height;
  private Color colorOfBox;
  private final int sizeOfRibbon = 5;
  public static final int minWidth = 30;
  public static final int minHeight = 30;
  private Color colorOfRibbon;

  public void genereteGift(int maxWidth, int maxHeight) {
    Random random = new Random();

    colorOfBox = listOfColorBox[random.nextInt(listOfColorBox.length)];
    colorOfRibbon = listOfColorRibbon[random.nextInt(listOfColorRibbon.length)];

    width = random.nextInt(maxWidth - minWidth) + minWidth;
    height = random.nextInt(maxHeight - minHeight) + minHeight;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Color getColorOfBox() {
    return colorOfBox;
  }

  public int getSizeOfRibbon() {
    return sizeOfRibbon;
  }

  public Color getColorOfRibbon() {
    return colorOfRibbon;
  }
}
