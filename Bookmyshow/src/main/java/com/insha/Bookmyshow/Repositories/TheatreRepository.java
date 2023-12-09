package com.insha.Bookmyshow.Repositories;

import com.insha.Bookmyshow.Model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre , Long> {
}
