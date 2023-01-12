import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String name;
    private Socket socket;
    private PrintWriter output;
    private Scanner scan;

    public Client() {
        try {
            this.socket = new Socket("localhost", 54321);

            do {
                scan = new Scanner(System.in);
                System.out.print("Enter a username: ");
                name = scan.nextLine();
            } while (name.equals(""));

            output = new PrintWriter(socket.getOutputStream(),true);

            start();
        } catch (IOException e) {

        }
    }


    public void start() {
        try {
            ClientInput clientInput = new ClientInput(socket);
            new Thread(clientInput).start();
            output.println(name);
            String input = "";

            do {
                input = scan.nextLine();
                output.println(input);
            } while (!input.equals("\\exit"));

            System.out.println("Disconnecting...");

        } catch (IOException e) {

        } catch (NullPointerException e) {
            System.out.println("Server not found");
        } finally {
            try {
                socket.close();
            } catch (Exception e) {

            }
        }
    }
}
