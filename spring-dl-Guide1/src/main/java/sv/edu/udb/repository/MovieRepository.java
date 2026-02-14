package sv.edu.udb.repository;

/*
Use un repositorio en memoria para las pruebas con (ArrayList y AtomicLong)
asi usando los metodos como (findAll(), save(), etc)
 */

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import sv.edu.udb.repository.domain.Movie;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class MovieRepository {
    private final List<Movie> listOfMovies = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @PostConstruct
    private void init() {
        final Movie movie_1 = Movie
                .builder()
                .id(1L)
                .name("Inception")
                .type("Science Fiction")
                .releaseYear(2010)
                .build();
        final Movie movie_2 = Movie
                .builder()
                .id(2L)
                .name("Butterfly effect")
                .type("Science Fiction Thriller")
                .releaseYear(2004)
                .build();
        final Movie movie_3 = Movie
                .builder()
                .id(3L)
                .name("Interstellar")
                .type("Science Fiction")
                .releaseYear(2014)
                .build();

        listOfMovies.addAll(Arrays.asList(movie_1, movie_2, movie_3));
        long maxId = listOfMovies.stream().mapToLong(m -> m.getId() == null ? 0L : m.getId()).max().orElse(0L);
        idGenerator.set(maxId);
    }

    public List<Movie> findAll() {
        return new ArrayList<>(listOfMovies);
    }

    public Optional<Movie> findById(final Long id) {
        return listOfMovies.stream().filter(m -> Objects.equals(m.getId(), id)).findFirst();
    }

    public Movie save(final Movie movie) {
        if (movie.getId() == null) {
            movie.setId(idGenerator.incrementAndGet());
            listOfMovies.add(movie);
            return movie;
        }
        Optional<Movie> existing = findById(movie.getId());
        if (existing.isPresent()) {
            Movie e = existing.get();
            e.setName(movie.getName());
            e.setType(movie.getType());
            e.setReleaseYear(movie.getReleaseYear());
            return e;
        } else {
            listOfMovies.add(movie);
            idGenerator.updateAndGet(cur -> Math.max(cur, movie.getId()));
            return movie;
        }
    }

    public void deleteById(final Long id) {
        listOfMovies.removeIf(m -> Objects.equals(m.getId(), id));
    }

    public Movie findMovieById(final Long id) {
        return findById(id).orElseThrow(() -> new NoSuchElementException("Movie doesn't exists"));
    }
}
