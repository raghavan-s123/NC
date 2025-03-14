import java.io.*;
import java.net.*;
class tcpClient {
    public static void main(String[] args) {
        try {
            System.out.println("Client is running!");
            Socket s = new Socket("localhost", 8081);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(s.getInputStream()));
            PrintWriter p = new PrintWriter(s.getOutputStream(), true);
            String msg = "";
            while (true) {
                System.out.print("Enter message: "); // Prompt user for input
                msg = in.readLine();
                p.println(msg);
                System.out.println("Server says: " + br.readLine());
                if (msg.equals("quit")) break;

            }
            p.close();
            br.close();
            s.close();
            System.out.println("TERMINATED");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}