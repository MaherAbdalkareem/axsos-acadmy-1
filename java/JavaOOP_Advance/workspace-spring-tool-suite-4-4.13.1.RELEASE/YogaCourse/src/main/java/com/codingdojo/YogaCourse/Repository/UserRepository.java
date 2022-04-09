package com.codingdojo.YogaCourse.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.YogaCourse.model.User;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	List<User> findAll();
	Optional<User> findById(Long id);
	Optional<User> findByEmail(String email);
	
}
