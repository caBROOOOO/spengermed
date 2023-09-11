package at.spengermed;


import at.spengermed.models.Imagingstudy;
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
public class ImagingstudyControllerTest {
    @Autowired
    MockMvc mockMvc; //Ahmt ModuleViewController nach

    @Autowired
    ObjectMapper om; //Macht aus Java-Objekt JSON-String

    @Test
    public void getAllImagingstudys() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/imagingstudy"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk()); //Statuscode: 200
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAImagingstudys() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/imagingstudy/00000000-0000-0000-0000-000000000001"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk()); //Statuscode: 200
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void postAImagingstudy() {
        Imagingstudy imagingstudy = ImagingstudyRepositoryTest.returnOneImagingstudy();
        String json = null;
        try {
            json = om.writeValueAsString(imagingstudy);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .post("/api/imagingstudy/")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated()); //Statuscode: 201
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void putAImagingstudy() {
        Imagingstudy imagingstudy = ImagingstudyRepositoryTest.returnOneImagingstudy();
        imagingstudy.setId("00000000-0000-0000-0000-000000000000");
        String json = null;
        try {
            json = om.writeValueAsString(imagingstudy);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .put("/api/imagingstudy/00000000-0000-0000-0000-000000000000")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk()); //Statuscode: 200
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void putANewImagingstudy() {
        Imagingstudy imagingstudy = ImagingstudyRepositoryTest.returnOneImagingstudy();
        imagingstudy.setId("12341234");
        String json = null;
        try {
            json = om.writeValueAsString(imagingstudy);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .put("/api/imagingstudy/12341234")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated()); //Statuscode: 202
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteAImagingstudy() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .delete("/api/imagingstudy/00000000-0000-0000-0000-000000000000"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk()); //Statuscode: 200
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteAImagingstudyNotFound() {
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .delete("/api/imagingstudy/ihiwvuejf"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isNotFound()); //Statuscode: 404
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void postAnInvalidIdImagingstudy() {
        Imagingstudy imagingstudy = ImagingstudyRepositoryTest.returnOneImagingstudy();
        imagingstudy.setId("?!!");
        String json = null;
        try {
            json = om.writeValueAsString(imagingstudy);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders
                            .post("/api/imagingstudy/")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isBadRequest()); //Statuscode: 400
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

