import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    private Socket clientSocket;
    private String ip;
    private int porta;

    public Cliente(String ip, int porta) throws UnknownHostException, IOException {
        this.ip = ip;
        this.porta = porta;
    }

    public void enviar(String msg) throws IOException {
        clientSocket = new Socket(this.ip, this.porta);

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(msg);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String resp = in.readLine();
        System.out.println("Servidor respondeu: " + resp);

        out.close();
        in.close();
    }

    public static void main(String... args) throws UnknownHostException, IOException {
        Cliente cliente = new Cliente("localhost", 3333);
        
        boolean sair = false;
        while (!sair) {
            String msg = System.console().readLine("Digite um texto: ");
            sair = msg.trim().toLowerCase().equals("sair");
            if (!sair) {
                cliente.enviar(msg);
            }
        }
    }

}
