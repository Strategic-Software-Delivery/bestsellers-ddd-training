package com.sdd.cinemareservationsinfra.repository;

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
        assertThat(false).isTrue();

    }
}
