package com.example.server_spring.repo;

import com.example.server_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepo extends CrudRepository<User, Long> {
    User findByName(String username);
}
