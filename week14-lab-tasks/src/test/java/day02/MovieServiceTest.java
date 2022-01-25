package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService movieService;

    @BeforeEach
    void init() {
        List<Movie> movies = List.of(
                new Movie("A két torony", 204, List.of(
                        "Orlando Bloom", "Christopher Lee", "Hugo Weaving", "Elijah Wood"
                )),
                new Movie("A király visszatér", 227, List.of(
                        "Orlando Bloom", "Christopher Lee", "Hugo Weaving", "Elijah Wood"
                )),
                new Movie("Mátrix", 146, List.of(
                        "Keanu Reeves", "Hugo Weaving", "Laurence Fishburne"
                )),
                new Movie("Jhon Wick", 153, List.of(
                        "Keanu Reeves", "Michael Nyqvist", "Willem Dafoe"
                )),
                new Movie("Ház a tónál", 122, List.of(
                        "Keanu Reeves", "Sandra Bullock", "Christopher Plummer"
                ))
        );
        movieService = new MovieService(movies);
    }

    @Test
    void testFindMoviesByActor() {
        List<Movie> results = movieService.getMoviesByActor("Hugo Weaving");
        assertEquals(3, results.size());
    }
}