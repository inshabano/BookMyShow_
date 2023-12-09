package com.insha.Bookmyshow.Repositories;

import com.insha.Bookmyshow.Model.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {
}
