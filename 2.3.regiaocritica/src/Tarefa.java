
public class Tarefa implements Runnable {

    private Contador contador;

    public Tarefa(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        // contador.setNumero(contador.getNumero() + 1);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contador.incrementar();
    }
    
}