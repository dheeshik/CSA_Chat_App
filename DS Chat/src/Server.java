import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;
import java.net.Socket;

public class Server {
    // initialize variables
    // -------------------------------------------------------------------------------------------------
    Thread sender;
    Thread recieve;
    ServerSocket serverSocket;
    Socket clientSocket;
    BufferedReader in;
    PrintWriter out = null; // fallback if connection is not sucessfull
    Scanner sc = new Scanner(System.in);

    
    public Server(){
        
        
        // try to create start a server on socket 6000
        // -------------------------------------------------------------------------------------------------
        try {
            serverSocket = new ServerSocket(6000);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        // Create Threads to send and recieve messages
        // -------------------------------------------------------------------------------------------------
        sender = new Thread(new Runnable() {
            String msg;
            @Override
            public void run(){
                while(true){
                    msg = sc.nextLine(); // reads user input from console
                    if (out != null){
                        out.println(msg);
                        out.flush();
                    }
                }
            }
        });

        recieve = new Thread(new Runnable() {
            String msg;
            @Override
            public void run(){
                try {
                    msg = in.readLine();

                    while(msg != null){
                        System.out.println("Client () " + msg);
                        msg = in.readLine();
                    }

                    System.out.println("---CLIENT CONNECTION LOST---");
                    // Close all connections an IO streams
                    out.close();
                    clientSocket.close();
                    serverSocket.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        });


    }



    public void runServer(){
        sender.start();
        recieve.start();
    }
}
