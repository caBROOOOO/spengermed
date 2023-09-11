package at.spengermed;



import at.spengermed.models.Practitioner;
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
public class PractitionerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper om;

    @Test
    public void getAllPractitioners() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/practitioner"))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test
    public void getPractitioners(){
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/practitioner/8"))
                    .andDo(MockMvcResultHandlers.print());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void getAPractitionerNotFound() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/practitioner/11"))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void postAPractitioner(){

        Practitioner practitioner = PractitionerRepositoryTest.returnOnePractitioner();
        String json= null;
        try {
            json = om.writeValueAsString(practitioner);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/practitioner/")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void putAPractitioner(){
        Practitioner practitioner = PractitionerRepositoryTest.returnOnePractitioner();
        practitioner.setId("9");
        String json= null;
        try {
            json = om.writeValueAsString(practitioner);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/api/practitioner/9")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void putANewPractitioner(){
        Practitioner practitioner = PractitionerRepositoryTest.returnOnePractitioner();
        practitioner.setId("11");
        String json= null;
        try {
            json = om.writeValueAsString(practitioner);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/api/practitioner/11")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Die id muss es bereits geben.
    // Erwartete Antwort ist 200 (OK)
    @Test
    public void deleteAPractitioner(){

        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/api/practitioner/9"))
                    .andDo(MockMvcResultHandlers.print());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}