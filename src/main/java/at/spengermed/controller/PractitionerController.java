package at.spengermed.controller;

import at.spengermed.models.Practitioner;


import at.spengermed.repositories.IPractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.net.URI;
@RequestMapping(path = "/api/practitioner")
@RestController
@CrossOrigin
public class PractitionerController {
    @Autowired
    private IPractitionerRepository practitionerRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Practitioner> getAllPractitioners() {
// This returns a JSON or XML with the users
        return practitionerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practitioner> getPractitioners(@PathVariable String id) {
        return practitionerRepository
                .findById(id)
                .map(practitioner -> ResponseEntity.ok().body(practitioner))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Practitioner
    @PostMapping()
    public ResponseEntity<Practitioner> createPractitioner(@RequestBody
                                                           Practitioner practitioner) {
        practitioner.setId(null); // ensure to create new names
        var saved = practitionerRepository.save(practitioner);return ResponseEntity.created(URI.create("/api/practitioner/" +
                saved.getId())).body(saved);
    }



    // Delete a Practitioner
    @DeleteMapping("/{id}")
    public ResponseEntity<Practitioner> deletePractitioner(@PathVariable(value =
            "id") String practitionerId) {
        return practitionerRepository
                .findById(practitionerId)
                .map(
                        practitioner -> {
                            practitionerRepository.delete(practitioner);
                            return ResponseEntity.ok().<Practitioner>build();
                        })
                .orElse(ResponseEntity.notFound().build());

    }

    // Update a Practitioner
    @PutMapping("/{id}")
    public ResponseEntity<Practitioner> updatePractitioner(
            @PathVariable(value = "id") String practitionerId,
            @RequestBody Practitioner practitionerDetails) {
        return practitionerRepository
                .findById(practitionerId)
                .map(
                        practitioner -> {

                            practitioner.setActive(practitionerDetails.isActive());
                            practitioner.setGender(practitionerDetails.getGender());
                            practitioner.setIdentifier(practitionerDetails.getIdentifier());
                            practitioner.setName(practitionerDetails.getName());
                            practitioner.setAddress(practitionerDetails.getAddress());
                            practitioner.setBirthDate(practitionerDetails.getBirthDate());
                            practitioner.setTelecom(practitionerDetails.getTelecom());

                            practitioner.setPhoto(practitionerDetails.getPhoto());
                            practitioner.setQualification(practitionerDetails.getQualification());
                            practitioner.setCommunication(practitionerDetails.getCommunication());



                            Practitioner updatedPractitioner =
                                    practitionerRepository.save(practitioner);
                            return ResponseEntity.ok(updatedPractitioner);
                        }).orElseGet ( () -> createPractitioner(practitionerDetails));
    }
}
