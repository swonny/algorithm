package cs;

public class ThreadQuiz {

    boolean running = true;

    public void test() {
        new Thread(() -> {
            int count = 0;
            while (running) {
                count++;
            }
            System.out.println("Thread1 finished");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {}
            System.out.println("Thread2 finished");
            running = false;
        }).start();
    }

    public static void main(String[] args) {
        new ThreadQuiz().test();
    }
}
