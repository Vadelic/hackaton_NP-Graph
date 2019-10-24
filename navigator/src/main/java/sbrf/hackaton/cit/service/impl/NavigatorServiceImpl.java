package sbrf.hackaton.cit.service.impl;

import org.springframework.stereotype.Service;
import sbrf.hackaton.cit.service.NavigatorService;

@Service
public class NavigatorServiceImpl implements NavigatorService {
    public String print(String text) {
        System.out.println(">>>>   " + text);
        return text;
    }

    @Override
    public String createNavigator(String text) {
        return null;
    }

    @Override
    public String updateTraffic(double[][] traffic) {
        return null;
    }
}
