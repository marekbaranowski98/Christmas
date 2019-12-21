package sample;

public class Producer implements Runnable {
  private ListSnow listSnow;
  private Thread thread = new Thread(this);
  private boolean running = true;

  public Producer(ListSnow listSnow) {
    this.listSnow = listSnow;

    thread.start();
  }

  @Override
  public void run() {
    while (running) {
      listSnow.addSnowflake();
      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void stop() {
    this.running = false;
  }
}
