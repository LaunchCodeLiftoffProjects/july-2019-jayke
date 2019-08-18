package com.aplaygroundreviewer.models.repositories;

import com.aplaygroundreviewer.models.dto.Playground;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PlaygroundDao extends CrudRepository<Playground, Integer> {
}
