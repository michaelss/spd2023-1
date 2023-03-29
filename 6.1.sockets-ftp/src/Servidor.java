import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ServerSocket serverSocket;

    // public void start(int port) throws IOException {
        
    // }

    public void stop() throws IOException {
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        // Servidor server = new Servidor();

        ServerSocket serverSocket = new ServerSocket(3333);
        System.out.println("Aguardando conexões...");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new Tratador(clientSocket)).start();
        }
    }
}