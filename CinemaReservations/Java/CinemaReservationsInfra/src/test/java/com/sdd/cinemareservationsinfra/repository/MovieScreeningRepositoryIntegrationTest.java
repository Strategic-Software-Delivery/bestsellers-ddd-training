package com.sdd.cinemareservationsinfra.repository;

import com.sdd.cinemareservationsinfra.repository.model.JPAMovieScreening;
import com.sdd.cinemareservationsinfra.repository.model.JPARow;
import com.sdd.cinemareservationsinfra.repository.model.JPASeat;
import com.sdd.cinemareservationsinfra.repository.model.JPASeatAvailability;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static com.google.common.truth.Truth.assertThat;


import java.util.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieScreeningRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SpringMovieScreeningRepository springMovieScreeningRepository;

    @Test
    public void whenFindById_thenReturnMovieScreening() {
        JPAMovieScreening jpaMovieScreening = new JPAMovieScreening();
        JPARow jpaRow = new JPARow();
        JPASeat jpaSeat = new JPASeat();
        jpaSeat.rowName("A");
        jpaSeat.number(1);
        jpaSeat.seatAvailability(JPASeatAvailability.Available);
        List<JPASeat> jpaSeats = new ArrayList<>();
        jpaSeats.add(jpaSeat);
        jpaRow.name("A");
        jpaRow.seats(jpaSeats);
        Map<String, JPARow> rows = new HashMap<>();
        rows.put("A", jpaRow);
        jpaMovieScreening.rows(rows);

        JPAMovieScreening persistedEntity = entityManager.persist(jpaMovieScreening);
        entityManager.flush();

        Optional<JPAMovieScreening> foundEntity = springMovieScreeningRepository.findById(persistedEntity.id());


        assertThat(foundEntity.isPresent()).isTrue();

    }
}
