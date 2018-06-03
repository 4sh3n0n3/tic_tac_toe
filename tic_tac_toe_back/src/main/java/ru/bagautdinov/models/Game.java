package ru.bagautdinov.models;

import javax.websocket.*;

import javax.persistence.*;

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

    private Session p1Session;

    public Session getP2Session() {
        return p2Session;
    }

    public void setP2Session(Session p2Session) {
        this.p2Session = p2Session;
    }

    public Session getP1Session() {
        return p1Session;
    }

    public void setP1Session(Session p1Session) {
        this.p1Session = p1Session;
    }

    private Session p2Session;
    private char[][] field;
    private int counter=0;
    public long getId() {
        return id;
    }

    public char[][] getField() {
        return field;
    }

    public void setField(char[][] field) {
        this.field = field;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
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
