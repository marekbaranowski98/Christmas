package sample;

public class Snowflake {
  private int x;
  private int y;
  public final char shape = '*';

  public Snowflake(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void move(int move) {
    this.y += move;
  }
}
