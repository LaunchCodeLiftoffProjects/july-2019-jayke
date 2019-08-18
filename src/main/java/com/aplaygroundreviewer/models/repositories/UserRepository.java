package com.aplaygroundreviewer.models.repositories;

import com.aplaygroundreviewer.models.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

	Optional<User> findByEmail(String email);

	@Override
	User save(User s);
}
