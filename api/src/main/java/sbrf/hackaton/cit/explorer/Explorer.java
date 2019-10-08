package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.api.Route;
import sbrf.hackaton.cit.api.Vertex;

import java.util.List;

public interface Explorer {

    void routeSearch(Vertex startPoint);

    List<Route> getAllAvailableRouts();
}
