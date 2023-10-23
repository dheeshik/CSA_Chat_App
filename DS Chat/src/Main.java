
public class Main {
  public static void main(String[] args) {
      Server server = new Server(6000);
      server.runServer();

      Client client = new Client("192.168.1.70", 6000);
      client.runClient();

    }
}