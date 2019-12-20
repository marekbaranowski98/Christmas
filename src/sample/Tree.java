package sample;

import javafx.geometry.Dimension2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tree {
  private interface LineTree {
    String getLine(int n);
  }
  private final char token;
  private final Color colorOfBranch;
  private final Color colorOfLeaves;
  private final Dimension2D dimension2D;
  private final int marginTop = 30;
  private final Font font = new Font("Comic Sans MS Bold", 15);
  private final String node = "|###|";

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
    gc.setFont(font);

    int topLevel = 1;
    int i, j = 0;

    for (i = 0; i < N; i++) {
      for (j = 1; j <= 8; j++) {
        String tmp = line.getLine(topLevel);
        topLevel += 2;

        Text tmpText = new Text(tmp);
        tmpText.setFont(font);
        gc.fillText(tmp, (dimension2D.getWidth() - tmpText.getLayoutBounds().getWidth())/ 2, (j + i * 8) * 15 + marginTop);
      }
      topLevel -= 6;
    }

    i--;
    j--;

    gc.setFill(colorOfBranch);
    for(int k = 1; k <= 4; k++) {
      Text tmpText = new Text(node);
      tmpText.setFont(font);

      gc.fillText(node, (dimension2D.getWidth() - tmpText.getLayoutBounds().getWidth()) / 2, (k + (j + i * 8))*15 + marginTop);
    }

    Star star = new Star(dimension2D.getWidth()/2, 30, 5);
    gc.setFill(star.color);
    gc.fillPolygon(star.x, star.y, star.n);
    return canvasWithTree;
  }
}
