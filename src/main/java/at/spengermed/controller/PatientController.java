package at.spengermed.controller;

import at.spengermed.models.Patient;

import at.spengermed.repositories.IPatientRepository;
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

@RequestMapping(path = "/api/patient")
@RestController
@CrossOrigin
public class PatientController {
    @Autowired
    private IPatientRepository patientRepository;

    @GetMapping
    public @ResponseBody  Iterable<Patient> getAllPatients() {
// This returns a JSON or XML with the users
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable String id) {
        return patientRepository
                .findById(id)
                .map(patient -> ResponseEntity.ok().body(patient))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Patient
    @PostMapping()
    public ResponseEntity<Patient> createPatient( @RequestBody
                                                  Patient patient) {
        patient.setId(null); // ensure to create new names
        var saved = patientRepository.save(patient);return ResponseEntity.created(URI.create("/api/patient/" +
                saved.getId())).body(saved);
    }



    // Delete a Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable(value =
            "id") String patientId) {
        return patientRepository
                .findById(patientId)
                .map(
                        patient -> {
                            patientRepository.delete(patient);
                            return ResponseEntity.ok().<Patient>build();
                        })
                .orElse(ResponseEntity.notFound().build());

    }

    // Update a Patient
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable(value = "id") String patientId,
            @RequestBody Patient patientDetails) {
        return patientRepository
                .findById(patientId)
                .map(
                        patient -> {
                            patient.setActive(patientDetails.isActive());
                            patient.setGender(patientDetails.getGender());
                            patient.setIdentifier(patientDetails.getIdentifier());
                            patient.setName(patientDetails.getName());
                            patient.setAddress(patientDetails.getAddress());
                            patient.setBirthDate(patientDetails.getBirthDate());
                            patient.setDeceasedDateTime(patientDetails.getDeceasedDateTime());
                            patient.setTelecom(patientDetails.getTelecom());
                            patient.setDeceasedBoolean(patientDetails.getDeceasedBoolean());
                            patient.setText(patientDetails.getText());
                            patient.setGeneralPractitioner(patientDetails.getGeneralPractitioner());
                            patient.setPhoto(patientDetails.getPhoto());


                            Patient updatedPatient =
                                    patientRepository.save(patient);
                            return ResponseEntity.ok(updatedPatient);
                        }).orElseGet ( () -> createPatient(patientDetails));
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