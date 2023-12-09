package com.insha.Bookmyshow.Repositories;

import com.insha.Bookmyshow.Model.Region;
import com.insha.Bookmyshow.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    Optional<Region> findById(Long aLong);
}
