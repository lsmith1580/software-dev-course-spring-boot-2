package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //tells springboot that the class is a controller and will handle http requests
@RequestMapping("/albums") //defines base url path for all methods within this controller
public class AlbumController {
    private final List<Album> albums = new ArrayList<>() {{
        add(new Album("Random Access Memories", "Daft Punk", 2013, 13));
        add(new Album("Ambrosia", "Ambrosia", 1975, 8));
        add(new Album("In the End It Always Does", "The Japanese House", 2023, 12));
    }};

    @GetMapping("/json")
        public List<Album> getAlbumsJson() {return albums;}

    @GetMapping("/html")
        public String getAlbumsHtml() {
        String albumList = "<ul>";
        for (Album album : albums) {
            albumList += "<li>" + album.getName() + " by " + album.getArtist() + " (" + album.getYear() + ") - " + album.getTracks() + " tracks" + "</li>";
        }
        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                     </body>
                """;
    }
}
