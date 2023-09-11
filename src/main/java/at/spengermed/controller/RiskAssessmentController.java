package at.spengermed.controller;


import at.spengermed.models.Medication;
import at.spengermed.models.RiskAssessment;
import at.spengermed.repositories.IRiskAssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping(path = "/api/riskassessment")
@RestController
@CrossOrigin
public class RiskAssessmentController {
    @Autowired
    private IRiskAssessmentRepository riskAssessmentRepository;

    @GetMapping
    public @ResponseBody
    Iterable<RiskAssessment> getAllRiskAssessment() {
// This returns a JSON or XML with the users
        return riskAssessmentRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<RiskAssessment> getRiskAssessment(@PathVariable String id) {
        return riskAssessmentRepository
                .findById(id)
                .map(riskAssessment -> ResponseEntity.ok().body(riskAssessment))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Patient
    @PostMapping()
    public ResponseEntity<RiskAssessment> createRiskAssessment( @RequestBody RiskAssessment riskAssessment) {
        riskAssessment.setId(null); // ensure to create new names
        var saved = riskAssessmentRepository.save(riskAssessment);
        return ResponseEntity.created(URI.create("/api/riskassessment/" +
                saved.getId())).body(saved);
    }
    // Delete a Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<RiskAssessment> deleteRiskAssessment(@PathVariable(value =
            "id") String riskassesmentId) {
        return riskAssessmentRepository
                .findById(riskassesmentId)
                .map(
                        riskAssessment -> {
                            riskAssessmentRepository.delete(riskAssessment);
                            return ResponseEntity.ok().<RiskAssessment>build();
                        })
                .orElse(ResponseEntity.notFound().build());

    }

    // Update a Patient
    @PutMapping("/{id}")
    public ResponseEntity<RiskAssessment> updateRiskAssessment(
            @PathVariable(value = "id") String riskassessmentId,
            @RequestBody RiskAssessment riskassessmentDetails) {
        return riskAssessmentRepository
                .findById(riskassessmentId)
                .map(
                        riskAssessment -> {
                            riskAssessment.setIdentifier(riskassessmentDetails.getIdentifier());
                            riskAssessment.setParent(riskassessmentDetails.getParent());
                            riskAssessment.setPrediction(riskassessmentDetails.getPrediction());
                            riskAssessment.setStatus(riskassessmentDetails.getStatus());
                            riskAssessment.setText(riskassessmentDetails.getText());

                            RiskAssessment updatedRiskAssessment =
                                    riskAssessmentRepository.save(riskAssessment);
                            return ResponseEntity.ok(updatedRiskAssessment);
                        }).orElseGet ( () -> createRiskAssessment(riskassessmentDetails));
    }
}