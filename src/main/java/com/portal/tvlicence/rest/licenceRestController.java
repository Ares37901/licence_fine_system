package com.portal.tvlicence.rest;

import com.portal.tvlicence.entity.Licence;
import com.portal.tvlicence.service.licenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class licenceRestController {

    private licenceService licenceService;

    @Autowired
    licenceRestController(licenceService theLicenceService) {
        licenceService = theLicenceService;
    }

    // expose "/licences" and return a list of licences
    @GetMapping("/licences")
    public List<Licence> findAll() {
       return licenceService.findAll();
    }

    // add mapping for GET /licences/{licenceId}
    @GetMapping("/licences/{licenceId}")
    public Licence findById(@PathVariable int licenceId) {
        Licence theLicence = licenceService.findById(licenceId);
        if(theLicence == null) {
            throw new RuntimeException("Licence id not found, " + licenceId);
        }
        return theLicence;
    }

    // add mapping for GET /fine/reference/{fineReference}
    @GetMapping("/fine/reference/{fineReference}")
    public Licence findByReference(@PathVariable String reference) {
        Licence theLicence = licenceService.findByReference(reference);
        if(theLicence == null) {
            throw new RuntimeException("Fine reference not found, " + reference);
        }
        return theLicence;
    }

    // add mapping for POST /licences - add new licence
    @PostMapping("/licences")
    public Licence addLicence(@RequestBody Licence theLicence) {
        // to handle any id set in JSON - as this is to add NEW licence data
        theLicence.setId(0);
        Licence dbLicence = licenceService.save(theLicence);
        return dbLicence;
    }

    // add mapping for PUT /licences/{licenceId} - update licence
    @PutMapping("/licences")
    public Licence updateLicence(@RequestBody Licence theLicence) {
        Licence dbLicence = licenceService.save(theLicence);
        return dbLicence;
    }

    @DeleteMapping("/licences/{licenceId}")
    public String deleteLicence(@PathVariable int licenceId) {
        Licence tempLicence = licenceService.findById(licenceId);
        if(tempLicence == null) {
            throw new RuntimeException("Licence id not found - " + licenceId);
        }
        licenceService.deleteById(licenceId);
        return "Licence deleted = " + licenceId;
    }



}
