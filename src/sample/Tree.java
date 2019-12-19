package sample;

import javafx.geometry.Dimension2D;
import javafx.scene.paint.Color;

public class Tree {
  private interface LineTree {
    String getLine(int n);
  }
  private final char token;
  private final Color colorOfBranch;
  private final Color colorOfLeaves;
  private final Dimension2D dimension2D;
  private final int marginTop = 10;

  public Tree() {
    dimension2D = new Dimension2D(650, 700);
    token = '+';
    colorOfBranch = Color.BROWN;
    colorOfLeaves = Color.GREEN;
  }

  public Tree(char token, Color colorOfBranch, Color colorOfLeaves, Dimension2D dimension2D) {
    this.token = token;

    this.dimension2D = dimension2D;
    this.colorOfBranch = colorOfBranch;
    this.colorOfLeaves = colorOfLeaves;
  }
}
