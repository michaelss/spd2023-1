import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cliente {
    private Socket clientSocket;
    private int port;
    private String ip;

    public Cliente(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
    }

    public void execCmd(String cmd) throws IOException {
        clientSocket = new Socket(ip, port);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(cmd);

        String nomeArq = parseNomeArq(cmd);

        InputStream in = clientSocket.getInputStream();
        byte[] bytes = in.readAllBytes();
        if (bytes.length > 0) {
            Path path = Paths.get(nomeArq);
            Files.write(path, bytes);
        }
        in.close();
        out.close();
    }

    private String parseNomeArq(String cmd) {
        String[] cmdSplit = cmd.split("\\s");
        String[] split = cmdSplit[1].split("/");
        String nomeArq = split[split.length-1];
        return nomeArq;
    }

    public void stopConnection() throws IOException {
        this.clientSocket.close();
    }

    public static void main(String... args) throws UnknownHostException, IOException {
        Cliente client = new Cliente("localhost", 3333);
        
        boolean sair = false;
        while (!sair) {
            String msg = System.console().readLine("Digite um texto: ");
            sair = msg.trim().toLowerCase().equals("sair");
            if (!sair) {
                client.execCmd(msg);
            } else {
                client.stopConnection();
            }
        }
    }
}
