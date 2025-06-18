package com.example.mycollections.controllers;


import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final List<Movie> movies = new ArrayList<>() {{
        add(new Movie("Twilight", "Catherine Hardwicke", 2008, 122));
        add(new Movie("She's the Man", "Andy Fickman", 2006, 105));
        add(new Movie("Legally Blonde", "Robert Luketic", 2001, 96));
    }};

    @GetMapping("/json")
        public List<Movie> getMoviesJson() {return movies;}

    @GetMapping("/html")
        public String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movie movie : movies) {
            movieList += "<li>" + movie.getName() + " by " + movie.getDirector() + " (" + movie.getYear() + "). Runtime is " + movie.getRuntime() + " minutes." + "</li>";
        }
        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                movieList +
                """
                        </ul>
                    </body>
                """;
    }
}
