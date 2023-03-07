import java.util.List;
import java.util.List;
import java.util.Vector;

public class App {
    public static void main(String[] args) throws InterruptedException {
        List<String> lista = new Vector<>();
        Runnable tarefa = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(i);
                } catch (InterruptedException e) {}
                lista.add(Thread.currentThread().getName());
            }
        };

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tarefa);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i));
        }
    }
}