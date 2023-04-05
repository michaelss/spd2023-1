import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ServerSocket serverSocket;

    public void stop() throws IOException {
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        System.out.println("Aguardando conexões...");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new Tratador(clientSocket)).start();
        }
    }
}