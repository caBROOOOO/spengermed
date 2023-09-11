package at.spengermed.controller;

import at.spengermed.models.Consent;
import at.spengermed.repositories.IConsentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RequestMapping(path = "/api/consent")
@RestController
@CrossOrigin

public class ConsentController {

    @Autowired
    private IConsentRepository consentRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Consent> getAllConsents() {
        return consentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consent> getConsent(@PathVariable String id) {
        return consentRepository
                .findById(id)
                .map(consent -> ResponseEntity.ok().body(consent))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping()
    public ResponseEntity<Consent> createConsent(@RequestBody
                                                 Consent consent) {
        consent.setId(null);
        var saved = consentRepository.save(consent);
        return ResponseEntity.created(URI.create("/api/consent/" + saved.getId())).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Consent> deleteConsents(@PathVariable(value =
            "id") String consentId) {
        return consentRepository
                .findById(consentId)
                .map(
                        consent -> {
                            consentRepository.delete(consent);
                            return ResponseEntity.ok().<Consent>build();
                        })
                .orElse(ResponseEntity.notFound().build());

    }
    @PutMapping("/{id}")
    public ResponseEntity<Consent> updateConsent(
            @PathVariable(value = "id") String consentId,
            @RequestBody Consent consentDetails) {
        return consentRepository
                .findById(consentId)
                .map(
                        consent -> {
                            consent.setDateTime(consentDetails.getDateTime());
                            consent.setPatient(consentDetails.getPatient());
                            consent.setScope(consentDetails.getScope());
                            consent.setSourceAttachment(consentDetails.getSourceAttachment());
                            consent.setSourceDateTime(consentDetails.getSourceDateTime());
                            consent.setIdentifier(consentDetails.getIdentifier());


                            Consent updatedConsent =
                                    consentRepository.save(consent);
                            return ResponseEntity.ok(updatedConsent);
                        }).orElseGet ( () -> createConsent(consentDetails));
    }
}