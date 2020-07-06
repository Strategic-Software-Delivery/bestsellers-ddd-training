package com.sdd.cinemareservationsinfra.repository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class JPAMovieScreening {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @MapKey(name = "name")
    private Map<String, JPARow> rows = new HashMap<>();


}
