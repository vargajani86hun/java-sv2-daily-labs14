package day02;

import java.util.List;

public class MovieService {
    private List<Movie> movies;

    public MovieService(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMoviesByActor(String actor) {
        return movies.stream()
                .filter(m -> m.getActors().contains(actor))
                .toList();
    }

    public int getLongestMovieLength() {
        return movies.stream()
                .mapToInt(Movie::getLength)
                .max().orElse(0);
    }
}
