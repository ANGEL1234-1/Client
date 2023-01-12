import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientInput extends Thread {
    private final Socket SOCKET;
    private BufferedReader intput;

    public ClientInput(Socket socket) throws IOException {
        this.SOCKET = socket;
        this.intput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = intput.readLine();
                System.out.println(msg);
            }
        } catch (IOException e) {
            System.exit(0);
        } finally {
            try {
                intput.close();
            } catch (Exception e) {

            }
        }
    }
}
