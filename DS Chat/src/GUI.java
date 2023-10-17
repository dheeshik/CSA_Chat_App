//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
public class GUI {
    public GUI() {

        //Creating the Frame
        JFrame frame = new JFrame("J Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);

        //Creating the MenuBar and adding components
        JMenuBar menuBar = new JMenuBar();

        JMenu serverMenu = new JMenu("Server");
        JMenu clientMenu = new JMenu("Client");

        menuBar.add(serverMenu);
        menuBar.add(clientMenu);

        JMenuItem serverHost = new JMenuItem("Host New Session");
        JMenuItem clientJoin = new JMenuItem("Join Session");
        serverMenu.add(serverHost);
        clientMenu.add(clientJoin);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        JLabel sid = new JLabel("Sid loves men", null, SwingConstants.CENTER);
        sid.setForeground(Color.WHITE);
        panel.setBackground(Color.decode("#B5BAD0"));
        panel.add(sid);

        menuBar.setBackground(Color.decode("#B5BAD0"));

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }
}

