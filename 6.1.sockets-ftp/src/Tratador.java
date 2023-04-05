import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tratador implements Runnable {

    private Socket clientSocket;

    public Tratador(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String comando = in.readLine();
            System.out.println("Recebeu comando: " + comando);

            String[] cmdSplit = comando.split("\\s");
            byte[] dados;
            switch (cmdSplit[0]) {
                case "GET":
                default:
                    String pathArq = cmdSplit[1];
                    dados = Files.readAllBytes(Paths.get(pathArq));

            }

            OutputStream out = clientSocket.getOutputStream();
            out.write(dados);
            out.flush();

            fechar(in, out);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fechar(BufferedReader in, OutputStream out) throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

}
