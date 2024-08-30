package com.portal.tvlicence.service;

import com.portal.tvlicence.dao.licenceDAO;
import com.portal.tvlicence.entity.Licence;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class licenceServiceImpl implements licenceService {

    private licenceDAO licenceDAO;

    @Autowired
    licenceServiceImpl(licenceDAO theLicenceDAO) {
        licenceDAO = theLicenceDAO;
    }

    @Override
    public List<Licence> findAll() {
        return licenceDAO.findAll();
    }

    @Override
    public Licence findById(int theId) {
        return licenceDAO.findById(theId);
    }

    @Override
    public Licence findByReference(String theReference) { return licenceDAO.findByReference(theReference); }


    @Override
    @Transactional
    public Licence save(Licence theLicence) {
        return licenceDAO.save(theLicence);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        licenceDAO.deleteById(theId);
    }
}
