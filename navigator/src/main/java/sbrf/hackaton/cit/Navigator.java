package sbrf.hackaton.cit;

import sbrf.hackaton.cit.core.FixedRoute;
import sbrf.hackaton.cit.domain.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Navigator {

    private final GraphContext graphContext;
    private ArrayList<Car> cars = new ArrayList<>();

    public Navigator(GraphContext graphContext, ArrayList<Car> cars) {
        this.cars = cars;
        this.graphContext = graphContext;
    }

    public Navigator(GraphContext graphContext) {
        this.graphContext = graphContext;
    }

    public void updateTraffic(double[][] traffic) {
        graphContext.updateTraffic(traffic);
    }

    public Map<Car, FixedRoute> getRoads() {
        HashMap<Car, FixedRoute> carRouteHashMap = new HashMap<>();
        for (Car car : cars) {
            FixedRoute routeFrom = buildRoutes(car);
            carRouteHashMap.put(car, routeFrom);
        }
        return carRouteHashMap;
    }


    /**
     * Находит Все маршруты которые всегда начинаются в @param start и заканчиваются @param destination
     *
     * @param start Точка в связанном графе от куоторой начинается маршрут
     * @param car   автомобиль с ограничениями по значенияям рекбер и вершин
     * @return Список фиксированых маршрутов при которых автомобиль соберет максимум значений вершин
     */
    public FixedRoute buildRoutes(Car car) {
        return car.goToNextPoint();
    }


}
