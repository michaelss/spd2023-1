import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(3333);
        System.out.println("Aguardando o cliente enviar dados...");
        Socket cliente = servidor.accept();

        InputStreamReader reader = new InputStreamReader(cliente.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);
        String texto = bufferedReader.readLine();

        PrintWriter writer = new PrintWriter(cliente.getOutputStream()); //, true);
        writer.println(texto.toUpperCase());
        writer.flush();
        System.out.println("Respondeu para o cliente. Encerrando...");

        reader.close();
        bufferedReader.close();
        writer.close();
        cliente.close();
        servidor.close();
    }

}
