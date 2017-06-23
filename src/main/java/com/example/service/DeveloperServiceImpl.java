package com.example.service;

import com.example.model.Developer;
import com.example.reposetory.DeveloperDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created on 22.06.2017
 *
 * @author Roman Hayda
 */
@Service
public class DeveloperServiceImpl implements DeveloperService{

    @Autowired
    private DeveloperDao devDao;

    @Override
    @Transactional(readOnly = true)
    public Developer findDevById(int id) throws DataAccessException {
        return devDao.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Developer> findAllDevs() throws DataAccessException {
        return devDao.findAll();
    }

    @Override
    @Transactional
    public void saveDev(Developer developer) throws DataAccessException {
        devDao.save(developer);
    }

    @Override
    @Transactional
    public void deleteDev(Developer developer) throws DataAccessException {
        devDao.delete(developer);
    }
}
