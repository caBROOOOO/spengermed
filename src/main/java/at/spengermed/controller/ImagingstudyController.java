package at.spengermed.controller;


import at.spengermed.models.Imagingstudy;
import at.spengermed.repositories.ImagingstudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping(path = "api/imagingstudy")
@RestController
@CrossOrigin

public class ImagingstudyController {

    @Autowired
    private ImagingstudyRepository imagingstudyRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Imagingstudy> getAllImagingstudy() {
        return imagingstudyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagingstudy> getImagingstudy(@PathVariable String id) {
        return imagingstudyRepository
                .findById(id)
                .map(imagingstudy -> ResponseEntity.ok().body(imagingstudy))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping() //erstellt neuen Patienten
    public ResponseEntity<Imagingstudy> createImagingstudy(@Valid @RequestBody Imagingstudy imagingstudy) {
        imagingstudy.setId(null);
        var saved = imagingstudyRepository.save(imagingstudy);
        return ResponseEntity.created(URI.create("/api/imagingstudy/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}") //updatet einen Patienten
    public ResponseEntity<Imagingstudy> updateImagingstudy(@PathVariable(value = "id") String imagingstudyId, @RequestBody Imagingstudy imagingstudyDetails) {
        //suchen Patienten und aktualisieren ihn (mit allen Attributen)
        return imagingstudyRepository.findById(imagingstudyId).map(imagingstudy -> {

                    imagingstudy.setIdentifier(imagingstudyDetails.getIdentifier());
                    imagingstudy.setStatus(imagingstudyDetails.getStatus());
                    imagingstudy.setSubject(imagingstudyDetails.getSubject());
                    imagingstudy.setStarted(imagingstudyDetails.getStarted());
                    imagingstudy.setNumberOfSeries(imagingstudyDetails.getNumberOfSeries());
                    imagingstudy.setDescription(imagingstudyDetails.getDescription());
                    imagingstudy.setSeries(imagingstudyDetails.getSeries());
                    Imagingstudy updatedImagingstudy = imagingstudyRepository.save(imagingstudy);
                    return ResponseEntity.ok(updatedImagingstudy);
                }
                //Falls es den Patienten nicht gibt (nicht aktulisert) wird er erstellt
        ).orElseGet(() -> createImagingstudy(imagingstudyDetails));
    }

    // Löscht einen Patienten
    @DeleteMapping("/{id}")
    public ResponseEntity<Imagingstudy> deleteImagingstudy(@PathVariable(value = "id") String imagingstudyId) {
        return imagingstudyRepository
                .findById(imagingstudyId)
                .map(
                        imagingstudy -> {
                            imagingstudyRepository.delete(imagingstudy);
                            return ResponseEntity.ok().<Imagingstudy>build();
                        })
                // Wenn es Patienten nicht gitb dann 404 Not Found zurückgegeben
                .orElse(ResponseEntity.notFound().build());
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public Map<String, String> onConstraintValidationException(
//            ConstraintViolationException e) {
//        Map<String, String> errors = new HashMap<>();
//        for (ConstraintViolation violation : e.getConstraintViolations()) {
//            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
//        }
//        return errors;
//    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public Map<String, String> onMethodArgumentNotValidException(
//            MethodArgumentNotValidException e) {
//        Map<String, String> errors = new HashMap<>();
//        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
//            errors.put(fieldError.getField() , fieldError.getDefaultMessage());
//        }
//        return errors;
//    }
}