# LikeScraper

LikeScraper is a Java application that fetches and displays a list of liked songs from a SoundCloud user's account. The application uses the SoundCloud API to retrieve the data and displays it in a simple GUI.

## Features

- Fetches liked songs from a SoundCloud user's account using the SoundCloud API.
- Displays the liked songs in a GUI, including the song's title, artist, and a clickable permalink to the song on SoundCloud.
- The GUI displays the album artwork for each song.

## Prerequisites

- Java Development Kit (JDK) 8 or later.
- A SoundCloud account and a valid OAuth token.

## Usage

1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA).
3. Run the `Frame` class. This will display an input window.
4. Enter your SoundCloud OAuth token into the input field and click "Submit".
5. The application will fetch your liked songs and display them in a new window.

## Code Structure

- `Frame.java`: Contains the main method and handles the GUI creation.
- `SongPanel.java`: A custom JPanel that displays information about a single song.
- `Song.java`: A simple data class that represents a song.
- `Request.java`: Handles the communication with the SoundCloud API.

## Limitations

- The application currently only supports fetching liked songs. Other types of data (e.g., playlists, followers) are not supported.
- The application does not handle API rate limits. If you make too many requests in a short period of time, the SoundCloud API may temporarily block your IP address.
- Done mainly as a proof-of-concept, things might break.
