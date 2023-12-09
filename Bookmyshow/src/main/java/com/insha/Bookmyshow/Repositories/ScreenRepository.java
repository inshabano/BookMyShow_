package com.insha.Bookmyshow.Repositories;

import com.insha.Bookmyshow.Model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen , Long> {
}
