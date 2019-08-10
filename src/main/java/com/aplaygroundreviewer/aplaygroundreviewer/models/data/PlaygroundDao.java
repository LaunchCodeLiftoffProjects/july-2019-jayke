package com.aplaygroundreviewer.aplaygroundreviewer.models.data;

import com.aplaygroundreviewer.aplaygroundreviewer.models.Playground;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaygroundDao extends JpaRepository<Playground, Integer> {
}
