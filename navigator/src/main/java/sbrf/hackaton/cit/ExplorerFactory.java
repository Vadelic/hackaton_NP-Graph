package sbrf.hackaton.cit;

import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.explorer.Explorer;
import sbrf.hackaton.cit.explorer.GraphExplorer;
import sbrf.hackaton.cit.explorer.GraphRecursionExplorer;

import java.util.Collections;
import java.util.List;

public class ExplorerFactory {
    public static Explorer getRecursionExplorer(Atm destinationPoint, Car car) {
        return getRecursionExplorer(Collections.singletonList(destinationPoint), car);
    }

    public static Explorer getRecursionExplorer(List<Atm> destinationPoints, Car car) {
        return new GraphRecursionExplorer(destinationPoints, car);
    }


    public static Explorer getExplorer(Atm destinationPoint, Car car) {
        return getExplorer(Collections.singletonList(destinationPoint), car);
    }

    public static Explorer getExplorer(List<Atm> destinationPoints, Car car) {
        return new GraphExplorer(destinationPoints, car);
    }
}
