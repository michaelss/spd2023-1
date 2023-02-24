public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando a busca...");

        String texto = "ebook";

        Thread t1 = new Thread(new Buscador("livro1.txt", texto), "tarefa1");
        Thread t2 = new Thread(new Buscador("livro2.txt", texto), "tarefa2");
        Thread t3 = new Thread(new Buscador("livro3.txt", texto), "tarefa3");

        t1.start();
        t2.start();
        t3.start();
        
    }
}
