package at.spengermed.controller;

import at.spengermed.models.Measure;

import at.spengermed.repositories.IMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(path = "/api/measure")
@RestController
@CrossOrigin
public class MeasureController {

    @Autowired
    private IMeasureRepository measureRepository;

    @GetMapping
    public @ResponseBody  Iterable<Measure> getAllMeasures() {
// This returns a JSON or XML with the users
        return measureRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Measure> getMeasure(@PathVariable String id) {
        return measureRepository
                .findById(id)
                .map(measure -> ResponseEntity.ok().body(measure))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Patient
    @PostMapping()
    public ResponseEntity<Measure> createMeasure( @RequestBody
                                                  Measure measure) {
        measure.setId(null); // ensure to create new names
        var saved = measureRepository.save(measure);return ResponseEntity.created(URI.create("/api/measure/" +
                saved.getId())).body(saved);
    }



    // Delete a Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Measure> deleteMeasure(@PathVariable(value =
            "id") String measureId) {
        return measureRepository
                .findById(measureId)
                .map(
                        measure -> {
                            measureRepository.delete(measure);
                            return ResponseEntity.ok().<Measure>build();
                        })
                .orElse(ResponseEntity.notFound().build());

    }

    // Update a Patient
    @PutMapping("/{id}")
    public ResponseEntity<Measure> updateMeasure(
            @PathVariable(value = "id") String measureId,
            @RequestBody Measure measureDetails) {
        return measureRepository
                .findById(measureId)
                .map(
                        measure -> {
                            measure.setDate(measureDetails.getDate());
                            measure.setIdentifier(measureDetails.getIdentifier());
                            measure.setVersion(measureDetails.getVersion());
                            measure.setSubjectCodeableConcept(measureDetails.getSubjectCodeableConcept());
                            measure.setUri(measureDetails.getUri());

                            Measure updatedMeasure =
                                    measureRepository.save(measure);
                            return ResponseEntity.ok(updatedMeasure);
                        }).orElseGet ( () -> createMeasure(measureDetails));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> onConstraintValidationException(
            ConstraintViolationException e) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            errors.put(violation.getPropertyPath().toString(),
                    violation.getMessage());
        }
        return errors;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField() , fieldError.getDefaultMessage());
        }
        return errors;
    }

}
