package at.spengermed.controller;

import at.spengermed.models.Observation;
import at.spengermed.models.Patient;
import at.spengermed.repositories.IObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping(path = "/api/observation")
@RestController
@CrossOrigin
public class ObservationController {
    @Autowired
    private IObservationRepository observationRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Observation> getAllObservations() {
// This returns a JSON or XML with the users
        return observationRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Observation> getObservation(@PathVariable String id) {
        return observationRepository
                .findById(id)
                .map(observation -> ResponseEntity.ok().body(observation))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Patient
    @PostMapping()
    public ResponseEntity<Observation> createObservation( @RequestBody
                                                          Observation observation) {
        observation.setId(null); // ensure to create new names
        var saved = observationRepository.save(observation);return ResponseEntity.created(URI.create("/api/observation/" +
                saved.getId())).body(saved);
    }
    // Delete a Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Observation> deleteObservation(@PathVariable(value =
            "id") String observationId) {
        return observationRepository
                .findById(observationId)
                .map(
                        observation -> {
                            observationRepository.delete(observation);
                            return ResponseEntity.ok().<Observation>build();
                        })
                .orElse(ResponseEntity.notFound().build());

    }

    // Update a Patient
    @PutMapping("/{id}")
    public ResponseEntity<Observation> updateObservation(
            @PathVariable(value = "id") String observationId,
            @RequestBody Observation observationDetails) {
        return observationRepository
                .findById(observationId)
                .map(
                        observation -> {
                            observation.setCategory(observationDetails.getCategory());
                            observation.setCode(observationDetails.getCode());
                            observation.setEffectiveDateTime(observationDetails.getEffectiveDateTime());
                            observation.setEffectivePeriod(observationDetails.getEffectivePeriod());
                            observation.setIdentifier(observationDetails.getIdentifier());
                            observation.setPerformer(observationDetails.getPerformer());
                            observation.setStatus(observationDetails.getStatus());
                            observation.setSubject(observationDetails.getSubject());
                            observation.setValueBoolean(observationDetails.getValueBoolean());
                            observation.setValuecodableconcept(observationDetails.getValuecodableconcept());
                            observation.setValueDateTime(observationDetails.getValueDateTime());
                            observation.setValueInteger(observationDetails.getValueInteger());
                            observation.setValueQuantity(observationDetails.getValueQuantity());
                            observation.setValueRange(observationDetails.getValueRange());
                            observation.setValueRatio(observationDetails.getValueRatio());


                            Observation updatedObservation =
                                    observationRepository.save(observation);
                            return ResponseEntity.ok(updatedObservation);
                        }).orElseGet ( () -> createObservation(observationDetails));
    }
}


