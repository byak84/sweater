package com.example.sweater.repos;

import com.example.sweater.domains.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Integer> {
    AppUser findByUsername(String username);
}
