
public class Main {
  public static void main(String[] args) {
      Server server = new Server();
      server.runServer();

      Client client = new Client();
      client.runClient();

    }
}