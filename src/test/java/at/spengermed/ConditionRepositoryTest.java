package at.spengermed;

import at.spengermed.models.*;
import at.spengermed.repositories.IConditionRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ConditionRepositoryTest {
    @Autowired
    IConditionRepository conditionRepository;

    @Test
    @Transactional
    public void testSaveAndLoadOneCondition() {
        Condition co = returnOneCondition();
        Condition savedCon = conditionRepository.save(co);
        Condition loadedCondition = conditionRepository.findById(savedCon.getId()).get();
        System.out.println(loadedCondition);

        //OneToOne
        assertEquals(co.getText(), savedCon.getText());
        assertEquals(co.getVerificationStatus(), savedCon.getVerificationStatus());
        assertEquals(co.getSeverity(), savedCon.getSeverity());
        assertEquals(co.getCode(), savedCon.getCode());
        assertEquals(co.getClinicalStatus(),savedCon.getClinicalStatus());
        assertEquals(co.getEncounter(),savedCon.getEncounter());
        assertEquals(co.getSubject(),savedCon.getSubject());

        //OneToMany
        assertTrue(CollectionUtils.isEqualCollection(co.getIdentifier(), loadedCondition.getIdentifier()));
        assertTrue(CollectionUtils.isEqualCollection(co.getCategory(), loadedCondition.getCategory()));
        assertTrue(CollectionUtils.isEqualCollection(co.getBodySite(), loadedCondition.getBodySite()));
    }

    @Test
    @Transactional
    public void testUpdateOnePractitioner() {
        Condition co = returnOneCondition();
        Condition conditiontochange = conditionRepository.findById("cd1").get();

        conditiontochange.setSubject(co.getSubject());
        conditiontochange.setText(co.getText());
        conditiontochange.setVerificationStatus(co.getVerificationStatus());
        conditiontochange.setSeverity(co.getSeverity());
        conditiontochange.setEncounter(co.getEncounter());
        conditiontochange.setClinicalStatus(co.getClinicalStatus());
        conditiontochange.setCategory(co.getCategory());
        conditiontochange.setBodySite(co.getBodySite());
        conditiontochange.setCode(co.getCode());
        conditiontochange.setIdentifier(co.getIdentifier());
        Condition savedC = conditionRepository.save(conditiontochange);

        Condition loadedCondition = conditionRepository.findById(savedC.getId()).get();
        System.out.println(loadedCondition);


        Condition updatedC = conditionRepository.save(savedC);
        Condition newUpdatedC = conditionRepository.findById(updatedC.getId()).get();


        assertTrue(CollectionUtils.isEqualCollection(conditiontochange.getIdentifier(), loadedCondition.getIdentifier()));
        assertTrue(CollectionUtils.isEqualCollection(conditiontochange.getBodySite(), loadedCondition.getBodySite()));
        assertTrue(CollectionUtils.isEqualCollection(conditiontochange.getCategory(), loadedCondition.getCategory()));

        assertEquals(conditiontochange.getText(), savedC.getText());
        assertEquals(conditiontochange.getVerificationStatus(), savedC.getVerificationStatus());
        assertEquals(conditiontochange.getSeverity(), savedC.getSeverity());
        assertEquals(conditiontochange.getCode(), savedC.getCode());
        assertEquals(conditiontochange.getClinicalStatus(),savedC.getClinicalStatus());
        assertEquals(conditiontochange.getEncounter(),savedC.getEncounter());
        assertEquals(conditiontochange.getSubject(),savedC.getSubject());
    }

    @Test
    @Transactional
    public void testDeleteOnePradictioner() {

        Condition co = returnOneCondition();

        Condition savedco =conditionRepository.save(co);

        conditionRepository.deleteById(savedco.getId());

        boolean exists = conditionRepository.existsById(savedco.getId());

        assertFalse(exists);
    }

    static Condition returnOneCondition() {
        List<Coding> coding = new ArrayList<>();
        List<Identifier> identifiers = new ArrayList<>();
        List<CodeableConcept> categorys = new ArrayList<>();
        List<CodeableConcept> bodySites = new ArrayList<>();

        CodeableConcept type = new CodeableConcept(coding,"id");

        identifiers.add(Identifier.builder()
                .system("spengermed")
                .period(Period.builder().start(LocalDateTime.of(2020,03,29,12,00)).end(LocalDateTime.now()).build())
                .code(Identifier.UseCode.old)
                .value("Identifiers condition")
                .type(type)
                .build());
        coding.add(Coding.builder()
                .code("code")
                .display("condition")
                .userSelected(Boolean.TRUE)
                .version("version 1")
                .system("spengermedco")
                .build());
        CodeableConcept code1 = new CodeableConcept(coding,"code1");
        CodeableConcept code2 = new CodeableConcept(coding,"code2");
        Reference encounter = new Reference("RefCon_Encounter", "ref",identifiers,"encounter-condition");
        CodeableConcept code3 = new CodeableConcept(coding, "code3");
        CodeableConcept cc = new CodeableConcept(coding,"cc");
        categorys.add(CodeableConcept.builder().coding(coding).text("categorys").build());
        bodySites.add(CodeableConcept.builder().text("bodysites").coding(coding).build());
        Reference subject = new Reference("RefCon_Subject", "ref",identifiers,"subject-condition");

        return Condition.builder()
                .verificationStatus(code1)
                .severity(code2)
                .identifier(identifiers)
                .encounter(encounter)
                .code(code3)
                .clinicalStatus(cc)
                .category(categorys)
                .bodySite(bodySites)
                .subject(subject)
                .build();
    }

}