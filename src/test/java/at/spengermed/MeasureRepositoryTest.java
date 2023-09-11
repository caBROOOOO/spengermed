package at.spengermed;


import at.spengermed.models.*;
import at.spengermed.repositories.IMeasureRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class MeasureRepositoryTest {
    @Autowired
    IMeasureRepository measureRepository;

    @Test
    @Transactional
    public void testSaveAndLoadOnePatient() {
        Measure m = returnOneMeasure();
        Measure savedM = measureRepository.save(m);
        Measure loadmeasure = measureRepository.findById(savedM.getId()).get();
        System.out.println(loadmeasure);

        assertEquals(m.getUri(), savedM.getUri());
        assertEquals(m.getVersion(), savedM.getVersion());
        assertEquals(m.getDate(), savedM.getDate());

        assertTrue(CollectionUtils.isEqualCollection(m.getIdentifier(), loadmeasure.getIdentifier()));
        assertTrue(CollectionUtils.isEqualCollection(m.getSubjectCodeableConcept(), loadmeasure.getSubjectCodeableConcept()));
    }
        public static Measure returnOneMeasure() {
            List<Identifier> identifiers = new ArrayList<>();
            List<Coding> codings = new ArrayList<>();

            codings.add(new Coding("System","0.1.1","Code","<div> ...<div>",false));

            CodeableConcept ccType = CodeableConcept.builder()
                    .coding(codings)
                    .text("<div></div>")
                    .build();

            return Measure.builder()
                    .uri("")
                    .identifier(identifiers)
                    .version("4.08.0")
                    .date(LocalDate.of(1999,01,01))
                    .build();
        }
}
