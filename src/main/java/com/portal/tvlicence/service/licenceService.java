package com.portal.tvlicence.service;

import com.portal.tvlicence.entity.Licence;
import java.util.List;

public interface licenceService {
    List<Licence> findAll();
    Licence findById(int theId);
    Licence findByReference(String theReference);
    Licence save(Licence theLicence);
    void deleteById(int theId);
}
