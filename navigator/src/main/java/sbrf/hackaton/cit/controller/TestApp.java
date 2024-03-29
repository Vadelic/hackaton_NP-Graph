package sbrf.hackaton.cit.controller;

import sbrf.hackaton.cit.service.impl.NavigatorServiceImpl;
import sbrf.hackaton.cit.srv.data.MainResponseServer;
import sbrf.hackaton.cit.srv.data.PointsServer;
import sbrf.hackaton.cit.srv.data.RoutesServer;
import sbrf.hackaton.cit.srv.data.TrafficServer;
import sbrf.hackaton.cit.srv.parse.Mapper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestApp {

    public static TrafficServer updateRoutes(WebsocketClientEndpoint clientEndPoint, NavigatorServiceImpl navigator, TrafficServer traffic) {
        if (traffic != null && navigator.checkAvailable()) {
            List<String> res = navigator.updateTraffic(traffic);
            for (String carRoute : res) {
                System.out.println(carRoute);
                clientEndPoint.sendMessage(carRoute);
                traffic = null;
            }
        }
        return traffic;
    }

    public static void main(String[] args) {

        NavigatorServiceImpl navigator = new NavigatorServiceImpl();
        final TrafficServer[] traffic = {null};

        try {
            // open websocket
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("ws://172.30.9.50:8080/race"));
            // add listener
            clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) {
                    System.out.println(message);

                    if (message.contains("token")) {
                        MainResponseServer mainInfo = Mapper.map(message, MainResponseServer.class);
                        navigator.createNavigator(mainInfo);




//                        updateRoutes(clientEndPoint, navigator, traffic[0]);
                    }
                    if (message.contains("routes")) {
                        RoutesServer routes = Mapper.map(message, RoutesServer.class);
                        navigator.createRoads(routes);
//                        updateRoutes(clientEndPoint, navigator, traffic[0]);
                    }
                    if (message.contains("points")) {
                        PointsServer points = Mapper.map(message, PointsServer.class);
                        navigator.createVertex(points);
//                        updateRoutes(clientEndPoint, navigator, traffic[0]);
                    }
                    if (message.contains("traffic")) {
                        traffic[0] = Mapper.map(message, TrafficServer.class);
                        updateRoutes(clientEndPoint, navigator, traffic[0]);
                    }

                }
            });

            // send message to websocket
            clientEndPoint.sendMessage("{\"team\":\"Digital Platform\"}");

            // wait 5 seconds for messages from websocket
            do {
                try {
                    TimeUnit.MINUTES.sleep(10);
                } catch (InterruptedException e) {
                    break;
                }
            } while (true);

        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());

        }



    }


}