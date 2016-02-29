public class ThreadTest {
  public static void main(String [] args) throws Exception {
    Thread th = new Thread() {
        public void run() {
          while(true);
        }
    };
    th.setDaemon(true);
    th.start();
    System.out.println("Hello world");
  }
}
