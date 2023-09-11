package at.spengermed.controller;

import at.spengermed.models.Condition;
import at.spengermed.repositories.IConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping(path = "/api/condition")
@RestController
@CrossOrigin
public class ConditionController {
    @Autowired
    private IConditionRepository conditionRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Condition> getAllConditions() {
// This returns a JSON or XML with the users
        return conditionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Condition> getConditions(@PathVariable String id) {
        return conditionRepository
                .findById(id)
                .map(condition -> ResponseEntity.ok().body(condition))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Patient
    @PostMapping()
    public ResponseEntity<Condition> createCondition( @RequestBody
                                                      Condition condition) {
        condition.setId(null); // ensure to create new names
        var saved = conditionRepository.save(condition);return ResponseEntity.created(URI.create("/api/condition/" +
                saved.getId())).body(saved);
    }



    // Delete a Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Condition> deleteCondition(@PathVariable(value =
            "id") String conditionId) {
        return conditionRepository
                .findById(conditionId)
                .map(
                        condition -> {
                            conditionRepository.delete(condition);
                            return ResponseEntity.ok().<Condition>build();
                        })
                .orElse(ResponseEntity.notFound().build());

    }
    @PutMapping("/{id}")
    public ResponseEntity<Condition> updateCondition(
            @PathVariable(value = "id") String conditionId,
            @RequestBody Condition conditionDetails) {

        return conditionRepository
                .findById(conditionId)
                .map(
                        condition -> {
                            condition.setIdentifier(conditionDetails.getIdentifier());
                            condition.setCode(conditionDetails.getCode());
                            condition.setBodySite(conditionDetails.getBodySite());
                            condition.setCategory(conditionDetails.getCategory());
                            condition.setClinicalStatus(conditionDetails.getClinicalStatus());
                            condition.setEncounter(conditionDetails.getEncounter());
                            condition.setSeverity(conditionDetails.getSeverity());
                            condition.setVerificationStatus(conditionDetails.getVerificationStatus());
                            condition.setText(conditionDetails.getText());
                            condition.setSubject(conditionDetails.getSubject());

                            Condition updatedCondition =
                                    conditionRepository.save(condition);
                            return ResponseEntity.ok(updatedCondition);
                        }).orElseGet ( () -> createCondition(conditionDetails));
    }

}
