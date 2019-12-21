package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Star {
  public int n;
  
  private double[] x = new double[] {-4, -1, 0, 1, 4, 2, 4, 0, -4, -2};
  private double[] y = new double[] {-1, -1, -3, -1, -1, 1, 4, 2, 4, 1};

  public final Color color = Color.GOLD;

  public Star(double vectorX, double vectorY, double size) {
    for (int i = 0; i < x.length; i++) {
      x[i] *= size;
      x[i] += vectorX;


      y[i] *= size;
      y[i] += vectorY;

    }
  }

  public Star(double[] x, double[] y) {
    this.x = x;
    this.y = y;
  }

  public void drawStar(GraphicsContext gc) {
    gc.setFill(color);
    gc.fillPolygon(x, y, x.length);
  }
}
