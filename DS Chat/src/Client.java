import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Client {
    //instance variables
    Thread send;
    Thread receive;
    Socket cliSocket;
    BufferedReader br;
    PrintWriter pr;
    Scanner sc = new Scanner(System.in);

    // Class constructor
    public Client(String connectionIP) {

        try {
            // Create socket, input, and output variables
            cliSocket = new Socket(connectionIP, 6969);
            pr = new PrintWriter(cliSocket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(cliSocket.getInputStream()));

            // Create new thread for sender
            send = new Thread(new Runnable() {
                String message;
                @Override public void run() {
                    while (true) {
                        // Sets the message to be displayed to user input
                        message = sc.nextLine();
                        pr.println(message);
                        pr.flush();
                    }

                }
            });

            // Create new thread for receiver
            receive = new Thread(new Runnable() {
                String message;
                @Override public void run() {
                    try {
                        message = br.readLine();

                        // Continues to display server messages until message is null
                        while (message != null) {
                            System.out.println("Server: " +  message);
                            message = br.readLine();
                        }
                        br.close();
                        cliSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void runClient() {
        send.start();
        receive.start();
    }
}


