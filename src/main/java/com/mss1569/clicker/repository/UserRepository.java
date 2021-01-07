package com.mss1569.clicker.repository;

import com.mss1569.clicker.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}