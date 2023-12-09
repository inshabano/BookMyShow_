package com.insha.Bookmyshow.Repositories;

import com.insha.Bookmyshow.Model.Movie;
import com.insha.Bookmyshow.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    Optional<Movie> findById(Long aLong);
}
