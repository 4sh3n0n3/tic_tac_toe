package ru.bagautdinov.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by User on 03.06.2018.
 */

@Entity
@Table(name = "games")
@SequenceGenerator(name = "games_gen", sequenceName = "games_seq", allocationSize = 1)
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "games_gen")
    @Column(name = "game_id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id", nullable = false)
    private Player p1;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id", nullable = false)
    private Player p2;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id", nullable = false)
    private Player winner=null;

    public long getId() {
        return id;
    }

    public Player getP1() {

        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
