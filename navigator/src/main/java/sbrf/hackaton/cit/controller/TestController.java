package sbrf.hackaton.cit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sbrf.hackaton.cit.service.SomeService;

import javax.annotation.PostConstruct;

@EnableWebMvc
@RestController
@RequestMapping("/api")
class TestController {
    private final SomeService service;

    TestController(SomeService service) {
        this.service = service;
    }

    @PostConstruct
    public void start() {
        System.out.println("start");
    }

    @GetMapping("/hello")
    public String yo() {
        service.print("yo-yo");
        return "yo!";
    }

}