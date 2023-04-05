import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    
    public static void main(String... args) throws IOException {
        DatagramSocket socket = new DatagramSocket(4444);
        byte[] buf = new byte[256];
        DatagramPacket packet  = new DatagramPacket(buf, buf.length);
        
        socket.receive(packet);
        
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        packet = new DatagramPacket(buf, buf.length, address, port);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println(received);

        packet.setData(received.toUpperCase().getBytes());
        socket.send(packet);
        socket.close();
    }
}
