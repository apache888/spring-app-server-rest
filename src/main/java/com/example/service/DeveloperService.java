package com.example.service;

import com.example.model.Developer;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Created on 22.06.2017
 *
 * @author Roman Hayda
 */
public interface DeveloperService {

    Developer findDevById(int id) throws DataAccessException;
    Collection<Developer> findAllDevs() throws DataAccessException;
    void saveDev(Developer developer) throws DataAccessException;
    void deleteDev(Developer developer) throws DataAccessException;
}
