package com.aplaygroundreviewer.repository;

import com.aplaygroundreviewer.dto.Playground;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaygroundDao extends JpaRepository<Playground, Integer> {

    List<Playground> findAll();
    Playground findOneById(int id);
    List<Playground> findByNameContainingOrDescriptionContaining(String name, String description);
}
