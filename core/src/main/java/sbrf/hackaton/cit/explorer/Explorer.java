package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.Edge;
import sbrf.hackaton.cit.core.FixedRoute;
import sbrf.hackaton.cit.core.Vertex;

public interface Explorer {

    FixedRoute routeSearch(Vertex startPoint);

    void routeSearch(Edge road, Vertex point);

    FixedRoute getRoute();
}
