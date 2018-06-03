package ru.bagautdinov.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * Created by User on 03.06.2018.
 */
@Entity
@Table(name = "players", uniqueConstraints={@UniqueConstraint(columnNames = "player_name")})
@SequenceGenerator(name = "players_gen", sequenceName = "players_seq", allocationSize = 1)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "players_gen")
    @Column(name = "player_id")
    private long id;


    @NotNull
    @NotEmpty
    @Size(max = 100)
    @Column(name = "player_name")
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}