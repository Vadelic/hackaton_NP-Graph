package sbrf.hackaton.cit.service.impl;

import org.springframework.stereotype.Service;
import sbrf.hackaton.cit.service.NavigatorService;
import sbrf.hackaton.cit.srv.data.MainResponseServer;
import sbrf.hackaton.cit.srv.data.PointsServer;
import sbrf.hackaton.cit.srv.data.RoutesServer;
import sbrf.hackaton.cit.srv.data.TrafficServer;

@Service
public class NavigatorServiceImpl implements NavigatorService {

    MainResponseServer main = null;
    private PointsServer points;
    private RoutesServer routesServer;

    @Override
    public void createNavigator(MainResponseServer main) {
        this.main = main;
    }

    @Override
    public void createVertex(PointsServer points) {
        this.points = points;
        buildNavigator();

    }

    @Override
    public void createRoads(RoutesServer routesServer) {
        this.routesServer = routesServer;
        buildNavigator();
    }

    private void buildNavigator() {

    }

    @Override
    public String updateTraffic(TrafficServer traffic) {
        return null;
    }
}
