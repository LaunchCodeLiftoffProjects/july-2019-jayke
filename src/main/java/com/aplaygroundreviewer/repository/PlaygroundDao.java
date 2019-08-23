package com.aplaygroundreviewer.repository;

import com.aplaygroundreviewer.dto.Playground;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaygroundDao extends JpaRepository<Playground, Integer> {

    Playground findOneById(int id);
    List<Playground> findByName(String name);
    List<Playground> findByNameContaining(String name);
    List<Playground> findByNameContainingOrDescriptionContaining(String name, String description);
}
