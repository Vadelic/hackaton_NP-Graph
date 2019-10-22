package sbrf.hackaton.cit.service.impl;

import org.springframework.stereotype.Service;
import sbrf.hackaton.cit.service.SomeService;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public String print(String text) {
        System.out.println(">>>>   " + text);
        return text;
    }
}
