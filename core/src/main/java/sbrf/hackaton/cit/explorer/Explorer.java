package sbrf.hackaton.cit.explorer;

import sbrf.hackaton.cit.core.Route;
import sbrf.hackaton.cit.core.Vertex;

import java.util.List;

public interface Explorer {

    List<Route> routeSearch(Vertex startPoint);


}
