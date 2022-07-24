package com.sonpt.repository;

import com.sonpt.model.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Statuses, Long> {
    public Optional<Statuses> findByStatusName(String statusName);
}
