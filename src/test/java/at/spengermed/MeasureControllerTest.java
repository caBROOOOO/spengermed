package at.spengermed;

import at.spengermed.models.Measure;
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
public class MeasureControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper om;

    //Erster Test, um alle Patienten unter der URL /api/patient mit GET abzufragen.
    //Expect überprüft, ob der zurückgegebene Status 200 ist
    @Test
    public void getAllMeasure() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/api/measure"));
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Test
    public void getAMeasure() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/measure/1"))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
        }
    }
    @Test
    public void getAMeasureNotFound() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/measure/2"))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void postAMeasure() {


        Measure measure = MeasureRepositoryTest.returnOneMeasure();
        String json = null;
        try {
            json = om.writeValueAsString(measure);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/measure/")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
