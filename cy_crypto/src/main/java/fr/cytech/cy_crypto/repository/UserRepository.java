package fr.cytech.cy_crypto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cytech.cy_crypto.modele.Role;
import fr.cytech.cy_crypto.modele.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);

    public Optional<User> findByEmail(String email);

    public List<User> findAllByRole(Role role);

    public boolean existsByUsername(String username);

    public boolean existsByEmail(String email);
}