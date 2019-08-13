package com.aplaygroundreviewer.aplaygroundreviewer.models.dao;

import com.aplaygroundreviewer.aplaygroundreviewer.models.dto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
}
