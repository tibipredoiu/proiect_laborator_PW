package com.example.proiectfinal;

import javax.persistence.*;

@Entity
@Table(name="movies")
public class MoviesClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MovieId;

    @Column(nullable = false, unique = true, length = 100)
    private String MovieName;

    @Column(nullable = false,  length = 100)
    private String ReleaseDate;

    @Column(nullable = false,  length = 100)
    private float Rating;

    //Get-ari
    public Long getMovieId() {
        return MovieId;
    }

    public String getMovieName() {
        return MovieName;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public float getRating() {
        return Rating;
    }

    //Set-ari
    public void setMovieId(Long movieId) {
        MovieId = movieId;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public void setRating(float rating) {
        Rating = rating;
    }
}
