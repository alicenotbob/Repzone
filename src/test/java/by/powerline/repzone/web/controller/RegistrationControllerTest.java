package by.powerline.repzone.web.controller;

import by.powerline.repzone.model.dto.RegistrationRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void register() throws Exception {
        RegistrationRequestDTO dto = new RegistrationRequestDTO();
        dto.setEmail("a@b.c");
        dto.setPassword("123");
        dto.setCourierAvailability(true);
        dto.setLegalEntityService(true);
        dto.setOfficialService(true);
        dto.setRegion("Minsk");
        dto.setServiceDescription("test");
        dto.setServiceName("test service");
        this.mockMvc.perform(post("/register", dto).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));
    }
}