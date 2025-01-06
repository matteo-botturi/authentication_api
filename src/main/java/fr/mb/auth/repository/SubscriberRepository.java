package fr.mb.auth.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import fr.mb.auth.entity.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
    Optional<Subscriber> findByUsername(String username);
    Optional<Subscriber> findByEmail(String email);
}