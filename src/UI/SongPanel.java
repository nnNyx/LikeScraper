package UI;

import util.Song;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.image.BufferedImage;
import java.awt.Desktop;

public class SongPanel extends JPanel {
    public SongPanel(Song song){
        setLayout(new FlowLayout(FlowLayout.LEFT));

        try {
            URI uri = new URI(song.getUrl());
            BufferedImage img = ImageIO.read(uri.toURL());
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImg);

            JLabel imageLabel = new JLabel(icon);
            add(imageLabel);

            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

            JLabel songLabel = new JLabel("Song: " + song.getTitle());
            textPanel.add(songLabel);

            JLabel artistLabel = new JLabel("Artist: " + song.getArtist());
            textPanel.add(artistLabel);

            // Add clickable permalink
            URI trackUri = new URI(song.getTrackUrl());
            JLabel trackUrlLabel = new JLabel("<html>Permalink: <a href=''>" + song.getTrackUrl() + "</a></html>");
            trackUrlLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            trackUrlLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(trackUri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            textPanel.add(trackUrlLabel);

            add(textPanel);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}