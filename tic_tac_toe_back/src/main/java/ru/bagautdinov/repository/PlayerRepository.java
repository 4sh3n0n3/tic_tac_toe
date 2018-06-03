package ru.bagautdinov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bagautdinov.models.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByName(String name);
    boolean existsByName(String name);
    List<Player> findAllByOnline(boolean online);
}