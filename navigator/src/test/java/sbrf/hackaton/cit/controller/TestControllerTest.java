package sbrf.hackaton.cit.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import sbrf.hackaton.cit.service.SomeService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
//@ContextConfiguration(classes = {SomeService.class})
public class TestControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private SomeService service;

    @Test
    public void yo() throws Exception {
//        String response = restTemplate.getForObject("http://localhost:8080/api/yo", String.class);
        ResultActions resultActions = mvc.perform(get("/api/hello")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(service, times(1)).print("yo-yo");

//        assertEquals("response", "hello", response);
    }

//    @Configuration
//    public static class Config {
//        @Bean
//        public RestTemplate restTemplate() {
//            return new RestTemplate();
//        }
//    }
}