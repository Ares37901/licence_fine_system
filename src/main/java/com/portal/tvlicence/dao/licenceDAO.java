package com.portal.tvlicence.dao;

import com.portal.tvlicence.entity.Licence;

import java.util.List;

public interface licenceDAO {
    List<Licence> findAll();
    Licence findById(int theId);
    Licence findByReference(String theReference);
    Licence save(Licence theLicence);
    void deleteById(int theId);
}
