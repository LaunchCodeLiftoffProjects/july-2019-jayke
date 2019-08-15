package com.aplaygroundreviewer.aplaygroundreviewer.models.data;

import com.aplaygroundreviewer.aplaygroundreviewer.models.Playground;
import org.springframework.data.repository.CrudRepository;

public interface PlaygroundDao extends CrudRepository<Playground, Integer> {
}
