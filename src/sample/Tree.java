package sample;

import javafx.geometry.Dimension2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
    colorOfBranch = Color.SADDLEBROWN;
    colorOfLeaves = Color.GREEN;
  }

  public Tree(char token, Color colorOfBranch, Color colorOfLeaves, Dimension2D dimension2D) {
    this.token = token;

    this.dimension2D = dimension2D;
    this.colorOfBranch = colorOfBranch;
    this.colorOfLeaves = colorOfLeaves;
  }

  public Canvas drawTree(int N) {
    LineTree line = (int n) -> {
      StringBuilder tmp = new StringBuilder();

      for(int i = 0; i < n; i++) {
        tmp.append(token);
      }

      return tmp.toString();
    };

    Canvas canvasWithTree = new Canvas(dimension2D.getWidth(), dimension2D.getHeight());

    GraphicsContext gc = canvasWithTree.getGraphicsContext2D();
    gc.setFill(colorOfLeaves);
    gc.setFont(new Font(15));
    int topLevel = 1;

    for (int i = 0; i < N; i++) {
      for (int j = 1; j <= 8; j++) {
        String tmp = line.getLine(topLevel);
        topLevel += 2;
        gc.fillText(tmp, (dimension2D.getWidth() - (tmp.length() * 9)) / 2, (j + i * 8) * 15 + marginTop);
      }
      topLevel -= 4;
    }
    return canvasWithTree;
  }
}
