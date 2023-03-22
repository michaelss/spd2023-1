import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Tratador implements Runnable {

    private Socket clientSocket;

    public Tratador(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            InputStreamReader leitor = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader leitorB = new BufferedReader(leitor);
            String texto = leitorB.readLine();
            System.out.println(Thread.currentThread().getName() + ": " + texto);
            
            PrintWriter escritor = new PrintWriter(clientSocket.getOutputStream(), true);
            escritor.println(Thread.currentThread().getName() + ": " + texto.toUpperCase());
            
            fechar(escritor, leitor, leitorB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fechar(PrintWriter escritor, InputStreamReader leitor, BufferedReader leitorB) throws IOException {
        escritor.close();
        leitor.close();
        leitorB.close();
        this.clientSocket.close();
    }
    
}
