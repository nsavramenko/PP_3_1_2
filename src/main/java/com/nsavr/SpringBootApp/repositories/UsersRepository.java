package com.nsavr.SpringBootApp.repositories;

import com.nsavr.SpringBootApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
}
