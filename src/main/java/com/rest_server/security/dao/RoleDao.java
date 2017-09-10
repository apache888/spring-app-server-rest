package com.rest_server.security.dao;

import org.springframework.data.repository.CrudRepository;
import com.rest_server.security.domain.Role;
import org.springframework.stereotype.Repository;

/**
 * Created on 17.08.2017
 *
 * @author Roman Hayda
 */
@Repository
public interface RoleDao extends CrudRepository<Role, Long> {

}
