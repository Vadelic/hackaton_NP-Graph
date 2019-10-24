package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.FixedRoute;
import sbrf.hackaton.cit.core.Vertex;

public interface Explorer {

    FixedRoute routeSearch(Vertex startPoint);
}
