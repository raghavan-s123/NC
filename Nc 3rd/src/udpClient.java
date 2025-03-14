import java.net.*;
public class udpClient {
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;
        try {
// Create a socket to listen on port 9875
            clientSocket = new DatagramSocket(9875);
            byte[] receiveData = new byte[1024]; // Buffer for receiving data
            System.out.println("Client is ready to receive messages.");
            while (true) {
// Create a datagram packet to receive data
                DatagramPacket receivePacket = new DatagramPacket(receiveData,
                        receiveData.length);
// Receive data from the server
                clientSocket.receive(receivePacket);
// Convert the byte array into a string
                String message = new String(receivePacket.getData(), 0,
                        receivePacket.getLength());
// Display the message
                System.out.println("Server says: " + message);
// Exit if the message is "exit"
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client exiting...");
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
        }
    }
}