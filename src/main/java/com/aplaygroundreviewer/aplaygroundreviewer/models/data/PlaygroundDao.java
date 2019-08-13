package com.aplaygroundreviewer.aplaygroundreviewer.models.data;

import com.aplaygroundreviewer.aplaygroundreviewer.models.Playground;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PlaygroundDao extends CrudRepository<Playground, Integer> {
}
