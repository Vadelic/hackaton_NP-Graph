package sbrf.hackaton.cit.service;

import sbrf.hackaton.cit.api.Route;
import sbrf.hackaton.cit.api.explorer.GraphRecursionExplorer;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.domain.route.DynamicRoute;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Navigator {
    /**
     * Находит Все маршруты которые всегда начинаются в @param start и заканчиваются @param destination
     *
     * @param start       Точка в связанном графе от куоторой начинается маршрут
     * @param destination Точка в связанном графе где маршрут завершается
     * @param car         автомобиль с ограничениями по значенияям рекбер и вершин
     * @return Список фиксированых маршрутов при которых автомобиль соберет максимум значений вершин
     */
    public List<DynamicRoute> buildRoutes(Atm start, List<Atm> destination, Car car) {

        GraphRecursionExplorer roadExplorer = new GraphRecursionExplorer(destination, car);
        Object route;
        do {
            roadExplorer.routeSearch(start);
            List<Route> allAvailableRouts = roadExplorer.getAllAvailableRouts();
            route = getBestRouts(allAvailableRouts);
            if (route instanceof DynamicRoute) {
                car.visitRoute((DynamicRoute) route);
            }

        } while (route != null);
        return car.getCompleteRoutes();
    }

    public List<DynamicRoute> buildRoutes(Atm start, Atm destination, Car car) {
        List<Atm> destination1 = Collections.singletonList(destination);
        return buildRoutes(start, destination1, car);
    }

    private Route getBestRouts(List<Route> allAvailableRouts) {
        return allAvailableRouts.stream().max(Comparator.comparingDouble(Route::getCost)).orElse(null);
    }
}
