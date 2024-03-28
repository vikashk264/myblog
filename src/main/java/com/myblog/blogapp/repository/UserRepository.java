package com.myblog.blogapp.repository;

import com.myblog.blogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {

    // It will take the email id go to the user table and search the record based on the email id and return optional object.
    Optional<User> findByEmail(String email);
    //find the record either by username or by email id
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);
    // it will just check if this user name present in the database it will return true nor false
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
