import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        
        byte[] buf = "msg".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4444);
        socket.send(packet);
        packet = new DatagramPacket(buf, buf.length);
        
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println(received);
        
        socket.close();
    }
}
