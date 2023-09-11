package at.spengermed;



import at.spengermed.models.RiskAssessment;
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

@SpringBootTest
@AutoConfigureMockMvc
public class RiskAssessmentControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper om;
    @Test
    public void getAllRiskAssessments() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/riskassessment"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test
    public void getAnRiskAssessment(){
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/riskassessment/ra1"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getAnRiskAssessmentNotFound() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/riskassessment/ra10"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isNotFound());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void postAnRiskAssessment(){

        RiskAssessment riskAssessment = RiskAssessmentRepositoryTest.returnOneRiskAssessment();
        String json= null;
        try {
            json = om.writeValueAsString(riskAssessment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/riskassessment/")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void putAnRiskAssessment(){
        RiskAssessment riskAssessment=RiskAssessmentRepositoryTest.returnOneRiskAssessment();
        riskAssessment.setId("ra3");
        String json= null;
        try {
            json = om.writeValueAsString(riskAssessment);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/api/riskassessment/ra1")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void putANewRiskAssessment(){
        RiskAssessment riskAssessment= RiskAssessmentRepositoryTest.returnOneRiskAssessment();
        riskAssessment.setId("ra4");
        String json= null;
        try {
            json = om.writeValueAsString(riskAssessment);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/api/riskassessment/ra4")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void deleteARiskAssessment(){
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/api/riskassessment/ra2"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
