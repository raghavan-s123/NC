import java.net.*;
import java.util.Scanner;
public class udpServer {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        try {
// Create a server socket bound to port 9876
            serverSocket = new DatagramSocket(9876);
            InetAddress clientAddress = InetAddress.getByName("localhost"); // Client
            Scanner scanner = new Scanner(System.in);
            System.out.println("Server is ready to send messages to the client.");
            while (true) {
// Read a message from the server user
                System.out.print("Enter message: ");
                String message = scanner.nextLine();
// Convert the message to a byte array
                byte[] sendData = message.getBytes();
// Create a datagram packet to send data to the client on port 9875
                DatagramPacket sendPacket = new DatagramPacket(sendData,
                        sendData.length, clientAddress, 9875);
// Send the packet
                serverSocket.send(sendPacket);
// Exit the loop if the user types "exit"
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Server exiting...");
                    break;
                }
            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        }
    }
}