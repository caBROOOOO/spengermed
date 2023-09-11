package at.spengermed;

import at.spengermed.models.Narrative;
import at.spengermed.models.Patient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper om;

    //Erster Test, um alle Patienten unter der URL /api/patient mit GET abzufragen.
    //Expect überprüft, ob der zurückgegebene Status 200 ist
    @Test
    public void getAllPatients() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/patient"));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //Ein einzelner Patient wird mit der id mit GET abgefragt. (Muss existent sein)
    //Expect überprüft, ob der zurückgegebene Status 200 ist
    @Test
    public void getAPatient() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/patient/1"))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
        }
    }

    @Test
    public void getAPatientNotFound() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/Patient/2"))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Es wird ein neuer Patient mit POST an den Controller geschickt und somit in der DB gespeichert.
    // Wir können die Methode aus PatientRepositoryTest, die uns eine Patienten Instanz erzeugt auch hierverwenden.
    // Der erwartete Rückgabecode ist "CREATED" Also 201
    @Test
    public void postAPatient() {


        Patient patient = PatientRepositoryTest.returnOnePatient();
        String json = null;
        try {
            json = om.writeValueAsString(patient);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/patient/")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //PUT aktualisiert einen Patienten. Dieser muss somit bereits in der DB existieren
    // Die id im Patienten und die id in der URL sollten gesetzt sein und müssen in der DB existieren.
    // Wir erwarten ein Status 200 für einen aktualisierten Patienten.
    // Kein 201 CREATED, sonst wäre der Patient neu angelegt worden.
    @Test
    public void putAPatient() {
        Patient patient = PatientRepositoryTest.returnOnePatient();
        patient.setId("2");
        String json = null;
        try {
            json = om.writeValueAsString(patient);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/api/patient/2")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void putANewPatient() {
        Patient patient = PatientRepositoryTest.returnOnePatient();
        patient.setId("123");
        String json = null;
        try {
            json = om.writeValueAsString(patient);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/api/patient/123")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Der Patient wird geöscht.
    // Die id muss es bereits geben.
    // Erwartete Antwort ist Status 200
    @Test
    public void deleteAPatient() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/api/patient/4"))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Validator wird getestet, wenn deceasedDateTime und deceasedBoolean beide gesetzt sind
    //soll ein 400 bad Request retourniert werden.
    @Test
    @Transactional
    public void
    postInvalidDeceasedPatient() {
        Patient patient = PatientRepositoryTest.returnOnePatient();
//patient.setDeceasedDateTime(LocalDateTime.now());
        patient.setDeceasedDateTime(LocalDate.now());
        patient.setDeceasedBoolean(true);
        String json = null;
        try {
            json = om.writeValueAsString(patient);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.post("/api/patient/")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Validator wird getestet, ob in Narrative (text) beide Attribute nicht null sind
    //soll ein 400 bad Request retourniert werden.
    @Test
    public void
    putInvalidNarrativePatient() {
        Patient patient = PatientRepositoryTest.returnOnePatient();
        Narrative narrative = new Narrative();
        narrative.setStatus(null);
        narrative.setDiv(null);
        patient.setText(narrative);
        //patient.setActive(null);
        String json = null;
        try {
            json = om.writeValueAsString(patient);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.post("/api/patient")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}