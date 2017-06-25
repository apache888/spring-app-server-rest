package com.example.reposetory;

import com.example.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 22.06.2017
 *
 * @author Roman Hayda
 */
@Repository
public interface DeveloperDao extends JpaRepository<Developer, Integer> {

}
