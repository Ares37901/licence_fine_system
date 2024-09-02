package com.portal.tvlicence.dao;

import com.portal.tvlicence.entity.Licence;
import jakarta.persistence.EntityManager;
// import jakarta.persistence.Id;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class licenceDAOJpaImpl implements licenceDAO {

    // define fields for entitymanager
    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public licenceDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Licence> findAll() {

        // create a query
        TypedQuery<Licence> theQuery = entityManager.createQuery(
                "SELECT e FROM licence_fine e", Licence.class
        );
        // execute the query
        List<Licence> licences = theQuery.getResultList();

        //return the results
        return licences;
    }

    @Override
    public Licence findById(int theId) {
        // get the licence
        Licence theLicence = entityManager.find(Licence.class, theId);
        // return the licence
        return theLicence;
    }

    public Licence findByReference(String theReference) {
        // get the fine

        // create a query
        TypedQuery<Licence> theQuery = entityManager.createQuery(
                "SELECT f FROM Licence f WHERE f.reference=:theReference", Licence.class
        );
        theQuery.setParameter("theReference", theReference);

        // execute the query
        Licence theLicence = theQuery.getSingleResult();

        // return the fine
        return theLicence;
    }


    @Override
    public Licence save(Licence theLicence) {
        // save the licence
        Licence dbLicence = entityManager.merge(theLicence);

        // return the dbLicence
        return dbLicence;
    }

    @Override
    public Licence update(Licence theLicence) {
        // save the licence
        Licence dbLicence = entityManager.merge(theLicence);

        // return the dbLicence
        return dbLicence;
    }

    @Override
    public void deleteById(int theId) {
        Licence theLicence = entityManager.find(Licence.class, theId);
        entityManager.remove(theLicence);
    }
}
