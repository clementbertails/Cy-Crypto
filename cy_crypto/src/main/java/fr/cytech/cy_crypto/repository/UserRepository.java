package fr.cytech.cy_crypto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cytech.cy_crypto.modele.Role;
import fr.cytech.cy_crypto.modele.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    public Optional<UserModel> findByUsername(String username);

    public Optional<UserModel> findByEmail(String email);

    public List<UserModel> findAllByRole(Role role);

    public boolean existsByUsername(String username);

    public boolean existsByEmail(String email);
}