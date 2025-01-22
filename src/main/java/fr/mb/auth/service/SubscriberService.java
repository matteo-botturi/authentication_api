package fr.mb.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.mb.auth.dto.SubscriberRequestDTO;
import fr.mb.auth.entity.Role;
import fr.mb.auth.entity.Subscriber;
import fr.mb.auth.enumeration.RoleName;
import fr.mb.auth.repository.RoleRepository;
import fr.mb.auth.repository.SubscriberRepository;

@Service
public class SubscriberService {

    private final SubscriberRepository subscriberRepository;
    private final RoleRepository roleRepository;

    public SubscriberService(SubscriberRepository subscriberRepository, RoleRepository roleRepository) {
        this.subscriberRepository = subscriberRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public Subscriber registerSubscriber(SubscriberRequestDTO request) {
        // Verifica se l'username o l'email esistono già
        if (subscriberRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (subscriberRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Recupera il ruolo predefinito (ROLE_USER)
        Role defaultRole = roleRepository.findByRoleName(RoleName.ROLE_USER)
            .orElseThrow(() -> new IllegalArgumentException("Default role not found"));

        // Crea un nuovo Subscriber
        Subscriber subscriber = new Subscriber();
        subscriber.setUsername(request.getUsername());
        subscriber.setEmail(request.getEmail());
        subscriber.setHashedPassword(request.getPassword()); // Hashing da aggiungere successivamente
        subscriber.setRole(defaultRole);

        // Salva il Subscriber nel database
        return subscriberRepository.save(subscriber);
    }
}