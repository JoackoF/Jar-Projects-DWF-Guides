package sv.edu.udb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sv.edu.udb.repository.domain.Movie;
import sv.edu.udb.service.implementation.MovieServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class MovieServiceTest {
    @Autowired
    private MovieServiceImpl movieService;
    @Test
    void shouldMovieServiceNotNull_When_SpringContextWorks() {
        assertNotNull(movieService);
    }
    @Test
    void shouldMovieRepositoryNotNul_When_DIWorks() {
        assertNotNull(movieService.getMovieRepository());
    }
    @Test
    void shouldGetAMovie_When_TheMovieIdExists() {
        final Long expectedMovieId = 1L;
        final String expectedMovieName = "Inception";
        final Integer expectedReleaseYear = 2010;
        final Movie actualMovie = movieService.findMovieById(expectedMovieId);
        assertEquals(actualMovie.getId(), expectedMovieId);
        assertEquals(actualMovie.getName(), expectedMovieName);
        assertEquals(actualMovie.getReleaseYear(), expectedReleaseYear);
    }
    @Test
    void shouldThrowNoSuchElementException_When_MovieIdDoesNotExists() {
        final Long fakeId = 4L;
        final String expectedErrorMessage = "Movie doesn't exists";
        final Exception exception = assertThrows(NoSuchElementException.class,
                () -> movieService.findMovieById(fakeId));
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    //Ejercicios Complementario

    //#1
    @Test
    void shouldGetAllMovies_When_DatabaseSeeded() {
        List<Movie> movies = movieService.getMovieRepository().findAll();
        assertNotNull(movies);
        assertTrue(movies.stream().anyMatch(m -> m.getId() != null && m.getId().equals(1L)));
    }
    //#2
    @Test
    void shouldSaveNewMovie_When_SaveToRepository() {
        Movie newMovie = new Movie();
        newMovie.setName("The Matrix");
        newMovie.setReleaseYear(1999);
        Movie saved = movieService.getMovieRepository().save(newMovie);
        assertNotNull(saved.getId());
        assertEquals("The Matrix", saved.getName());
        movieService.getMovieRepository().deleteById(saved.getId());
    }
    //#3
    @Test
    void shouldDeleteMovie_When_DeleteById() {
        Movie temp = new Movie();
        temp.setName("Temp Movie");
        temp.setReleaseYear(2020);
        Movie saved = movieService.getMovieRepository().save(temp);
        final Long id = saved.getId();
        movieService.getMovieRepository().deleteById(id);
        assertFalse(movieService.getMovieRepository().findById(id).isPresent());
    }
}