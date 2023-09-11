package at.spengermed;

import at.spengermed.models.Condition;
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

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class ConditionControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper om;

    @Test
    public void getACondition(){
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/condition/cd1"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getAllConditions() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/condition"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    @Test
    public void getAConditionNotFound() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .get("/api/condition/cd10"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isNotFound());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void postACondition(){

        Condition condition = ConditionRepositoryTest.returnOneCondition();
        String json= null;
        try {
            json = om.writeValueAsString(condition);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/condition/")
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
    public void putACondition(){
        Condition condition = ConditionRepositoryTest.returnOneCondition();
        condition.setId("cdput");
        String json= null;
        try {
            json = om.writeValueAsString(condition);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/api/condition/cd1")
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
    public void putANewCondition(){
        Condition condition = ConditionRepositoryTest.returnOneCondition();
        condition.setId("cdnew");
        String json= null;
        try {
            json = om.writeValueAsString(condition);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/api/condition/cdnew")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Die id muss es bereits geben.
    // Erwartete Antwort ist 200 (OK
    @Test
    public void deleteACondition(){

        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/api/condition/cd1"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void
    postInvalidCondition() {
        Condition c = ConditionRepositoryTest.returnOneCondition();
        Narrative n = new Narrative();
        n.builder().div("div").status(Narrative.NarrativeCode.abated).build();
        c.setText(n);

        String json = null;
        try {
            json = om.writeValueAsString(c);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.post("/api/condition/")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
