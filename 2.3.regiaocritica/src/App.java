public class App {

    private static final int QTD_THREADS = 1000;
    
    public static void main(String[] args) throws Exception {
        Contador contador = new Contador();

        Thread[] threads = new Thread[QTD_THREADS];
        for (int i = 0; i < QTD_THREADS; i++) {
            threads[i] = new Thread(new Tarefa(contador));
            threads[i].start();
        }
        
        for (int i = 0; i < QTD_THREADS; i++) {
            threads[i].join();
        }

        System.out.println(contador.getNumero());
    }
}
