package sbrf.hackaton.cit;

import sbrf.hackaton.cit.core.FixedRoute;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.explorer.Explorer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Navigator {
    public static Navigator navigator;
    private final GraphContext graphContext;
    private ArrayList<Car> cars = new ArrayList<>();



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
     * @param car автомобиль с ограничениями по значенияям рекбер и вершин
     * @return Список фиксированых маршрутов при которых автомобиль соберет максимум значений вершин
     */
    public FixedRoute buildRoutes(Car car) {
        FixedRoute fixedRoute = car.goToNextPoint();
        System.out.println(car);
        return fixedRoute;
    }

    public Car getCar(String name, int time, int weight, int start, Function<Car, Explorer> getExplorer) {
        Car car = graphContext.getCar(name, time, weight, start, getExplorer);
        cars.add(car);
        return car;
    }
}
