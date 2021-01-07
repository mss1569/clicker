package com.mss1569.clicker.repository;

import com.mss1569.clicker.domain.Ant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AntRepository extends JpaRepository<Ant, Long> {
    
}