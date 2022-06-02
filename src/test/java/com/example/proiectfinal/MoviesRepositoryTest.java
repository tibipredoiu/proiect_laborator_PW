package com.example.proiectfinal;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MoviesRepositoryTest {

    @Autowired
    MoviesRepository moviesRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void TestAddMovies()
    {
        MoviesClass moviesClass = new MoviesClass();
        moviesClass.setMovieName("Fast and Furios 9");
        moviesClass.setReleaseDate("13 Aprilie 2019");
        moviesClass.setRating(7.9f);

        MoviesClass savedMovies = moviesRepository.save(moviesClass);

        MoviesClass existsUser = testEntityManager.find(MoviesClass.class, savedMovies.getMovieId());

        assertThat(existsUser.getMovieName()).isEqualTo(moviesClass.getMovieName());
    }

}
