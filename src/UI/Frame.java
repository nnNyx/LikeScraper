package UI;

import util.Song;
import util.Request;

import javax.swing.*;
import java.util.LinkedList;

public class Frame {
    private String userInput;
    LinkedList<Song> likedList = new LinkedList<>();

    public static void main(String[] args) {
        new Frame().displayInputWindow();
    }

    private void displayInputWindow() {
        JFrame inputFrame = new JFrame("Input your SC token");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            userInput = textField.getText();
            inputFrame.dispose();
            getLikedSongs(userInput);
            displayMainWindow();
        });

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(button);

        inputFrame.getContentPane().add(panel);
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputFrame.pack();
        inputFrame.setLocationRelativeTo(null);
        inputFrame.setVisible(true);
    }

    private void displayMainWindow() {
        JFrame mainFrame = new JFrame("Liked songs");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Song s : likedList) {
            SongPanel songPanel = new SongPanel(s);
            panel.add(songPanel);

            JSeparator sep = new JSeparator();
            panel.add(sep);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainFrame.getContentPane().add(scrollPane);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(900, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private void getLikedSongs(String userInput) {
        Request request = new Request(userInput);
        request.getSongs(likedList);
    }
}