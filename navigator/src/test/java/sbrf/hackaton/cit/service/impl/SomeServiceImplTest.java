package sbrf.hackaton.cit.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SomeServiceImplTest {
    @Autowired
    private NavigatorServiceImpl someService;

    @Test
    public void print_ok() {
        String result = someService.print("test string");

        assertEquals("result", "test string", result);
    }
}