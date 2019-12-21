package sample;

import javafx.geometry.Dimension2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class Snowing implements Runnable {
  private GraphicsContext gc;
  private Thread thread = new Thread(this);
  private boolean running = true;
  private Dimension2D dimension2D;
  private ListSnow listSnow;

  private final int move = 2;
  private final long fps = 1000/20;
  private final Font font = new Font("Comis Sans MS Bold", 20);
  public Snowing(GraphicsContext gc, Dimension2D dimension2D, ListSnow listSnow) {
    this.gc = gc;
    this.dimension2D = dimension2D;
    this.listSnow = listSnow;

    thread.start();
  }

  @Override
  public void run() {

    while (running) {
      float time = System.currentTimeMillis();
      gc.clearRect(0, 0, dimension2D.getWidth(), dimension2D.getHeight());
      gc.setFill(Color.WHITE);
      gc.setFont(font);

      ArrayList<Snowflake> snowflakes = listSnow.getSnowflakes();
      for (int i = 0; i < snowflakes.size(); i++) {
        if(snowflakes.get(i).getY() + font.getSize() > dimension2D.getHeight()) {
         listSnow.removeSnowflake(i);
        }else {
          gc.fillText(snowflakes.get(i).shape + "", snowflakes.get(i).getX(), snowflakes.get(i).getY());

          snowflakes.get(i).move(move);
        }
      }

      time = System.currentTimeMillis() - time;
      if (time < fps) {
        try {
          Thread.sleep((long) (fps - time));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void stop() {
    this.running = false;
  }
}
