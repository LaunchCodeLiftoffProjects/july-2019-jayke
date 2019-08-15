package com.aplaygroundreviewer.aplaygroundreviewer.models.data;

import com.aplaygroundreviewer.aplaygroundreviewer.models.Playground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaygroundDao extends JpaRepository<Playground, Integer> {

    List<Playground> findByName(String name);
    List<Playground> findByNameContaining(String name);
}
