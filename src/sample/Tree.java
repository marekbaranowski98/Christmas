package sample;

import javafx.geometry.Dimension2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;

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
  private final int chanceToGenerete = 4;

  public Tree(Dimension2D dimension2D) {
    this.dimension2D = dimension2D;
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

  public void drawTree(GraphicsContext gc, int N) {
    LineTree line = (int n) -> {
      StringBuilder tmp = new StringBuilder();

      for(int i = 0; i < n; i++) {
        tmp.append(token);
      }

      return tmp.toString();
    };

    gc.setFont(font);
    gc.setStroke(Color.WHITE);

    int topLevel = 1;
    int i, j = 0;

    for (i = 0; i < N; i++) {
      for (j = 1; j <= 8; j++) {
        gc.setFill(colorOfLeaves);
        String tmp = line.getLine(topLevel);
        topLevel += 2;

        Text tmpText = new Text(tmp);
        tmpText.setFont(font);
        int lineWidth = (int)tmpText.getLayoutBounds().getWidth();
        int y = (j + i * 8) * 15 + marginTop;
        int x = (int)(dimension2D.getWidth() - tmpText.getLayoutBounds().getWidth())/ 2;

        gc.fillText(tmp, x, y);

        drawBauble(gc, genereteBaubles(lineWidth, Math.max(tmp.length(), 3)), x, y);

      }
      topLevel -= 6;
    }

    i--;
    j--;

    drawNode(gc, (j + i * 8));

    Star star = new Star(dimension2D.getWidth()/2, 30, 5);
    star.drawStar(gc);
  }

  private Bauble[] genereteBaubles(int lengthOfBranch, int count) {
    Bauble[] baubles = new Bauble[count - 3];

    for(int i = 0; i < count - 3; i++) {
      boolean repeatBauble = false;

      Random random = new Random();
      if(random.nextInt(chanceToGenerete) == chanceToGenerete-1) {
        baubles[i] = new Bauble(10);
        baubles[i].genereteBauble((int)(lengthOfBranch));

        int j = i - 1;
        while (j>=0) {
          if ((baubles[j] != null) && Math.abs(baubles[i].getX() - baubles[j].getX()) < baubles[i].size + 5) {
            repeatBauble = true;
          }
          j--;
        }
        if(repeatBauble) {
          i--;
        }
      }else {
        baubles[i] = null;
      }
    }

    return baubles;
  }

  private void drawBauble(GraphicsContext gc, Bauble[] baubles, int x, int y) {
    for (int i = 0; i < baubles.length; i++) {
      if (baubles[i] != null) {
        gc.strokeLine(x + baubles[i].getX() + baubles[i].size/2, y-7, x+baubles[i].getX() + baubles[i].size/2, y-3);
        gc.setFill(baubles[i].colors[baubles[i].getNumberOfColors()]);
        gc.fillOval(x + baubles[i].getX(), y-3, baubles[i].size, baubles[i].size);
      }
    }
  }

  private void drawNode(GraphicsContext gc, int y) {
    gc.setFill(colorOfBranch);

    for(int i = 1; i <= 4; i++) {
      Text tmpText = new Text(node);
      tmpText.setFont(font);

      gc.fillText(node, (dimension2D.getWidth() - tmpText.getLayoutBounds().getWidth()) / 2, (i + y)*15 + marginTop);
    }
  }
}
