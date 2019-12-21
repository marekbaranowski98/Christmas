package sample;

import javafx.geometry.Dimension2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Claus {
  private Dimension2D dimension2D;
  private final int minNumberGift = 5;
  private final int maxHeight = 60;
  private final int breakGift = 10;

  public Claus(Dimension2D dimension2D) {
    this.dimension2D = dimension2D;
  }

  public void giveGift(GraphicsContext gc, int heightWithEarth) {
    ArrayList<Gift> gifts = genereteGifts();
    int startX = breakGift;

    for (Gift gift : gifts) {
      gc.setFill(gift.getColorOfBox());
      gc.fillRect(startX,  heightWithEarth-gift.getHeight(), gift.getWidth(), gift.getHeight());
      startX += gift.getWidth() + breakGift;
    }
  }

  private ArrayList<Gift> genereteGifts() {
    int N = (int)dimension2D.getWidth()/Gift.minWidth+1;
    int maxWidth = (int)dimension2D.getWidth();
    int maxGift = maxWidth/minNumberGift;
    ArrayList<Gift> listOfGifts = new ArrayList<Gift>();

    int i;
    for (i = 0; i < N && maxWidth > Gift.minWidth + breakGift; i++) {
      listOfGifts.add(new Gift());
      listOfGifts.get(i).genereteGift(Math.max(maxGift, Gift.minWidth+1), maxHeight);
      maxWidth -= listOfGifts.get(i).getWidth() + breakGift;
      maxGift = maxWidth/minNumberGift;
    }

    return listOfGifts;
  }
}
