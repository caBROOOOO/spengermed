package at.spengermed;


import at.spengermed.models.*;
import at.spengermed.repositories.IRiskAssessmentRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RiskAssessmentRepositoryTest {
    @Autowired
    IRiskAssessmentRepository riskAssessmentRepository;

    @Test
    @Transactional
    public void testSaveAndLoadOneRiskAssessment() {
        RiskAssessment ra = returnOneRiskAssessment();
        RiskAssessment savedra = riskAssessmentRepository.save(ra);
        RiskAssessment loadedRiskAssessment= riskAssessmentRepository.findById(savedra.getId()).get();
        System.out.println(loadedRiskAssessment);

        assertEquals(ra.getParent(), loadedRiskAssessment.getParent());
        assertEquals(ra.getStatus(), loadedRiskAssessment.getStatus());
        assertEquals(ra.getText(), loadedRiskAssessment.getText());

        assertTrue(CollectionUtils.isEqualCollection(ra.getIdentifier(), loadedRiskAssessment.getIdentifier()));
        assertTrue(CollectionUtils.isEqualCollection(ra.getPrediction(), loadedRiskAssessment.getPrediction()));
    }

    public static RiskAssessment returnOneRiskAssessment() {

        List<Coding> listco = new ArrayList<>();
        List<Identifier> id = new ArrayList<>();
        List<Prediction> pre = new ArrayList<>();

        listco.add(Coding.builder().code("String").display("dsp").system("spengermed").userSelected(true).version("v01").build());
        Period period = new Period().builder().end(LocalDateTime.now()).start(LocalDateTime.now()).build();
        CodeableConcept code = new CodeableConcept().builder().text("Text").coding(listco).build();
        id.add(Identifier.builder().value("RiskAssessment").type(code).system("spengermed").period(period).code(Identifier.UseCode.official).build());
        Reference re = new Reference("reference","reference2",id,"reference3");
        Range range = new Range(10,90);
        pre.add(Prediction.builder().outcome(code).probabilityDecimal(3).probabilityRange(range).build());


        return RiskAssessment.builder()
                .identifier(id)
                .parent(re)
                .prediction(pre)
                .status(RiskAssessment.Status.preliminary)
                .build();
    }
    @Test
    @Transactional
    public void testUpdateOneRiskAssessment() {
        RiskAssessment ra = returnOneRiskAssessment();
        RiskAssessment ratochange = riskAssessmentRepository.findById("ra1").get();
        //hier einfach alles . bis auf Id
        ratochange.setText(ra.getText());
        ratochange.setStatus(ra.getStatus());
        ratochange.setPrediction(ra.getPrediction());
        ratochange.setParent(ra.getParent());
        ratochange.setIdentifier(ra.getIdentifier());
        ratochange.setStatus(ra.getStatus());

        RiskAssessment savedra = riskAssessmentRepository.save(ratochange);

        RiskAssessment loadedRiskAssessment= riskAssessmentRepository.findById(ratochange.getId()).get();
        System.out.println(loadedRiskAssessment);

        //Haben Sie bei Medication auskommentiert also denke ich ist das ebenso hier nicht nötig (wegen dem Fehler den wir besprochen hatten
        //Medication updatedMe = medicationRepository.save(savedMe);
        //Medication newUpdatedMe = medicationRepository.findById(updatedMe.getId()).get();

        //hier einfach copy pasta von oben und loadedmedication auf medicationtochange ändern


        assertEquals(loadedRiskAssessment.getParent(), ratochange.getParent());
        assertEquals(loadedRiskAssessment.getStatus(), ratochange.getStatus());
        assertEquals(loadedRiskAssessment.getText(), ratochange.getText());

        assertTrue(CollectionUtils.isEqualCollection(loadedRiskAssessment.getIdentifier(), ratochange.getIdentifier()));
        assertTrue(CollectionUtils.isEqualCollection(loadedRiskAssessment.getPrediction(), ratochange.getPrediction()));
    }

    @Test
    @Transactional
    public void testDeleteOneRiskAssessment() {

        RiskAssessment ra = returnOneRiskAssessment();

        RiskAssessment savedra =riskAssessmentRepository.save(ra);

        riskAssessmentRepository.deleteById(savedra.getId());

        boolean exists = riskAssessmentRepository.existsById(savedra.getId());


        assertFalse(exists);
    }

}
