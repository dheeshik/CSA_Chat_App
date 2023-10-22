
public class Main {
  public static void main(String[] args) {
      //Server server = new Server();
      //server.runServer();

      Client client = new Client("192.168.1.70");
      client.runClient();

    }
}