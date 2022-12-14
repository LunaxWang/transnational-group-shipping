package com.example.transnationalgroupshipping.repository;

import com.example.transnationalgroupshipping.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    int countByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
}
