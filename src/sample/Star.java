package sample;

import javafx.scene.paint.Color;
public class Star {
  public int n;
  
  public double[] x = new double[] {-4, -1, 0, 1, 4, 2, 4, 0, -4, -2};
  public double[] y = new double[] {-1, -1, -3, -1, -1, 1, 4, 2, 4, 1};

  public final Color color = Color.LIGHTGOLDENRODYELLOW;

  public Star(double vectorX, double vectorY, double size) {
    n = x.length;
    for (int i = 0; i < n; i++) {
      x[i] *= size;
      x[i] += vectorX;


      y[i] *= size;
      y[i] += vectorY;

    }
  }

  public Star(double[] x, double[] y) {
    this.x = x;
    this.y = y;
    n = x.length;
  }
}
