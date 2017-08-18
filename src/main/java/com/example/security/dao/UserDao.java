package com.example.security.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.security.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created on 17.08.2017
 *
 * @author Roman Hayda
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
