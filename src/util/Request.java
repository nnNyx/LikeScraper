package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Request {
    private final String token;

    public Request(String token){
        this.token = token;
    }

    // Gets a JSON response of liked songs, adds to the passed list
    public void getSongs(LinkedList<Song> songs){
        try {
            // GET request to the SoundCloud API
            URI uri = new URI("https://api-v2.soundcloud.com/users/316203127/track_likes?oauth_token=" + this.token);
            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Successful GET request
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                // Parsing JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray collection = jsonResponse.getJSONArray("collection");

                for (int i = 0; i < collection.length(); ++i) {
                    JSONObject like = collection.getJSONObject(i);
                    JSONObject track = like.getJSONObject("track");

                    String artworkUrl = track.getString("artwork_url");
                    String songName = track.getString("title");
                    String artistName = track.getJSONObject("user").getString("username");
                    String trackUrl = track.getString("permalink_url");

                    songs.add(new Song(artworkUrl, songName, artistName, trackUrl));
                }

                System.out.println("[Debug] Response: " + response);
            } else {
                System.out.println("[Error] GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}