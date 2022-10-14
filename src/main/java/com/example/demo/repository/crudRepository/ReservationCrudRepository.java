package com.example.demo.repository.crudRepository;

import com.example.demo.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    @Query("SELECT c.status, count (c.status) FROM Reservation AS c GROUP BY c order by COUNT (c) DESC ")
    public List<Object[]> countTotalReservationByStatus();

    @Query("SELECT c.client, count (c.client) FROM Reservation AS c GROUP BY c.client order by COUNT (c) DESC ")
    public List<Object[]> countTotalReservationByClient();

    //public List<Reservation> findAllByIdReservationBetweenAnd(Integer a, Integer b);

    public List<Reservation> findAllByStatus(String status);
}
