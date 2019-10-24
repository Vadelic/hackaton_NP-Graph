package sbrf.hackaton.cit.service;

import sbrf.hackaton.cit.srv.data.MainResponseServer;
import sbrf.hackaton.cit.srv.data.PointsServer;
import sbrf.hackaton.cit.srv.data.RoutesServer;
import sbrf.hackaton.cit.srv.data.TrafficServer;

public interface NavigatorService {

    void createNavigator(MainResponseServer main);

    String updateTraffic(TrafficServer traffic);

    void createVertex(PointsServer points);

    void createRoads(RoutesServer routesServer);

}
