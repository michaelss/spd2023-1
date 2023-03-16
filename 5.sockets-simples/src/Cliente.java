import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    
    public static void main(String... args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 3333);
        PrintWriter writer = new PrintWriter(socket.getOutputStream()); //, true);
        writer.println("sistemas distribuidos");
        writer.flush();

        InputStreamReader reader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);
        String resposta = bufferedReader.readLine();

        System.out.println(resposta);

        bufferedReader.close();
        reader.close();
        writer.close();
        socket.close();
    }
}
